package fr.firmeon.firmprotect.event;

import fr.firmeon.firmprotect.FirmProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {

    /**
     * Method when player's food level change
     */
    @EventHandler
    public static void foodEvent(FoodLevelChangeEvent e){
        if(!FirmProtect.getINSTANCE().playerManager.isVulnerable(e.getEntity().getName())){
            e.setFoodLevel(FirmProtect.getINSTANCE().getConfig().getInt("foodLevel"));
        }
    }
}