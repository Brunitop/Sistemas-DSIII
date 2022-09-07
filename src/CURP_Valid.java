import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

public class CURP_Valid {
    static Pattern pat = Pattern.compile("^[A-Z][AEIOU][A-Z]{2}[0-9]{2}" +
            "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
            "[HM](AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
            "[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z][0-9]$");
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);
        String cadena;
        System.out.print("Introduzca su CURP: ");
        cadena = ns.next();
        System.out.println(verificarCURP(cadena));
    }

    public static String verificarCURP(String cadena){
        Matcher mat = pat.matcher(cadena);
        if(mat.matches()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        return cadena;
    }
}
