import java.util.Scanner;

public class NumeroNegativoExcepcion extends Throwable {
    public static void main(String[] args) {
            Scanner ns = new Scanner(System.in);
            int n;
            double sqrt = 0;
            System.out.println("Número: " );
            n = ns.nextInt();
            try{
                sqrt = Math.sqrt(n);

            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
            System.out.println("La raiz es: " +  sqrt);
        }

    public NumeroNegativoExcepcion(String abc){
        Scanner ns = new Scanner(System.in);
        int abc = ns.nextLine();
        caracterEN(abc);
    }
    public NumeroNegativoExcepcion(){

    }
}
