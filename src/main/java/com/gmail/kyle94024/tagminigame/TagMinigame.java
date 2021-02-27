package com.gmail.kyle94024.tagminigame;

import com.gmail.kyle94024.tagminigame.commands.*;
import com.gmail.kyle94024.tagminigame.listeners.TagEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TagMinigame extends JavaPlugin {

    public static TagMinigame plugin = null;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("TagMinigame has now been enabled.");
        this.getCommand("tag").setExecutor(new TagMain());
        this.getCommand("tagStart").setExecutor(new TagStart());
        this.getCommand("tagEnd").setExecutor(new TagEnd());
        this.getCommand("tagStatus").setExecutor(new TagStatus());
        this.getCommand("tagJoin").setExecutor(new TagJoin());
        this.getCommand("tagLeave").setExecutor(new TagLeave());

        registerEvents(this, new TagEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("TagMinigame has now been disabled.");
    }

    public static void registerEvents(TagMinigame plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static TagMinigame getPlugin() {
        return plugin;
    }

}
