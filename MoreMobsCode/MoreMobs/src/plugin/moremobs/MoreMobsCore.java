package plugin.moremobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.moremobs.Listeners.*;
import plugin.moremobs.Mobs.*;

import java.util.logging.Logger;
// Shouldnt need to import anything from Mobs or Listeners anymore should make it a little easier.
// Extened from above


public class MoreMobsCore extends JavaPlugin {

    public static final Logger log = Logger.getLogger("Minecraft");
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
    public static Wisp MMWisp;
    public FoodFight MMFoodFight;
    private final SkeletonWarriorIronListener skeletonwarrioriron;
    private final SkeletonWarriorGoldListener skeletonwarriorgold;
    private final SkeletonWarriorDiamondListener skeletonwarriordiamond;
    private final HellSkeletonListener HellSkeleton;
    private final PigChestListener PigChest;
    private final WispListener Wisp;
    private final HellhoundListener hellhound;
    private final LichListener lich;
    private final PossessedItemListener possessedItem;
    private final WraithListener wraith;
    private final FoodFightListener foodfight;

    public MoreMobsCore() {
        this.foodfight = new FoodFightListener(this);
        this.hellhound = new HellhoundListener(this);
        this.lich = new LichListener(this);
        this.PigChest = new PigChestListener(this);
        this.possessedItem = new PossessedItemListener(this);
        this.wraith = new WraithListener(this);
        this.skeletonwarriordiamond = new SkeletonWarriorDiamondListener(this);
        this.Wisp = new WispListener(this);
        this.HellSkeleton = new HellSkeletonListener(this);
        this.skeletonwarrioriron = new SkeletonWarriorIronListener(this);
        this.skeletonwarriorgold = new SkeletonWarriorGoldListener(this);
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(this.foodfight, this);
        manager.registerEvents(this.hellhound, this);
        manager.registerEvents(this.Wisp, this);
        manager.registerEvents(this.PigChest, this);
        manager.registerEvents(this.HellSkeleton, this);
        manager.registerEvents(this.skeletonwarriordiamond, this);
        manager.registerEvents(this.skeletonwarrioriron, this);
        manager.registerEvents(this.skeletonwarriorgold, this);
        manager.registerEvents(this.lich, this);
        manager.registerEvents(this.possessedItem, this);
        manager.registerEvents(this.wraith, this);

    }


    @Override
    public void onDisable() {
    }

    public void NoPerms(Player player) {
        player.sendMessage(ChatColor.RED
                + "You don't have permission to do this!");
    }

