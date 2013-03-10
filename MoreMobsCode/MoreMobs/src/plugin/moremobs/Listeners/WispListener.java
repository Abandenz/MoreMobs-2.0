package plugin.moremobs.Listeners;

import java.util.Iterator;
import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Mobs.Wisp;

public class WispListener implements Listener{
	
	public MoreMobsCore plugin;
	public Wisp MMWisp;
	
	
	public WispListener(MoreMobsCore plugin) {
		this.plugin = plugin;
	}
}