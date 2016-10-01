package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Aplicación que trabaja con la pila para verificar si una expresión
 * conformada por separadores está correctamente balanceada.
 * Created by xtrs84zk on 29/09/2016.
 */

public class BalanceoDeExpresiones {
    public static void main(String[] args) {
        //Declaración de variables
        Stack separadores;
        char auxiliar, temporal;
        boolean estaBalanceado = true;
        String expresion;
        //Creación de objetos
        Scanner entrada = new Scanner(System.in);
        separadores = new StackUnlimited();
        //Inicializando objetos
        System.out.print("\nIntroduzca la expresión a verificar: ");
        expresion = entrada.next();
        //Verificar que no sea impar, quitar espacios en blanco, etcétera
        // do{
        for (int i = 0; i < expresion.length(); i++) {
            auxiliar = expresion.charAt(i);
            if (auxiliar == '(' || auxiliar == '[' || auxiliar == '{') { //Si el caracter es de apertura, se agrega a la pila.
                separadores.push(expresion.charAt(i));
            } else {
                try {
                    temporal = (Character) separadores.pop(); //Los caracteres de apertura son sacados de la pila para compararles con los de cierre.
                    if ((expresion.charAt(i) == ')' && temporal == '(') || (temporal == '{' && expresion.charAt(i) == '}') || (temporal == '[' && expresion.charAt(i) == ']')) {
                        estaBalanceado = true;
                    } else {
                        estaBalanceado = false;
                        break;
                    }
                } catch (Exception e) { //De terminar anormalmente, la expresión no está balanceada
                    System.out.print("La expresión " + expresion + " no está balanceada.");
                }
            }
        }
        if (estaBalanceado) System.out.print("La expresión " + expresion + " está balanceada.");
    }
}
