package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;

/** Created by xtrs84zk on 16/10/2016. **/
public class AplicacionInfijoAPosfijo {
    private static Stack operadores = new StackUnlimited();
    public static void main(String[] args) {
        //Declaración de variables
        int posicion = 0;
        String expresionConvertidaAPosfijo, expresionEnInfijo, log, mensaje;
        Scanner entrada;
        //Creación de objetos
        entrada = new Scanner(System.in);
        final String operador = "+ * - / % ";
        System.out.println("Introduce la expresión: ");
        expresionEnInfijo = entrada.next();
        expresionConvertidaAPosfijo = "";
        mensaje = "";
        log = "";

        cicloPrincipal:
        //Este es el ciclo donde se realiza el proceso de conversión.
        do {
            if (posicion == expresionEnInfijo.length()) { //Si se ha llegado al fin de la expresión.
                try {
                    while (!operadores.isEmpty()) {
                        expresionConvertidaAPosfijo += (Character) operadores.pop();
                    }
                } catch (Exception e) {
                    log += "\n" + e.getMessage();
                } finally {
                    mensaje = "La expresión que el usuario introdujo es: \"" + expresionEnInfijo + "\"" +
                            "\nConvertida a posfijo es: \"" + expresionConvertidaAPosfijo + "\".";
                }
                break;
            } else if (expresionEnInfijo.charAt(posicion) == '(') {
                operadores.push('(');
            } else if (expresionEnInfijo.charAt(posicion) == ')') {
                try {
                    do {
                        if ((Character) operadores.top() == '(') {
                            operadores.pop();
                        } else {
                            expresionConvertidaAPosfijo += (Character) operadores.pop();
                        }
                    } while ((Character) operadores.pop() != '(');
                } catch (Exception e) {
                    log += "\n" + e.getMessage();
                }
            } else if (operador.contains(expresionEnInfijo.charAt(posicion) + " ")) {
                if (!operadores.isEmpty()) {
                    try {
                        while (tieneMenorOIgualPrecedencia(expresionEnInfijo.charAt(posicion))) {
                            if ((Character) operadores.top() == '(') {
                                break;
                            } else {
                                expresionConvertidaAPosfijo += operadores.pop();
                            }
                        }
                    } catch (Exception e) {
                        log += "\n" + e.getMessage();
                    }
                }
                operadores.push(expresionEnInfijo.charAt(posicion));
            } else {
                expresionConvertidaAPosfijo += expresionEnInfijo.charAt(posicion);
            }
            posicion++;
        } while (posicion < expresionEnInfijo.length() + 1);
        System.out.println(mensaje);
        System.out.println(log);
    }

    private static boolean tieneMenorOIgualPrecedencia(char operador) throws Exception{
            char auxiliar = (Character) operadores.top();
            if(operador == '*' || operador == '/' || operador == '%'){
                if(auxiliar == '+' || auxiliar == '-'){
                    return false;
                }
            }
        return true;
    }
}
