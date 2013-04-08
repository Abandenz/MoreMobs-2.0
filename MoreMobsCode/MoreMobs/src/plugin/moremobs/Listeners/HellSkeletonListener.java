package plugin.moremobs.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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
    public void onPlayerDamage (EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        if (entity instanceof Player) {
            if (damager instanceof Skeleton) {
                Player player = (Player) entity;
                Skeleton hellskele = (Skeleton) damager;
                if (MMHellSkeleton.isHellSkeleton(hellskele)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, 1));
                    player.sendMessage("" + ChatColor.RED + ChatColor.ITALIC + "You start to uncontrollably shudder!");
                }
            }
        }
    }


}


