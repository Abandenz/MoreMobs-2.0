package plugin.moremobs.Listeners;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Mobs.Wraith;

public class WraithListener implements Listener {

	public MoreMobsCore plugin;
	public Wraith MMWraith;

	public WraithListener(MoreMobsCore plugin) {
		this.plugin = plugin;
	}

	public static boolean isTrappedSoulItem(Player player) {
		ItemStack itemInHand = player.getItemInHand();
		try {
			if (itemInHand.getType().equals(Material.SOUL_SAND)) {
				if (itemInHand
						.getItemMeta()
						.getDisplayName()
						.equals("" + ChatColor.RED + ChatColor.BOLD
								+ "Trapped Souls")) {
					if (itemInHand
							.getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 10) {
						return true;
					}
				}
			}
		} catch (Exception ex) {
			return false;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Location playerLoc = player.getLocation();
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)
				|| event.getAction().equals(Action.LEFT_CLICK_AIR)
				|| event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			try {
				if (isTrappedSoulItem(player)) {
					player.playSound(playerLoc, Sound.GHAST_MOAN, 0.65F, -1.25F);
				}
			} catch (Exception ex) {
				return;
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Location playerLoc = player.getLocation();
		try {
			if (isTrappedSoulItem(player)) {
				player.playSound(playerLoc, Sound.GHAST_MOAN, 0.65F, -1.25F);
				event.setCancelled(true);
			}
		} catch (Exception ex) {
			return;
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		Random rand = new Random();
		int i = rand.nextInt(200);
		int j = rand.nextInt(200);
		int k = rand.nextInt(200);
		int l = rand.nextInt(200);
		Entity entity = event.getEntity();
		Entity damager = event.getDamager();
		if (entity instanceof Player) {
			if (damager instanceof Zombie) {
				Player player = (Player) entity;
				Zombie wraith = (Zombie) damager;
				if (MMWraith.isWraith(wraith)) {
					Location location = new Location(plugin.getServer()
							.getWorld("world_nether"), i + 0 - j + 0.5, 63, k
							+ 0 - l + 0.5);
					location = location.getWorld().getHighestBlockAt(location)
							.getLocation();
					Location locUnderLoc = location.subtract(0.0D, 1.0D, 0.0D)
							.getBlock().getLocation();
					player.teleport(location);
					if (locUnderLoc.getBlock().getType().equals(Material.LAVA)) {
						locUnderLoc.getBlock().setType(Material.NETHERRACK);
					} else {
						return;
					}
					plugin.getServer().broadcastMessage(
							player.getName()
									+ "'s soul was reaped by a Wraith.");
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onMobDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Zombie) {
			Zombie wraith = (Zombie) entity;
			if (MMWraith.isWraith(wraith)) {
				try {
					if (event.getCause().equals(DamageCause.FALL)) {
						event.setCancelled(true);
					}
				} catch (Exception ex) {
					return;
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	@EventHandler(priority = EventPriority.HIGH)
	public void onMobDeath(EntityDeathEvent event) {
		Random rand = new Random();
		int dropAmount = rand.nextInt(3);
		Entity entity = event.getEntity();
		World world = event.getEntity().getWorld();
		if (entity instanceof Zombie) {
			Zombie wraith = (Zombie) entity;
			Location wraithLoc = wraith.getLocation();
			if (MMWraith.isWraith(wraith)) {
				try {
					world.playSound(wraithLoc, Sound.ENDERMAN_SCREAM, 3.5F,
							-0.005F);
					world.createExplosion(wraithLoc, -1.0F);
					event.getDrops().clear();
					if (entity.getLastDamageCause().getCause()
							.equals(DamageCause.ENTITY_ATTACK)) {
						ItemMeta meta;
						ItemStack stack = new ItemStack(Material.SOUL_SAND,
								dropAmount);
						meta = (ItemMeta) stack.getItemMeta();
						meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD
								+ "Trapped Souls");
						meta.addEnchant(Enchantment.ARROW_INFINITE, 10, true);
						stack.setItemMeta(meta);
						world.dropItemNaturally(wraithLoc, stack);
						event.setDroppedExp(15);
					}
				} catch (Exception ex) {
					return;
				}
			}
		}
	}
}
