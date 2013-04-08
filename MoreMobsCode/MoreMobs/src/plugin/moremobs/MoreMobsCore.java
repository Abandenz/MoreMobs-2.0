package plugin.moremobs;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.moremobs.Commands.CommandHandler;
import plugin.moremobs.Listeners.*;
import plugin.moremobs.Mobs.*;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class MoreMobsCore extends JavaPlugin {

    public static final Logger log = Logger.getLogger("Minecraft");
    public static MoreMobsCore plugin;
    public Hellhound MMHellhound;
    public ChargedCreeper MMChargedCreeper;
    public HellSkeleton MMHellSkeleton;
    public FoodFight MMFoodFight;
    public PigChest MMPigChest;
    public Lich MMLich;
    public PossessedItem MMPossessedItem;
    public Wraith MMWraith;
    public ZombieGiant MMGiant;
    private final ChargedCreeperListener chargedcreeper;
    private final FoodFightListener foodfight;
    private final HellSkeletonListener hellskele;
    private final PigChestListener pigchest;
    private final HellhoundListener hellhound;
    private final LichListener lich;
    private final PossessedItemListener possessedItem;
    private final WraithListener wraith;
    public static Double version = Double.valueOf(2.0);
    public static Integer maxSpawnLimit = Integer.valueOf(10);

    public MoreMobsCore () {
        this.chargedcreeper = new ChargedCreeperListener(this);
        this.foodfight = new FoodFightListener(this);
        this.hellskele = new HellSkeletonListener(this);
        this.pigchest = new PigChestListener(this);
        this.hellhound = new HellhoundListener(this);
        this.lich = new LichListener(this);
        this.possessedItem = new PossessedItemListener(this);
        this.wraith = new WraithListener(this);
    }

    @Override
    public void onEnable () {
        loadConfig();
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this.foodfight, this);
        manager.registerEvents(this.chargedcreeper, this);
        manager.registerEvents(this.hellskele, this);
        manager.registerEvents(this.pigchest, this);
        manager.registerEvents(this.hellhound, this);
        manager.registerEvents(this.lich, this);
        manager.registerEvents(this.possessedItem, this);
        manager.registerEvents(this.wraith, this);
        getCommand("MoreMobs").setExecutor(new CommandHandler(plugin));
    }

    public void loadConfig () {
        File folder = getDataFolder();
        PluginDescriptionFile pdfFile = getDescription();
        File configFile = new File(getDataFolder(), "config.yml");
        Properties settingsFile = new Properties();
        if (! (folder.exists())) {
            try {
                folder.mkdir();
                log.info("[More Mobs] Created folder.");
            } catch (Exception ex) {
                log.info("[More Mobs] Failed to create folder!");
                getServer().getPluginManager().disablePlugin(plugin);
            }
        }
        if (! configFile.exists()) {
            try {
                configFile.createNewFile();
                FileOutputStream out = new FileOutputStream(configFile);
                settingsFile.put("Version", Double.toString(version));
                settingsFile.put("MaxSpawnLimit", Integer.toString(maxSpawnLimit.intValue()));
                settingsFile.store(out, "Configuration file for More Mobs " + pdfFile.getVersion());
                log.info("[More Mobs] Created configuration file.");
            } catch (IOException ex) {
                log.info("[More Mobs] Failed to create configuration file!");
            }
        } else {
            try {
                FileInputStream in = new FileInputStream(configFile);
                try {
                    try {
                        settingsFile.load(in);
                        if (! settingsFile.getProperty("Version").equals(version)) {
                            FileOutputStream out = new FileOutputStream(configFile);
                            settingsFile.put("Version", Double.toString(version));
                            settingsFile.put("MaxSpawnLimit", Integer.toString(maxSpawnLimit.intValue()));
                            settingsFile.store(out, "Configuration file for More Mobs " + pdfFile.getVersion());
                            log.info("[More Mobs] Updating configuration file!");
                        }
                    } catch (NullPointerException ex) {
                        log.info("[More Mobs] Failed to update configuration file! Disabling plugin.");
                        getServer().getPluginManager().disablePlugin(plugin);
                    }
                    settingsFile.load(in);
                    maxSpawnLimit = Integer.valueOf(settingsFile.getProperty("MaxSpawnLimit"));
                    log.info("[More Mobs] Loaded configuration file.");
                } catch (IOException ex) {
                    log.info("[More Mobs] Failed to load configuration file! Disabling plugin.");
                    getServer().getPluginManager().disablePlugin(plugin);
                }
            } catch (FileNotFoundException ex) {
                log.info("[More Mobs] Failed to load configuration file! Disabling plugin.");
                getServer().getPluginManager().disablePlugin(plugin);
            }
        }
    }

    public void reloadConfig () {
        File configFile = new File(getDataFolder(), "config.yml");
        Properties settingsFile = new Properties();
        try {
            FileInputStream in = new FileInputStream(configFile);
            try {
                settingsFile.load(in);
                maxSpawnLimit = Integer.valueOf(settingsFile.getProperty("MaxSpawnLimit"));
                log.info("[More Mobs] Reloaded configuration file.");
            } catch (IOException ex) {
                log.info("[More Mobs] Failed to reload configuration file!");
            }
        } catch (FileNotFoundException ex) {
            log.info("[More Mobs] Failed to reload configuration file!");
        }
    }
}