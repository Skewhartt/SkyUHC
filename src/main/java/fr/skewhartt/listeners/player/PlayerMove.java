package fr.skewhartt.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    public static boolean playerCanMove = true;

    public static boolean isPlayerCanMove() {
        return playerCanMove;
    }

    public static void setPlayerCanMove(boolean playerCanMove) {
        PlayerMove.playerCanMove = playerCanMove;
    }

    @EventHandler
    public void onMovePlayer(PlayerMoveEvent event){
        if(!playerCanMove){
            event.setCancelled(true);
        }

    }
}
