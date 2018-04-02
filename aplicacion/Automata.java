package aplicacion;

public class Automata {
    public static void Main(String[] args) {

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


    private String validarIdentificador(String posibleIdentificador) {
        String palabrasReservadas[] = {"prog", "entero", "leer", "si", "var", "real", "escribir", "sino", "proc", "string",
                "repite", "ejecuta", "inicio", "limpiar", "hasta", "and", "fin", "vexy", "mientras", "or"};
        char operadoresAritmeticos[] = {'+', '-', '*', '/'};
        String operadoresRelacionales[] = {"<", "<=", "<>", ">", ">=", "="};
        String operadoresLogicos[] = {"&&", "||", "!"};
        String caracteresEspecialesQueGeneranToken[] = {";", "[", "]", ",", ":", "(", ")", ":="};
        String caracteresEspecialesQueNoGeneranToken[] = {"\"", ".", "BCO", "TAB", "EOLN", "EOF"};

        //Si la cadena contiene una palabra reservada
        int token = contiene(palabrasReservadas, posibleIdentificador);
        if (token != -1) {

            //Método bergas que hace algo bien chingón
        }
        return null;
    }

    /**
     * Recibe un arreglo y la cadena que buscará en él. En caso de encontrarlo, regresa
     * su posición en el arreglo; de lo contrario, regresa -100 como mensaje de error.
     *
     * @param arregloQueLoDeberiaContener
     * @param loQueDeberiaContener
     * @return
     */
    private int contiene(String[] arregloQueLoDeberiaContener, String loQueDeberiaContener) {
        for (int i = 0; i < arregloQueLoDeberiaContener.length - 1; i++) {
            if (arregloQueLoDeberiaContener[i].equals(loQueDeberiaContener)) {
                return i;
            }
        }
        return -100;
    }

    private int tokenPalabrasReservadas(String[] palabrasReservadas, String palabra) {
        if (palabra.equals("prog")) {
            return -1;
        } //if (palabra.equals()) {

        //}
        //Se ha determinado que -100 es el token de un error
        return -100;
    }

    //Considerando meter cada palabra en un arreglo con la posición del token para fusionar los últimos dos métodos
}
