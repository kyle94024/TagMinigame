package com.gmail.kyle94024.tagminigame.commands;

import com.gmail.kyle94024.tagminigame.utility.States;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TagStatus implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            // TODO: Add game logic
            if (States.gameOn) {
                sender.sendMessage("There are currently " + States.playersInGame.size() +  " playing. " + States.currentlyIt.getDisplayName() + " is currently it!");
            }
            else {
                sender.sendMessage("There is no tag game currently running.");
            }
            return true;
        }
        sender.sendMessage("Sorry you are not a player. This command is only allowed for players.");
        return false;
    }
}
