package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/** Created on 14/10/2016. **/
public class AplicacionInfijoAPosfijo {
    //Stack de tipo StackUnlimited donde se almacenan los operadores
    // mientras se decide en qué lugar de la expresión serán mostrados.
    private static Stack pilaDeOperadores = new StackUnlimited();
    public static void main(String[] args) {
        //Declaración de variables
        int posicionActualEnLaExpresion = 0;
        String expresionEnInfijo;
        Scanner entrada;
        //Creación de objetos
        entrada = new Scanner(System.in);
        final String operadores = "+ * - / % "; //Operadores que puede manejar la clase.
        System.out.print("Introduce la expresión: "); //Pidiendo la expresión al usuario.
        expresionEnInfijo = entrada.next(); //Almacenando la expresión del usuario.
        System.out.print("Convirtiendo a postfijo...\n");
        System.out.print("La expresión convertida es: \"");
        do {
            if (posicionActualEnLaExpresion == expresionEnInfijo.length()) { //Si se ha llegado al fin de la expresión.
                try { //Se saca lo que esté en la pila de operadores a la salida.
                    while (!pilaDeOperadores.isEmpty()) {
                        System.out.print(pilaDeOperadores.pop());
                    }
                } catch (Exception e) { //Los errores se imprimen en la salida de errores.
                    System.err.print(e.getMessage());
                } finally {
                    System.out.print("\"."); //Se cierra la expresión con una comilla doble.
                }
                break; //Se rompe el ciclo do
            } else if (expresionEnInfijo.charAt(posicionActualEnLaExpresion) == '(') {
                pilaDeOperadores.push('('); //Si se encuentra un paréntesis de apertura, se almacena en la pila.
            } else if (expresionEnInfijo.charAt(posicionActualEnLaExpresion) == ')') {
                //Si encuentra un paréntesis de cierre, saca de la pila hasta encontrar alguno abierto.
                try {
                    do {
                        if ((Character) pilaDeOperadores.top() == '(') {
                            pilaDeOperadores.pop();
                        } else { //Si el carácter no es un paréntesis de apertura, lo manda a la salida.
                            System.out.print(pilaDeOperadores.pop());
                        }
                    } while ((Character) pilaDeOperadores.pop() != '(');
                } catch (Exception e) { //Los errores se imprimen en la salida de errores.
                    System.err.print(e.getMessage());
                }
            } else if (operadores.contains(expresionEnInfijo.charAt(posicionActualEnLaExpresion) + " ")) {
                //En caso de encontrar un operador, se procede a verificar que la pila no esté vacía.
                if (!pilaDeOperadores.isEmpty()) {
                    try { //Si la pila no está vacía, se procede a verificar la precedencia.
                        while (tieneMenorOIgualPrecedencia(expresionEnInfijo.charAt(posicionActualEnLaExpresion))) {
                            if ((Character) pilaDeOperadores.top() == '(') {
                                break; //Si es un paréntesis, rompe y continúa el ciclo.
                            } else { //Saca de la pila aquello que no sea un paréntesis de apertura.
                                System.out.print(pilaDeOperadores.pop());
                            }
                        }
                    } catch (Exception e) { //Los errores se imprimen en la salida de errores.
                        System.err.print(e.getMessage());
                    }
                }
                //Si ha llegado hasta este punto, agrega el operador a la pila.
                pilaDeOperadores.push(expresionEnInfijo.charAt(posicionActualEnLaExpresion));
            } else { //En caso de encontrar cualquier otro carácter, lo manda a la salida.
                System.out.print(expresionEnInfijo.charAt(posicionActualEnLaExpresion));
            }
            posicionActualEnLaExpresion++;
            //Mientras la posición actual esté dentro de la expresión.
        } while (posicionActualEnLaExpresion <= expresionEnInfijo.length());
    }
    /** Método que determina la precedencia de un operador contra el que esté al tope de la pila
     * Recibe un operador y lo compara contra el valor que esté al tope de la pila de operadores
     * Dicha pila es una variable de clase estática por lo que es la misma en cualquier método
     * Regresa true cuando la precedencia del operador recibido es menor que la del operador
     * que está al tope de la pila, de no ser así, regresa false.**/
    private static boolean tieneMenorOIgualPrecedencia(char operador) throws Exception{
            char auxiliar = (Character) pilaDeOperadores.top();
            if(operador == '*' || operador == '/' || operador == '%'){
                if(auxiliar == '+' || auxiliar == '-') return false;
            }
        return true;
    }
}
