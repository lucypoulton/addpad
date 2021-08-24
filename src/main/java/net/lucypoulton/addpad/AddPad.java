package net.lucypoulton.addpad;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class AddPad extends PlaceholderExpansion {
	@Override
	public @NotNull String getIdentifier() {
		return "addpad";
	}

	@Override
	public @NotNull String getAuthor() {
		return "Lucy Poulton (lucyy-mc)";
	}

	@Override
	public @NotNull String getVersion() {
		return "1.0.0"; // TODO
	}

	@Override
	public String onRequest(OfflinePlayer player, @NotNull String params) {
		String[] paramsSplit = params.split("_");
		if (paramsSplit.length < 2) return null;

		StringBuilder placeholder = new StringBuilder();
		for (int x = 1; x < paramsSplit.length; x++) {
			placeholder.append(paramsSplit[x]).append("_");
		}
		placeholder.setLength(placeholder.length() - 1);

		String placeholderVal = PlaceholderAPI.setPlaceholders(player, "%" + placeholder + "%");

		switch (paramsSplit[0]) {
			case "before":
				return " " + placeholderVal;
			case "after":
				return placeholderVal + " ";
			case "pad":
				return  " " + placeholderVal + " ";
			default:
				return null;
		}
	}
}
