import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class PieChart extends JComponent implements Runnable{
    Image image;
    Graphics2D g2;

    public void paintComponent(Graphics g) {
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(225, 80, 150, 150);
        image = createImage(getSize().width, getSize().height);
        g2 = (Graphics2D) image.getGraphics();

            int[] ventas = new int[4];
            for (int i = 0; i < 4; i++) {
                int b = (int) (Math.random() * (1500 - 100) + 100);
                ventas[i] = b;
            }

            int c = 0;
            for (int i = 0; i < 4; i++) {
                c = c + ventas[i];
            }
            System.out.println();

            double[] percent = new double[4];
            for (int i = 0; i < 4; i++) {
                percent[i] = (ventas[i] * 360) / c;
            }
            int sumAngles = 0;
            for (int i = 0; i < 4; i++) {
                sumAngles = (int) (sumAngles + percent[i]);
            }
            double missingAmount = 360 - sumAngles;
            for (int i = 0; i < 4; i++) {
                percent[i] = percent[i] + (missingAmount / 4);
                System.out.println(percent[i]);
            }

            // 0 - 80 degrees
            arc.setAngleStart(0);
            arc.setAngleExtent(percent[0]);
            g2.setColor(Color.gray);
            g2.draw(arc);
            g2.setColor(Color.red);
            g2.fill(arc);

            // 80 - 200 degrees
            arc.setAngleStart(percent[0]);
            arc.setAngleExtent(percent[0] + percent[1]);
            g2.setColor(Color.gray);
            g2.draw(arc);
            g2.setColor(Color.blue);
            g2.fill(arc);

            // 200 - 360 degrees
            arc.setAngleStart(percent[0] + percent[1]);
            arc.setAngleExtent(percent[2]);
            g2.setColor(Color.gray);
            g2.draw(arc);
            g2.setColor(Color.green);
            g2.fill(arc);

            arc.setAngleStart(percent[0] + percent[1] + percent[2]);
            arc.setAngleExtent(percent[3]);
            g2.setColor(Color.gray);
            g2.draw(arc);
            g2.setColor(Color.yellow);
            g2.fill(arc);

            g2.setColor(Color.white);
            g2.fillRect(0, 0, getSize().width, getSize().height);
            repaint();
        }
    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void run(){
        while(true){
            clear();
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}