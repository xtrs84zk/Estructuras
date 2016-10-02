package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Aplicación que trabaja con pilas para evaluar expresiones dadas por el usuario y determinar si estas están balanceadas.
 * Created by xtrs84zk on 01/10/2016.
 */
//:v
public class BalanceoDeAgrupadores {
    public static void main(String[] args) {
        String expresion; //Declaración de variables
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner
        System.out.print("\nIntroduzca la expresón a verificar: "); // Pidiendo la expresión
        expresion = entrada.next(); //Asignando el valor de expresión.
        expresion = expresion.replaceAll(" ", ""); //Quitando espacios en blanco
        expresion = liberaAgrupadores(expresion); //Quitando carácteres que no sean agrupadores
        if (estaBalanceada(expresion)) { //Llamada al método que evalúa la expresión y mostrando resultados
            System.out.println("La expresion está balanceada.");
        } else {
            System.out.print("La expresión no está balanceada");
        }
    }

    /**
     * Método que evalúa la expresión y regresa un boolean.
     * Recibe un String que contiene la expresión a evaluar
     * Regresa un boolean cierto o falso dependiendo del balanceo.
     **/
    private static boolean estaBalanceada(String expresion) {
        Stack parentesis, llaves, corchetes;
        int agrupadores[] = new int[3];
        if (expresion.length() == 0) return true; //Naturalmente, no se puede evaluar una expresión vacía
        parentesis = new StackUnlimited(); //Suponiendo que no esté vacía, procedemos a crear las pilas
        llaves = new StackUnlimited();
        corchetes = new StackUnlimited();
        if (expresion.length() % 2 != 0)
            return false; //Si la expresión tiene una cantidad impar de carácteres, podemos obviar que no está balanceada.
        //La pila no está vacía y tiene una cantidad par de carácteres, se procede a evaluar rigurosamente.
        for (int i = 0; i < agrupadores.length; i++) { //Inicializando cantidad de agrupadores en cero.
            agrupadores[i] = 0;
        }
        try{
            for (int i = 0; i < expresion.length(); i++) {
                switch (expresion.charAt(i)) {
                    //Parentesis
                    case '(': parentesis.push(1);
                    case ')': parentesis.pop();
                        //Llaves
                    case '{': llaves.push(1);
                    case '}': llaves.pop();
                        //Corchetes
                    case '[': corchetes.push(1);
                    case ']': corchetes.pop();
                }
            }
        } catch(Exception e){ //En caso de haber una excepción, la expresión no está balanceada.
            return false;
        }
        return true; //Si el proceso terminó como debería; la expresión está balanceada.
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