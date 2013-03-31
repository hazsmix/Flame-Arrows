package me.hsmithers;

import org.bukkit.plugin.java.JavaPlugin;

public class FlameArrows extends JavaPlugin { // the main
					      // (and only)
					      // class

    static String PLUGIN_PREFIX = "Flame Arrows";
    static String VERSION = "v0.1";

    public void onEnable() {
	getServer().getPluginManager()
		.registerEvents(new ArrowListener(), this);
	this.getLogger().info(
		PLUGIN_PREFIX + " " + VERSION + "has been enabled");
    }

    public void onDisable() {
	this.getLogger().info(
		PLUGIN_PREFIX + " " + VERSION + "has been disabled");
    }

}