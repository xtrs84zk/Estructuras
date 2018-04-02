package aplicacion;

public class Automata {
    public static void Main(String[] args) {
        String tokens[] = new String[100];
        inicializarTokens(tokens);

    }

    private String identificarLexico(String cadenaAIdentificar) {
        //Aquí se especifíca un valor inicial para el caracter en determinado punto de la cadena
        String posibleMiembroDelLenguaje = "";
        Character caracterActual = null;
        int p = 0;
        do {
            if (cadenaAIdentificar.charAt(p) != ' ') {
                posibleMiembroDelLenguaje += cadenaAIdentificar.charAt(p);
            }
            p++;
        } while (caracterActual != ' ' && p < cadenaAIdentificar.length());
        return posibleMiembroDelLenguaje;
    }

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
        //String operadoresRelacionales[] = {"<", "<=", "<>", ">", ">=", "="};
        //String operadoresLogicos[] = {"&&", "||", "!"};
        //String caracteresEspecialesQueGeneranToken[] = {";", "[", "]", ",", ":", "(", ")", ":="};
        //String caracteresEspecialesQueNoGeneranToken[] = {"\"", ".", "BCO", "TAB", "EOLN", "EOF"};
    }

    private String analisisLexico(String posibleIdentificador, String[] tokens, int numeroDeLinea) {
        int token = contiene(tokens, posibleIdentificador);
        String analisisLexico = null;
        //Si el token recibido es diferente a cien, se ha identificado la cadena en el lenguaje
        if (token != 100) {
            //Si la cadena contiene una palabra reservada
            if (token > 0 && token < 20) {
                analisisLexico = "(" + posibleIdentificador + ", -" + token + ", -1, " + numeroDeLinea + " )";
            }
            //Más o menos lo mismo para los demás
        }
        return analisisLexico;
    }

    private String analizarIdentificador(String posibleIdentificador, int numeroDeLinea) {
        //Los identificadores inician con una letra y pueden seguir con letras o hasta seis caracteres.
        if (posibleIdentificador.length() > 6) {
            return null;
        }
        String letras = "abcdefghijklmnñopqrstuvwxyz";
        String analisisLexico = null;
        //if(letras.contains(((char)posibleIdentificador.charAt(0))))
        return analisisLexico;
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
}
