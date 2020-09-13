package fr.skewhartt;

import fr.skewhartt.commands.CommandManager;
import fr.skewhartt.listeners.ListenersManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    public static TestPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        new CommandManager().registerCommands();
        new ListenersManager(this).registerListeners();
        GameStatus.setStatus(GameStatus.LOBBY);

        for (Player player: Bukkit.getOnlinePlayers()){
            player.setHealth(20);
            player.setHealthScale(20);
            player.setFoodLevel(20);
            player.teleport(new Location(Bukkit.getWorld("world"), 91, 84, 250, 0, 0));
            player.setGameMode(GameMode.ADVENTURE);
        }

    }

    @Override
    public void onDisable() {

    }

    public String getPrefix() {
        return "§3[§6Sky§3Run] ";
    }
}
