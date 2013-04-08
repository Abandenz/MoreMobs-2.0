package plugin.moremobs.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import plugin.moremobs.Mobs.ChargedCreeper;
import plugin.moremobs.MoreMobsCore;

public class ChargedCreeperListener implements Listener {

    public MoreMobsCore plugin;
    public ChargedCreeper MMChargedCreeper;

    public ChargedCreeperListener (MoreMobsCore plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void onMobDeath (EntityDeathEvent event) {
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        if (entity instanceof Creeper) {
            Creeper CC = (Creeper) entity;
            Location CCLoc = CC.getLocation();
            if (MMChargedCreeper.isChargedCreeper(CC)) {
                try {
                    world.strikeLightning(CCLoc);
                    CCLoc.subtract(- 2, - 2, - 2);
                    world.strikeLightning(CCLoc);
                    CCLoc.add(2, 2, 2);
                    world.strikeLightning(CCLoc);
                    event.getDrops().clear();
                    if (entity.getLastDamageCause().getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                        Location CCDeathLoc = CC.getLocation();
                        event.setDroppedExp(15);
                        ItemStack CCDrop = new ItemStack(Material.IRON_PICKAXE, 1);
                        world.dropItemNaturally(CCDeathLoc, CCDrop);
                    }
                } catch (Exception ex) {
                    return;
                }
            }
        }
    }

}
