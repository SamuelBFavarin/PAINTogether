package PAINTogether.utils;

import PAINTogether.components.Component;
import PAINTogether.components.ComponentFactory;
import PAINTogether.shared.ComponentWrapper;
import com.google.gson.Gson;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Baragatti
 */
public class Serializer {
    private static Gson gson = new Gson();

    public static ComponentWrapper[] wrapComponents(List<Component> components) {
        ComponentWrapper[] wrapperList = new ComponentWrapper[components.size()];
        for (int i = 0; i < components.size(); i++) {
            Component c = components.get(i);
            ComponentWrapper wrapper = new ComponentWrapper();

            wrapper.type = c.getType().toString();
            wrapper.color = c.getColor().getRGB();
            wrapper.x = c.getX();
            wrapper.y = c.getY();
            wrapper.width = c.getWidth();
            wrapper.height = c.getHeight();

            wrapperList[i] = wrapper;
        }

        return wrapperList;
    }

    public static ArrayList<Component> unwrapComponents(ComponentWrapper[] componentWrappers) {
        ArrayList<Component> components = new ArrayList<>();
        for (ComponentWrapper wrapper : componentWrappers) {
            Component c = ComponentFactory.newInstance(ComponentFactory.ComponentType.valueOf(wrapper.type), wrapper.x, wrapper.y,
                    wrapper.width, wrapper.height, new Color(wrapper.color));

            components.add(c);
        }

        return components;
    }

    public static <T> T fromJson(String json, Class<T> classType) {
        return gson.fromJson(json, classType);
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

}
