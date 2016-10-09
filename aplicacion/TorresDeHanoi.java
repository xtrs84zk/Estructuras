package aplicacion;
import java.util.InputMismatchException;
import java.util.Scanner;
/** Created by xtrs84zk on 06/10/2016. **/
public class TorresDeHanoi {
    /** Método main. Se encarga de mostrar al usuario las instrucciones y colectar la cantidad de discos que se usará en el programa.
     * Llama al método Hanoi y le envía la cantidad de discos que debe usar.
     * Si la excepción IllegalArgumentException es atrapada, la introducción del usuario no es válida.
     * Si la excepción InputMismatchException es atrapada, el usuario introdujo valores de tipo incorrecto.**/
    public static void main(String[] args) {
        int cantidad = 0; //Declarar e inicializar la variable cantidad, que es la cantidad de discos.
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.println("Torres de Hanoi.");
        System.out.println("Para jugar, sólo necesito el número de discos. Debe ser al menos 2.");
        do { //En caso de recibir un parámetro incorrecto, debe seguir pidiendo el valor.
            try { //El método Hanoi lanza excepciones, hay que estar preparados para atraparlas.
                System.out.print("¿Cuántos discos usaré? "); //Pidiendo al usuario la cantidad de discos.
                cantidad = entrada.nextInt(); // Almacenando la cantidad de discos.
                Hanoi(cantidad); //Llamada al método Hanoi. Este método puede lanzar la excepción.
            } catch(IllegalArgumentException e) { //La excepción IllegalArgumentException es atrapada.
                System.out.println("Necesito al menos dos discos para trabajar. ");
            }catch(InputMismatchException e) { //La excepción InputMismatchException es atrapada.
                System.out.print("Necesito un valor entero.");
                return;
            } catch(Exception e){ //Cualquier otra excepción es atrapada.
                System.out.println("Error desconocido: " + e);
                return;
            }
        }while(cantidad<2); //El valor mínimo debe ser dos, mientras no se reciba un valor válido, se seguirá pidiendo.
    }
    /** Método que recibe la cantidad de discos con los que se plantea resolver.
     * Llama al método recursivo en caso de que el número sea valido.
     * Si la cantidad es insuficiente (menor a dos) lanzará una excepción del tipo IllegalArgumentsException.
     * En caso de recibir una letra o algún valor que no sea del tipo int, lanzará la excepción InputMismatchException. **/
    private static void Hanoi(int cantidad) throws Exception{
        if(cantidad >= 2) {
            System.out.println("Los movimientos a realizar se mostrarán aquí.");
            int columna1 = 1; //Aquí es donde están todos los discos al inicio.
            int columna2 = 2; //Esta es la columna auxiliar que se utilizará para mover los discos.
            int columna3 = 3; //Esta es la columna de destino, a donde se planea mover los discos.
            HanoiRecursivo(cantidad, columna1, columna2, columna3);
            System.out.println("Usando esos movimientos, podrás resolverlo. ;) ");
            return;
        }
        //En caso de que la cantidad no cumpla los requisitos, se lanzará una excepción
        throw new IllegalArgumentException("Necesito al menos dos discos para trabajar. ");
    }
    /** Método recursivo encargado de mostrar los movimientos necesarios para
     * resolver "las torres de Hanoi" con el número de discos recibido.
     * Se mueve el disco siguiendo la lógica: columna actual () hacia la pila de destino.
     * Haber llamado al método recursivo decrementando el número de disco asegura que, al final,
     * llegará al caso base; esto es, que habrá sólo un disco que mover cada vez.
     * Los discos pares se mueven en una dirección, los impares en otra.
     * Recibe el número de discos, la pila de origen, la  pila auxiliar y la pila de destino.**/
    private static void HanoiRecursivo(int n, int origen,  int auxiliar, int destino) {
        if (n == 1) { //Caso base
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
        }
        else { //Caso recursivo
            HanoiRecursivo(n - 1, origen, destino, auxiliar);
            //Llamar al método recursivo con exactamente la misma información, sólo que con un disco debajo en el origen.
            System.out.println("Mueve el disco que está en la pila " + origen + " a la pila " + destino + ".");
            //Muestra en un mensaje hacia donde moverá el disco dependiendo de los paramtetros dados.
            HanoiRecursivo(n - 1, auxiliar, origen, destino);
            //Llamar al método recursivo diciéndole que mueva el disco inferior de la columna auxiliar a la tercera.
        }
    }
}