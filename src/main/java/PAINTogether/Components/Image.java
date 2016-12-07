package PAINTogether.Components;

/**
 * Created by samuel on 07/12/16.
 */
public class Image {
    private final String filename;
    private final Rectangle rectangle;

    public Image(String filename, Rectangle rectangle) {
        this.filename = filename;
        this.rectangle = rectangle;
    }

    public String getFilename() {
        return this.filename;
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }
}
