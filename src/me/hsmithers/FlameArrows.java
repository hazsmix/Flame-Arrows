package me.hsmithers;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class FlameArrows extends JavaPlugin {

	static String PLUGIN_PREFIX = "Flame Arrows";
	static String VERSION = "v0.1";

	public void onEnable() {
		this.getLogger().info(
				PLUGIN_PREFIX + " " + VERSION + "has been enabled");
	}

	public void onDisable() {
		this.getLogger().info(
				PLUGIN_PREFIX + " " + VERSION + "has been disabled");
	}

	@EventHandler
	public void projectileHitEvent(Projectile projectile) {
		if (projectile.getShooter() instanceof Player) {
			Player player = (Player) projectile.getShooter();
			if (player.hasPermission("flamearrow.ignite")) {
				if (projectile instanceof Arrow) {
					if (projectile.getFireTicks() > 0) {
						projectile.getLocation().getBlock()
								.getRelative(BlockFace.UP)
								.setType(Material.FIRE);
					}
				}
			}
		}
	}
}
