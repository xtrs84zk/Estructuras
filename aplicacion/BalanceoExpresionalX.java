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
        expresion = liberaAgrupadores(expresion);

        if (estaBalanceada(expresion)) {
            System.out.println("La expresion está balanceada.");
        } else {
            System.out.print("La expresión no está balanceada");
        }
    }

    private static boolean estaBalanceada(String expresion) {
        Stack separadores;
        int agrupadores[] = new int[3];
        if (expresion.length() == 0) return true; //Naturalmente, no se puede evaluar una expresión vacía
        separadores = new StackUnlimited(); //Suponiendo que no esté vacía, procedemos a crear la pila
        if (expresion.length() % 2 != 0)
            return false; //Si la expresión tiene una cantidad impar de carácteres, podemos obviar que no está balanceada.
        //La pila no está vacía y tiene una cantidad par de carácteres, se procede a evaluar rigurosamente.
        for (int i = 0; i < agrupadores.length; i++) { //Inicializando cantidad de agrupadores en cero.
            agrupadores[i] = 0;
        }
        //Agrupadores[0] servirá para almacenar los (); agrupadores[1] servirá para almacenar los {}; agrupadores[2] servirá para almacenar los [];
        do {
            for (int i = 0; i < expresion.length(); i++) {
                switch (expresion.charAt(i)) {
                    case '(':
                        agrupadores[0]++;
                    case ')':
                        agrupadores[0]--;
                    case '{':
                        agrupadores[1]++;
                    case '}':
                        agrupadores[1]--;
                    case '[':
                        agrupadores[2]++;
                    case ']':
                        agrupadores[2]--;
                }
                //if(agrupadores.contains(-1)) return false;
            }
        } while (agrupadores[0] >= 0 && agrupadores[1] >= 0 && agrupadores[2] >= 0);
        return true; //Si el do finalizó sin p2, la expresión "está balanceada"
    }

    /**
     * Método que libera los agrupadores eliminando el resto de los carácteres.
     **/
    private static String liberaAgrupadores(String expresion) {
        String temporal = "";
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(' || expresion.charAt(i) == '{' || expresion.charAt(i) == '[' || expresion.charAt(i) == ']' || expresion.charAt(i) == '}' || expresion.charAt(i) == ')') {
                temporal += expresion.charAt(i);
            }

        }
        return temporal;
    }
}