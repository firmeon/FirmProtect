package fr.firmeon.firmprotect.event;

import fr.firmeon.firmprotect.FirmProtect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public static void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            e.setCancelled(!FirmProtect.getINSTANCE().playerManager.isVulnerable((e.getEntity().getName())));
        }
    }

    @EventHandler
    public static void onHealthChange(EntityRegainHealthEvent e){
        if(e.getEntity() instanceof Player){
            if(!FirmProtect.getINSTANCE().playerManager.isVulnerable(e.getEntity().getName())){
                e.setAmount(((Player) e.getEntity()).getHealthScale());
            }
        }
    }
}