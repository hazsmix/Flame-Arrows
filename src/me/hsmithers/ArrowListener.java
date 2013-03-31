package me.hsmithers;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowListener implements Listener {
    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
	if (event.getEntity().getShooter() instanceof Player
		&& event.getEntity() instanceof Arrow) {
	    Player player = (Player) event.getEntity().getShooter();
	    Projectile proj = (Projectile) event.getEntity();
	    if (proj.getFireTicks() > 0) {
		if (player.hasPermission("flamearrow.ignite")) {
		    proj.getLocation().getBlock().getRelative(BlockFace.UP)
			    .setType(Material.FIRE);
		    proj.getLocation().getBlock();
		}
	    }
	}
    }
}
