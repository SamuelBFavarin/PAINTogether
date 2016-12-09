package PAINTogether.components;

/**
 * Created by samuel on 07/12/16.
 */
public class Image implements Components {
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

    @Override
    public String typeComponent() {
        return "Image";
    }
}
