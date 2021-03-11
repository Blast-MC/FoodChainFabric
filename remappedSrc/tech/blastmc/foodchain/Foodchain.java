package tech.blastmc.foodchain;

import io.github.bymartrixx.playerevents.api.event.PlayerKillEntityCallback;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.minecraft.util.ActionResult;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Foodchain implements DedicatedServerModInitializer {

	public Map<UUID, Tier> playerTiers = new HashMap<>();

	@Override
	public void onInitializeServer() {
		PlayerKillEntityCallback.EVENT.register(((player, killedEntity) -> {

			return ActionResult.PASS;
		}));
	}
}
