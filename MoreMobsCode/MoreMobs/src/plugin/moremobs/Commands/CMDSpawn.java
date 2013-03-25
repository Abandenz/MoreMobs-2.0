package plugin.moremobs.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.moremobs.Mobs.*;
import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Tools;

public class CMDSpawn {

    public static MoreMobsCore plugin;
    public FoodFight MMFoodFight;
    public Hellhound MMHellhound;
    public HellSkeleton MMHellSkeleton;
    public SkeletonWarriorDiamond MMSkeletonWarriorDiamond;
    public Lich MMLich;
    public PigChest MMPighchest;
    public PossessedItem MMPossessedItem;
    public Wraith MMWraith;
    public ZombieGiant MMGiant;
    public static Tools tools;

    @SuppressWarnings("static-access")
    public CMDSpawn (MoreMobsCore plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("static-access")
    public void Command (CommandSender sender, Command cmd, String commandlabel, String[] args) {
        Player player = (Player) sender;
        Location spawnLoc = tools.playerTarget(player);
        if (player.hasPermission("MoreMobs.Spawn.DevList")) {
            if (args[0].equalsIgnoreCase("DevList")) {
                tools.devList(player);
            }
            if (args[0].equalsIgnoreCase("spawn")) {
                try {
                    int amount = tools.amount(player, args);
                    if (args[1].equalsIgnoreCase("giant")) {
                        if (player.hasPermission("MoreMobs.Spawn.Giant")) {
                            MMGiant.spawnZombieGiant(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " Giant(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("skeletonwarriordiamond")) {
                        if (player.hasPermission("MoreMobs.Spawn.skelewarriordiamond")) {
                            MMSkeletonWarriorDiamond.spawnSkeletonWarriorDiamond(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " Skeleton Warrior Diamond(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("pigchest")) {
                        if (player.hasPermission("MoreMobs.Spawn.PigChest")) {
                            MMPighchest.spawnPigChest(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " PigChest(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("foodfight")) {
                        if (player.hasPermission("MoreMobs.Spawn.FoodFight")) {
                            MMFoodFight.spawnFoodFight(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " FoodFight(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("hellskeleton")) {
                        if (player.hasPermission("MoreMobs.Spawn.HellSkeleton")) {
                            MMHellSkeleton.spawnHellSkeleton(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " HellSkeleton(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("hellhound")) {
                        if (player.hasPermission("MoreMobs.Spawn.Hellhound")) {
                            MMHellhound.spawnHellhound(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " Hellhound(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("lich")) {
                        if (player.hasPermission("MoreMobs.Spawn.Lich")) {
                            MMLich.spawnLich(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " Lich(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else if (args[1].equalsIgnoreCase("wraith")) {
                        if (player.hasPermission("MoreMobs.Spawn.Wraith")) {
                            MMWraith.spawnWraith(spawnLoc, amount);
                            player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.GREEN + " Wraith(" + amount + ") spawned!");
                            player.getWorld().playSound(player.getLocation(), Sound.WITHER_SPAWN, 1.0F, 1.0F);
                        } else {
                            tools.NoPerms(player);
                        }
                    } else {
                        tools.invalidMob(player);
                    }
                } catch (Exception ex) {
                    tools.spawnList(player);
                }
            }
        }
    }
}