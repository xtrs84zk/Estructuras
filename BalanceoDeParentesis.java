import estructuras.Stack;
import estructuras.StackUnlimited;
import java.util.Scanner;
    public class BalanceoDeParentesis{
                public static void main (String[]args) {
                    /* Declaración de variables */
                    Stack separadores; //Pila que se usará.
                    char auxiliar; //Variables de apoyo.
                    char temporal=' ';
                    boolean estaBalanceado = true; //ra.
                    String expresion, mensaje =""; //Variable donde se almacenará la expresión a evaluar.
                    /* Creación de objetos */
                    Scanner entrada = new Scanner(System.in);
                    separadores = new StackUnlimited();
                    /* Inicializando objetos */
                    System.out.print("Introduzca la expresión a verificar: ");
                    expresion = entrada.next();
                    expresion = expresion.replaceAll(" ", "");
                    try{
                        for (int i = 0; i < expresion.length(); i++) {
                            auxiliar = expresion.charAt(i);
                            if (auxiliar == '(' || auxiliar == '[' || auxiliar == '{') {
                                separadores.push(expresion.charAt(i)); //Introduciendo a la pila sólo los valores de apertura
                            } else try{
                                        temporal = (Character) separadores.pop(); //Extrayendo de la pila
                                        if ((expresion.charAt(i) == ')' && temporal == '(') || (temporal == '{' && expresion.charAt(i) == '}') || (temporal == '[' && expresion.charAt(i) == ']')) {
                                            mensaje = "La expresión está balanceada.";
                                            estaBalanceado = true; //La expresión continua estando balanceada.
                                        } else {
                                            mensaje = "La expresión " + expresion + " no está balanceada.";
                                            estaBalanceado = false;
                                             //La expresión no está balanceada.
                                        }
                                    }finally{
                                System.out.println(mensaje);
                            }



                                    }
                                }finally{
                        System.out.println(mensaje);
                    }
}
}
