import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Da Hinh 3");
        Layer layer = new Layer();

        /**
         * Nhấn phím C để thêm hình tròn
         * Nhấn phím R để thêm hình chữ nhật
         */
        frame.add(layer);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}