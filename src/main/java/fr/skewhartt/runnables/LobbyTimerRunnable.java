package fr.skewhartt.runnables;

import fr.skewhartt.GameStatus;
import fr.skewhartt.TestPlugin;
import fr.skewhartt.manager.GameManager;
import fr.skewhartt.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyTimerRunnable extends BukkitRunnable {

    public int timer = 10;

    @Override
    public void run() {

        if (Bukkit.getOnlinePlayers().size() < 1){
            Bukkit.broadcastMessage(TestPlugin.INSTANCE.getPrefix() + "§3Il n'y a pas assez de joueurs pour lancer la partie.");
            timer = 121;
            this.cancel();
        }

        if ((timer == 120) || (timer == 90) || (timer == 60) || (timer == 30) || (timer == 20) || (timer == 10) || (timer == 5) || (timer == 4)|| (timer == 3)|| (timer == 2)|| (timer == 1)){

            for (Player player: Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
                TitleManager.sendTitle(player, "§6" + timer, "", 20);
            }
            setLevel(timer);
            timer--;
            return;
        }

        if (timer == 0){
            if (GameStatus.isStatus(GameStatus.LOBBY)){
                timer = 121;
                setLevel(0);
                // Bukkit.broadcastMessage("§3Lancement de la partie...");
                this.cancel();
                GameManager.loadGame();
                return;
            }

        }
        setLevel(timer);
        timer--;
    }


    private void setLevel(int level){
        for (Player player: Bukkit.getOnlinePlayers()){
            player.setLevel(level);
        }
    }

    private String getSecond(int time) {
        if (time == 1) return "seconde.";
        return "secondes.";
    }
}
