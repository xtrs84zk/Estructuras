package estructuras;

/** Created by xtrs84zk on 06/11/2016. **/
public class QueueLimited implements Queue{
    private Object[] queue;
    private int rear;
    public QueueLimited() {
        queue = new Object[10];
        rear = 0;
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public boolean isFull() {
        return rear == queue.length -1 ;
    }

    public void insert(Object element) {
        if(!isFull()){
            queue[rear++] = element;
        } else {
            throw new Exception("La cola está llena.");
        }
    }

    public Object extract() throws Exception {
        Object auxiliar = queue[0];
        if(!isEmpty()) {
            for (int i = 0; i < queue.length; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        } else {
            throw new Exception("La cola esta vacía.");
        }
        return auxiliar;
    }

    public Object front() throws Exception {
        if(isEmpty()){
            throw new Exception("La cola está vacía.");
        }
        return queue[0];
    }
}
