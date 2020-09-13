package fr.skewhartt.commands;

import fr.skewhartt.GameStatus;
import fr.skewhartt.TestPlugin;
import fr.skewhartt.runnables.LobbyTimerRunnable;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player && label.equalsIgnoreCase("start")){
            Player player = (Player) sender;
            if(args.length != 0){
                player.sendMessage(TestPlugin.INSTANCE.getPrefix() + "§3La commande 'start' ne reçoit aucun argument.");
            }
            else if (!GameStatus.isStatus(GameStatus.LOBBY)){
                player.sendMessage(TestPlugin.INSTANCE.getPrefix() + "§3Vous ne pouvez démarrer la partie seulement dans le lobby.");
            }
            else {
                new LobbyTimerRunnable().runTaskTimer(Bukkit.getPluginManager().getPlugin("TestPlugin"), 0, 20);
            }
        }

        return false;
    }
}
