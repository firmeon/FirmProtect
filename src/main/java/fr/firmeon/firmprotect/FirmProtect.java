package fr.firmeon.firmprotect;

import fr.firmeon.firmprotect.manager.EventManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FirmProtect extends JavaPlugin {

    private static FirmProtect INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        EventManager.registerEvent();
    }

    public static FirmProtect getINSTANCE() {
        return INSTANCE;
    }
}
