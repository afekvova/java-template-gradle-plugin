package me.afek.template;

import me.afek.template.commands.TemplateCommand;
import me.afek.template.settings.Settings;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.io.File;

@Plugin(name = "Template", version = "1.0.0")
@Description("A simple, human-friendly template")
@Website("t.me/afekvova, github.com/afekvova, gitlab.com/afekvova, vk.com/afekvova")
@Author("Afek")
@Commands(@Command(name = "template"))
public final class Template extends JavaPlugin {

    @Override
    public void onEnable() {
        Settings.IMP.reload(new File(this.getDataFolder(), "config.yml"));
        this.getCommand("template").setExecutor(new TemplateCommand(this));
    }

    @Override
    public void onDisable() {

    }
}
