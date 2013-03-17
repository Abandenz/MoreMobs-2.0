package plugin.moremobs.Mobs;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FoodFight {

    public static boolean isFoodFight(FoodFight MMFoodFight) {
        if (MMFoodFight instanceof Zombie) {
            Zombie FoodFight = (Zombie) MMFoodFight;
            if (FoodFight.getEquipment().getChestplate()
                    .equals(new ItemStack(299, 1, (short) -98789))) {
                return true;
            }
        }
        return false;
    }

    public static void spawnFoodFight(Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            Zombie FoodFight = (Zombie) loc.getWorld().spawnEntity(loc,
                    EntityType.ZOMBIE);
            LeatherArmorMeta meta;
            LeatherArmorMeta legMeta;
            ItemStack FFLeg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            legMeta = (LeatherArmorMeta) FFLeg.getItemMeta();
            legMeta.setColor(Color.fromRGB(48, 206, 0));
            FFLeg.setItemMeta(legMeta);
            LeatherArmorMeta chestMeta;
            ItemStack FFChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1,
                    (short) -98789);
            chestMeta = (LeatherArmorMeta) FFChest.getItemMeta();
            chestMeta.setColor(Color.fromRGB(48, 206, 0));
            FFChest.setItemMeta(chestMeta);
            LeatherArmorMeta bootsMeta;
            ItemStack FFBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
            bootsMeta = (LeatherArmorMeta) FFBoots.getItemMeta();
            bootsMeta.setColor(Color.fromRGB(48, 206, 0));
            FFBoots.setItemMeta(bootsMeta);
            LeatherArmorMeta HelmetMeta;
            ItemStack FFHelm = new ItemStack(Material.LEATHER_HELMET, 1);
            HelmetMeta = (LeatherArmorMeta) FFHelm.getItemMeta();
            HelmetMeta.setColor(Color.fromRGB(48, 206, 0));
            FFHelm.setItemMeta(HelmetMeta);
            FoodFight.getEquipment().setItemInHand(
                    new ItemStack(Material.PORK, 1));
            FoodFight.getEquipment().setChestplate(FFChest);
            FoodFight.getEquipment().setLeggings(FFLeg);
            FoodFight.getEquipment().setBoots(FFBoots);
            FoodFight.getEquipment().setChestplateDropChance(0.30F);
            FoodFight.getEquipment().setLeggingsDropChance(0.30F);
            FoodFight.getEquipment().setBootsDropChance(0.40F);
            FoodFight.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                    2147483647, 1));
            FoodFight.addPotionEffect(new PotionEffect(
                    PotionEffectType.INVISIBILITY, 2147483647, 10));
            FoodFight.addPotionEffect(new PotionEffect(
                    PotionEffectType.INCREASE_DAMAGE, 2147483647, 1));
            FoodFight.addPotionEffect(new PotionEffect(
                    PotionEffectType.WATER_BREATHING, 2147483647, 1));
            FoodFight.setCanPickupItems(false);
            FoodFight.setBaby(true);
            i++;
        }
    }
}