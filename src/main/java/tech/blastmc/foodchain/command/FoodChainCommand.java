package tech.blastmc.foodchain.command;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import tech.blastmc.foodchain.Foodchain;
import tech.blastmc.foodchain.Tier;
import tech.blastmc.foodchain.components.Components;
import tech.blastmc.foodchain.components.TierComponent;

import static net.minecraft.server.command.CommandManager.literal;
import static tech.blastmc.foodchain.Utils.*;

public class FoodChainCommand {

	public FoodChainCommand() {
		register();
	}
	
	public void register() {
		CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) ->
				dispatcher.register(literal("foodchain")
						.then(literal("rewind").executes(context -> {
							PlayerEntity player = context.getSource().getPlayer();
							Tier newTier = previous(Tier.class, Foodchain.playerTiers.get(player.getUuid()).ordinal());
							Foodchain.playerTiers.put(player.getUuid(), newTier);
							EntityType type = randomElement(Foodchain.playerTiers.get(player.getUuid()).getEntityTypes());
							Foodchain.setIdentity(player, type);
							send(player, "You are now in tier " + (newTier.ordinal() + 1), "dark_aqua");
							Foodchain.updateData(player);
							return 1;
						}))
						.then(literal("mob")
								.then(literal("tropical_fish")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.TROPICAL_FISH);
											return 1;
										}))
								.then(literal("pufferfish")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PUFFERFISH);
											return 1;
										}))
								.then(literal("cod")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.COD);
											return 1;
										}))
								.then(literal("salmon")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SALMON);
											return 1;
										}))
								.then(literal("endermite")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ENDERMITE);
											return 1;
										}))
								.then(literal("silverfish")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SILVERFISH);
											return 1;
										}))
								.then(literal("chicken")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.CHICKEN);
											return 1;
										}))
								.then(literal("slime")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_1;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SLIME);
											return 1;
										}))
								.then(literal("squid")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_2;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SQUID);
											return 1;
										}))
								.then(literal("bat")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_2;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.BAT);
											return 1;
										}))
								.then(literal("bee")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_2;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.BEE);
											return 1;
										}))
								.then(literal("parrot")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_2;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PARROT);
											return 1;
										}))
								.then(literal("rabbit")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_2;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.RABBIT);
											return 1;
										}))
								.then(literal("pig")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PIG);
											return 1;
										}))
								.then(literal("sheep")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SHEEP);
											return 1;
										}))
								.then(literal("cow")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.COW);
											return 1;
										}))
								.then(literal("wolf")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.WOLF);
											return 1;
										}))
								.then(literal("fox")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.FOX);
											return 1;
										}))
								.then(literal("cat")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.CAT);
											return 1;
										}))
								.then(literal("ocelot")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_3;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.OCELOT);
											return 1;
										}))
								.then(literal("dolphin")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_4;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.DOLPHIN);
											return 1;
										}))
								.then(literal("villager")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_4;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.VILLAGER);
											return 1;
										}))
								.then(literal("spider")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_4;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SPIDER);
											return 1;
										}))
								.then(literal("panda")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_4;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PANDA);
											return 1;
										}))
								.then(literal("horse")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.HORSE);
											return 1;
										}))
								.then(literal("donkey")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.DONKEY);
											return 1;
										}))
								.then(literal("mule")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.MULE);
											return 1;
										}))
								.then(literal("skeleton_horse")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SKELETON_HORSE);
											return 1;
										}))
								.then(literal("zombie_horse")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ZOMBIE_HORSE);
											return 1;
										}))
								.then(literal("turtle")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.TURTLE);
											return 1;
										}))
								.then(literal("llama")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.LLAMA);
											return 1;
										}))
								.then(literal("trader_llama")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.TRADER_LLAMA);
											return 1;
										}))
								.then(literal("wandering_trader")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_5;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.WANDERING_TRADER);
											return 1;
										}))
								.then(literal("cave_spider")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_6;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.CAVE_SPIDER);
											return 1;
										}))
								.then(literal("creeper")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_6;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.CREEPER);
											return 1;
										}))
								.then(literal("enderman")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_6;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ENDERMAN);
											return 1;
										}))
								.then(literal("zombie")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_7;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ZOMBIE);
											return 1;
										}))
								.then(literal("husk")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_7;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.HUSK);
											return 1;
										}))
								.then(literal("skeleton")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_7;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SKELETON);
											return 1;
										}))
								.then(literal("stray")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_7;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.STRAY);
											return 1;
										}))
								.then(literal("phantom")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_7;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PHANTOM);
											return 1;
										}))
								.then(literal("witch")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.WITCH);
											return 1;
										}))
								.then(literal("evoker")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.EVOKER);
											return 1;
										}))
								.then(literal("vindicator")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.VINDICATOR);
											return 1;
										}))
								.then(literal("pillager")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PILLAGER);
											return 1;
										}))
								.then(literal("vex")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.VEX);
											return 1;
										}))
								.then(literal("zombie_villager")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ZOMBIE_VILLAGER);
											return 1;
										}))
								.then(literal("ravager")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_8;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.RAVAGER);
											return 1;
										}))
								.then(literal("strider")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_9;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.STRIDER);
											return 1;
										}))
								.then(literal("zombified_piglin")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_9;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ZOMBIFIED_PIGLIN);
											return 1;
										}))
								.then(literal("ghast")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_9;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.GHAST);
											return 1;
										}))
								.then(literal("hoglin")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_9;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.HOGLIN);
											return 1;
										}))
								.then(literal("piglin")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_9;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PIGLIN);
											return 1;
										}))
								.then(literal("blaze")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_10;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.BLAZE);
											return 1;
										}))
								.then(literal("wither_skeleton")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_10;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.WITHER_SKELETON);
											return 1;
										}))
								.then(literal("magma_cube")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_10;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.MAGMA_CUBE);
											return 1;
										}))
								.then(literal("piglin_brute")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_11;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.PIGLIN_BRUTE);
											return 1;
										}))
								.then(literal("zoglin")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_11;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ZOGLIN);
											return 1;
										}))
								.then(literal("guardian")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_11;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.GUARDIAN);
											return 1;
										}))
								.then(literal("iron_golem")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_11;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.IRON_GOLEM);
											return 1;
										}))
								.then(literal("elder_guardian")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_12;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ELDER_GUARDIAN);
											return 1;
										}))
								.then(literal("wither")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_12;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.WITHER);
											return 1;
										}))
								.then(literal("snow_golem")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_12;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.SNOW_GOLEM);
											return 1;
										}))
								.then(literal("ender_dragon")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_13;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ENDER_DRAGON);
											return 1;
										}))
								.then(literal("armor_stand")
										.requires(source -> {
											try { return Foodchain.playerTiers.get(source.getPlayer().getUuid()) == Tier.TIER_14;
											} catch (CommandSyntaxException e) { return false; } })
										.executes(context -> {
											Foodchain.setIdentity(context.getSource().getPlayer(), EntityType.ARMOR_STAND);
											return 1;
										}))))));
	}
	
}
