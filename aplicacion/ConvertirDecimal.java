package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/**
 * Aplicación que convierte cualquier número entero positivo decimal a la base elegida por el usuario entre binario y hexadecimal.
 *
 * @author (Javier Sánchez)
 * @version (27/09/2016)
 */
public class ConvertirDecimal {
    public static void main(String[] args) {
        //Declarando variables
        Stack convertido; //Pila donde se almacenarán los residuos
        String temporalString, cadena;
        int residuo, cociente, base, temporal, número;
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
        cadena = "El número " + cociente + " "; //Agregando texto a la cadena.
        do { //Pedir y verificar la base a la que se transformará. Debe ser un número entre 2 y 16.
            System.out.print("¿A qué base? ");
            base = entrada.nextInt();
        } while (base < 2 || base > 16);
        cadena += "convertido a base " + base + " es: "; //Agregando texto a la cadena.
        do { //Sacar el residuo mientras el cociente sea mayor que cero.
            convertido.push(cociente % base);
            cociente /= base;
        } while (cociente > 0);
        while (!convertido.isEmpty()) { //Verificar el contenido de la pila.
            temporal = (Integer) convertido.pop();
            temporalString = temporal + "";
            if (temporal >= 10) { //Si el número es mayor o igual a diez, se le asignará una letra.
                switch (temporal) { //Asignándole una letra a los valores superiores a 10.
                    case 10:
                        temporalString = "A";
                        break;
                    case 11:
                        temporalString = "B";
                        break;
                    case 12:
                        temporalString = "C";
                        break;
                    case 14:
                        temporalString = "D";
                        break;
                    case 15:
                        temporalString = "E";
                        break;
                    case 16:
                        temporalString = "F";
                        break;
                }
            }
            cadena += temporalString;
        }
        System.out.println(cadena);//Imprimiendo la cadena.
    }
}