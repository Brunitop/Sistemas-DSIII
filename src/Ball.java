import java.awt.geom.Ellipse2D;

public class Ball implements Runnable {

    public static final int MAX_X = 640;
    public static final int MAX_Y = 480;
    public static final int SIGN = -1;
    public static int score1 = 0;
    public static int score2 = 0;
    public static int DX = -10;
    public static int DY = 10;
    private static Ellipse2D.Double ball;
    private Paddle paddle1;
    private Paddle paddle2;
    private static int ballX;
    private static int ballY;

    public Ball( Ellipse2D.Double shape, Paddle p1, Paddle p2) {
        ball = shape;
        paddle1 = p1;
        paddle2 = p2;
        ballX = 310;
        ballY = 240;
        ball.x = ballX;
        ball.y = ballY;
    }
    public static int getCurrentX(){
        return (int)ball.x;
    }
    public static int getCurrentY(){
        return (int)ball.y;
    }

    public static int trackScore1(){
        return score1;
    }
    public static int trackScore2(){
        return score2;
    }
    public static void gameEnd(){
        DX = 0;
        DY = 0;
        ballX = 310;
        ball.x = ballX;
        ballY = 240;
        ball.y = ballY;
    }
    @Override
    public void run() {
        int directionY = 1;
        int directionX = 1;
        int bxmin, bxmax, bymin, bymax;
        while( true ) {
            bxmin = (int)ball.getMinX();
            bxmax = (int)ball.getMaxX();
            bymin = (int)ball.getMinY();
            bymax = (int)ball.getMaxY();
            if( paddle1.check(bxmin,bymin) || paddle1.check(bxmin,bymax)) {
                // sX = sX * SIGN;
                directionX = directionX * SIGN;
                ballX = ballX + (DX*directionX);
                ballY = ballY + (DY*directionY);
                ball.x = ballX;
                ball.y = ballY;
                continue;
            }
            if( paddle2.check(bxmax,bymin) || paddle2.check(bxmax,bymax)) {
                // sX = sX * SIGN;
                directionX = directionX * SIGN;
                ballX = ballX + (DX*directionX);
                ballY = ballY + (DY*directionY);
                ball.x = ballX ;
                ball.y = ballY;
                continue;
            }
            if(ball.x == MAX_X){
                ballX = 310;
                ball.x = ballX;
                ballY = 240;
                ball.y = ballY;
                score1++;
            }
            if(ball.x == 0){
                ballX = 310;
                ball.x = ballX;
                ballY = 240;
                ball.y = ballY;
                score2++;
            }
            if(ball.y == MAX_Y || ball.y == 0){
                directionY = directionY*SIGN;
            }
            ballX = ballX + (DX*directionX);
            ballY = ballY + (DY*directionY);
            ball.x = ballX ;
            ball.y = ballY;
            try {
                Thread.sleep(35L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
