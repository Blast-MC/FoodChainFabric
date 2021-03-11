package tech.blastmc.foodchain.components;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.util.Identifier;

public class Components implements EntityComponentInitializer {

	public static final ComponentKey<TierComponent> CURRENT_TIER = ComponentRegistry.getOrCreate(new Identifier("foodchain", "tier"), TierComponent.class);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerForPlayers(Components.CURRENT_TIER, TierComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
	}
}
