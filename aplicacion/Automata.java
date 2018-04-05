package aplicacion;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Automata {
    public static void main(String[] args) {
        String tokens[] = new String[100];
        inicializarTokens(tokens);
        ArrayList<String> codigoPorLineas;
        ArrayList<String> analisisLexico;
        try {
            codigoPorLineas = cargarCodigoDesdeUnArchivoDeTexto();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.out.println("No hay archivo de código, no puede continuar.");
            return;
        }
        System.out.println("El archivo de texto se ha cargado correctamente.");
        System.out.println(codigoPorLineas.get(0));
        //partir las líneas por espacios
        //analizar con lo que se conoce ahora
        //concatenar cada análisis a un archivo
    }

    private static ArrayList cargarCodigoDesdeUnArchivoDeTexto() throws IOException {
        ArrayList<String> codigoPorLineas = new ArrayList<String>();
        File archivoDelCodigo = new File("C:/users/xtrs84zk/desktop/codigo.txt");
        InputStreamReader input = null;
        input = new InputStreamReader(new FileInputStream(archivoDelCodigo), "UTF8");
        if (input != null) {
            codigoPorLineas = new ArrayList<String>();
            String r;
            BufferedReader in = new BufferedReader(input);
            while ((r = in.readLine()) != null) {
                codigoPorLineas.add(r + "\n");
            }
            in.close();
        }
        return codigoPorLineas;
    }

    /**
     * Hipotéticamente, este método inicializará el arreglo de tokens que contiene cada elemento definido
     * del lenguaje, su token está definido por la posición que ocupa en el arreglo.
     *
     * @param tokens referencia que fungirá para almacenar los token
     */
    private static void inicializarTokens(String tokens[]) {
        //Palabras reservadas
        tokens[1] = "prog";
        tokens[6] = "limpiar";
        tokens[11] = "leer";
        tokens[16] = "si";
        tokens[2] = "var";
        tokens[7] = "vexy";
        tokens[12] = "escribir";
        tokens[17] = "sino";
        tokens[3] = "proc";
        tokens[8] = "string";
        tokens[13] = "repite";
        tokens[18] = "ejecuta";
        tokens[4] = "inicio";
        tokens[9] = "real";
        tokens[14] = "hasta";
        tokens[19] = "and";
        tokens[5] = "fin";
        tokens[10] = "10";
        tokens[15] = "mientras";
        tokens[20] = "or";

        //Operadores aritméticos
        tokens[31] = "+";
        tokens[32] = "-";
        tokens[33] = "*";
        tokens[34] = "/";

        //Operadores relacionales
        tokens[41] = "<";
        tokens[43] = "<=";
        tokens[46] = "<>";
        tokens[42] = ">";
        tokens[44] = ">=";
        tokens[35] = "=";

        //Operadores lógicos
        tokens[51] = "&&";
        tokens[52] = "||";
        tokens[53] = "!";

        //Carácteres especiales que generan tokens
        tokens[85] = ";";
        tokens[83] = "[";
        tokens[84] = "]";
        tokens[88] = ",";
        tokens[86] = ":";
        tokens[82] = "(";
        tokens[82] = ")";
        tokens[87] = ":=";

        //Carácteres especiales que no generan token
        //Pensando qué haré con ellos
        //String caracteresEspecialesQueNoGeneranToken[] = {"\"", ".", "BCO", "TAB", "EOLN", "EOF"};
    }

    private static void escribirElResultadoAUnArchivo(ArrayList<String> analisisLexico) throws IOException {
        FileWriter writer = new FileWriter("C:/users/xtrs84zk/desktop/analisis.txt");
        for (String str : analisisLexico) {
            writer.write(str);
        }
        writer.close();
    }

    private ArrayList identificarLexicoEnUnaLinea(String lineaAIdentificar, String[] tokens, int numeroDeLinea) {
        ArrayList<String> analisisDeLaLinea = new ArrayList<String>();
        //Estableciendo las expresiones
        String analisisDeLaIteracionActual;
        String expresiones[] = lineaAIdentificar.split(Pattern.quote(" "));
        for (int i = 0; i < expresiones.length; i++) {
            analisisDeLaIteracionActual = analisisLexicoDeElementosDelLenguaje(expresiones[i], tokens, numeroDeLinea);
            if (analisisDeLaIteracionActual == null) {
                analisisDeLaIteracionActual = analisisLexicoDeIdentificadores(expresiones[i], numeroDeLinea);
                if (analisisDeLaIteracionActual == null) {

                }
            }
            analisisDeLaLinea.add(analisisDeLaIteracionActual + "\n");
        }
        return analisisDeLaLinea;
    }

    private String analisisLexicoDeElementosDelLenguaje(String posibleIdentificador, String[] tokens, int numeroDeLinea) {
        int token = contiene(tokens, posibleIdentificador);

        //Si el token recibido es diferente a cien, se ha identificado la cadena en el lenguaje
        if (token != 100) {
            String analisisLexico = "";
            //Si la cadena contiene una palabra reservada
            if (token > 0 && token < 20) {
                analisisLexico = "(" + posibleIdentificador + ", -" + token + ", -1, " + numeroDeLinea + " )";
            }
            //Más o menos lo mismo para los demás
            return analisisLexico;
        } else {
            return null;
        }
    }

    /**
     * Recibe un arreglo y la cadena que buscará en él. En caso de encontrarlo, regresa
     * su posición en el arreglo; de lo contrario, regresa -100 como mensaje de error.
     *
     * @param tokens
     * @param loQueDeberiaContener
     * @return
     */
    private int contiene(String[] tokens, String loQueDeberiaContener) {
        for (int i = 0; i < 100; i++) {
            if (tokens[i].equals(loQueDeberiaContener)) {
                return i;
            }
        }
        return 100;
    }

    private String analisisLexicoDeIdentificadores(String posibleIdentificador, int numeroDeLinea) {
        //Los identificadores inician con una letra y pueden seguir con letras o hasta seis caracteres.
        if (0 <= "abcdefghijklmnñopqrstuvwxyz".indexOf(posibleIdentificador.charAt(0)) && posibleIdentificador.length() < 6) {
            return "(" + posibleIdentificador + ", -" + 61 + ", -2, " + numeroDeLinea + " )";
        } else {
            return null;
        }

    }
}
