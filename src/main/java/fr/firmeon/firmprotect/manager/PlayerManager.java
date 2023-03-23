package fr.firmeon.firmprotect.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage player that can take damage
 */
public class PlayerManager {

    private List<String> vulnerablePlayers;

    public PlayerManager(){
        this.vulnerablePlayers = new ArrayList<>();
    }

    /**
     * Check if the player can take damage
     * @param player Name of the player to check
     * @return true if the player can take damage
     */
    public boolean isVulnerable(String player){
        return this.vulnerablePlayers.contains(player);
    }

    /**
     * Set a player vulnerable
     * @param playerName Name of player to set vulnerable
     */
    public void setVulnerable(String playerName){
        this.vulnerablePlayers.add(playerName);
    }


    /**
     * Unset a player vulnerable
     * @param playerName Name of the player to unset vulnerable
     */
    public void unsetVulnerable(String playerName){
        this.vulnerablePlayers.remove(playerName);
    }

}
