package fr.skewhartt.commands;

import fr.skewhartt.TestPlugin;

public class CommandManager {

    public static void registerCommands(){
        TestPlugin.INSTANCE.getCommand("start").setExecutor(new StartCommand());
    }
}
