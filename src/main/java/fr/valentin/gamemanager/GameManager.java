package fr.valentin.gamemanager;

import java.util.logging.Logger;

/**
 * @author Val'entin.
 */
public final class GameManager {

    private static Logger logger = Logger.getLogger("Minecraft");

    private GameManager(){}

    private static final String prefix = "[GameManager] ";
    public static void log(String message){
        logger.info(prefix + message);
    }

}
