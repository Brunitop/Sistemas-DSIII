public class ThreadPractica implements Runnable{
    static int fact;
    public ThreadPractica(int x){
        this.fact = x;
    }

    public void run(){
        int resultado = fact;
        if(fact != 0) {
            for (int i = fact-1; i >= 1; i--) {
                resultado = resultado*i;
            }
        }
        else{
            resultado = 1;
        }
        System.out.println( Thread.currentThread().getName() + ": " + resultado);
    }
}
