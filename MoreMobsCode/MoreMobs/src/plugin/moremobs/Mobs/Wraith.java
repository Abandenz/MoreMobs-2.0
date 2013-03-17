package plugin.moremobs.Mobs;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Wraith {

    public static boolean isWraith(Entity entity) {
        if (entity instanceof Zombie) {
            Zombie wraith = (Zombie) entity;
            if (wraith.getEquipment().getChestplate()
                    .equals(new ItemStack(299, 1, (short) -98789))) {
                return true;
            }
        }
        return false;
    }

    public static void spawnWraith(Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            LeatherArmorMeta meta;
            ItemStack stack = new ItemStack(299, 1, (short) -98789);
            meta = (LeatherArmorMeta) stack.getItemMeta();
            meta.setColor(Color.fromRGB(52, 52, 52));
            stack.setItemMeta(meta);
            Zombie wraith = (Zombie) loc.getWorld().spawnEntity(loc,
                    EntityType.ZOMBIE);
            wraith.getEquipment().setHelmet(
                    new ItemStack(Material.SKULL_ITEM, 1, (short) 1));
            wraith.getEquipment().setChestplate(stack);
            wraith.getEquipment().setItemInHand(
                    new ItemStack(Material.IRON_HOE, 1));
            wraith.getEquipment().setHelmetDropChance(0.0F);
            wraith.getEquipment().setChestplateDropChance(0.0F);
            wraith.getEquipment().setItemInHandDropChance(0.0F);
            wraith.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
                    2147483647, 2));
            wraith.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                    2147483647, 1));
            wraith.addPotionEffect(new PotionEffect(
                    PotionEffectType.INVISIBILITY, 2147483647, 10));
            wraith.addPotionEffect(new PotionEffect(
                    PotionEffectType.INCREASE_DAMAGE, 2147483647, 1));
            wraith.addPotionEffect(new PotionEffect(
                    PotionEffectType.FIRE_RESISTANCE, 2147483647, 10));
            wraith.addPotionEffect(new PotionEffect(
                    PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 2));
            wraith.addPotionEffect(new PotionEffect(
                    PotionEffectType.WATER_BREATHING, 2147483647, 1));
            wraith.setCanPickupItems(false);
            i++;
        }
    }
}