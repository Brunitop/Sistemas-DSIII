public class Hare implements Runnable{
    private static int position;
    private boolean winner = false;
    public Hare(int position){
        Hare.position = position;
    }

    public void run() {
        boolean fin = false;
        while(!fin){
            int turno1 = (int) Math.floor(Math.random()*(100)+1);
            try {
                liebreTurno(turno1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int p1 = (int) get();

            for(int i = 0; i < p1; i++){
                System.out.print(" ");
            }
            System.out.println("L");

            LiebreTortugaMain.getWinner(position);
        }
    }
    public synchronized void duerme() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        notifyAll();
    }

    public synchronized void granSalto() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position + 9;
        notifyAll();
    }
    public synchronized void resbalonGrande() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position - 12;
        if(position < 1){
            position = 1;
        }
        notifyAll();
    }
    public synchronized void saltoChico() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position + 1;
        notifyAll();
    }
    public synchronized void resbalonChico() throws InterruptedException{
        // Esperar un segundo y ejecutar accion
        Thread.sleep(1000);
        position = position - 2;
        if(position < 1){
            position = 1;
        }
        notifyAll();
    }

    public synchronized int get() {
        notifyAll();
        return position;
    }

    public void liebreTurno(int valor) throws InterruptedException {
        if(0 < valor && valor < 21){
            duerme();
        }
        else if(21 < valor && valor < 41){
            granSalto();
        }
        else if(41 < valor && valor < 51){
            resbalonGrande();
        }
        else if(51 < valor && valor < 81){
            saltoChico();
        }
        else{
            resbalonChico();
        }
    }
}
