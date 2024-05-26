package me.afek.template.common;

import lombok.experimental.UtilityClass;
import me.afek.template.settings.Settings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class StringCommon {

    public String color(String textToTranslate) {
        char[] b = textToTranslate.replace("%prefix%", Settings.IMP.PREFIX).replace("{PRFX}", Settings.IMP.PREFIX).replace("{PREFIX}", Settings.IMP.PREFIX).toCharArray();

        for (int i = 0; i < b.length - 1; ++i) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = 167;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }

    public String colorInternal(String textToTranslate) {
        char[] b = textToTranslate.toCharArray();

        for (int i = 0; i < b.length - 1; ++i) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = 167;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }

    public List<String> color(List<String> messages) {
        return messages.stream().map(StringCommon::color).collect(Collectors.toList());
    }

    public List<String> color(String... messages) {
        return Arrays.stream(messages).map(StringCommon::color).collect(Collectors.toList());
    }
}
