package plugin.moremobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tools {

    public static MoreMobsCore plugin;

    public static Location playerTarget (Player player) {
        Location spawnLoc = player.getTargetBlock(null, 100).getLocation();
        spawnLoc = spawnLoc.getWorld().getHighestBlockAt(spawnLoc).getLocation();
        spawnLoc = spawnLoc.add(0.0D, 1.0D, 0.0D);
        return spawnLoc;
    }

    @SuppressWarnings({"static-access"})
    public static int amount (Player player, String[] args) {
        int spawnLimit = plugin.maxSpawnLimit;
        if ((args.length <= 2)) {
            return 1;
        } else {
            int amount = Integer.parseInt(args[2]);
            try {
                if (1 > amount) {
                    amount = Integer.valueOf(1);
                    player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.RED + " Minimum spawn limit is 1!");
                }
                if (spawnLimit < amount) {
                    amount = Integer.valueOf(spawnLimit);
                    player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.RED + " Max spawn limit is " + spawnLimit + "!");
                }
                return amount;
            } catch (Exception ex) {
                amount = Integer.valueOf(1);
                return amount;
            }
        }
    }

    public static void NoPerms (Player player) {
        player.sendMessage(ChatColor.RED + "You don't have permission to do this!");
    }

    public static void invalidMob (Player player) {
        player.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.RED + " Not a mob type!");
    }

    public static void spawnList (Player player) {
        player.sendMessage(ChatColor.RED + "-----[" + ChatColor.GOLD + "More Mobs" + ChatColor.RED + "]-----");
        player.sendMessage(ChatColor.GOLD + "Type /moremobs spawn <Mob Type> <Amount>.");
        player.sendMessage(ChatColor.GOLD + "Mob Types:");
        player.sendMessage(ChatColor.GOLD + "Giant:" + ChatColor.GRAY + ChatColor.ITALIC + " Giant cousins of zombies.");
        player.sendMessage(ChatColor.GOLD + "Hellhound:" + ChatColor.GRAY + ChatColor.ITALIC + " Hellish demonic hounds hungering over the thought of human flesh.");
        player.sendMessage(ChatColor.GOLD + "Lich:" + ChatColor.GRAY + ChatColor.ITALIC + " Undead necromancers who achieved a way of immortality.");
        player.sendMessage(ChatColor.GOLD + "Wraith:" + ChatColor.GRAY + ChatColor.ITALIC + " Roaming lost spirits in search of souls of players.");
        player.sendMessage(ChatColor.GOLD + "HellSkeleton:" + ChatColor.GRAY + ChatColor.ITALIC + " A skeleton straight from hell.");
    }

    public static void helpList (Player player) {
        player.sendMessage(ChatColor.RED + "-----[" + ChatColor.GOLD + "More Mobs" + ChatColor.RED + "]-----");
        player.sendMessage(ChatColor.GOLD + "Type /moremobs <Subcommand>.");
        player.sendMessage(ChatColor.GOLD + "Subcommands:");
        player.sendMessage(ChatColor.GOLD + "Help:" + ChatColor.GRAY + ChatColor.ITALIC + " How to use the command.");
        player.sendMessage(ChatColor.GOLD + "Spawn:" + ChatColor.GRAY + ChatColor.ITALIC + " The command for spawning more mobs mobs.");
    }

    public static void notAPlayer (CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "[More Mobs]" + ChatColor.RED + " You are not a player! You must be in-game to execute this command.");
    }
}
