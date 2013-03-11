package plugin.moremobs.Listeners;

import java.util.Iterator;
import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Mobs.Wisp;

public class WispListener implements Listener {

	public MoreMobsCore plugin;
	public Wisp MMWisp;

	public WispListener(MoreMobsCore plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void EntityTargetEvent(final Entity entity, final Entity target,
			final TargetReason reason) {
		if (entity instanceof Bat) {
			Bat wisp = (Bat) entity;
			if (MMWisp.isWisp(wisp)) {
				plugin.getServer().getScheduler()
						.scheduleSyncDelayedTask(plugin, new Runnable() {
							public void run() {
								entity.getWorld().playEffect(
										entity.getLocation(),
										Effect.MOBSPAWNER_FLAMES, 0);
								entity.getWorld().playEffect(
										entity.getLocation(),
										Effect.POTION_BREAK, 0);
								entity.getWorld().playEffect(
										entity.getLocation(), Effect.SMOKE, 0);
								entity.getWorld().playEffect(
										entity.getLocation(),
										Effect.ENDER_SIGNAL, 0);
								entity.getWorld().playEffect(
										entity.getLocation(),
										Effect.POTION_BREAK, 1);
							}
						}, 20L);
			}
		}
	}
}
