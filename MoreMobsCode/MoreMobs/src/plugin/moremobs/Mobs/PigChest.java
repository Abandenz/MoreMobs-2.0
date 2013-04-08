package plugin.moremobs.Mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class PigChest {

    @SuppressWarnings("deprecation")
    public static boolean isPigChest (Entity entity) {
        if (entity instanceof Pig) {
            Pig pigc = (Pig) entity;
            if (pigc.getPassenger() instanceof StorageMinecart) {
                ItemStack pigcChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1, (short) - 98789);
                if (pigc.getEquipment().getChestplate().equals(pigcChest)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void spawnPigChest (Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            LivingEntity pig = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.PIG);
            pig.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
            Entity minecart = (Entity) loc.getWorld().spawn(loc, StorageMinecart.class);
            pig.setPassenger(minecart);
            i++;
        }
    }
}