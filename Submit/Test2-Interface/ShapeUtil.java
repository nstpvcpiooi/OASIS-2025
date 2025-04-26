import java.util.List;

public class ShapeUtil {
    /**
     * Prints the information of the shapes in the list.
     *
     * @param shapes the list of shapes
     * @return the information of the shapes
     */
    public String printInfo(List<GeometricObject> shapes) {
        String info = "";

        info += "Circle:\n";
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                info += shape.getInfo() + "\n";
            }
        }

        info += "Triangle:\n";
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                info += shape.getInfo() + "\n";
            }
        }
        return info;
    }
}
