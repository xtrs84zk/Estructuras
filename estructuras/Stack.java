package estructuras;
/**
 * Interface que define las operaciones de un Stack.
 *
 * Created by xtrs84zk on 21/09/2016.
 */

public interface Stack{
    /**
     * Inserta un elemento a la pila.
     */
    void push (Object elemento);

    /**
     *
     */
    Object pop () throws Exception;

    /**
     * Regresa el último elemento insertado a la pila, sin eliminarlo.
     * */
    Object top() throws Exception;
    
    /**
     * Indica si la pila está vacía.
     */
    boolean isEmpty();
}
