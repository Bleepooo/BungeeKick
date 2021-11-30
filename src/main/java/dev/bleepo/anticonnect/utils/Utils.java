package dev.bleepo.anticonnect.utils;

import dev.bleepo.anticonnect.Main;
import net.md_5.bungee.api.ChatColor;

public class Utils {
    public static void sendInfo(String message) {
        Main.getInstance().getLogger().info(ChatColor.translateAlternateColorCodes('&', "&6[&bBungee&3Kick&6] " + message));
    }
}
