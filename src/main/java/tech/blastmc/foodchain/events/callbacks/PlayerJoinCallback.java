package tech.blastmc.foodchain.events.callbacks;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public interface PlayerJoinCallback {
	Event<PlayerJoinCallback> EVENT = EventFactory.createArrayBacked(PlayerJoinCallback.class, (listeners) -> (player, server) -> {
		for (PlayerJoinCallback listener : listeners) {
			ActionResult result = listener.join(player, server);

			if (result != ActionResult.PASS) {
				return result;
			}
		}

		return ActionResult.PASS;
	});

	ActionResult join(ServerPlayerEntity player, MinecraftServer server);
}
