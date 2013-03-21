package me.hsmithers;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

public class FlameArrows extends JavaPlugin { // the main (and only) class

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

	@EventHandler(priority = EventPriority.LOW)
	// lets other plugins manage this event as well
	public void projectileHitEvent(Projectile projectile) { // receives all
															// events when an
															// arrow hits
															// "something" - a
															// block, player, or
															// entity
		if (projectile.getShooter() instanceof Player) { // don't want to have
															// skeletons with
															// flaming arrows...
															// or do we?
			Player player = (Player) projectile.getShooter(); // stores the
																// shooter, and
																// casts to
																// player
			if (player.hasPermission("flamearrow.ignite")) { // checks
																// permissions
				if (projectile instanceof Arrow) { // checks the projectile is
													// actually an arrow (should
													// this be first to reduce
													// unnecessary firing of the
													// event?)
					if (projectile.getFireTicks() > 0) { // if the arrow is
															// already on fire
															// (ie shot through
															// a flame)
						projectile.getLocation().getBlock() // gets the "block"
															// the arrow is
															// "mostly" in
								.getRelative(BlockFace.UP) // gets the top of
															// this block
								.setType(Material.FIRE); // and sets it on fire
					}
				}
			}
		}
	}
}