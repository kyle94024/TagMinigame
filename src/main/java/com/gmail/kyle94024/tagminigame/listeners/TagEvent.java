package com.gmail.kyle94024.tagminigame.listeners;

import com.gmail.kyle94024.tagminigame.utility.States;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


public class TagEvent implements Listener {

    @EventHandler
    public void onTag(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player attacker = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();
            if (States.currentlyIt == attacker && States.playersInGame.contains(attacker)) {
                if (States.playersInGame.contains(victim)) {
                    // System.out.println("Player " + attacker.getDisplayName() + " attacked Player " + victim.getDisplayName());
                    States.currentlyIt = victim;
                    attacker.sendMessage("You tagged " + victim.getDisplayName());
                    victim.sendMessage(attacker.getDisplayName() + " tagged you. You're it!");
                    for (Player player: States.playersInGame) {
                        player.sendMessage(attacker.getDisplayName() + " taggaed " + victim.getDisplayName() + "! " + victim.getDisplayName() + " is now it!");
                    }
                    event.setCancelled(true);
                } else {
                    attacker.sendMessage(victim.getDisplayName() + " is not a player in the Tag game.");
                }
            }
        }

    }

}
