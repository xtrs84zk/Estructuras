package estructuras;
/**
 * Clase que crea pilas virtualmente sin limite.
 * 
 * author (Javier Sánchez)
 * version (21-09-2016)
 */
public class StackUnlimited implements Stack{
    private Object[] stack; //pila
    /**
     * Constructor for objects of class StackUnlimited
     */
    public StackUnlimited()
    {
        stack = new Object[0];
    }

    /** Método push que "pushea" (inserta) nuevos elementos a la pila. **/
    public void push (Object elemento){
        Object[] auxiliar;
        auxiliar = new Object[stack.length+1];
        System.arraycopy(stack, 0, auxiliar, 0, stack.length);
        auxiliar[auxiliar.length-1] = elemento;
        stack = auxiliar;
    }
    
    /** Método que "popea" (extrae y elimina) el valor al tope de la pila
     * @return elemento al tope de la pila. **/
    public Object pop () throws Exception{
        Object auxiliarObject, auxiliarArray[];
        auxiliarObject = stack[stack.length-1];
        auxiliarArray = new Object[stack.length-1];
        System.arraycopy(stack, 0, auxiliarArray, 0, stack.length - 1);
        stack = auxiliarArray;
        return auxiliarObject;
    }
    
    /** Método que regresa el elemento al tope de la pila sin eliminarlo
     * @return elemento al tope. **/
    public Object top() throws Exception{
        return stack[stack.length-1];
    }
    
    /** Método que dice si la pila está vacía o no. **/
    public boolean isEmpty(){
        return stack.length==0;
    }
}