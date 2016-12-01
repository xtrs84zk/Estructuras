package estructuras;

/**
 * Created by xtrs84zk on 23/11/2016.
 **/
public class ArbolBinarioOrdenado {
    //Nodo de tipo árbol binario donde se encontrará la
    // referencia al nodo raíz del árbol
    private NodoArbolBinario raiz;

    /**
     * Constructor para la clase ArbolBinarioOrdenado
     * que inicializa los valores en null.
     **/
    public ArbolBinarioOrdenado() {
        raiz = null;
    }

    /** Constructor para la clase ArbolBinarioOrdenado
     * que inicializa los valore con parametros dados.
     * @param dato que es el dato a insertar en la raíz.**/
    public ArbolBinarioOrdenado(Object dato) {
        raiz = new NodoArbolBinario(dato, null, null);
    }

    /** Método insertar que verifica qué procedimiento
     * utilizar para insertar los datos en el árbol.
     * @param dato que es el dato a insertar.**/
    public void insertar(Object dato) {

    }

    private void insertarRecursivo(Object dato) {

    }

    public void preOrden() {
        if (!isEmpty()) {
            preOrdenRecursivo(raiz);
        }
    }

    private void preOrdenRecursivo(NodoArbolBinario raiz) {
        if (!isEmpty()) {
            //Procesar la raíz.
            preOrdenRecursivo(raiz.getIzquierdo());
            preOrdenRecursivo(raiz.getDerecho());
        }
    }

    public void inOrden() {
        if (!isEmpty()) {
            inOrdenRecursivo(raiz);
        }
    }

    /** Método que recorre el árbol en modo inOrden
     * Primeramente resuelve el nodo a la izquierda,
     * luego la raíz y finalmente, el nodo a la derecha.
     * @param raiz que la raíz del subárbol a procesar.**/
    private void inOrdenRecursivo(NodoArbolBinario raiz) {
        //En caso de que el subárbol actual tenga una referencia
        //válida hacia el nodo izquierdo, se recorre dicho nodo.
        if (raiz.getIzquierdo() != null) {
            inOrdenRecursivo(raiz.getIzquierdo());
        }
        //procesar la raíz.
        //Se recorre el subárbol a la derecha si y sólo si existe.
        if (raiz.getDerecho() != null) {
            inOrdenRecursivo(raiz.getDerecho());
        }
    }

    /** Método público que se encarga de verificar que el
     * método recursivo postOrdenRecursivo pueda procesar
     * el árbol que se le ha enviado. **/
    public void postOrden() {
        if (!isEmpty()) {
            postOrdenRecursivo(raiz);
        }
    }

    /** Método que recorre el árbol binario procesando primero
     * los nodos a la izquierda, después los de la derecha y
     * finalmente la raíz. Es una función recursiva así que,
     * en realidad, sólo procesa un subárbol a la vez.
     * @param raiz que será la raíz del árbol a procesar.**/
    private void postOrdenRecursivo(NodoArbolBinario raiz) {
        postOrdenRecursivo(raiz.getIzquierdo());
        postOrdenRecursivo(raiz.getDerecho());
        //Procesar la raíz.
    }

    /** Método isEmpty que informa si el árbol está vacío.
     * @return true en caso de que la raíz no haya sido establecida. **/
    public boolean isEmpty() {
        return raiz == null;
    }
}
