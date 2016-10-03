package aplicacion;

import estructuras.Stack;
import estructuras.StackUnlimited;

import java.util.Scanner;
/**
 * Aplicación que trabaja con pilas para evaluar expresiones dadas por el usuario y determinar si estas están balanceadas.
 * Created on 29/09/2016.
 */
//:v
public class BalanceoDeAgrupadores {
    public static void main(String[] args) {
        String expresion, auxiliar; //Declaración de variables.
        Scanner entrada = new Scanner(System.in); //Inicializando objeto Scanner.
        System.out.print("\nIntroduzca la expresón a verificar: "); // Pidiendo la expresión.
        expresion = entrada.next(); //Asignando el valor de expresión.
        auxiliar = expresion; //Salvando la expresión sin modificar.
        if (estaBalanceada(expresion)) { //Llamada al método que evalúa la expresión.
            System.out.println("La expresion \"" + auxiliar + "\" está balanceada.");
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
        Stack parentesis, llaves, corchetes;
        liberaAgrupadores(expresion); //Quitando carácteres que no sean agrupadores.
        if (expresion.length() == 0) { return false; }//Naturalmente, no se puede evaluar una expresión vacía.
        if (expresion.length() % 2 != 0) {return false; }//Si la expresión tiene una cantidad impar de carácteres, podemos obviar que no está balanceada.
        //La pila no está vacía y tiene una cantidad par de carácteres, se procede a evaluar rigurosamente.
        parentesis = new StackUnlimited(); //Procedemos a crear las pilas, una para cada agrupador.
        llaves = new StackUnlimited();
        corchetes = new StackUnlimited();
        boolean bandera = false; //La expresión no está balanceada hasta que se demuestre lo contrario.
        try{ //Se intenta insertar y extraer de la pila.
            for (int i = 0; i < expresion.length(); i++) {
                if(expresion.charAt(i) == '('){ //Parentesis
                    parentesis.push(expresion.charAt(i));
                }else if(expresion.charAt(i) == ')'){
                    parentesis.pop();
                }
                if(expresion.charAt(i) == '{'){ //Llaves
                    llaves.push(expresion.charAt(i));
                }else if(expresion.charAt(i) == '}'){
                    llaves.pop();
                }
                if(expresion.charAt(i) == '['){//Corchetes
                    corchetes.push(expresion.charAt(i));
                }else if(expresion.charAt(i) == ']'){
                    corchetes.pop();
                }
            }
        } catch(Exception e){ //En caso de haber una excepción, la expresión no está balanceada.
            bandera   = false;
        }
        //Ahora que el proceso ha terminado, sólo queda verificar que las pilas estén vacías.
        if(parentesis.isEmpty()  && llaves.isEmpty() && corchetes.isEmpty()){
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