package fr.firmeon.firmprotect.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {

    @EventHandler
    public static void foodEvent(FoodLevelChangeEvent e){
        e.setFoodLevel(20);
    }
}