package fr.firmeon.firmprotect.command;

import fr.firmeon.firmprotect.FirmProtect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FirmProtectCommand implements CommandExecutor {

    /**
     * Method for the main command
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length == 0){
            sender.sendMessage(FirmProtect.PREFIX + "§cType /firmprotect help for list of subcommand");
            return true;
        }

        switch (args[0]){
            case "help":
                sendHelpMessage(sender);
                return true;
            case "vulnerable":
                if(args.length < 2){
                    sendWrongMessage(sender);
                    return true;
                }

                String player = args[1];

                if(FirmProtect.getINSTANCE().playerManager.isVulnerable(player)){
                    sender.sendMessage(FirmProtect.PREFIX + "§cThis player is already vulnerable");
                    return true;
                }

                FirmProtect.getINSTANCE().playerManager.setVulnerable(player);
                sender.sendMessage(FirmProtect.PREFIX + "§2The player §6" + player + " §2is now vulnerable");
                return true;

            case "invulnerable":
                if(args.length < 2){
                    sendWrongMessage(sender);
                    return true;
                }

                String playerName = args[1];

                if(!FirmProtect.getINSTANCE().playerManager.isVulnerable(playerName)){
                    sender.sendMessage(FirmProtect.PREFIX + "§cThis player is not vulnerable");
                    return true;
                }

                FirmProtect.getINSTANCE().playerManager.unsetVulnerable(playerName);
                sender.sendMessage(FirmProtect.PREFIX + "§2The player §6" + playerName + " §2is now invulnerable");
                return true;

            default:
                sendWrongMessage(sender);
                return true;
        }
    }

    /**
     * Method to send the help message for the command
     * @param sender The person (player or console) to send the help message
     */
    private void sendHelpMessage(CommandSender sender) {
    }

    /**
     * Method to send a message that indicate that the command is invalid
     * @param sender The person (player or console) to send the help message
     */
    private void sendWrongMessage(CommandSender sender){
        sender.sendMessage(FirmProtect.PREFIX + "§cType /firmprotect help for help");
    }
}