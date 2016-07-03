package fr.valentin.gamemanager.property;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Val'entin.
 */
public class GameProperty {

    private Map<String, Object> properties;

    public GameProperty(){
        this.properties = new HashMap<String, Object>();
    }

    public void addPropertie(String key, Object value){
        properties.put(key, value);
    }

    public Object getPropertie(String keyName){
        return properties.get(keyName);
    }

    public Map<String, Object> getProperties(){
        return properties;
    }
}
