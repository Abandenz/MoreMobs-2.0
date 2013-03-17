package plugin.moremobs.Listeners;

import org.bukkit.event.Listener;
import plugin.moremobs.Mobs.FoodFight;
import plugin.moremobs.MoreMobsCore;

public class FoodFightListener implements Listener {

    public MoreMobsCore plugin;
    public FoodFight MMFoodFight;

    public FoodFightListener(MoreMobsCore plugin) {
        this.plugin = plugin;
    }
}
