package estructuras;

/** Created by xtrs84zk on 06/11/2016. **/
public class QueueUnlimited implements Queue {
    private Object queue[];
    private int rear;
    public QueueUnlimited() {
        queue = new Object[0];
        rear = 0;
    }

    public boolean isEmpty() {
        return queue.length == 0;
    }

    public Object front() throws Exception {
        if(isEmpty()){
            throw new Exception("La cola está vacía.");
        }
        return queue[0];
    }

    public void insert(Object element) {
        Object[] auxiliar = new Object[queue.length+1];
        System.arraycopy(queue, 0, auxiliar, 0, queue.length-1);
        auxiliar[rear++] = element;
        queue = auxiliar;
    }

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
