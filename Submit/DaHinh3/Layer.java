import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;


class Layer extends JPanel implements ActionListener {
    private java.util.List<Shape> shapes = new ArrayList<>();
    private Timer timer;
    private Random rand;

    /** Constructor. */
    public Layer() {
        shapes = new ArrayList<>();
        rand = new Random();
        timer = new Timer(10, this);
        timer.start();
        setFocusable(true);

        // Key listener for adding shapes
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    // Add circle
                    Circle circle = new Circle(rand.nextInt(getWidth()), rand.nextInt(getHeight()),
                            rand.nextInt(100) + 10, getRandomColor(), rand.nextInt(5) - 2,
                            rand.nextInt(5) - 2, rand.nextInt(50) + 10);
                    addShape(circle);
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    // Add rectangle
                    Rectangle rectangle = new Rectangle(rand.nextInt(getWidth()), rand.nextInt(getHeight()),
                            rand.nextInt(100) + 10, getRandomColor(), rand.nextInt(5) - 2,
                            rand.nextInt(5) - 2, rand.nextInt(50) + 10, rand.nextInt(50) + 10);
                    addShape(rectangle);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    // Remove last shape
                    if (!shapes.isEmpty()) {
                        shapes.remove(shapes.size() - 1);
                    }
                }
            }
        });
    }

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

    private Color getRandomColor() {
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Shape shape : shapes) {
            shape.move();
            shape.checkBoundary(getWidth(), getHeight());
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
