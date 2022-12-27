package fr.firmeon.firmprotect;

import fr.firmeon.firmprotect.manager.CommandManager;
import fr.firmeon.firmprotect.manager.EventManager;
import fr.firmeon.firmprotect.manager.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FirmProtect extends JavaPlugin {

    private static FirmProtect INSTANCE;
    public static final String PREFIX = "§7[§9FirmProtect§7] §r";
    public PlayerManager playerManager = new PlayerManager();

    @Override
    public void onEnable() {
        INSTANCE = this;
        EventManager.registerEvent();
        CommandManager.registerCommand();
    }

    public static FirmProtect getINSTANCE() {
        return INSTANCE;
    }
}