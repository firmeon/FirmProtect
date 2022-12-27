package fr.firmeon.firmprotect.event;

import fr.firmeon.firmprotect.FirmProtect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {

    @EventHandler
    public static void foodEvent(FoodLevelChangeEvent e){
        e.setCancelled(FirmProtect.getINSTANCE().playerManager.isVulnerable((e.getEntity().getName())));
    }
}