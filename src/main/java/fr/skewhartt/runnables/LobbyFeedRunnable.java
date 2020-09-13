package fr.skewhartt.runnables;

import fr.skewhartt.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyFeedRunnable extends BukkitRunnable{

    @Override
    public void run() {
        if(GameStatus.isStatus(GameStatus.LOBBY)){
            for (Player player: Bukkit.getOnlinePlayers()){
                player.setFoodLevel(20);
                player.setSaturation(20);
            }
        }
    }
}
