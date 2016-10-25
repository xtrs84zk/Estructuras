package estructuras;

/** Created by xtrs84zk on 23/10/2016. **/
public interface Queue {

	/** Indica si la pila está vacia.
	 * @param Sin parametros.
	 * @return true si la pila está vacia, false en caso contrario. **/
	boolean isEmpty();

	/** Indica si la pila está llena.
	 * @param Sin parametros.
	 * @return true si la pila está llena, false en caso contrario. **/
	boolean isFull();

	/** Inserta un elemento en la pila.
	 * @param element
	 * @return Sin valores de retorno. **/
	void insert(Object element) throws Exception;

	/** Extrae el elemento del fondo de la cola y lo muestra. Tiene compartamiento FIFO.
	 * @param Sin parametros.
	 * @return Object, que es el elemento del fondo de la cola. **/
	Object extract();
}
