package tech.blastmc.foodchain;

import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Tier {

	TIER_1(EntityType.TROPICAL_FISH, EntityType.PUFFERFISH, EntityType.COD, EntityType.SALMON, EntityType.ENDERMITE, EntityType.SILVERFISH, EntityType.CHICKEN, EntityType.SLIME),
	TIER_2(EntityType.SQUID, EntityType.BAT, EntityType.BEE, EntityType.PARROT, EntityType.RABBIT),
	TIER_3(EntityType.PIG, EntityType.SHEEP, EntityType.COW, EntityType.WOLF, EntityType.FOX, EntityType.CAT, EntityType.OCELOT),
	TIER_4(EntityType.DOLPHIN, EntityType.VILLAGER, EntityType.SPIDER, EntityType.PANDA),
	TIER_5(EntityType.HORSE, EntityType.DONKEY, EntityType.MULE, EntityType.SKELETON_HORSE, EntityType.ZOMBIE_HORSE, EntityType.TURTLE, EntityType.LLAMA, EntityType.TRADER_LLAMA, EntityType.WANDERING_TRADER),
	TIER_6(EntityType.CAVE_SPIDER, EntityType.CREEPER, EntityType.ENDERMAN),
	TIER_7(EntityType.ZOMBIE, EntityType.HUSK, EntityType.SKELETON, EntityType.STRAY, EntityType.PHANTOM),
	TIER_8(EntityType.WITCH, EntityType.EVOKER, EntityType.VINDICATOR, EntityType.PILLAGER, EntityType.VEX, EntityType.ZOMBIE_VILLAGER, EntityType.RAVAGER),
	TIER_9(EntityType.STRIDER, EntityType.ZOMBIFIED_PIGLIN, EntityType.GHAST, EntityType.HOGLIN, EntityType.PIGLIN),
	TIER_10(EntityType.BLAZE, EntityType.WITHER_SKELETON, EntityType.MAGMA_CUBE),
	TIER_11(EntityType.PIGLIN_BRUTE, EntityType.ZOGLIN, EntityType.GUARDIAN, EntityType.IRON_GOLEM),
	TIER_12(EntityType.ELDER_GUARDIAN, EntityType.WITHER, EntityType.SNOW_GOLEM),
	TIER_13(EntityType.ENDER_DRAGON),
	TIER_14(EntityType.ARMOR_STAND);

	public List<EntityType> getEntityTypes() {
		return entityTypes;
	}

	List<EntityType> entityTypes;
	Tier(EntityType... entityTypes) {
		this.entityTypes = new ArrayList<>(Arrays.asList(entityTypes));
	}

	static Tier fromEntityType(EntityType entityType) {
		for (Tier tier : values())
			if (tier.getEntityTypes().contains(entityType))
				return tier;
		return null;
	}

}
