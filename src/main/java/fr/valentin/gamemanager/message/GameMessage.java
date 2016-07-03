package fr.valentin.gamemanager.message;

import fr.valentin.gamemanager.GameManager;
import fr.valentin.gamemanager.game.AbstractGame;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author Val'entin.
 */
public class GameMessage {

    private AbstractGame game;

    public GameMessage(AbstractGame game){
        this.game = game;
    }

    public String getLogPrefix() {
        return String.format("[%s:%s] ", game.getPlugin().getName(), game.getName());
    }

    public void log(String message){
        GameManager.log(getLogPrefix() + message);
    }


    public String getGamePrefix() {
        return ChatColor.AQUA + "[" + ChatColor.LIGHT_PURPLE + game.getName() + ChatColor.AQUA + "] " + ChatColor.YELLOW;
    }

    public void broadcastMessage(String message){
        String m = getGamePrefix() + message;
        for (Player player : game.getPlayersManager().getPlayers()){
            player.sendMessage(m);
        }
    }

}
