package fr.firmeon.firmprotect.event;

import fr.firmeon.firmprotect.FirmProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public static void onJoinEvent(PlayerJoinEvent e){
        if(!FirmProtect.getINSTANCE().playerManager.isVulnerable(e.getPlayer().getName())){
            e.getPlayer().setHealth(20);
            e.getPlayer().setFoodLevel(FirmProtect.getINSTANCE().getConfig().getInt("foodlevel"));
        }
    }
}