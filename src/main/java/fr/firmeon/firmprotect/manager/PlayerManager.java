package fr.firmeon.firmprotect.manager;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<String> vulnerablePlayers;

    public PlayerManager(){
        this.vulnerablePlayers = new ArrayList<>();
    }

    public boolean isVulnerable(String player){
        return this.vulnerablePlayers.contains(player);
    }

    public void setVulnerable(String playerName){
        this.vulnerablePlayers.add(playerName);
    }

    public void unsetVulnerable(String playerName){
        this.vulnerablePlayers.remove(playerName);
    }

}
