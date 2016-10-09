package aplicacion;
import java.util.Scanner;
/** Created by xtrs84zk on 06/10/2016. **/
public class TorresDeHanoi {
    /** Método main. Se encarga de mostrar al usuario las instrucciones y colectar la cantidad de discos que se usará en el programa.
     * Llama al método Hanoi y le envía la cantidad de discos que debe usar.**/
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.println("Torres de Hanoi.");
        System.out.println("Para jugar, necesito el número de discos, este debe ser al menos 2.");
        System.out.print("¿Cuántos discos usaré? "); //Pidiendo al usuario la cantidad de discos.
        int n = entrada.nextInt(); // Almacenando la cantidad de discos.
        System.out.println("Movimientos a realizar:"); //A partir de este punto se mostrarán los movimientos necesarios para resolver el problema.
        Hanoi(n); //LLamada al método Hanoi.
    }
    /** Método que recibe la cantidad de discos con los que se plantea resolver. Llama al método recursivo en caso de que el número sea valido.
     * Muestra un mensaje de error en caso de que el número no cumpla los requisitos necesarios.**/
    private static void Hanoi(int n){
        if(n >= 2) {
            int columna1 = 1; //Aquí es donde están todos los discos al inicio.
            int columna2 = 2; //Esta es la columna auxiliar que se utilizará para mover los discos.
            int columna3 = 3; //Esta es la columna de destino, a donde se planea mover los discos.
            HanoiRecursivo(n, columna1, columna2, columna3);
            System.out.println("Usando esos movimientos, podrás resolverlo. ;) ");
            return;
        }
        System.out.println( "El número tiene que ser al menos cuatro.");
    }
    /** Método recursivo encargado de mostrar los movimientos necesarios para
     * resolver "las torres de Hanoi" con el número de discos recibido.
     * Se mueve el disco siguiendo la lógica: columna actual (la cual puede hacia la pila de destino.
     * Haber llamado al método recursivo decrementando el número de disco asegura que, al final, llegará al caso base.
     * Los discos pares se mueven en una dirección, los impares en otra.
     * Recibe el número de discos, la pila de origen, la  pila auxiliar y la pila de destino.**/
    private static void HanoiRecursivo(int n, int origen,  int auxiliar, int destino) {
        if (n == 1) { //Caso base
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
        }
        else { //Caso recursivo
            HanoiRecursivo(n - 1, origen, destino, auxiliar);
            //Llamar al método recursivo con exactamente la misma información, sólo que con un disco debajo en el origen.
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + "."); //Ta' kbrón
            HanoiRecursivo(n - 1, auxiliar, origen, destino);
            //Llamar al método recursivo diciéndole que mueva el disco inferior de la columna auxiliar a la primer columna y luego a la tercera.
        }
    }
}