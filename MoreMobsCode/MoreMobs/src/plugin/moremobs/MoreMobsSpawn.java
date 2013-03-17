package plugin.moremobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
import plugin.moremobs.Mobs.*;

public class MoreMobsSpawn {

    public MoreMobsCore plugin;
    public Hellhound MMHellhound;
    public Lich MMLich;
    public PossessedItem MMPossessedItem;
    public Wraith MMWraith;
    public ZombieGiant MMGiant;
    public SkeletonWarriorDiamond MMSkeletonWarriorDiamond;
    public SkeletonWarriorGold MMSkeletonWarriorGold;
    public SkeletonWarriorIron MMSkeletonWarriorIron;
    public HellSkeleton MMHellSkeleton;
    public PigChest MMPigChest;
    public Wisp MMWisp;
    public FoodFight MMFoodFight;

    @EventHandler(priority = EventPriority.LOW)
    public void onMobSpawn(CreatureSpawnEvent event) {
        int randomnum = (int) (Math.random() * 100.0D);
        Location spawnLoc = event.getLocation();
        spawnLoc = spawnLoc.getWorld().getHighestBlockAt(spawnLoc)
                .getLocation();
        spawnLoc.add(0.0D, 2.0D, 0.0D);
        World world = event.getEntity().getWorld();
        Location moblocation = event.getEntity().getLocation();

        if ((event.getEntityType() == EntityType.SPIDER)
                && (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CUSTOM)
                && (!event.isCancelled())) {
            int giantZombieChance = 100;
            if ((randomnum >= 100 - giantZombieChance) && (randomnum <= 100)) {
                event.getEntity().remove();
                MMGiant.spawnZombieGiant(spawnLoc, 1);

            }
        }
    }
}

// / if ((event.getEntityType() == EntityType.SLIME) && (event.getSpawnReason()
// != CreatureSpawnEvent.SpawnReason.SPAWNER) && (event.getSpawnReason() !=
// CreatureSpawnEvent.SpawnReason.CUSTOM) && (!event.isCancelled())) {
// / int giantSlimeChance = getConfig().getInt("giantSlimeChance");
// / if ((randomnum >= 100 - giantSlimeChance) && (randomnum <= 100)) {
// / Slime megaSlime = (Slime)event.getEntity();
// / megaSlime.setSize(12);
// / return;

