package aplicacion;
import java.util.Scanner;

/** Created by xtrs84zk on 06/10/2016. **/
public class TorresDeHanoi {
    /** Método main. Se encarga de mostrar al usuario las instrucciones y colectar la cantidad de discos que se usará en el programa.
     * Llama al méotodo Hanoi y le envía la cantidad de discos que debe usar.**/
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.println("Torres de Hanoi.");
        System.out.println("Para jugar, necesito el número de discos, este debe ser al menos 4.");
        System.out.print("¿Cuántos discos usaré? "); //Pidiendo al usuario la cantidad de discos.
        int n = entrada.nextInt(); // Almacenando la cantidad de discos.
        System.out.println("Movimientos:"); //A partir de este punto se mostrarán los movimientos necesarios para resolver el problema.
        Hanoi(n); //LLamada al método Hanoi.
    }
    /** Método que recibe la cantidad de discos con los que se plantea resolver. Llama al método recursivo en caso de que el número sea valido.
     * Muestra un mensaje de error en caso de que el número no cumpla los requisitos necesarios.**/
    private static void Hanoi(int n){
        if(n >= 4) {
            int origen = 1;
            int auxiliar = 2;
            int destino = 3;
            HanoiRecursivo(n, origen, auxiliar, destino);
            return;
        }
        System.out.println( "El número tiene que ser al menos cuatro.");
    }
    /** Método recursivo encargado de mostrar los movimientos necesarios para
     * resolver "las torres de Hanoi" con el número de discos recibido.
     * Recibe el número de discos, la pila origen, la pila auxiliar y la pila destino.**/
    private static void HanoiRecursivo(int n, int origen,  int auxiliar, int destino) {
        if (n == 1) { //Caso base
            System.out.println("Mover disco de la pila " + origen + " a la pila " + destino);
        }
        else { //Caso recursivo
            HanoiRecursivo(n - 1, origen, destino, auxiliar);
            System.out.println("Mover disco de la pila " + origen + " a la pila " + destino);
            HanoiRecursivo(n - 1, auxiliar, origen, destino);
        }
    }
}