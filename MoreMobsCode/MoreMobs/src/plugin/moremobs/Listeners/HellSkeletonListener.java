package plugin.moremobs.Listeners;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import plugin.moremobs.*;
import plugin.moremobs.Mobs.*;

public class HellSkeletonListener implements Listener{
	
	public MoreMobsCore plugin;
	public HellSkeleton MMHellSkeleton;
	
	public HellSkeletonListener(MoreMobsCore plugin) {
		this.plugin = plugin;
	}
	
	@SuppressWarnings("static-access")
	@EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
	public void onPlayerInteract(PlayerInteractEntityEvent event) {
		Entity interactedEntity = event.getRightClicked();
		if(interactedEntity instanceof Skeleton) {
			Skeleton HS = (Skeleton) interactedEntity;
			if(MMHellSkeleton.isHellSkeleton(HS)) {
				event.setCancelled(true);
			}
		}
	}
	
	
	
	@SuppressWarnings("static-access")
	@EventHandler(priority=EventPriority.HIGH)
	public void onMobDamage(EntityDamageByEntityEvent event) {
		Entity entity = event.getEntity();
		Entity damager = event.getDamager();
		if(entity instanceof Player) {
			if(damager instanceof Skeleton) {
				Player player = (Player) entity;
				Skeleton HS = (Skeleton) damager;
				if(MMHellSkeleton.isHellSkeleton(HS)) {
					player.setFireTicks(30);
				}
			}
		}
	}
	
	@SuppressWarnings("static-access")
	@EventHandler(priority=EventPriority.HIGH)
	public void onMobDeath(EntityDeathEvent event) {
		Entity entity = event.getEntity();
		World world = event.getEntity().getWorld();
		if(entity instanceof Skeleton) {
			Skeleton HS = (Skeleton) entity;
			Location HSLoc = HS.getLocation();
			if(MMHellSkeleton.isHellSkeleton(HS)) {
				try {
					world.playSound(HSLoc, Sound.GHAST_FIREBALL, 1.0F, 1.0F);
					world.playEffect(HSLoc, Effect.MOBSPAWNER_FLAMES, 1);
					event.getDrops().clear();
					if(entity.getLastDamageCause().getCause().equals(DamageCause.ENTITY_ATTACK)) {
						event.setDroppedExp(15);
					}
				} catch(Exception ex) {
					return;
				}
			}
		}
	}
}

