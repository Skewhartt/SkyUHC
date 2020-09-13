package fr.skewhartt.manager;

import fr.skewhartt.GameStatus;
import fr.skewhartt.listeners.player.PlayerMove;
import fr.skewhartt.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GameManager {


    public GameManager(){

    }

    public static void loadGame(){
        GameStatus.setStatus(GameStatus.GAME);

        if (GameStatus.isStatus(GameStatus.GAME)){
            for (Player player: Bukkit.getOnlinePlayers()){
                TitleManager.sendTitle(player, "§3Début de la partie", "§6Bonne chance :)", 40);
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
                PlayerMove.setPlayerCanMove(false);

            }
        }
    }
}
