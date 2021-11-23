package dev.bleepo.anticonnect.listeners;

import dev.bleepo.anticonnect.utils.Config;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerConnect implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PreLoginEvent event) {
        if (Config.getConfig().getBoolean("Enabled")) {
            String kickReason = String.join("\n", Config.getConfig().getStringList("Message"));
            TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', kickReason));
            event.getConnection().disconnect(component);
        }
    }
}
