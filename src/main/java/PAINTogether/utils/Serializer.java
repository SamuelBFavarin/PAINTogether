package PAINTogether.utils;

import com.google.gson.Gson;

/**
 * @author Lucas Baragatti
 */
public class Serializer {

    public static <T> T fromJson(String json, Class<T> classType) {
        Gson gson = new Gson();

        return gson.fromJson(json, classType);
    }

    public static String toJson(Object object) {
        Gson gson = new Gson();

        return gson.toJson(object);
    }

}
