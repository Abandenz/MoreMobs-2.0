package plugin.moremobs.Mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PossessedItem {

    public static boolean isPossessedItem(Entity entity) {
        if (entity instanceof Skeleton) {
            Skeleton lich = (Skeleton) entity;
            if (lich.getEquipment()
                    .getChestplate()
                    .equals(new ItemStack(Material.GLOWSTONE, 1, (short) -98789))) {
                return true;
            }
        }
        return false;
    }

    public static void spawnPossessedItem(Location loc, int amount,
                                          ItemStack stack) {
        int i = 0;
        while (i < amount) {
            Skeleton possessedItem = (Skeleton) loc.getWorld().spawnEntity(loc,
                    EntityType.SKELETON);
            possessedItem.addPotionEffect(new PotionEffect(
                    PotionEffectType.FIRE_RESISTANCE, 2147483647, 10));
            possessedItem.addPotionEffect(new PotionEffect(
                    PotionEffectType.INVISIBILITY, 2147483647, 10));
            possessedItem.setHealth(6);
            possessedItem.getEquipment().setHelmet(
                    new ItemStack(Material.GLOWSTONE_DUST, 1));
            possessedItem.getEquipment().setChestplate(
                    new ItemStack(Material.GLOWSTONE, 1, (short) -98789));
            possessedItem.getEquipment().setItemInHand(stack);
            possessedItem.getEquipment().setHelmetDropChance(0.0F);
            possessedItem.getEquipment().setChestplateDropChance(0.0F);
            possessedItem.getEquipment().setItemInHandDropChance(100.0F);
            possessedItem.setCanPickupItems(false);
            i++;
        }
    }
}