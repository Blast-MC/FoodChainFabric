package tech.blastmc.foodchain;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.blastmc.foodchain.command.FoodChainCommand;
import tech.blastmc.foodchain.components.Components;
import tech.blastmc.foodchain.components.TierComponent;
import tech.blastmc.foodchain.events.Events;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

import static tech.blastmc.foodchain.Utils.*;

public class Foodchain implements DedicatedServerModInitializer {

	public static Map<UUID, Tier> playerTiers = new HashMap<>();

	@Override
	public void onInitializeServer() {
		LocalDateTime startup = LocalDateTime.now();
		log("Initializing");
		log("Loading Data");
		log("Loading Events and Commands");
		new Events();
		new FoodChainCommand();
		log("Startup Complete. Took " + Duration.between(startup, LocalDateTime.now()).toMillis() + "ms");
	}

	public static Logger LOGGER = LogManager.getLogger();

	public static void log(String message) {
		LOGGER.log(Level.INFO, message);
	}

	public static void setIdentity(PlayerEntity player, EntityType type) {
		runCommandAsOp(player, "identity equip " + player.getName().getString() + " minecraft:" + type.getName().getString().toLowerCase());
		send(player, "You are now a " + camelCase(type.getName().getString()), "dark_aqua");
		tellNextTierInfo(player, Tier.fromEntityType(type));
	}

	public static void tellNextTierInfo(PlayerEntity player, Tier currentTier) {
		if (currentTier == null) return;
		send(player, "To progress to the next tier, kill one of the following:", "dark_aqua");
		List<String> strings = new ArrayList<>();
		for (EntityType entityType : nextWithLoop(Tier.class, currentTier.ordinal()).getEntityTypes())
			strings.add(entityType.getName().getString());
		send(player, String.join(", ", strings), "yellow");
	}

	public static void updateData(PlayerEntity player) {
		TierComponent component = Components.CURRENT_TIER.get(player);
		component.setCurrentTier(playerTiers.get(player.getUuid()));
	}

}
