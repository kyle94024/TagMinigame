package com.gmail.kyle94024.tagminigame.commands;

import com.gmail.kyle94024.tagminigame.TagMinigame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class TagMain implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String description = TagMinigame.getPlugin().getDescription().getDescription();
        sender.sendMessage(description);
        return true;
    }
}
