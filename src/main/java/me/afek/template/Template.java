package me.afek.template;

import me.afek.template.settings.Settings;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.io.File;

@Plugin(name = "Template", version = "1.0.0")
@Description("A simple, human-friendly template")
@Website("t.me/afekvova, github.com/afekvova, gitlab.com/afekvova, vk.com/afekvova")
@Author("Afek")
public final class Template extends JavaPlugin {

    @Override
    public void onEnable() {
        Settings.IMP.reload(new File(this.getDataFolder(), "config.yml"));
    }

    @Override
    public void onDisable() {

    }
}
