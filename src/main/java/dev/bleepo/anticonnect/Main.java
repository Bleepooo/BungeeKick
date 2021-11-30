package dev.bleepo.anticonnect;

import dev.bleepo.anticonnect.listeners.PlayerConnect;
import dev.bleepo.anticonnect.utils.Config;
import dev.bleepo.anticonnect.utils.Utils;
import net.md_5.bungee.api.plugin.Plugin;

public final class Main extends Plugin {
    private static Main Instance;

    public static Main getInstance() {
        return Instance;
    }

    @Override
    public void onEnable() {
        if (Instance == null) {
            Instance = this;
        }

        Config.makeConfig();
        getProxy().getPluginManager().registerListener(this, new PlayerConnect());
        Utils.sendInfo("Loaded and Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
