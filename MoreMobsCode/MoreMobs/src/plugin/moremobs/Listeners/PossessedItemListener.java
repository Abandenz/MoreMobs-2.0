package plugin.moremobs.Listeners;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Mobs.PossessedItem;

public class PossessedItemListener implements Listener {

	public MoreMobsCore plugin;
	public PossessedItem MMPossessedItem;

	public PossessedItemListener(MoreMobsCore plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("static-access")
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		Random rand = new Random();
		int possessionChance = rand.nextInt(5);
		final ItemStack droppedStack = event.getItemDrop().getItemStack();
		final Entity droppedStackEntity = event.getItemDrop();
		final Location stackLoc = event.getItemDrop().getLocation();
		if (possessionChance == 1) {
			plugin.getServer().getScheduler()
					.scheduleSyncDelayedTask(plugin, new Runnable() {
						public void run() {
							droppedStackEntity.remove();
							MMPossessedItem.spawnPossessedItem(stackLoc, 1,
									droppedStack);
						}
					}, 200L);
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler(priority = EventPriority.HIGH)
	public void onMobDeath(EntityDeathEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Skeleton) {
			Skeleton possessedItem = (Skeleton) entity;
			if (MMPossessedItem.isPossessedItem(possessedItem)) {
				try {
					event.getDrops().clear();
					if (entity.getLastDamageCause().getCause()
							.equals(DamageCause.ENTITY_ATTACK)) {
						event.setDroppedExp(8);
					}
				} catch (Exception ex) {
					return;
				}
			}
		}
	}
}