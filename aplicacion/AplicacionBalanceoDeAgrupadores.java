package aplicacion;

import java.util.Scanner;

import static estructuras.BalanceoDeAgrupadores.estaBalanceada;

/** Aplicación que trabaja con pilas para evaluar expresiones dadas por el usuario y determinar si éstas están balanceadas.
 * Created on 29/09/2016. **/
public class AplicacionBalanceoDeAgrupadores {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.print("\nIntroduzca la expresión a verificar: "); // Pidiendo la expresión.
        String expresion = entrada.nextLine(); //Almacenando la expresión introducida por el usuario.
        if (estaBalanceada(expresion)) { //Llamada al método que evalúa la expresión.
            System.out.println("La expresión está balanceada.");
        } else {
            System.out.println("La expresión no está balanceada.");
        }
    }
}