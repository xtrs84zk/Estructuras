package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/** Created by xtrs84zk on 16/10/2016. **/
public class AplicacionInfijoAPosfijo {
    private static Stack pilaDeOperadores = new StackUnlimited();
    public static void main(String[] args) {
        //Declaración de variables
        int posicion = 0;
        String expresionEnInfijo;
        Scanner entrada;
        //Creación de objetos
        entrada = new Scanner(System.in);
        final String operadores = "+ * - / % ";
        System.out.print("Introduce la expresión: ");
        expresionEnInfijo = entrada.next();
        System.out.print("Convirtiendo a postfijo...\n");
        System.out.print("La expresión convertida es: \"");
        do {
            if (posicion == expresionEnInfijo.length()) { //Si se ha llegado al fin de la expresión.
                try {
                    while (!pilaDeOperadores.isEmpty()) {
                        System.out.print(pilaDeOperadores.pop());
                    }
                } catch (Exception e) {
                    System.err.print(e.getMessage());
                } finally {
                    System.out.print("\".");
                }
                break;
            } else if (expresionEnInfijo.charAt(posicion) == '(') {
                pilaDeOperadores.push('(');
            } else if (expresionEnInfijo.charAt(posicion) == ')') {
                try {
                    do {
                        if ((Character) pilaDeOperadores.top() == '(') {
                            pilaDeOperadores.pop();
                        } else {
                            System.out.print(pilaDeOperadores.pop());
                        }
                    } while ((Character) pilaDeOperadores.pop() != '(');
                } catch (Exception e) {
                    System.err.print(e.getMessage());
                }
            } else if (operadores.contains(expresionEnInfijo.charAt(posicion) + " ")) {
                if (!pilaDeOperadores.isEmpty()) {
                    try {
                        while (tieneMenorOIgualPrecedencia(expresionEnInfijo.charAt(posicion))) {
                            if ((Character) pilaDeOperadores.top() == '(') {
                                break;
                            } else {
                                System.out.print(pilaDeOperadores.pop());
                            }
                        }
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                    }
                }
                pilaDeOperadores.push(expresionEnInfijo.charAt(posicion));
            } else {
                System.out.print(expresionEnInfijo.charAt(posicion));
            }
            posicion++;
        } while (posicion < expresionEnInfijo.length() + 1);
    }

    private static boolean tieneMenorOIgualPrecedencia(char operadores) throws Exception{
            char auxiliar = (Character) pilaDeOperadores.top();
            if(operadores == '*' || operadores == '/' || operadores == '%'){
                if(auxiliar == '+' || auxiliar == '-'){
                    return false;
                }
            }
        return true;
    }
}
