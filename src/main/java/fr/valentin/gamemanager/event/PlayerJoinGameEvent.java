package fr.valentin.gamemanager.event;

import fr.valentin.gamemanager.game.AbstractGame;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author Val'entin.
 */
public class PlayerJoinGameEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private AbstractGame game;
    private Player player;

    private PlayerJoinGameEvent.Result result;
    private String message;

    public PlayerJoinGameEvent(AbstractGame game, Player player){
        this.game = game;
        this.player = player;
        this.result = Result.ALLOWED;
        this.message = "";
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

    public Result getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void allow(){
        this.result = Result.ALLOWED;
        this.message = "";
    }

    public void disallow(PlayerJoinGameEvent.Result result, String message){
        this.result = result;
        this.message = message;
    }

    public static enum Result {
        ALLOWED,
        DISALLOWED_GAME_FULL,
        DISALLOWED_GAME_STARTED,
        DISALLOWED_OTHER
    }
}
