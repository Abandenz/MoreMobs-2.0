package plugin.moremobs.Mobs;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Bat;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;




public class Wisp {

	public static boolean isWisp(Entity entity) {
		if(entity instanceof Bat) {
			Bat Wisp = (Bat) entity;
				return true;
		}
		return false;
	}



	World getWorld = Bukkit.getServer().getWorld("World1");
	
	
	
	public static void spawnWisp(Location loc, int amount) {
		int i = 0 ;
		while(i < amount) {
			Wisp Wisp = (Wisp) loc.getWorld().spawnEntity(loc, EntityType.BAT);
	          Wisp.getWorld.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0);
	          Wisp.getWorld.playEffect(loc, Effect.POTION_BREAK, 0);
	          Wisp.getWorld.playEffect(loc, Effect.SMOKE, 0);
	          Wisp.getWorld.playEffect(loc, Effect.ENDER_SIGNAL, 0);
	          Wisp.getWorld.playEffect(loc, Effect.POTION_BREAK, 1);
	          Wisp.getWorld.playEffect(loc, Effect.POTION_BREAK, 2);
	          Wisp.getWorld.playEffect(loc, Effect.POTION_BREAK, 3);
	          Wisp.getWorld.playEffect(loc, Effect.POTION_BREAK, 4);
			i++;
		}
	}
}