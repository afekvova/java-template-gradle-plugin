package me.afek.template.commands.subcommands;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import me.afek.template.Template;
import me.afek.template.commands.SubCommand;
import me.afek.template.settings.Settings;
import org.bukkit.command.CommandSender;

import java.io.File;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReloadSubCommand extends SubCommand {

    Template template;

    public ReloadSubCommand(Template template) {
        super("reload", 1, "/template reload &f- перезагрузить плагин");
        this.template = template;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("Перезагрузка...");
        Settings.IMP.reload(new File(this.template.getDataFolder(), "config.yml"));
        sender.sendMessage("Плагин перезагружен!");
    }
}