package estructuras;

/** Created by xtrs84zk on 23/10/2016. **/
public class CircularQueue implements Queue {
    private int rear, front;
    private Object[] queue;

    public CircularQueue() {
        rear = 0;
        front = 0;
        queue = new Object[10];
    }

    public boolean isEmpty(){
        return rear == front && queue[front] == null;
    }

    public Object front() throws Exception {
        return queue[front];
    }

    public boolean isFull(){
        return rear == front && queue[front] != null;
    }

    public Object delete() throws Exception{
        Object elemento = null;
        if(!isEmpty()){
            queue[lugarAEliminar()] = null;
            return elemento;
        } else {
            throw new Exception("La cola está vacía.");
        }

    }
    public void insert (Object elemento) {//} throws Exception{
        if(!isFull()) {
            queue[lugarAInsertar()] = elemento;
        } else {
            //throw new Exception("La cola está llena.");
        }
    }

    public Object extract() {
        return null;
    }

    private int lugarAInsertar(){
        if(rear<queue.length-1){
            return rear;
        }
        return 0;
    }
    private int lugarAEliminar(){
        if(front<queue.length-1){
            return front;
        }
        return front;
    }
}
