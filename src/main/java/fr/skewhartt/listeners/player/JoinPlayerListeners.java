package fr.skewhartt.listeners.player;

import fr.skewhartt.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinPlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        event.setJoinMessage(TestPlugin.INSTANCE.getPrefix() + "§6" + player.getName() + "§3 a rejoint le serveur. (" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");

        player.getInventory().clear();
        player.setHealth(20);
        player.setHealthScale(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setSaturation(20);
    }
}
