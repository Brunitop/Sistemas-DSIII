public class LiebreTortugaMain {

    static Thread tort = new Thread(new Turtle(1));
    static Thread hare = new Thread(new Hare(1));

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio de la carrera");
        tort.start();
        hare.start();
    }
    public static synchronized void getWinner(int position){
        boolean winner = false;
        if(position >= 70){
            winner = true;
        }
    }
}
