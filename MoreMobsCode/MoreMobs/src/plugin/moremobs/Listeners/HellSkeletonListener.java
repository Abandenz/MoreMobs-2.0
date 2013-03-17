package plugin.moremobs.Listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import plugin.moremobs.Mobs.HellSkeleton;
import plugin.moremobs.MoreMobsCore;

public class HellSkeletonListener implements Listener {

    public MoreMobsCore plugin;
    public HellSkeleton MMHellSkeleton;
    private ItemStack bow = new ItemStack(Material.BOW, 1);
    private Projectile arrow = new Projectile(Entity.Arrow, 1);


    public HellSkeletonListener(MoreMobsCore plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        Entity interactedEntity = event.getRightClicked();
        if (interactedEntity instanceof Skeleton) {
            Skeleton HS = (Skeleton) interactedEntity;
            if (MMHellSkeleton.isHellSkeleton(HS)) {
                event.setCancelled(true);
            }
        }
    }


    @EventHandler(priority = EventPriority.HIGH)
    void EntityShootBowEvent(final LivingEntity MMHellSkeleton, final ItemStack bow, final Projectile projectile, final float force)


    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void onMobDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (entity instanceof Player) {
            if (damager instanceof Skeleton) {
                Player player = (Player) entity;
                Skeleton HS = (Skeleton) damager;
                if (MMHellSkeleton.isHellSkeleton(HS)) {
                    player.setFireTicks(30);
                }
            }
        }
    }

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void onMobDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        if (entity instanceof Skeleton) {
            Skeleton HS = (Skeleton) entity;
            Location HSLoc = HS.getLocation();
            if (MMHellSkeleton.isHellSkeleton(HS)) {
                try {
                    world.playSound(HSLoc, Sound.GHAST_FIREBALL, 1.0F, 1.0F);
                    world.playEffect(HSLoc, Effect.MOBSPAWNER_FLAMES, 1);
                    event.getDrops().clear();
                    if (entity.getLastDamageCause().getCause()
                            .equals(DamageCause.ENTITY_ATTACK)) {
                        event.setDroppedExp(15);
                    }
                } catch (Exception ex) {
                    return;
                }
            }
        }
    }
}
