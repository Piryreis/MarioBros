package fr.valentin.nmsutils.reflection;

import java.lang.reflect.Constructor;

/**
 * @author Val'entin.
 */
public final class ConstructorAccess {

    private ConstructorAccess(){}

    /**
     * Retourne le type du constructeur de la class avec les arguments sp�cifi�s
     *
     * @param clazz du constructeur souhait�
     * @param args arguments souhait� pour le constructeur
     * @return L'instance du constructeur
     * @throws NoSuchMethodException
     */
    public static Constructor getConstructorWithExeption(Class<?> clazz, Class... args) throws NoSuchMethodException {
        return clazz.getConstructor(args);
    }

    /**
     * Retourne le type du constructeur de la class avec les arguments sp�cifi�s
     *
     * @param clazz du constructeur souhait�
     * @param args arguments souhait� pour le constructeur
     * @return Le type du constructeur
     */
    public static Constructor getConstructor(Class<?> clazz, Class<?>... args){
        Constructor constructor = null;
        try {
            constructor = getConstructorWithExeption(clazz, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }

}
