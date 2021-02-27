package com.gmail.kyle94024.tagminigame.commands;

import com.gmail.kyle94024.tagminigame.utility.States;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TagEnd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            // TODO: Add game logic
            if (States.gameOn) {
                States.gameOn = false;
                States.playersInGame.clear();
                States.currentlyIt = null;
                Bukkit.broadcastMessage("The tag game has now ended.");
                return true;
            } else {
                Bukkit.broadcastMessage("There is no game of Tag to end!");
            }
        }
        sender.sendMessage("Sorry you are not a player. This command is only allowed for players.");
        return false;
    }
}
