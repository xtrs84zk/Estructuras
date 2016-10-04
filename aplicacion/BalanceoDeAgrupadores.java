package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;
/**
 * Aplicación que trabaja con pilas para evaluar expresiones dadas por el usuario y determinar si éstas están balanceadas.
 * Created on 29/09/2016.
 */
public class BalanceoDeAgrupadores {
    public static void main(String[] args) {
        String expresion, auxiliar; //Declaración de variables.
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.print("\nIntroduzca la expresón a verificar: "); // Pidiendo la expresión.
        expresion = entrada.next(); //Asignando el valor de expresión.
        auxiliar = expresion; //Salvando la expresión sin modificar.
        if (estaBalanceada(expresion)) { //Llamada al método que evalúa la expresión.
            System.out.println("La expresión \"" + auxiliar + "\" está balanceada.");
        } else {
            System.out.print("La expresión \"" + auxiliar + "\" no está balanceada");
        }
    }

    /**
     * Método que evalúa la expresión y regresa un boolean.
     * Recibe un String que contiene la expresión a evaluar
     * Regresa un boolean cierto o falso dependiendo del balanceo.
     **/
    private static boolean estaBalanceada(String expresion) {
        Stack agrupadores;
        liberaAgrupadores(expresion); //Quitando carácteres que no sean agrupadores.
        if (expresion.length() == 0) { return false; }//Naturalmente, no se puede evaluar una expresión vacía.
        if (expresion.length() % 2 != 0) {return false; }//Si la expresión tiene una cantidad impar de carácteres, podemos obviar que no está balanceada.
        if(expresion.charAt(0) == '}' || expresion.charAt(0) == ']' || expresion.charAt(0) == ')') { return false; }
        //La pila no está vacía y tiene una cantidad par de carácteres, se procede a evaluar rigurosamente.
         agrupadores = new StackUnlimited(); //Procedemos a crear las pilas, una para cada agrupador.
        boolean bandera = false; //La expresión no está balanceada hasta que se demuestre lo contrario.
        try{ //Se intenta insertar y extraer de la pila.
            for (int i = 0; i < expresion.length(); i++) {
                if(expresion.charAt(i) == '('){ //Parentesis
                    agrupadores.push(expresion.charAt(i));
                }else if(expresion.charAt(i) == ')' && (Character) agrupadores.top()== '('){ //Y el top es lo que corresponde
                    agrupadores.pop();
                } else if (expresion.charAt(i) == ')' && (Character) agrupadores.top()!= '(') {
                    return false;
                }
                if(expresion.charAt(i) == '{'){ //Llaves
                    agrupadores.push(expresion.charAt(i));
                }else if(expresion.charAt(i) == '}' && (Character) agrupadores.top()== '{'){ //Y el top es lo que corresponde
                    agrupadores.pop();
                } else if (expresion.charAt(i) == '}' && (Character) agrupadores.top()!= '{') {
                    return false;
                }
                if(expresion.charAt(i) == '['){//Corchetes
                    agrupadores.push(expresion.charAt(i));
                }else if(expresion.charAt(i) == ']' && (Character) agrupadores.top()== '['){ //Y el top es lo que corresponde
                    agrupadores.pop();
                } else if (expresion.charAt(i) == ']' && (Character) agrupadores.top()!= '[') {
                    return false;
                }
            }
        } catch(Exception e){ //En caso de haber una excepción, la expresión no está balanceada.
            return false;
        }
        //Ahora que el proceso ha terminado, sólo queda verificar que las pilas estén vacías.
        if(agrupadores.isEmpty()){
            bandera = true;
        }
        return bandera; //Regresando el resultado.
    }


    /** Método que libera los agrupadores eliminando el resto de los carácteres. **/
    private static void liberaAgrupadores(String expresion) {
        expresion = expresion.replaceAll(" ", ""); //Quitando espacios en blanco.
        String temporal = "";
        for (int i = 0; i < expresion.length(); i++) { //Almacenando únicamente los agrupadores.
            if (expresion.charAt(i) == '(' || expresion.charAt(i) == '{' || expresion.charAt(i) == '[' || expresion.charAt(i) == ']' || expresion.charAt(i) == '}' || expresion.charAt(i) == ')') {
                temporal += expresion.charAt(i);
            }
            expresion = temporal; //Asignándole el nuevo valor a expresion.
        }
    }
}