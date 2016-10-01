package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Created by xtrs84zk on 01/10/2016.
 */
public class BalanceoExpresionalX {
    public static void main(String[] args) { //Declaración de variables
        Stack separadores;
        char auxiliar, temporal;
        String expresion;
        //Creación de objetos
        Scanner entrada = new Scanner(System.in);
        separadores = new StackUnlimited();
        //Inicializando objetos
        System.out.print("\nIntroduzca la expresión a verificar: ");
        expresion = entrada.next();
        //Verificar que no sea impar, quitar espacios en blanco, etcétera
        if (estaBalanceada(expresion)) {
            System.out.println("La expresion está balanceada.");
        }

    }

    public static boolean estaBalanceada(String expresion) {
        if (expresion.length() == 0) {
            return true;
        } else {
            do {

            } while (true);
        }
    }
}
