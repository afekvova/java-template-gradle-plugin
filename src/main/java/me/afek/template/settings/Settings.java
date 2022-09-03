package me.afek.template.settings;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Settings extends Config {

    @Ignore
    public static final Settings IMP = new Settings();

    public String PREFIX = "&f[&6Temlate&f]&f";
    public String PERMISSIONS = "У вас недостаточно прав!";

    public void reload(File file) {
        if (this.load(file)) {
            this.save(file);
            return;
        }

        this.save(file);
        this.load(file);
    }
}