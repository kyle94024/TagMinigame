package com.gmail.kyle94024.tagminigame.commands;

import com.gmail.kyle94024.tagminigame.utility.States;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TagLeave implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            // TODO: Add game logic
            Player player = (Player) sender;
            if (States.gameOn) {
                if (States.playersInGame.contains(player)) {
                    States.playersInGame.remove(player);
                    player.sendMessage("You successfully left the game!");
                    return true;
                } else {
                    player.sendMessage("You are not a player in the tag game!");
                    return true;
                }
            } else {
                player.sendMessage("Unfortunately, there is not tag game going on right now.");
                return true;
            }
        }
        sender.sendMessage("Sorry you are not a player. This command is only allowed for players.");
        return false;
    }
}
