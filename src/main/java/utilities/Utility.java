package utilities;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public <T> List<T> jasonArrayToObjectList(String json, Class<T> tClass){
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        try {
            return objectMapper.readValue(json, collectionType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
