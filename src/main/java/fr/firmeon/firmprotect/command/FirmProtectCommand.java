package fr.firmeon.firmprotect.command;

import fr.firmeon.firmprotect.FirmProtect;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FirmProtectCommand implements CommandExecutor {

    /**
     * Method for the main command
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!sender.hasPermission("firmprotect.command")){
            sender.sendMessage(FirmProtect.PREFIX + "§cYou don't have permission to do that");
            return true;
        }

        if(args.length == 0){
            sender.sendMessage(FirmProtect.PREFIX + "§cType /firmprotect help for list of subcommand");
            return true;
        }

        switch (args[0]) {
            case "help":
                sendHelpMessage(sender);
                return true;
            case "vulnerable":
                if (args.length < 2) {
                    sendWrongMessage(sender);
                    return true;
                }
                String player = args[1];
                if (FirmProtect.getINSTANCE().playerManager.isVulnerable(player)) {
                    sender.sendMessage(FirmProtect.PREFIX + "§cThis player is already vulnerable");
                    return true;
                }
                FirmProtect.getINSTANCE().playerManager.setVulnerable(player);
                sender.sendMessage(FirmProtect.PREFIX + "§2The player §6" + player + " §2is now vulnerable");
                return true;
            case "invulnerable":
                if (args.length < 2) {
                    sendWrongMessage(sender);
                    return true;
                }
                String playerName = args[1];
                if (!FirmProtect.getINSTANCE().playerManager.isVulnerable(playerName)) {
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
        sender.sendMessage(FirmProtect.PREFIX + "§9Help Page");

        if(sender instanceof Player){
            TextComponent vulnerableCommand = new TextComponent("§7- §bvulnerable §d[player] §7: §2 make the player vulnerable");
            vulnerableCommand.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click to execute the command").create()));
            vulnerableCommand.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/firmprotect vulnerable "));
            sender.spigot().sendMessage(vulnerableCommand);

            TextComponent invulnerableCommand = new TextComponent("§7- §binvulnerable §d[player] §7: §2 make the player invulnerable");
            invulnerableCommand.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click to execute the command").create()));
            invulnerableCommand.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/firmprotect invulnerable "));
            sender.spigot().sendMessage(invulnerableCommand);

            TextComponent helpCommand = new TextComponent("§7- §bhelp §7: §2show this page");
            helpCommand.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7Click to execute the command").create()));
            helpCommand.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/firmprotect help"));
            sender.spigot().sendMessage(helpCommand);
        } else {
            sender.sendMessage("§7- §bvulnerable §d[player] §7: §2make the player vulnerable");
            sender.sendMessage("§7- §binvulnerable §d[player] §7: §2make the player invulnerable");
            sender.sendMessage("§7- §bhelp §7: §2show this page");
        }


    }

    /**
     * Method to send a message that indicate that the command is invalid
     * @param sender The person (player or console) to send the help message
     */
    private void sendWrongMessage(CommandSender sender){
        if(sender instanceof Player){
            TextComponent wrongMessage = new TextComponent(FirmProtect.PREFIX + "§cClick here for help");
            wrongMessage.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7/firmprotect help").create()));
            wrongMessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/firmprotect help"));
        } else {
            sender.sendMessage(FirmProtect.PREFIX + "§cType /firmprotect help for help");
        }
    }
}