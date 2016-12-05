package PAINTogether.shared;

/**
 * Created by Lucas on 05/12/2016.
 */
public class Brush {

    private float size;
    private String color;
    private BrushType type;
    private Position position;

    private enum BrushType {
        SQUARE, CIRCLE
    }

}
