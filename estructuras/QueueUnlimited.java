package estructuras;

/** Created on 06/11/2016. **/
public class QueueUnlimited implements Queue {
    private Object queue[];
    private int rear;
    public QueueUnlimited() {
        queue = new Object[0];
        rear = 0;
    }
	/** Indica si la cola está vacia. **/
    public boolean isEmpty() {
        return queue.length == 0;
    }
	/** Regresa el objecto al frente de la cola sin eliminarlo. **/
    public Object front() throws Exception {
        if(isEmpty()){
            throw new Exception("La cola está vacía.");
        }
        return queue[0];
    }
	/** Inserta un elemento en la pila.
	 * Recibe el elemento a importar de tipo Object
     * No tiene valores de retorno. **/
    public void insert(Object element) {
        Object[] auxiliar = new Object[queue.length+1];
        if (queue.length>0) System.arraycopy(queue, 0, auxiliar, 0, rear);
        auxiliar[rear++] = element;
        queue = auxiliar;
    }
	/** Extrae el elemento del fondo de la cola y lo muestra.
     * Al ser una cola, su comportamiento es FIFO.
     * No recibe parámetros. Regresa el objeto que estaba al frente.**/
    public Object extract() throws Exception {
        if(isEmpty()) throw new Exception("La cola está vacía.");
        Object auxiliar = queue[0];
        Object[] temporal = new Object[queue.length-1];
        System.arraycopy(queue, 1, temporal, 0, temporal.length);
        rear--;
        queue = temporal;
        return auxiliar;
    }
}
