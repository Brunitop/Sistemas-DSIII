import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Grafica de Pastel ");
        final PieChart panel = new PieChart(frame);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}