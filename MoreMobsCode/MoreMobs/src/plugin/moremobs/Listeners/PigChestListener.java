package plugin.moremobs.Listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
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

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void onMobDeath (EntityDeathEvent event) {
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        if (entity instanceof Pig) {
            Pig pigc = (Pig) entity;
            Location pigcLoc = pigc.getLocation();
            if (MMPigChest.isPigChest(pigc)) {
                try {
                    Location teleloc = pigcLoc;
                    teleloc.add(1920, 1920, 1920);
                    pigc.getPassenger().teleport(teleloc);
                } catch (Exception ex) {
                    return;
                }
            }
        }
    }
}

