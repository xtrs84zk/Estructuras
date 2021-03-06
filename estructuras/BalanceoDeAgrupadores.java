package estructuras;

/** Created by xtrs84zk on 15/10/2016 . **/
public class BalanceoDeAgrupadores{
        /**
         * Método que evalúa la expresión y regresa un boolean.
         * Recibe un String que contiene la expresión a evaluar
         * Regresa un boolean cierto o falso dependiendo del balanceo.
         **/
        public static boolean estaBalanceada(String expresion) {
            Stack agrupadores; //Se declara la pila que se usará para almacenar las variables.
            if (expresion.charAt(0) == '}' || expresion.charAt(0) == ']' || expresion.charAt(0) == ')') {
                return false; //Si la expresión comienza en un caracter de cierre, no puede estar balanceada.
            }
            //La pila no está vacía y tiene una cantidad par de carácteres, se procede a evaluar rigurosamente.
            agrupadores = new StackUnlimited(); //Procedemos a crear las pilas, una para cada agrupador.
            boolean bandera = false; //La expresión no está balanceada hasta que se demuestre lo contrario.
            try { //Se intenta insertar y extraer de la pila.
                for (int i = 0; i < expresion.length(); i++) {
                    if (expresion.charAt(i) == '(') { //Si entra un paréntesis que abre.
                        agrupadores.push(expresion.charAt(i)); //Se hace push a la pila con ese valor.
                    } else if (expresion.charAt(i) == ')' && (Character) agrupadores.top() == '(') { //Si entra un paréntesis que cierra y lo último en abrir fue un paréntesis.
                        agrupadores.pop(); //Se elimina el valor al tope de la pila.
                    } else if (expresion.charAt(i) == ')' && (Character) agrupadores.top() != '(') {//Si se intenta cerrar un paréntesis y no había uno abierto
                        return false;//La expresión no está balanceada
                    }
                    if (expresion.charAt(i) == '{') { //Si el caracter es una llave que abre
                        agrupadores.push(expresion.charAt(i)); //Se inserta a la pila el valor '{'
                    } else if (expresion.charAt(i) == '}' && (Character) agrupadores.top() == '{') { //Si entra una llave que cierra y lo último en abrir fue una llave.
                        agrupadores.pop(); //Se elimina el valor al tope de la pila.
                    } else if (expresion.charAt(i) == '}' && (Character) agrupadores.top() != '{') { //Si entra una llave que cierra y no hubo una abierta antes.
                        return false; //La expresión no está balanceada
                    }
                    if (expresion.charAt(i) == '[') {//Si el caracter es un corchete que abre
                        agrupadores.push(expresion.charAt(i)); //Se hace push a la pila con ese valor.
                    } else if (expresion.charAt(i) == ']' && (Character) agrupadores.top() == '[') { //Si entra un corchete que abre y lo último en abrir fue un corchete.
                        agrupadores.pop();//Se elimina el valor al tope de la pila.
                    } else if (expresion.charAt(i) == ']' && (Character) agrupadores.top() != '[') {//Si entra un corchete que cierra y no hubo uno abierto.
                        return false;//La expresión no está balanceada.
                    }
                }
            } catch (Exception e) { //En caso de haber una excepción, la expresión no está balanceada.
                return false;
            }
            //Ahora que el proceso ha terminado, sólo queda verificar que las pilas estén vacías.
            if (agrupadores.isEmpty()) {
                bandera = true; //La expresión sólo puede estar balanceada si el proceso ha llegado hasta aquí sin errores.
            }
            return bandera; //Regresando el resultado.
        }
}
