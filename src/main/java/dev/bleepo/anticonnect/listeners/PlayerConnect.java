package dev.bleepo.anticonnect.listeners;

import dev.bleepo.anticonnect.utils.Config;
import dev.bleepo.anticonnect.utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class PlayerConnect implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PreLoginEvent event) {
        if (Config.getConfig().getBoolean("KickOnJoin.Enabled")) {
            String kickReason = String.join("\n", Config.getConfig().getStringList("KickOnJoin.Message"));
            TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', kickReason));
            Utils.sendInfo("Disconnected &3" + event.getConnection().getName() + " &6because &bBungee&3Kick &6is enabled.");
            event.getConnection().disconnect(component);
        }
    }
}
