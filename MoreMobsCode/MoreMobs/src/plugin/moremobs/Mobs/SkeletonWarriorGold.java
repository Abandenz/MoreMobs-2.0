package plugin.moremobs.Mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkeletonWarriorGold {

    public static boolean isSkeletonWarriorGold(
            SkeletonWarriorGold MMSkeletonWarriorGold) {
        if (MMSkeletonWarriorGold instanceof Skeleton) {
            Skeleton SkeletonWarriorGold = (Skeleton) MMSkeletonWarriorGold;
            if (SkeletonWarriorGold.getEquipment().getChestplate()
                    .equals(new ItemStack(315))) {
                return true;
            }
        }
        return false;
    }

    public static void spawnSkeletonWarriorGold(Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            Skeleton SkeletonWarriorIron = (Skeleton) loc.getWorld()
                    .spawnEntity(loc, EntityType.SKELETON);
            SkeletonWarriorIron.getEquipment().setChestplate(
                    new ItemStack(Material.GOLD_CHESTPLATE, 1));
            SkeletonWarriorIron.getEquipment().setHelmet(
                    new ItemStack(Material.GOLD_HELMET, 1));
            SkeletonWarriorIron.getEquipment().setLeggings(
                    new ItemStack(Material.GOLD_LEGGINGS, 1));
            SkeletonWarriorIron.getEquipment().setBoots(
                    new ItemStack(Material.GOLD_BOOTS, 1));
            SkeletonWarriorIron.getEquipment().setItemInHand(
                    new ItemStack(Material.BOW, 1));
            SkeletonWarriorIron.getEquipment().setHelmetDropChance(0.50F);
            SkeletonWarriorIron.getEquipment().setChestplateDropChance(0.50F);
            SkeletonWarriorIron.getEquipment().setItemInHandDropChance(0.50F);
            SkeletonWarriorIron.addPotionEffect(new PotionEffect(
                    PotionEffectType.SPEED, 2147483647, 1));
            SkeletonWarriorIron.setCanPickupItems(false);
            i++;
        }
    }
}