package fr.valentin.nmsutils.reflection;

import java.lang.reflect.Method;

/**
 * @author Val'entin.
 */
public final class MethodeAcces {

    private MethodeAcces(){}


    /**
     * Permet de retourner la méthode recherché dans une class grâce à son nom et ses arguments
     *
     * @param clazz Class où se trouve le méthode
     * @param methodName Nom de la méthode
     * @param parameterType Class des arguments de la méthode
     * @return Un objet Method
     * @throws NullPointerException
     */
    public static Method getMethodWithExeption(Class<?> clazz, String methodName, Class<?>... parameterType) throws NoSuchMethodException {
        Method method = clazz.getMethod(methodName, parameterType);
        method.setAccessible(true);
        return method;
    }

    /**
     * Permet de retourner la méthode recherché dans une class grâce à son nom et ses arguments
     *
     * @param clazz Class où se trouve le méthode
     * @param methodName Nom de la méthode
     * @param parameterType Class des arguments de la méthode
     * @return Un objet Method
     */
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterType){
        Method method = null;
        try {
            method = getMethodWithExeption(clazz, methodName, parameterType);
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        return method;
    }


    /**
     * Permet de retourner la méthode déclaré recherché dans une class grâce à son nom et ses arguments
     *
     * @param clazz Class où se trouve le méthode
     * @param methodName Nom de la méthode
     * @param parameterType Class des arguments de la méthode
     * @return Un objet Method
     * @throws NullPointerException
     */
    public static Method getDeclaredMethodWithExeption(Class<?> clazz, String methodName, Class<?>... parameterType) throws NoSuchMethodException {
        Method method = clazz.getDeclaredMethod(methodName, parameterType);
        method.setAccessible(true);
        return method;
    }

    /**
     * Permet de retourner la méthode déclaré recherché dans une class grâce à son nom et ses arguments
     *
     * @param clazz Class où se trouve le méthode
     * @param methodName Nom de la méthode
     * @param parameterType Class des arguments de la méthode
     * @return Un objet Method
     */
    public static Method geDeclaredtMethod(Class<?> clazz, String methodName, Class<?>... parameterType){
        Method method = null;
        try {
            method = getDeclaredMethodWithExeption(clazz, methodName, parameterType);
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        return method;
    }
}
