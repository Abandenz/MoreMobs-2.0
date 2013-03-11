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

public class SkeletonWarriorDiamond {

	public static boolean isSkeletonWarriorDiamond(
			SkeletonWarriorDiamond MMSkeletonWarriorDiamond) {
		if (MMSkeletonWarriorDiamond instanceof Skeleton) {
			Skeleton SkeletonWarriorDiamond = (Skeleton) MMSkeletonWarriorDiamond;
			if (SkeletonWarriorDiamond.getEquipment().getChestplate()
					.equals(new ItemStack(311))) {
				return true;
			}
		}
		return false;
	}

	public static void spawnSkeletonWarriorDiamond(Location loc, int amount) {
		int i = 0;
		while (i < amount) {
			Skeleton SkeletonWarriorIron = (Skeleton) loc.getWorld()
					.spawnEntity(loc, EntityType.SKELETON);
			SkeletonWarriorIron.getEquipment().setChestplate(
					new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
			SkeletonWarriorIron.getEquipment().setHelmet(
					new ItemStack(Material.DIAMOND_HELMET, 1));
			SkeletonWarriorIron.getEquipment().setLeggings(
					new ItemStack(Material.DIAMOND_LEGGINGS, 1));
			SkeletonWarriorIron.getEquipment().setBoots(
					new ItemStack(Material.DIAMOND_BOOTS, 1));
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