import java.util.Scanner;

public class Runner{
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);
        int n;
        System.out.print("Numero de valores: ");
        n = ns.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print("Valor " + i + ": ");
            int x = ns.nextInt();
            Thread t = new Thread(new ThreadPractica(x));
            t.start();
        }
    }
}
