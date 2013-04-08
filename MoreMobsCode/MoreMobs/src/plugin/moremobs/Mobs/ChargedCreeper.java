package plugin.moremobs.Mobs;

import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class ChargedCreeper {

    public static boolean isChargedCreeper (Entity entity) {
        if (entity instanceof Creeper) {
            Creeper chargedcreeper = (Creeper) entity;
            if (chargedcreeper.isPowered()) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("static-access")
    public static void spawnChargedCreeper (Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            Creeper chargedcreeper = (Creeper) loc.getWorld().spawnEntity(loc, EntityType.CREEPER);
            chargedcreeper.setPowered(true);
            i++;
        }
    }
}
