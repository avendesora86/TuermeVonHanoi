import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by shari on 03.11.2017.
 */
public class Disc extends Rectangle {

    public Disc(double width, double height, Paint fill) {
        super(width, height, fill);
    }

    public boolean isSmaller(){
        return true;
    }

}
