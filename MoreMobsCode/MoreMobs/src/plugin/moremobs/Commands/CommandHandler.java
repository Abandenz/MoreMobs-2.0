package plugin.moremobs.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.moremobs.MoreMobsCore;
import plugin.moremobs.Tools;

public class CommandHandler implements CommandExecutor {

    public static MoreMobsCore plugin;
    private CMDSpawn spawnCmd;
    private ConsoleCommands consoleCmd;
    public static Tools tools;

    @SuppressWarnings("static-access")
    public CommandHandler (MoreMobsCore plugin) {
        this.plugin = plugin;
        this.spawnCmd = new CMDSpawn(this.plugin);
        this.consoleCmd = new ConsoleCommands(this.plugin);
    }

    @SuppressWarnings("static-access")
    public boolean onCommand (CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                this.spawnCmd.Command(sender, cmd, commandlabel, args);
            } catch (Exception ex) {
                if (player.isOp() || player.hasPermission("MoreMobs.List")) {
                    tools.helpList(player);
                }
            }
        } else {
            if (sender.getName().equals("CONSOLE")) {
                try {
                    this.consoleCmd.Command(sender, cmd, commandlabel, args);
                } catch (Exception ex) {
                    tools.notAPlayer(sender);
                }
            } else {
                tools.notAPlayer(sender);
            }
        }
        return false;
    }
}