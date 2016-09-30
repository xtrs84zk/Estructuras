package estructuras;
/**
 * Interface que define las operaciones de un Stack.
 * 
 * @author (Javier Sánchez) 
 * @version (21/09/2016 <3)
 */

public interface Stack{
    /*static final*/ int x = 7;
    /**
     * Inserta un elemento a la pila.
     * 
     * @param  elemento a insertar
     * @return        no tiene valor de retorno 
     */
    void push (Object elemento);

    /**
     * Extrae un elemento de la pila, tiene comportamiento LIFO.
     * @param no tiene parametro
     * @return        regresa el último elemento insertado a la pila 
     */
    Object pop ();

    /**
     * Regresa el último elemento insertado a la pila, sin eliminarlo.
     * 
     * @param  no tiene parametros.
     * @return        elemento del tope de la pila. 
     */
    Object top();
    
    /**
     * Indica si la pila está vacía.
     * 
     * @param  no tiene parametro
     * @return        true si la pila está vacía, false en caso contrario. 
     */
    boolean isEmpty();
}
