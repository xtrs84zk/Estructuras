package aplicacion; import java.util.Scanner; import estructuras.Stack; import estructuras.StackUnlimited;
public class BalanceoDeParentesis{
    public static void main (String[]args){
        //Declaración de variables
        Stack separadores;
        char auxiliar, temporal;
        boolean estaBalanceado = true;
        String expresion;
        //Creación de objetos
        Scanner entrada = new Scanner(System.in);
        separadores = new StackUnlimited();
        //Inicializando objetos
        System.out.println("Introduzca la expresión a verificar: ");
        expresion = entrada.next();
        do{
            for(int i = 0; i<expresion.length(); i++){
                auxiliar = expresion.charAt(i);
                if(auxiliar == '(' || auxiliar == '[' || auxiliar == '{'){
                    separadores.push(expresion.charAt(i));
                }else {
                    temporal = (Character) separadores.pop();
                    if((auxiliar == '(' && temporal == ')' ) || (auxiliar == '{' && temporal == '}') || (auxiliar == '[' && temporal == ']')){
                        continue;
                    } else {
                        estaBalanceado = false; break; 
                    }
                }
            }
        } while(estaBalanceado);
        if(estaBalanceado){
            System.out.print("La expresión "+ expresion + " está balanceada.");
        } else {
            System.out.print("La expresión "+ expresion + " no está balanceada.");
        }
    }
}
