package fr.skewhartt.listeners;

import fr.skewhartt.listeners.player.EntityDamage;
import fr.skewhartt.listeners.player.JoinPlayerListeners;
import fr.skewhartt.listeners.player.PlayerMove;
import fr.skewhartt.listeners.player.QuitPlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public Plugin plugin;
    public PluginManager pluginManager;

    public ListenersManager(Plugin plugin) {
        this.plugin = plugin;
        this.pluginManager = Bukkit.getPluginManager();
    }

    public void registerListeners(){
        this.pluginManager.registerEvents(new JoinPlayerListeners(), this.plugin);
        this.pluginManager.registerEvents(new QuitPlayerListeners(), this.plugin);
        this.pluginManager.registerEvents(new EntityDamage(), this.plugin);
        this.pluginManager.registerEvents(new PlayerMove(), this.plugin);
    }
}
