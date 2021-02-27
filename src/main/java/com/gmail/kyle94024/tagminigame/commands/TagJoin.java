package com.gmail.kyle94024.tagminigame.commands;

import com.gmail.kyle94024.tagminigame.utility.States;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TagJoin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            // TODO: Add game logic
            Player player = (Player) sender;
            if (States.gameOn) {
                if (!States.playersInGame.contains(player)) {
                    States.playersInGame.add(player);
                    player.sendMessage("You were successfully added to the game!");
                    player.sendMessage("Currently " + States.currentlyIt.getDisplayName() + " is it!");
                } else {
                    player.sendMessage("You are already part of the tag game!");
                }
            } else {
                player.sendMessage("Unfortunately, there is not tag game going on right now.");
            }
        }
        sender.sendMessage("Sorry you are not a player. This command is only allowed for players.");
        return false;
    }
}
