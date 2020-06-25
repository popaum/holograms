package com.popaum.holograms;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class HologramMain extends JavaPlugin {

	public void onEnable() {
		Location loc = new Location(Bukkit.getWorlds().get(0), 100, 100, 100);
		final Hologram hologram = HologramLibrary.createHologram(loc, "§7" + Bukkit.getOnlinePlayers().size(),
				"§bJogadores");
		hologram.spawn();

		new BukkitRunnable() {
			public void run() {
				hologram.updateLine(1, "§7" + Bukkit.getOnlinePlayers().size());
			}
		}.runTaskTimer(getPlugin(), 0, 20);
	}

	public void onDisable() {
		for (Hologram hologram : HologramLibrary.listHolograms()) {
			hologram.despawn();
		}
	}

	public static HologramMain getPlugin() {
		return HologramMain.getPlugin(HologramMain.class);
	}
}
