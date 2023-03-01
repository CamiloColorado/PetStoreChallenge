package utilities;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {

    private static final Map<String, Object> data = new HashMap<>();

    public Object getData(String key) {
        return data.get(key);
    }

    public void setData(String key, Object object) {
        data.put(key, object);
    }
}
