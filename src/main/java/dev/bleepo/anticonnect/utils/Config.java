package dev.bleepo.anticonnect.utils;

import dev.bleepo.anticonnect.Main;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public class Config {
    private static Configuration config;
    private static File configFile;

    public static void makeConfig() {
        try {
            File dataFolder = Main.getInstance().getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }
            configFile = new File(dataFolder, "config.yml");
            if (!configFile.exists()) {
                InputStream stream = Config.class.getClassLoader().getResourceAsStream("config.yml");
                if (stream != null) {
                    Files.copy(stream, configFile.toPath());
                    stream.close();
                } else {
                    throw new NullPointerException("Corrupted jar file");
                }
            }
            loadConfig();
        } catch (Exception e) {
            System.out.println("&eFailed to create or load configuration");
            e.printStackTrace();
        }
    }

    private static void loadConfig() {
        try {
            config = YamlConfiguration.getProvider(YamlConfiguration.class).load(configFile);
        } catch (Exception e) {
            System.out.println("&eFailed to load configuration");
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        loadConfig();
    }

    public static Configuration getConfig() {
        return config;
    }
}
