package fr.firmeon.firmprotect.command;

import fr.firmeon.firmprotect.FirmProtect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FirmProtectCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage(FirmProtect.PREFIX + "§cType /firmprotect help for list of subcommand");
            return true;
        }
        switch (args[0]){
            case "a":
                sender.sendMessage(FirmProtect.PREFIX + "b");
                return true;
            default:
                sender.sendMessage(FirmProtect.PREFIX + "Bonjour !");
                return true;
        }
    }
}