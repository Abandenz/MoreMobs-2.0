package plugin.moremobs.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import plugin.moremobs.Mobs.PigChest;
import plugin.moremobs.MoreMobsCore;

public class PigChestListener implements Listener {

    public MoreMobsCore plugin;
    public PigChest MMPigChest;

    public PigChestListener (MoreMobsCore plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings({"deprecation", "static-access"})
    @EventHandler(priority = EventPriority.HIGH)
    public void onMobDeath (EntityDeathEvent event) {
        Entity entity = event.getEntity();
        event.getEntity().getWorld();
        if (entity instanceof Pig) {
            Pig pigc = (Pig) entity;
            pigc.getLocation();
            if (MMPigChest.isPigChest(pigc)) {
                StorageMinecart chest = (StorageMinecart) pigc.getPassenger();
                try {
                    chest.remove();
                } catch (Exception ex) {
                    return;
                }
            }
        }
    }
}

