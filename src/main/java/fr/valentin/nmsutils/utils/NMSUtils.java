package fr.valentin.nmsutils.utils;

import fr.valentin.nmsutils.nmsreflection.NMSAccess;
import fr.valentin.nmsutils.reflection.MethodeAcces;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Val'entin.
 */
public final class NMSUtils {

    private static Class<?> chatSerializer = NMSAccess.getNMSClass("IChatBaseComponent$ChatSerializer");

    public static Object getIChatBaseComponent(String text){
        Object chatComponent = null;
        try {
            chatComponent = MethodeAcces.getMethod(chatSerializer, "a", String.class).invoke(null, "{\"text\": \"" + text + "\"}");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return chatComponent;
    }
}
