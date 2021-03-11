package tech.blastmc.foodchain.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import tech.blastmc.foodchain.Foodchain;
import tech.blastmc.foodchain.Tier;
import tech.blastmc.foodchain.components.Components;
import tech.blastmc.foodchain.components.TierComponent;
import tech.blastmc.foodchain.events.callbacks.PlayerJoinCallback;

import static tech.blastmc.foodchain.Utils.nextWithLoop;
import static tech.blastmc.foodchain.Utils.send;

public class Events {

	public Events() {
		killListener();
		joinListener();
	}

	private void joinListener() {
		PlayerJoinCallback.EVENT.register(((player, server) -> {
			TierComponent component = Components.CURRENT_TIER.get(player);
			Foodchain.playerTiers.put(player.getUuid(), component.getCurrentTier());
			Foodchain.tellNextTierInfo(player, component.getCurrentTier());
			return ActionResult.PASS;
		}));
	}

	private void killListener() {
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((serverWorld, entity, killedEntity) -> {
			if (!(entity instanceof PlayerEntity)) return;
			PlayerEntity player = (PlayerEntity) entity;
			if (!Foodchain.playerTiers.containsKey(player.getUuid())) return;
			Tier tier = Foodchain.playerTiers.get(player.getUuid());
			Tier newTier = nextWithLoop(Tier.class, tier.ordinal());
			if (!newTier.getEntityTypes().contains(killedEntity.getType())) return;
			Foodchain.setIdentity(player, killedEntity.getType());
			Foodchain.playerTiers.put(player.getUuid(), newTier);
			Foodchain.updateData(player);
			Foodchain.log(player.getName().getString() + " has killed a " + killedEntity.getType().getName().getString() + " and is now in tier " + (newTier.ordinal() + 1));
		});
	}
}
