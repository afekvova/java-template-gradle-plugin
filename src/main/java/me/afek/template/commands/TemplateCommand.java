package me.afek.template.commands;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import me.afek.template.Template;
import me.afek.template.commands.subcommands.ReloadSubCommand;
import me.afek.template.settings.Settings;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TemplateCommand implements CommandExecutor {

    Set<SubCommand> subCommandSet = new HashSet<>();

    public TemplateCommand(Template template) {;
        registerSubCommands(template);
    }

    private void registerSubCommands(Template template) {
        subCommandSet.add(new ReloadSubCommand(template));
    }

    private void sendHelp(CommandSender sender) {
        subCommandSet.stream().filter(subCommand -> subCommand.checkPermission(sender)).map(SubCommand::getUsage).forEach(sender::sendMessage);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmdLabel, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
            return true;
        }

        Optional<SubCommand> subCommandOptional = subCommandSet.stream().filter(subCommand -> subCommand.getLabel().equalsIgnoreCase(args[0])).findFirst();
        if (!subCommandOptional.isPresent()) {
            sendHelp(sender);
            return true;
        }

        SubCommand subCommand = subCommandOptional.get();
        if (!subCommand.checkPermission(sender)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Settings.IMP.PERMISSIONS));
            return true;
        }

        if (args.length < subCommand.getMinArgs()) {
            sender.sendMessage(subCommand.getUsage());
            return true;
        }

        subCommand.execute(sender, args);
        return true;
    }
}