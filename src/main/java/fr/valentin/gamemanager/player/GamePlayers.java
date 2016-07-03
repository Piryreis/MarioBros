package fr.valentin.gamemanager.player;

import fr.valentin.gamemanager.event.PlayerJoinGameEvent;
import fr.valentin.gamemanager.event.PlayerLeaveGameEvent;
import fr.valentin.gamemanager.game.AbstractGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Val'entin.
 */
public class GamePlayers {

    private AbstractGame game;

    private Map<UUID, Player> players;

    public GamePlayers(AbstractGame game){
        this.game = game;
        this.players = new HashMap<UUID, Player>();
    }


    public void addPlayer(Player player){

        PlayerJoinGameEvent playerJoinGame = new PlayerJoinGameEvent(game, player);
        Bukkit.getPluginManager().callEvent(playerJoinGame);

        if (playerJoinGame.getResult().equals(PlayerJoinGameEvent.Result.ALLOWED)){
            players.put(player.getUniqueId(), player);
        }
        else {
            game.getMessageManager().log(String.format("The player %s could not join the game %s : %s : %s",
                    player.getName(), game.getName(), playerJoinGame.getResult().toString(), playerJoinGame.getMessage()));
        }
    }

    public void removePlayer(Player player){
        PlayerLeaveGameEvent playerLeaveGame = new PlayerLeaveGameEvent(game, player);
        Bukkit.getPluginManager().callEvent(playerLeaveGame);
        players.remove(player.getUniqueId());
    }

    public Player getPlayer(UUID playerUUID){
        return players.get(playerUUID);
    }

    public Player getPlayer(String playerName){
        return players.get(Bukkit.getPlayer(playerName).getUniqueId());
    }

    public Collection<Player> getPlayers(){
        return players.values();
    }

    public Map<UUID, Player> getMap(){
        return players;
    }
}
