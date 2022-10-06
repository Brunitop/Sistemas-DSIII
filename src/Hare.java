public class Hare {
    private int position;
    private boolean winner = false;
    public Hare(int position){
        this.position = position;
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
    public synchronized boolean getWinner(){
        if(position >= 70){
            winner = true;
        }
        return winner;
    }
}
