package tech.blastmc.foodchain.components;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import tech.blastmc.foodchain.Tier;

public class TierComponent implements AutoSyncedComponent {

	PlayerEntity player;
	Tier currentTier;

	public Tier getCurrentTier() {
		return currentTier;
	}

	public void setCurrentTier(Tier currentTier) {
		this.currentTier = currentTier;
		Components.CURRENT_TIER.sync(player);
	}

	public TierComponent(PlayerEntity player) {
		this.player = player;
	}

	@Override
	public void readFromNbt(CompoundTag tag) {
		try {
			currentTier = Tier.valueOf(tag.getString("tier"));
		} catch (Exception ig) {
			currentTier = Tier.TIER_1;
		}
	}

	@Override
	public void writeToNbt(CompoundTag tag) {
		if (currentTier == null)
			currentTier = Tier.TIER_1;
		tag.putString("tier", currentTier.name());
	}
}
