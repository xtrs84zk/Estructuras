package estructuras;

/** Created by xtrs84zk on 23/10/2016. **/
public interface Queue {

	/** Indica si la cola está vacia. **/
	boolean isEmpty();

	/** Regresa el objecto al frente de la cola sin eliminarlo. **/
	Object front() throws Exception ;

	/** Inserta un elemento en la pila.
	 * Recibe el elemento a importar de tipo Object
     * No tiene valores de retorno. **/
	void insert(Object element);

	/** Extrae el elemento del fondo de la cola y lo muestra.
     * Al ser una cola, su comportamiento es FIFO.
     * No recibe parámetros. Regresa el objeto que estaba al frente.**/
	Object extract() throws Exception;
}
