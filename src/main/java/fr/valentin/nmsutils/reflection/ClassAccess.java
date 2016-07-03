package fr.valentin.nmsutils.reflection;

/**
 * @author Val'entin.
 */
public final class ClassAccess {

    private ClassAccess(){}


    /**
     * Retourne la class du nom spécifiée.
     *
     * @param className nom de la class avec le chemin d'accès
     * @return Un objet Class<?> de la class
     * @throws ClassNotFoundException
     */
    public static Class<?> getClassWithExeption(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    /**
     * Retourne la class du nom spécifiée.
     *
     * @param className nom de la class avec le chemin d'accès
     * @return Un objet Class<?> de la class
     */
    public static Class<?> getClass(String className){
        Class<?> clazz = null;
        try {
            clazz = getClassWithExeption(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
