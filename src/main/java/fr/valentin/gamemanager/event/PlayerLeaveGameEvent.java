package fr.valentin.gamemanager.event;

import fr.valentin.gamemanager.game.AbstractGame;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author Val'entin.
 */
public class PlayerLeaveGameEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private AbstractGame game;
    private Player player;

    public PlayerLeaveGameEvent(AbstractGame game, Player player){
        this.game = game;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public AbstractGame getGame(){
        return game;
    }

    public Player getPlayer() {
        return player;
    }
}
