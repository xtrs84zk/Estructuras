package estructuras;
/** Created on 16/10/2016. **/
public class InfijoAPosfijo extends BalanceoDeAgrupadores{
    private int posicion = 0;
    private Stack pilaDeOperadores = new StackUnlimited();
    private String expresionConvertidaAPostfijo = "";
    private String expresionEnInfijo;
    private final char [] operadores = {'+', '-', '*', '/', '%'};
    private String mensaje = "La expresión:  ";

    public InfijoAPosfijo(String expresion) {
        expresionEnInfijo = expresion;
    }

    public String convertirInfijoAPosfijo()throws Exception {
            do {
                try {
                    if (posicion == expresionEnInfijo.length() - 1) { // Si es el fin de la cadena
                        try {// Saca elementos de la pila y los agrega a la expresión convertida.
                            expresionConvertidaAPostfijo += pilaDeOperadores.pop();
                        } finally { //Forma el mensaje con las expresiones.
                            mensaje += expresionEnInfijo + " en postfijo es: " + expresionConvertidaAPostfijo;
                        }
                        return expresionConvertidaAPostfijo; //Regresa la expresión convertida.
                    } else if (expresionEnInfijo.charAt(posicion) == '(') {//Si encuentra un paréntesis de apertura.
                        pilaDeOperadores.push(expresionEnInfijo.charAt(posicion)); //Lo mete a la pila
                    } else if (expresionEnInfijo.charAt(posicion) == ')') { //Si encuentra un paréntesis de cierre.
                        do {
                            pilaDeOperadores.pop(); //Saca de la pila mientras no encuentre un paréntesis de apertura.
                        } while ((Character) pilaDeOperadores.pop() != '(');
                    } else if (esOperador(expresionEnInfijo.charAt(posicion))) { //Si encuentra un operador
                        // Determina la precedencia del operador y precedencia del
                        // elemento tope de la pila
                        if (!pilaDeOperadores.isEmpty()) {
                            //Si el operador tiene menor o igual precedencia que el que está al tope de la pila.
                            if (tieneMenorOIgualPrecedencia(expresionEnInfijo.charAt(posicion))) {
                                pilaDeOperadores.pop();
                                expresionConvertidaAPostfijo += pilaDeOperadores.pop();
                            } else
                                // Si la precedencia del operador no es menor que la del elemento al tope, lo mete a la pila.
                                pilaDeOperadores.push(expresionEnInfijo.charAt(posicion));
                        }
                    } else { //Si no encontró operadores ni paréntesis, se procede a agregar a la expresión en postfijo.
                        expresionConvertidaAPostfijo += expresionEnInfijo.charAt(posicion);
                    }
                    posicion++;
                } catch (Exception e) {
                    mensaje = "Excepción atrapada: " + e.getMessage();
                }
            } while (posicion != expresionEnInfijo.length());
            return expresionConvertidaAPostfijo;
        }

    private boolean esOperador(char caracter) {
        for (char operadore : operadores) //For each que va a comparar el caracter con los operadores.
            if (operadore == caracter) return true; //En caso de encontrarlo, regresa true.
        return false;//Si el foreach ha terminado, regresa false.
    }

    private boolean tieneMenorOIgualPrecedencia(char operador) throws Exception {
        char auxiliar = (Character) pilaDeOperadores.top();
        boolean flag = true;
        //El operador es de suma o resta
        if (operador == '+' || operador == '-'){
            //Si lo que está al tope de la pila tiene mayor precedencia que + o - , la bandera cambia a false.
            if (auxiliar == '*' || auxiliar == '/' || auxiliar == '%') flag = false;
        } else {
            //Si lo que está al tope de la pila tiene menor precedencia que *,/,%; la bandera cambia a false.
            if (auxiliar == '-' || auxiliar == '+') flag = false;
        }
        return flag;
    }
    
    @Override
    public String toString() {
        return mensaje;
    }
}
