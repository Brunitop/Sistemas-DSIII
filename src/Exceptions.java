import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);

        String lectTeclado = ns.nextLine();
        System.out.println(caracterEn(lectTeclado, 7));
    }

    public static char caracterEn(String abc, int n) {
        if (n >= 0 && n <= abc.length()) {
            return abc.charAt(n);
        }
        else{
            try {
                System.out.println("Texto: " + abc);
                System.out.println("Caracter en la posición " + n + ": " + abc.charAt(n));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(e.getMessage() + "Has intentado recuperar una posición de la cadena de caracteres que no existe");
                System.exit(2);
            }
            return 0;
        }
    }
}
