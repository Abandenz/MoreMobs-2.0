package plugin.moremobs.Mobs;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Lich {

    public static boolean isLich(Entity entity) {
        LeatherArmorMeta chestMeta;
        ItemStack lichChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1,
                (short) -98789);
        chestMeta = (LeatherArmorMeta) lichChest.getItemMeta();
        chestMeta.setColor(Color.fromRGB(52, 52, 52));
        lichChest.setItemMeta(chestMeta);
        if (entity instanceof Skeleton) {
            Skeleton lich = (Skeleton) entity;
            if (lich.getEquipment().getChestplate().equals(lichChest)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("static-access")
    public static void spawnLich(Location loc, int amount) {
        int i = 0;
        while (i < amount) {
            LeatherArmorMeta helmMeta;
            ItemStack lichHelm = new ItemStack(Material.LEATHER_HELMET, 1);
            helmMeta = (LeatherArmorMeta) lichHelm.getItemMeta();
            helmMeta.setColor(Color.fromRGB(52, 52, 52));
            lichHelm.setItemMeta(helmMeta);
            LeatherArmorMeta chestMeta;
            ItemStack lichChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1,
                    (short) -98789);
            chestMeta = (LeatherArmorMeta) lichChest.getItemMeta();
            chestMeta.setColor(Color.fromRGB(52, 52, 52));
            lichChest.setItemMeta(chestMeta);
            LeatherArmorMeta bootsMeta;
            ItemStack lichBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
            bootsMeta = (LeatherArmorMeta) lichBoots.getItemMeta();
            bootsMeta.setColor(Color.fromRGB(52, 52, 52));
            lichBoots.setItemMeta(bootsMeta);
            ItemMeta wandMeta;
            ItemStack lichWand = new ItemStack(Material.BLAZE_ROD, 1,
                    (short) -32768);
            wandMeta = (ItemMeta) lichWand.getItemMeta();
            wandMeta.setDisplayName(ChatColor.RED.ITALIC + "Cursed Wand");
            wandMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
            lichWand.setItemMeta(wandMeta);
            Skeleton lich = (Skeleton) loc.getWorld().spawnEntity(loc,
                    EntityType.SKELETON);
            lich.setHealth(6);
            lich.getEquipment().setHelmet(lichHelm);
            lich.getEquipment().setChestplate(lichChest);
            lich.getEquipment().setBoots(lichBoots);
            lich.getEquipment().setItemInHand(lichWand);
            lich.getEquipment().setHelmetDropChance(0.0F);
            lich.getEquipment().setChestplateDropChance(0.0F);
            lich.getEquipment().setBootsDropChance(0.0F);
            lich.getEquipment().setItemInHandDropChance(0.025F);
            lich.addPotionEffect(new PotionEffect(
                    PotionEffectType.WATER_BREATHING, 2147483647, 10));
            lich.addPotionEffect(new PotionEffect(
                    PotionEffectType.FIRE_RESISTANCE, 2147483647, 10));
            lich.setCanPickupItems(false);
            i++;
        }
    }
}