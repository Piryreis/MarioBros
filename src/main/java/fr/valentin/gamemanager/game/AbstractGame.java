package fr.valentin.gamemanager.game;

import fr.valentin.gamemanager.message.GameMessage;
import fr.valentin.gamemanager.player.GamePlayers;
import fr.valentin.gamemanager.property.GameProperty;
import fr.valentin.gamemanager.state.GameState;
import org.bukkit.plugin.Plugin;

/**
 * @author Val'entin.
 */
public abstract class AbstractGame {

    private Plugin plugin;
    private String name;
    private GameProperty properties;
    private GamePlayers players;
    private GameState state;
    private GameMessage message;

    protected AbstractGame(Plugin plugin, String name) {
        this.plugin = plugin;
        this.name = name;
        this.state = GameState.SETTING;
        this.properties = new GameProperty();
        this.players = new GamePlayers(this);
        this.message = new GameMessage(this);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public String getName() {
        return name;
    }

    public GameProperty getProperties() {
        return properties;
    }

    public GamePlayers getPlayersManager() {
        return players;
    }

    public GameMessage getMessageManager() {
        return message;
    }

    public GameState getState() {
        return state;
    }
}
