package PAINTogether.components;

import java.awt.*;

/**
 * Created by Lucas Baragatti on 12/12/2016.
 */
public class ComponentFactory {

    public static Component newInstance(ComponentType type, int x, int y, int width, int height, Color color) {
        switch (type) {
            case RECTANGLE:
                return new Rectangle(x, y, width, height, color);
            case CIRCLE:
                return new Circle(x, y, width, height, color);
            default:
                return null;
        }
    }

    public enum ComponentType {
        RECTANGLE, CIRCLE;
    }

}
