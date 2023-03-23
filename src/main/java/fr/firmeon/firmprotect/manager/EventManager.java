package fr.firmeon.firmprotect.manager;

import fr.firmeon.firmprotect.FirmProtect;
import fr.firmeon.firmprotect.event.DamageEvent;
import fr.firmeon.firmprotect.event.FoodEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    /**
     * Method for init all the events
     */
    public static void registerEvent(){
        FirmProtect INSTANCE = FirmProtect.getINSTANCE();
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new DamageEvent(), INSTANCE);
        pm.registerEvents(new FoodEvent(), INSTANCE);
    }
}