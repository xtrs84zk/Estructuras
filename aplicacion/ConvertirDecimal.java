package aplicacion;
import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Aplicación que convierte cualquier número entero positivo decimal a la base elegida por el usuario entre binario y hexadecimal.
 *
 *  Created by xtrs84zk on 29/09/2016.
 */
public class ConvertirDecimal {
    public static void main(String[] args) {
        //Declarando variables
        Stack convertido; //Pila donde se almacenarán los residuos
        String cadena;
        int cociente, base;
        final String[] unidades = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        //Creando objetos
        convertido = new StackUnlimited(); //Debe tener espacio "ilimitado"
        Scanner entrada = new Scanner(System.in);
        //Mostrando las reglas
        System.out.print("Aplicación que convierte números de una base a otra." +
                "\nFunciona a cualquier sistema númerico entre binario y hexadecimal" +
                "\nLa base de entrada siempre debe ser decimal, entero y positivo.\n");
        do { //Pedir y verificar el número a convertir. Debe ser un número entero positivo.
            System.out.print("¿Qué número deseas convertir? ");
            cociente = entrada.nextInt();
        } while (cociente < 1);
        cadena = "El número " + cociente + " "; //Incializando el texto en la cadena.
        do { //Pedir y verificar la base a la que se transformará. Debe ser un número entre 2 y 16.
            System.out.print("¿A qué base? ");
            base = entrada.nextInt();
        } while (base < 2 || base > 16);
        cadena += "convertido a base " + base + " es: "; //Agregando texto a la cadena.
        do { //Sacar el residuo mientras el cociente sea mayor que cero.
            convertido.push(cociente % base);
            cociente /= base;
        } while (cociente > 0);
        while (!convertido.isEmpty()) { //Formar la cadena mientras haya elementos en la pila.
            cadena += unidades[(Integer) convertido.pop()];
        }
        System.out.println(cadena);//Imprimiendo la cadena.
    }
}