    @SuppressWarnings("static-access")
    @Override
    // args 0=spawn,1=mob,2=amount of mob.
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("moremobs")
                || cmd.getName().equalsIgnoreCase("mm")) {
            try {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    Location spawnLoc = player.getTargetBlock(null, 100)
                            .getLocation();
                    spawnLoc = spawnLoc.getWorld().getHighestBlockAt(spawnLoc)
                            .getLocation();
                    spawnLoc.add(0.0D, 2.0D, 0.0D);
                    if (args[0].equalsIgnoreCase("spawn")) {
                        try {
                            int amount = Integer.parseInt(args[2]);
                            if (100 < amount) {
                                amount = 100;
                                player.sendMessage(ChatColor.GOLD
                                        + "[More Mobs]" + ChatColor.RED
                                        + " 100 is the max!");
                            }
                            if (args[1].equalsIgnoreCase("PigChest")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Giant")) {
                                    MMPigChest.spawnPigChest(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " PigChest(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("HellSkele")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Giant")) {
                                    MMHellSkeleton.spawnHellSkeleton(spawnLoc,
                                            amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " HellSkele(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("wisp")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Giant")) {
                                    MMWisp.spawnWisp(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " Wisp(" + amount + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1]
                                    .equalsIgnoreCase("skeletonwarriordiamond")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.SkeletonWarriorDiamond")) {
                                    MMSkeletonWarriorDiamond
                                            .spawnSkeletonWarriorDiamond(
                                                    spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " SkeletonWarriorGold(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1]
                                    .equalsIgnoreCase("skeletonwarriorgold")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.SkeletonWarriorGold")) {
                                    MMSkeletonWarriorGold
                                            .spawnSkeletonWarriorGold(spawnLoc,
                                                    amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " SkeletonWarriorGold(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1]
                                    .equalsIgnoreCase("skeletonwarrioriron")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.SkeletonWarriorIron")) {
                                    MMSkeletonWarriorIron
                                            .spawnSkeletonWarriorIron(spawnLoc,
                                                    amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " SkeletonWarriorIron(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("foodfight")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Foodfight")) {
                                    MMFoodFight
                                            .spawnFoodFight(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " FoodFight(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("giant")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Giant")) {
                                    MMGiant.spawnZombieGiant(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " Giant(" + amount + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("hellhound")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Hellhound")) {
                                    MMHellhound
                                            .spawnHellhound(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " Hellhound(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("lich")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Lich")) {
                                    MMLich.spawnLich(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " Lich(" + amount + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else if (args[1].equalsIgnoreCase("wraith")) {
                                if (player.isOp()
                                        || player
                                        .hasPermission("MoreMobs.Spawn.Wraith")) {
                                    MMWraith.spawnWraith(spawnLoc, amount);
                                    player.sendMessage(ChatColor.GOLD
                                            + "[More Mobs]" + ChatColor.GREEN
                                            + " Wraith(" + amount
                                            + ") spawned!");
                                    player.getWorld().playSound(
                                            player.getLocation(),
                                            Sound.WITHER_SPAWN, 1.0F, 1.0F);
                                } else {
                                    NoPerms(player);
                                }
                            } else {
                                player.sendMessage(ChatColor.GOLD
                                        + "[More Mobs]" + ChatColor.RED
                                        + " Not a mob type!");
                            }
                        } catch (Exception ex) {
                            player.sendMessage(ChatColor.RED + "-----["
                                    + ChatColor.GOLD + "More Mobs"
                                    + ChatColor.RED + "]-----");
                            player.sendMessage(ChatColor.GOLD
                                    + "Type /moremobs spawn <Mob Type> <Amount>.");
                            player.sendMessage(ChatColor.GOLD + "Mob Types:");
                            player.sendMessage(ChatColor.GOLD + "FoodFight:"
                                    + ChatColor.GRAY + ChatColor.ITALIC
                                    + " Dont play with your food.");
                            player.sendMessage(ChatColor.GOLD
                                    + "SkeletonWarriorIron:" + ChatColor.GRAY
                                    + ChatColor.ITALIC
                                    + " Its A Skeleton in Iron");
                            player.sendMessage(ChatColor.GOLD
                                    + "SkeletonWarriorGold:" + ChatColor.GRAY
                                    + ChatColor.ITALIC
                                    + " Its A Skeleton in Gold");
                            player.sendMessage(ChatColor.GOLD
                                    + "SkeletonWarriorDiamond:"
                                    + ChatColor.GRAY + ChatColor.ITALIC
                                    + " Its A Skeleton in Diamond");
                            player.sendMessage(ChatColor.GOLD + "Giant:"
                                    + ChatColor.GRAY + ChatColor.ITALIC
                                    + " Giant cousins of zombies.");
                            player.sendMessage(ChatColor.GOLD
                                    + "Hellhound:"
                                    + ChatColor.GRAY
                                    + ChatColor.ITALIC
                                    + " Hellish demonic hounds hungering over the thought of human flesh.");
                            player.sendMessage(ChatColor.GOLD
                                    + "Lich:"
                                    + ChatColor.GRAY
                                    + ChatColor.ITALIC
                                    + " Undead necromancers who achieved a way of immortality.");
                            player.sendMessage(ChatColor.GOLD
                                    + "Wraith:"
                                    + ChatColor.GRAY
                                    + ChatColor.ITALIC
                                    + " Roaming lost spirits in search of souls of players.");
                        }
                    }

                } else {
                    sender.sendMessage(ChatColor.GOLD + "[More Mobs]"
                            + ChatColor.RED + " You are not a player!");
                }
            } catch (Exception ex) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.sendMessage(ChatColor.RED + "-----["
                            + ChatColor.GOLD + "More Mobs" + ChatColor.RED
                            + "]-----");
                    player.sendMessage(ChatColor.GOLD
                            + "Type /moremobs <Subcommand>.");
                    player.sendMessage(ChatColor.GOLD + "Subcommands:");
                    player.sendMessage(ChatColor.GOLD + "Spawn:"
                            + ChatColor.GRAY + ChatColor.ITALIC
                            + " The command for spawning more mobs mobs.");
                } else {
                    sender.sendMessage(ChatColor.GOLD + "[More Mobs]"
                            + ChatColor.RED + " You are not a player!");
                }
            }
        }
        return false;
    }
}
