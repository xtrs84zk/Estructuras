import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;
public class BalanceoDeParentesis{
            public static void main (String[]args) {
                /* Declaración de variables */
                Stack separadores; //Pila que se usará.
                char auxiliar, temporal; //Variables de apoyo.
                boolean esPar, estaBalanceado = false; //Bandera.
                String expresion; //Variable donde se almacenará la expresión a evaluar.
                /* Creación de objetos */
                Scanner entrada = new Scanner(System.in);
                separadores = new StackUnlimited();
                /* Inicializando objetos */
                System.out.print("Introduzca la expresión a verificar: ");
                expresion = entrada.next();
                esPar = expresion.length()==0;
                if(expresion.length() == 0){
                    System.out.print("La expresión está vacía.");
                } else if (esPar){
                    for (int i = 0; i < expresion.length(); i++) {
                        auxiliar = expresion.charAt(i);
                        if (auxiliar == '(' || auxiliar == '[' || auxiliar == '{') {
                            separadores.push(expresion.charAt(i)); //Introduciendo a la pila sólo los valores de apertura
                        } else {
                            try {
                                temporal = (Character) separadores.pop(); //Extrayendo de la pila
                                if ((expresion.charAt(i) == ')' && temporal == '(') || (temporal == '{' && expresion.charAt(i) == '}') || (temporal == '[' && expresion.charAt(i) == ']')) {
                                    estaBalanceado = true; //La expresión continua estando balanceada.
                                } else {
                                    estaBalanceado = false;
                                    break; //La expresión no está balanceada.
                                }
                            } catch (Exception e) { //Si el programa termina de forma anormal, significa que algo no coincidió.
                                System.out.print("La expresión " + expresion + " no está balanceada.");
                            }
                        }
                    }
                    if (estaBalanceado) System.out.print("La expresión " + expresion + " está balanceada.");
                } else {
                    System.out.print("La expresión " + expresion + " no está balanceada.");
                }
            }
}