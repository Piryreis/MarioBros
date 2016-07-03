package fr.valentin.nmsutils.custompacket;

import fr.valentin.nmsutils.nmsreflection.NMSAccess;
import fr.valentin.nmsutils.utils.NMSUtils;

/**
 * @author Val'entin.
 */
public class Title extends CustomPacket {

    public Title(EnumTitleAction action, String text, int fadeIn, int stay, int fadeOut){
        super(action.getNmsReference(), NMSUtils.getIChatBaseComponent(text), fadeIn, stay, fadeOut);
    }

    public Title(EnumTitleAction action, String text){
        this(action, text, -1, -1, -1);
    }

    public Title(int fadeIn, int stay, int fadeOut){
        this(EnumTitleAction.TIME, (String)null, fadeIn, stay, fadeOut);
    }

    @Override
    public String getNMSClassName() {
        return "PacketPlayOutTitle";
    }

    @Override
    public Class[] getParameterType() {
        return new Class[]{NMSAccess.getNMSClass("PacketPlayOutTitle$EnumTitleAction"), NMSAccess.getNMSClass("IChatBaseComponent"), int.class, int.class, int.class};
    }

    public enum EnumTitleAction {

        TITLE(NMSAccess.getNMSClass("PacketPlayOutTitle$EnumTitleAction").getEnumConstants()[0]),
        SUBTITLE(NMSAccess.getNMSClass("PacketPlayOutTitle$EnumTitleAction").getEnumConstants()[1]),
        TIME(NMSAccess.getNMSClass("PacketPlayOutTitle$EnumTitleAction").getEnumConstants()[2]),
        CLEAR(NMSAccess.getNMSClass("PacketPlayOutTitle$EnumTitleAction").getEnumConstants()[3]),
        RESET(NMSAccess.getNMSClass("PacketPlayOutTitle$EnumTitleAction").getEnumConstants()[4]);

        private Object nmsReference;

        EnumTitleAction(Object nmsReference) {
            this.nmsReference = nmsReference;
        }

        public Object getNmsReference() {
            return nmsReference;
        }
    }

}
