import java.util.HashMap;
import java.util.Map;

public class Vehicle implements UObject {
    Map<String, Object> properties = new HashMap<>();

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public void printProperty(String key) {
        System.out.println(key + " = " + properties.get(key));
    }
}
