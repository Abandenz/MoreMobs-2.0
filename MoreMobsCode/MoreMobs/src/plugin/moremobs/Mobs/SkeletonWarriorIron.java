package plugin.moremobs.Mobs;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SkeletonWarriorIron {

	public static boolean isSkeletonWarriorIron(
			SkeletonWarriorIron MMSkeletonWarriorIron) {
		if (MMSkeletonWarriorIron instanceof Skeleton) {
			Skeleton SkeletonWarriorIron = (Skeleton) MMSkeletonWarriorIron;
			if (SkeletonWarriorIron.getEquipment().getChestplate()
					.equals(new ItemStack(307))) {
				return true;
			}
		}
		return false;
	}

	public static void spawnSkeletonWarriorIron(Location loc, int amount) {
		int i = 0;
		while (i < amount) {
			Skeleton SkeletonWarriorIron = (Skeleton) loc.getWorld()
					.spawnEntity(loc, EntityType.SKELETON);
			SkeletonWarriorIron.getEquipment().setChestplate(
					new ItemStack(Material.IRON_CHESTPLATE, 1));
			SkeletonWarriorIron.getEquipment().setHelmet(
					new ItemStack(Material.IRON_HELMET, 1));
			SkeletonWarriorIron.getEquipment().setLeggings(
					new ItemStack(Material.IRON_LEGGINGS, 1));
			SkeletonWarriorIron.getEquipment().setBoots(
					new ItemStack(Material.IRON_BOOTS, 1));
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