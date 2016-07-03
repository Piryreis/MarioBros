package fr.valentin.nmsutils.reflection;

import java.lang.reflect.Field;

/**
 * @author Val'entin.
 */
public final class FieldAccess {

    //private FieldAccess(){}

    public FieldAccess(){

    }

    private int test = 10;

    /**
     * Permet de retourner une variable d'une class
     *
     * @param clazz Class où se trouve la variable
     * @param fieldName Nom de la variable
     * @return Un objet Field
     * @throws NoSuchFieldException
     */
    public static Field getFieldWithExeption(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Field field = clazz.getField(fieldName);
        field.setAccessible(true);
        return field;
    }

    /**
     * Permet de retourner une variable d'une class
     *
     * @param clazz Class où se trouve la variable
     * @param fieldName Nom de la variable
     * @return Un objet Field
     * @throws NoSuchFieldException
     */
    public static Field getField(Class<?> clazz, String fieldName){
        Field field = null;
        try {
            field = getFieldWithExeption(clazz, fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }


    /**
     * Permet de retourner une variable déclaré d'une class
     *
     * @param clazz Class où se trouve la variable
     * @param fieldName Nom de la variable
     * @return Un objet Field
     * @throws NoSuchFieldException
     */
    public static Field getDeclaredFieldWithExeption(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }

    /**
     * Permet de retourner une variable déclaré d'une class
     *
     * @param clazz Class où se trouve la variable
     * @param fieldName Nom de la variable
     * @return Un objet Field
     * @throws NoSuchFieldException
     */
    public static Field getDeclaredField(Class<?> clazz, String fieldName){
        Field field = null;
        try {
            field = getDeclaredFieldWithExeption(clazz, fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }
}
