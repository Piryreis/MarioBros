package fr.valentin.nmsutils.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Val'entin.
 */
public final class InstanceAcces {

    private InstanceAcces(){}

    /**
     * Retourne un objet d'une nouvelle instance d'une class grace au constructeur et aux arguments donnés
     *
     * @param constructor que l'on doit utiliser
     * @param initargs arguments besoin pour initialiser la class
     * @return l'instance de la class
     * @throws IllegalAccessException, InvocationTargetException, InstantiationException
     */
    public static Object getNewInstanceWithExeption(Constructor constructor, Object... initargs) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance(initargs);
    }

    /**
     * Retourne un objet d'une nouvelle instance d'une class grace au constructeur et aux arguments donnés
     *
     * @param constructor que l'on doit utiliser
     * @param initargs arguments besoin pour initialiser la class
     * @return l'instance de la class
     */
    public static Object getNewInstance(Constructor constructor, Object... initargs){
        Object object = null;
        try {
            object = getNewInstanceWithExeption(constructor, initargs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
}
