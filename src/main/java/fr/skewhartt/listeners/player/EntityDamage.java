package fr.skewhartt.listeners.player;

import fr.skewhartt.GameStatus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    public static boolean playerCanTakeDamage = false;

    @EventHandler
    public final void onEntityDamage(EntityDamageEvent event){
        if (!playerCanTakeDamage){
            event.setCancelled(true);
        }
    }

}
