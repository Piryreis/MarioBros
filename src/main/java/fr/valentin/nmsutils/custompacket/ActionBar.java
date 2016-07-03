package fr.valentin.nmsutils.custompacket;

import fr.valentin.nmsutils.nmsreflection.NMSAccess;
import fr.valentin.nmsutils.utils.NMSUtils;

/**
 * @author Val'entin.
 */
public class ActionBar extends CustomPacket {


    public ActionBar(String text){
        super(NMSUtils.getIChatBaseComponent(text), (byte) 2);
    }

    @Override
    public String getNMSClassName() {
        return "PacketPlayOutChat";
    }

    @Override
    public Class[] getParameterType() {
        return new Class[]{NMSAccess.getNMSClass("IChatBaseComponent"), byte.class,};
    }
}
