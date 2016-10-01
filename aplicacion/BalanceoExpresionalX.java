package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Created by xtrs84zk on 01/10/2016.
 */
public class BalanceoExpresionalX {
    public static void main(String[] args) { //Declaración de variables

        char auxiliar;
        String expresion;
        //Creación de objetos
        Scanner entrada = new Scanner(System.in);

        //Inicializando objetos
        System.out.print("\nIntroduzca la expresión a verificar: ");
        expresion = entrada.next();
        //Verificar que no sea impar, quitar espacios en blanco, etcétera
        if (estaBalanceada(expresion)) {
            System.out.println("La expresion está balanceada.");
        }

    }

    private static boolean estaBalanceada(String expresion) throws Exception {
        Stack separadores;
        char temporal, auxiliar;
        separadores = new StackUnlimited();
        int i = 0;
        if (expresion.length() == 0) return true; //Naturalmente, no se puede evaluar una expresión vacía
        if (expresion.length() % 2 != 0)
            return false; //Si la expresión tiene una cantidad impar de carácteres, podemos obviar que no está balanceada.

        for (int i = 0; i < expresion.length(); i++) {
            if (auxiliar == '(' || auxiliar == '[' || auxiliar == '{') { //Si el caracter es de apertura, se agrega a la pila.
                separadores.push(expresion.charAt(i));
            }
            try {
                temporal = (Character) separadores.pop(); //Los caracteres de apertura son sacados de la pila para compararles con los de cierre.
                if ((expresion.charAt(i) == ')' && temporal != '(') || (temporal == '{' && expresion.charAt(i) != '}') || (temporal == '[' && expresion.charAt(i) != ']')) {
                    return false;
                }
            } catch (Exception e) {

            }
        }

        return true;
    }

}