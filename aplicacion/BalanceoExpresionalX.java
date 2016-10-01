package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Aplicación secundaria de emergencia que trabaja con la pila para evualar expresiones.
 * Created by xtrs84zk on 01/10/2016.
 */
public class BalanceoExpresionalX {
    public static void main(String[] args) { //Declaración de variable.
        //Creación de objetos
        Scanner entrada = new Scanner(System.in);
        //Inicializando objetos
        System.out.print("\nIntroduzca la expresión a verificar: ");
        String expresion = entrada.next();
        expresion = expresion.replaceAll(" ", ""); //Quitando espacios en blanco
        if (estaBalanceada(expresion)) {
            System.out.println("La expresion está balanceada.");
        } else {
            System.out.print("La expresión no está balanceada");
        }
    }

    private static boolean estaBalanceada(String expresion) {
        Stack separadores;
        char temporal, auxiliar;
        if (expresion.length() == 0) return true; //Naturalmente, no se puede evaluar una expresión vacía
        separadores = new StackUnlimited(); //Suponiendo que no esté vacía, procedemos a crear la pila
        if (expresion.length() % 2 != 0)
            return false; //Si la expresión tiene una cantidad impar de carácteres, podemos obviar que no está balanceada.
        //La pila no está vacía y tiene una cantidad par de carácteres, se procede a evaluar rigurosamente.
        for (int i = 0; i < expresion.length(); i++) {
            auxiliar = expresion.charAt(i);
            if (auxiliar == '(' || auxiliar == '[' || auxiliar == '{') { //Si el caracter es de apertura, se agrega a la pila.
                separadores.push(expresion.charAt(i));
            }
            try {
                temporal = (Character) separadores.pop(); //Los caracteres de apertura son sacados de la pila.
                if ((expresion.charAt(i) == ')' && temporal != '(') || (temporal == '{' && expresion.charAt(i) != '}') || (temporal == '[' && expresion.charAt(i) != ']')) {
                    return false;
                }
            } catch (Exception e) {
                return true;
            }
        }

        return true;
    }

}