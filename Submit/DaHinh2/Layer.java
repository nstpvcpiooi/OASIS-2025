import java.util.ArrayList;

public class Layer {
    private java.util.List<Shape> shapes = new ArrayList<>();

    /** Add shape. */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /** Remove circles. */
    public void removeCircles() {
        shapes.removeIf(shape -> shape instanceof Circle);
    }

    /** Get info. */
    public String getInfo() {
        String info = "Layer of crazy shapes:\n";
        for (int i = 0; i < shapes.size(); i++) {
            info += shapes.get(i).toString() + "\n";
        }
        return info;
    }

    /** Remove duplicates. */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    shapes.remove(j);
                    j--;
                }
            }
        }
    }
}
