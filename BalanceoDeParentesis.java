import java.util.Scanner;
import estructuras.Stack;
import estructuras.StackUnlimited;

public class BalanceoDeParentesis{
    public static void main (String[]args){
        /* Declaración de variables */
        Stack separadores;
        char auxiliar, temporal;
        boolean estaBalanceado = false;
        String expresion;
        /* Creación de objetos */
        Scanner entrada = new Scanner(System.in);
        separadores = new StackUnlimited();
        /* Inicializando objetos */
        System.out.println("Introduzca la expresión a verificar: ");
        expresion = entrada.next();
            for(int i = 0; i<expresion.length(); i++){
                auxiliar = expresion.charAt(i);
                if(auxiliar == '(' || auxiliar == '[' || auxiliar == '{'){
                    separadores.push(expresion.charAt(i));
                }else {
                	try{
                    temporal = (Character) separadores.pop();
                    if((expresion.charAt(i) == ')' && temporal == '(' ) || (temporal == '{' && expresion.charAt(i) == '}') || (temporal == '[' && expresion.charAt(i) == ']')){
                    	estaBalanceado = true;
                    } else {
                        estaBalanceado = false; break; 
                    }
                }catch(Exception e){
                	System.out.print("La expresión "+ expresion + " no está balanceada.");
            	}
                }
            }
        if(estaBalanceado){ System.out.print("La expresión " + expresion + " está balanceada.");}
    }
}
