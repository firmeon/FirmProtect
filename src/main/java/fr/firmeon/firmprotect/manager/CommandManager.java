package fr.firmeon.firmprotect.manager;

import fr.firmeon.firmprotect.FirmProtect;
import fr.firmeon.firmprotect.command.FirmProtectCommand;

public class CommandManager {

    public static void registerCommand(){
        FirmProtect.getINSTANCE().getCommand("firmprotect").setExecutor(new FirmProtectCommand());
    }
}