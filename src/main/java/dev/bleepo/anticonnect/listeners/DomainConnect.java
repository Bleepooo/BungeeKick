package dev.bleepo.anticonnect.listeners;

import dev.bleepo.anticonnect.utils.Config;
import dev.bleepo.anticonnect.utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class DomainConnect implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PreLoginEvent event) {
        if (Config.getConfig().getBoolean("DomainRedirect.Enabled")) {
            if (Config.getConfig().getStringList("DomainRedirect.Domains").contains(event.getConnection().getVirtualHost().getHostName())) {
                String kickReason = String.join("\n", Config.getConfig().getStringList("DomainRedirect.Message"));
                TextComponent component = new TextComponent(ChatColor.translateAlternateColorCodes('&', kickReason));
                Utils.sendInfo("Disconnected &3" + event.getConnection().getName() + " &6because they tried to connect with &3" + event.getConnection().getVirtualHost().getHostName() + "&6.");
                event.getConnection().disconnect(component);
            }
        }
    }
}
