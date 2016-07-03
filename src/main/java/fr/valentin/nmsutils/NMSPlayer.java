package fr.valentin.nmsutils;

import fr.valentin.nmsutils.nmsreflection.NMSAccess;
import fr.valentin.nmsutils.reflection.FieldAccess;
import fr.valentin.nmsutils.reflection.MethodeAcces;
import org.bukkit.entity.Player;

import java.lang.IllegalAccessException;
import java.lang.Object;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Val'entin.
 */
public class NMSPlayer {

    private Player player;

    public NMSPlayer(Player player){
        this.player = player;
    }

    public Object getHandle(){
        Object handle = null;
        try {
            handle = MethodeAcces.getMethod(player.getClass(), "getHandle").invoke(player);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return handle;
    }

    public Object getConnection(){
        Object connection = null;
        try {
            connection = FieldAccess.getField(getHandle().getClass(), "playerConnection").get(getHandle());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void sendPacket(Object packet){
        try {
            Class packetClass = NMSAccess.getNMSClass("Packet");
            MethodeAcces.getMethod(getConnection().getClass(), "sendPacket", packetClass).invoke(getConnection(), packet);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
