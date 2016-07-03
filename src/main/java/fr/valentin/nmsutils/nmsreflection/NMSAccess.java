package fr.valentin.nmsutils.nmsreflection;

import fr.valentin.nmsutils.reflection.ClassAccess;
import org.bukkit.Bukkit;

/**
 * @author Val'entin.
 */
public final class NMSAccess {

    private NMSAccess(){}


    /**
     * Retourne la version du packet net.minecraft.server.version
     *
     * @return La version en chaine de caract�res
     */
    public static String getNMSVersion(){
        String version;
        String name = Bukkit.getServer().getClass().getPackage().getName();
        version = name.substring(name.lastIndexOf('.') + 1);
        return version;
    }

    /**
     * Retourne la class recherch�
     *
     * @param className Le nom de la class voulu
     * @return Une Class
     */
    public static Class<?> getNMSClass(String className){
        String fullname = "net.minecraft.server." + getNMSVersion() + "." + className;
        return ClassAccess.getClass(fullname);
    }
}
