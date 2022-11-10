import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.ArrayList;

public class URLweb {

    public static final String TAG = URLweb.class.getSimpleName();

    public static final Logger LOG = Logger.getLogger(TAG);


    //public static final String THE_URL = "http://www.gutenberg.org/cache/epub/29640/";
    public static String THE_URL;
    public static String palabra;
    public static int counter = 0;
    public static int pos;

    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);
        System.out.print("Ingrese un url de web: ");
        THE_URL = ns.next();
        System.out.print("Ingrese una palabra para buscar en esta pagina (utilice minusculas): ");
        palabra = ns.next();

        ArrayList<Character> palabraList = new ArrayList<>();
        for(char ch: palabra.toCharArray()){
            palabraList.add(ch);
        }

        URL webPage = null;
        try {
            webPage = new URL(THE_URL);
        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
        }

        // Crear un flujo para leer datos del URL
        BufferedReader htmlReader = null;
        try {
            htmlReader = new BufferedReader(
                    new InputStreamReader( webPage.openStream() ));
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }

        String htmlLine = null;

        try {
            while ((htmlLine = htmlReader.readLine()) != null) {
                if (htmlLine.toLowerCase().contains(palabra)) {
                    pos = 0;
                    counter++;
                    ArrayList<Character> lineList = new ArrayList<>();
                    for(char ch: htmlLine.toCharArray()){
                        lineList.add(ch);
                    }
                    System.out.println(lineList);
                    for(int i = 0; i < lineList.size(); i++){
                        char c = Character.toLowerCase(lineList.get(i));
                        if(Objects.equals(palabraList.get(0), c)){
                            int matched = 1;
                            if(palabraList.size() > 1){
                                int j = 1;
                                int k = i+1;
                                c = Character.toLowerCase(lineList.get(k));
                                while(palabraList.get(j) == c){
                                    j++;
                                    k++;
                                    c = Character.toLowerCase(lineList.get(k));
                                    matched++;
                                    if(matched == palabraList.size()){
                                        pos = i;
                                        break;
                                    }
                                }
                            }
                            else {
                                pos = i;
                            }
                        }
                    }
                    System.out.println("Posicion de ocurrencia " + counter + ": " + pos);
                }
            }
            System.out.println("Veces que se repite la palabra: " + counter);
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        } finally {
            try {
                if (htmlReader != null) {
                    htmlReader.close();
                }
            } catch (IOException ex) {
                LOG.severe(ex.getMessage());
            }
        }
    }
}