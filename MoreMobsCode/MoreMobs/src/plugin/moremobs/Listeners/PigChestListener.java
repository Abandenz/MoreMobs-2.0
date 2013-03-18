package plugin.moremobs.Listeners;

import org.bukkit.event.Listener;
import plugin.moremobs.Mobs.PigChest;
import plugin.moremobs.MoreMobsCore;

public class PigChestListener implements Listener {

    public MoreMobsCore plugin;
    public PigChest MMPigChest;

    public PigChestListener (MoreMobsCore plugin) {
        this.plugin = plugin;
    }
}
