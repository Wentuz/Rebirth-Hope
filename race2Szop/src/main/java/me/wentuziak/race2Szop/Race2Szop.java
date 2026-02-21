package me.wentuziak.race2Szop;

import org.bukkit.plugin.java.JavaPlugin;

public final class Race2Szop extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("@ Hope and Rebirth enabled");

        getServer().getPluginManager().registerEvents(new EntityListener(), this);

        getCommand("rah").setExecutor(new CommandManager());

        // Plugin startup logic

    }

    @Override
    public void onDisable() {

        getLogger().info("@ Hope and Rebirth disabled");
        // Plugin shutdown logic
    }

    public static Race2Szop getInstance() {
        return Race2Szop.getPlugin(Race2Szop.class);
    }
}
