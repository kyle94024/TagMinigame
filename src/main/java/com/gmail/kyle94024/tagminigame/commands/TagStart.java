package com.gmail.kyle94024.tagminigame.commands;

import com.gmail.kyle94024.tagminigame.utility.States;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class TagStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            // TODO: Add game logic
            if (!States.gameOn) {
                States.gameOn = true;
                States.playersInGame.addAll(Bukkit.getOnlinePlayers());
                Random randomizer = new Random();
                States.currentlyIt = States.playersInGame.get(randomizer.nextInt(States.playersInGame.size()));
                Bukkit.broadcastMessage("A new tag game has begun. " + States.currentlyIt.getDisplayName() + " is it!");
                return true;
            } else {
                Bukkit.broadcastMessage("A game of tag is currently running. Try again after the game ends.");
            }
        }
        sender.sendMessage("Sorry you are not a player. This command is only allowed for players.");
        return false;
    }
}
