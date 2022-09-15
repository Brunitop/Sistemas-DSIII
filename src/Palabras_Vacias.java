import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Palabras_Vacias {
    public static void main(String[] args) {
        FileReader fin = null;
        BufferedReader in = null;

        try {
            fin = new FileReader("C:\\Users\\bruno\\Downloads\\stopwords-es.txt");
            in = new BufferedReader( fin );
        } catch (FileNotFoundException e) {
            System.out.println( e.getMessage() );
            System.exit(1);
        }

        ArrayList<String> stops = new ArrayList<String>();
        String a = null;
        try {
            // Leer la primera linea y descartar
            a = in.readLine();
            while ( (a = in.readLine()) != null ) {  // leer cada linea del archivo
                stops.add(a);
            }
            in.close();
            fin.close();
            stops.add("0");
        } catch (IOException e) {
            System.out.println( e.getMessage() );
            System.exit(1);
        }



        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }

        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        //Usar para leer linea x linea el archivo
        BufferedReader inputFile = new BufferedReader(fi);

        String textLine = null;


        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";


        // Lista con todas las palabras diferentes
        ArrayList<String> list = new ArrayList<String>();

        try {
            while ((textLine = inputFile.readLine()) != null) {

                if (textLine.trim().length() == 0) {
                    continue; // la linea esta vacia, continuar
                }

                // separar las palabras en cada linea
                String words[] = textLine.split( delimiters );


                for (String theWord : words) {

                    theWord = theWord.toLowerCase().trim();

                    boolean isNumeric = true;

                    // verificar si el token es un numero
                    try {
                        Double num = Double.parseDouble(theWord);
                    } catch (NumberFormatException e) {
                        isNumeric = false;
                    }

                    // Si el token es un numero, pasar al siguiente
                    if (isNumeric) {
                        continue;
                    }

                    // si la palabra no esta en la lista, agregar a la lista
                    if ( !list.contains(theWord) && !stops.contains(theWord)) {
                        list.add(theWord);
                    }
                }
            }
            inputFile.close();
            fi.close();

            // Mostrar total de palabras diferentes
            System.out.println("Total de Palabras diferentes: " +  list.size());
            System.out.println("Palabras diferentes: " + list);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
