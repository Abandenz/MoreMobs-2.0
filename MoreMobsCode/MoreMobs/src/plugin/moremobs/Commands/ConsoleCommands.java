package plugin.moremobs.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import plugin.moremobs.MoreMobsCore;

public class ConsoleCommands {

    public static MoreMobsCore plugin;

    @SuppressWarnings("static-access")
    public ConsoleCommands (MoreMobsCore plugin) {
        this.plugin = plugin;
    }

    public void Command (CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if (args[0].equalsIgnoreCase("reload")) {
            return;
        }
    }
}