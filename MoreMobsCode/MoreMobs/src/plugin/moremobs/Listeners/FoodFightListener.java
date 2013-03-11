package plugin.moremobs.Listeners;

import org.bukkit.event.Listener;

import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Mobs.FoodFight;

public class FoodFightListener implements Listener {

	public MoreMobsCore plugin;
	public FoodFight MMFoodFight;

	public FoodFightListener(MoreMobsCore plugin) {
		this.plugin = plugin;
	}
}
