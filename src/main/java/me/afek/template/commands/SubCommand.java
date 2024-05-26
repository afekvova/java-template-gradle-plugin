package me.afek.template.commands;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import me.afek.template.common.StringCommon;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class SubCommand {

    String label, usage;
    int minArgs;

    public SubCommand(String label, int minArgs, String usage) {
        this.label = label;
        this.minArgs = minArgs;
        this.usage = StringCommon.color(usage);
    }

    public boolean checkPermission(CommandSender sender) {
        return sender.hasPermission("template.command." + label);
    }

    public abstract void execute(CommandSender sender, String[] args);
}