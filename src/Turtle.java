public class Turtle implements Runnable{
    private int position;
    private boolean winner = false;
    public Turtle(int position){
        this.position = position;
    }

    public void run() {
        boolean fin = false;
        while(!fin){
            int turno1 = (int) Math.floor(Math.random()*(100)+1);
            int turno2 = (int) Math.floor(Math.random()*(100)+1);
            try {
                tortugaTurno(turno2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int p1 = (int) get();
            int p2 = (int) get();

            for(int i = 0; i < p2; i++){
                System.out.print(" ");
            }
            System.out.println("T");

            LiebreTortugaMain.getWinner(position);
        }
    }

    public synchronized void avanceRapido() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position + 3;
        notifyAll();
    }
    public synchronized void resbalon() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position - 6;
        if(position < 1){
            position = 1;
        }
        notifyAll();
    }
    public synchronized void avanceLento() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position + 3;
        notifyAll();
    }
    public synchronized int get() {
        notifyAll();
        return position;
    }
    public synchronized boolean getWinner(){
        if(position >= 70){
            winner = true;
        }
        return winner;
    }

    public void tortugaTurno(int valor) throws InterruptedException{
        if(0 < valor && valor < 51){
            avanceRapido();
        }
        else if(51 < valor && valor < 71) {
            resbalon();
        }
        else{
            avanceLento();
        }
    }
}
