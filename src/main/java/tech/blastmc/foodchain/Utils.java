package tech.blastmc.foodchain;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {

	public static <T> T randomElement(List<T> list) {
		if (list == null || list.isEmpty()) return null;
		return list.get(new Random().nextInt(list.size()));
	}

	public static void runCommandAsOp(PlayerEntity sender, String commandNoSlash) {
		sender.getCommandSource().getMinecraftServer().getCommandManager().execute(sender.getCommandSource(), commandNoSlash);
	}

	public static String camelCase(String text) {
		return Arrays.stream(text.replaceAll("_", " ").split(" "))
				.map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
				.collect(Collectors.joining(" "));
	}

	public static <T> T previous(Class<? extends T> clazz, int ordinal) {
		T[] values = clazz.getEnumConstants();
		return values[Math.max(0, ordinal - 1 % values.length)];
	}

	public static <T> T nextWithLoop(Class<? extends T> clazz, int ordinal) {
		T[] values = clazz.getEnumConstants();
		int next = ordinal + 1 % values.length;
		return next >= values.length ? values[0] : values[next];
	}

	public static void send(PlayerEntity playerEntity, String message, String color) {
		playerEntity.sendSystemMessage(Text.Serializer.fromJson("{\"text\":\"" + message + "\",\"color\":\"" + color + "\"}"), Util.NIL_UUID);
	}


}
