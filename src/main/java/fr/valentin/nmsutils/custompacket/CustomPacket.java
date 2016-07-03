package fr.valentin.nmsutils.custompacket;

import fr.valentin.nmsutils.nmsreflection.NMSAccess;
import fr.valentin.nmsutils.reflection.ConstructorAccess;
import fr.valentin.nmsutils.reflection.InstanceAcces;

import java.lang.Class;import java.lang.Object;import java.lang.String;import java.lang.reflect.Constructor;

/**
 * @author Val'entin.
 */
public abstract class CustomPacket {

    protected Object[] arguments;

    public CustomPacket(Object... args){
        this.arguments = new Object[args.length];
        //this.arguments = args;
        for (int i = 0; i < args.length; i++){
            arguments[i] = args[i];
        }
    }

    public abstract String getNMSClassName();

    public Class<?> getNMSClass(){
        return NMSAccess.getNMSClass(getNMSClassName());
    }

    public Object[] getArguments(){
        return arguments;
    }

    public void addArgument(int i, Object arg){
        arguments[i] = arg;
    }

    public void addArgument(Object arg){
        arguments[arguments.length + 1] = arg;
    }

    public abstract Class[] getParameterType();

    public Object getPacket(){
        Object packet;
        Class clazz = getNMSClass();
        Constructor constructor = ConstructorAccess.getConstructor(clazz, getParameterType());
        packet = InstanceAcces.getNewInstance(constructor, getArguments());
        return packet;
    }
}
