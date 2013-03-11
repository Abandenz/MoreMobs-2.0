package plugin.moremobs.Mobs;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PigChest {

	public static boolean isPigChest(PigChest MMPigChest) {
		if (MMPigChest instanceof Pig) {
			Pig PigChest = (Pig) MMPigChest;
			if (PigChest.getEquipment().getChestplate()
					.equals(new ItemStack(299, 1, (short) -98789))) {
				return true;
			}
		}
		return false;
	}

	public static void spawnPigChest(Location loc, int amount) {
		int i = 0;
		while (i < amount) {
			LivingEntity pig = (LivingEntity) loc.getWorld().spawnEntity(loc,
					EntityType.PIG);
			Entity minecart = (Entity) loc.getWorld().spawn(loc,
					StorageMinecart.class);
			pig.setPassenger(minecart);
			i++;
		}
	}
}