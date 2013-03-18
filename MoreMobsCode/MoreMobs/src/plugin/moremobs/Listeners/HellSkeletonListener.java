package plugin.moremobs.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import plugin.moremobs.Mobs.HellSkeleton;
import plugin.moremobs.MoreMobsCore;

public class HellSkeletonListener implements Listener {

    public MoreMobsCore plugin;
    public HellSkeleton MMHellSkeleton;

    public HellSkeletonListener (MoreMobsCore plugin) {
        this.plugin = plugin;
    }


    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void EntityShootBowEvent (EntityShootBowEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Skeleton) {
            Skeleton HS = (Skeleton) entity;
            if (MMHellSkeleton.isHellSkeleton(HS)) {
                HS.setFireTicks(30);
            }


        }


    }
}



