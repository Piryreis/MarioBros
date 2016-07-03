package fr.valentin.gamemanager.state;

/**
 * @author Val'entin.
 */
public enum GameState {

    SETTING("SETTING", "on setting"),
    PREPARING("PREPARAING", "on preparing"),
    WAITING_PLAYERS("WAITING PLAYERS", "on waiting players"),
    COUNTDOWN("COUNTDOWN", "on countdown"),
    STARTING("STARTING", "on starting"),
    IN_GAME("IN GAME", "in game"),
    VICTORY("VICTORY", "victory"),
    END("END", "end"),
    SHUTDOWN("SHUTDOWN", "shutdown");

    private String name;
    private String displayName;

    GameState(String name, String displayName){
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean equals(GameState gameState){
        return (gameState.getName() == getName() && gameState.displayName == getDisplayName()) ? true : false;
    }

}
