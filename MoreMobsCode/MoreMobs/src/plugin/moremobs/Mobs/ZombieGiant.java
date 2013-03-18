package plugin.moremobs.Mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ZombieGiant {

    public static boolean isZombieGiant (Entity entity) {
        if (entity instanceof Giant) {
            return true;
        }
        return false;
    }

    public static void spawnZombieGiant (Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            Giant giant = (Giant) loc.getWorld().spawnEntity(loc, EntityType.GIANT);
            giant.setHealth(100);
            giant.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 3));
            i++;
        }
    }
}