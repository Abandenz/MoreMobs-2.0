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

public class FoodFight {
	
	public static boolean isFoodFight(FoodFight MMFoodFight) {
		if(MMFoodFight instanceof Zombie) {
			Zombie FoodFight = (Zombie) MMFoodFight;
			if(FoodFight.getEquipment().getChestplate().equals(new ItemStack(299, 1, (short) -98789))) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void spawnFoodFight(Location loc, int amount) {
		int i = 0 ;
		while(i < amount) {
			LeatherArmorMeta meta;
			ItemStack chestplate = new ItemStack(299, 1, (short) -98789);
			Zombie FoodFight = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
			FoodFight.getEquipment().setChestplate(chestplate);
			FoodFight.getEquipment().setHelmet(new ItemStack(Material.MELON_BLOCK, 1));
			FoodFight.getEquipment().setItemInHand(new ItemStack(Material.PORK, 1));
			FoodFight.getEquipment().setHelmetDropChance(0.0F);
			FoodFight.getEquipment().setChestplateDropChance(5.0F);
			FoodFight.getEquipment().setItemInHandDropChance(50.0F);
			FoodFight.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2147483647, 1));
			FoodFight.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2147483647, 10));
			FoodFight.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2147483647, 1));
			FoodFight.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 2147483647, 1));
			FoodFight.setCanPickupItems(false);
			i++;
		}
	}
}