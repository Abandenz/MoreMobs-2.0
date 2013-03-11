package plugin.moremobs.Mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Hellhound {

	public static boolean isHellhound(Entity entity) {
		if (entity instanceof Wolf) {
			Wolf hound = (Wolf) entity;
			if (hound
					.getEquipment()
					.getChestplate()
					.equals(new ItemStack(Material.LEATHER_CHESTPLATE, 1,
							(short) -98789))) {
				return true;
			}
		}
		return false;
	}

	public static void spawnHellhound(Location loc, int amount) {
		int i = 0;
		while (i < amount) {
			Wolf hound = (Wolf) loc.getWorld()
					.spawnEntity(loc, EntityType.WOLF);
			hound.getEquipment().setChestplate(
					new ItemStack(Material.LEATHER_CHESTPLATE, 1,
							(short) -98789));
			hound.getEquipment().setChestplateDropChance(0.0F);
			hound.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
					2147483647, 1));
			hound.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
					2147483647, 1));
			hound.addPotionEffect(new PotionEffect(
					PotionEffectType.INCREASE_DAMAGE, 2147483647, 1));
			hound.addPotionEffect(new PotionEffect(
					PotionEffectType.FIRE_RESISTANCE, 2147483647, 10));
			hound.addPotionEffect(new PotionEffect(
					PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 1));
			hound.setBreed(false);
			hound.setFireTicks(2147483647);
			hound.setAngry(true);
			i++;
		}
	}
}