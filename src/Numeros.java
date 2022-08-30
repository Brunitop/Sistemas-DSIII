public class Numeros {
    public static void main(String[] args) {
        double suma = 0;
        for (int i = 0; i < args.length; i++){
            suma = suma + Double.parseDouble(args[i]);
        }
        System.out.println("Sumatoria: " + suma);
        System.out.println("Media: " + (suma/args.length));
    }
}