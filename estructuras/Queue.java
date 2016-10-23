package estructuras;

/** Created by xtrs84zk on 23/10/2016. **/
public interface Queue {
    void insert(Object elemento) throws Exception;
    Object delete()  throws Exception;
    boolean isEmpty();
    boolean isFull();
}
