import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class PongGame extends JComponent implements Runnable, KeyListener {
    Dimension preferredSize = null;
    Ellipse2D.Double ball;
    private Paddle paddle1;
    private Paddle paddle2;
    Font scoreFont;
    public PongGame() {
        setOpaque(true);
        scoreFont = new Font("Monospaced", Font.PLAIN, 45);

        setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        ball = new Ellipse2D.Double(20,320,20,20);
        paddle1 = new Paddle(20);
        paddle2 = new Paddle(600);
        Ball ballRunner = new Ball(ball, paddle1, paddle2);
        Thread t1 = new Thread(ballRunner);
        t1.start();
        Thread t2 = new Thread(this);
        t2.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isOpaque()) {
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.white);
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(scoreFont);

        g2.setStroke(new BasicStroke(5.0f));
        g2.drawLine(320, 0, 320, 480);
        g2.drawString(Integer.toString(Ball.trackScore1()), (int) getBounds().getCenterX() - 50, 35);
        g2.drawString(Integer.toString(Ball.trackScore2()), (int) getBounds().getCenterX() + 25, 35);
        if (Ball.trackScore1() == 5) {
            g2.drawString("PLAYER 1 WINS", (float) getBounds().getCenterX()-180, (float) getBounds().getCenterY());
            Ball.gameEnd();
        }
        if (Ball.trackScore2() == 5) {
            g2.drawString("PLAYER 2 WINS", (float) getBounds().getCenterX()-180, (float) getBounds().getCenterY());
            Ball.gameEnd();
        }

        g2.fill(ball);
        g2.fill(paddle1.getRectangle());
        g2.fill(paddle2.getRectangle());
    }

    public Dimension getPreferredSize() {
        if (preferredSize == null) {
            return new Dimension(640, 480);
        } else {
            return super.getPreferredSize();
        }
    }

    public void setPreferredSize(Dimension newPrefSize) {
        preferredSize = newPrefSize;
        super.setPreferredSize(newPrefSize);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //presionado una vez
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char tecla = e.getKeyChar();
        switch(tecla){
            case 'w':
            case 'W':
                paddle1.moveUp();
                break;
            case 's':
            case 'S':
                paddle1.moveDown();
                break;
            case 'o':
            case 'O':
                paddle2.moveUp();
                break;
            case 'l':
            case 'L':
                paddle2.moveDown();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //dejar de presionar
    }

    @Override
    public void run() {
        while(true){
            repaint();
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}