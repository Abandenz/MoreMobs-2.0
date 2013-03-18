package plugin.moremobs.Listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.moremobs.Mobs.Lich;
import plugin.moremobs.MoreMobsCore;

import java.util.Random;

public class LichListener implements Listener {

    public MoreMobsCore plugin;
    public Lich MMLich;

    public LichListener (MoreMobsCore plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamage (EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (entity instanceof Player) {
            if (damager instanceof Skeleton) {
                Player player = (Player) entity;
                Skeleton lich = (Skeleton) damager;
                if (MMLich.isLich(lich)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, 1));
                    player.sendMessage("" + ChatColor.RED + ChatColor.ITALIC + "You start to uncontrollably shudder!");
                }
            }
        }
    }

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onMobDamage (EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (entity instanceof Skeleton) {
            final Skeleton lich = (Skeleton) entity;
            if (damager instanceof Player) {
                final Player player = (Player) damager;
                if (MMLich.isLich(lich)) {
                    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                        public void run () {
                            Random rand = new Random();
                            int i = rand.nextInt(5);
                            int j = rand.nextInt(5);
                            int k = rand.nextInt(5);
                            int l = rand.nextInt(5);
                            Location lichLoc = lich.getLocation();
                            lichLoc.add(i + 0 - j, 0, k + 0 - l);
                            lichLoc.getWorld().getHighestBlockAt(lichLoc).getLocation();
                            lich.getWorld().playEffect(lich.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                            lich.getWorld().playSound(lich.getLocation(), Sound.GHAST_FIREBALL, 0.7F, 1.0F);
                            Zombie undead = (Zombie) lichLoc.getWorld().spawnEntity(lichLoc, EntityType.ZOMBIE);
                            undead.getEquipment().setHelmet(new ItemStack(Material.GLOWSTONE_DUST, 1));
                            undead.getEquipment().setHelmetDropChance(0.0F);
                            undead.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 10));
                            undead.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2147483647, 1));
                            undead.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 2));
                            undead.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 2147483647, 1));
                            undead.setTarget(player);
                        }
                    }, 15L);
                }
            }
        }
    }

    @SuppressWarnings("static-access")
    @EventHandler(priority = EventPriority.HIGH)
    public void onMobDeath (EntityDeathEvent event) {
        Entity entity = event.getEntity();
        World world = event.getEntity().getWorld();
        if (entity instanceof Skeleton) {
            Skeleton lich = (Skeleton) entity;
            Location lichLoc = lich.getLocation();
            if (MMLich.isLich(lich)) {
                try {
                    world.playSound(lichLoc, Sound.GHAST_DEATH, 1.0F, - 1.0F);
                    event.getDrops().clear();
                    if (entity.getLastDamageCause().getCause().equals(DamageCause.ENTITY_ATTACK)) {
                        event.setDroppedExp(15);
                    }
                } catch (Exception ex) {
                    return;
                }
            }
        }
    }
}