package estructuras;

/**
 * Created by Javier Sánchez on 23/11/2016.
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
        NodoArbolBinario temporal = new NodoArbolBinario(dato, null, null);
        insertarRecursivo(temporal, raiz);
    }

    /**
     * Método que inserta de forma recursiva elementos en un arreglo.
     **/
    private void insertarRecursivo(NodoArbolBinario nodoAInsertar, NodoArbolBinario raiz) {

    }

    /** Metodo que verifica que el árbol pueda ser recorrido de
     * forma recursiva en modo preorden y después lo recorre.**/
    public void preOrden() {
        //Si el arbol tiene datos, se puede recorrer.
        if (!isEmpty()) {
            preOrdenRecursivo(raiz);
        }
    }

    /** Método que recorre el arbol de forma recursiva en preorden.
     * Primero procesa la raíz, después recorre hacia la izquierda
     * y finalmente, a la derecha.
     * @param raiz que es el subárbol a procesar. **/
    private void preOrdenRecursivo(NodoArbolBinario raiz) {
        //Procesar la raíz.
        //En caso de que el subárbol actual tenga una referencia
        //válida hacia el nodo izquierdo, se recorre dicho nodo.
        if (raiz.getIzquierdo() != null) {
            preOrdenRecursivo(raiz.getIzquierdo());
        }
        //Se recorre el subárbol a la derecha si y sólo si existe.
        if (raiz.getDerecho() != null) {
            preOrdenRecursivo(raiz.getDerecho());
        }
    }

    /** Método que verifica que sea posible recorrer el
     * árbol en forma recursiva inorden y luego lo recorre.**/
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
        //En caso de que el subárbol actual tenga una referencia
        //válida hacia el nodo izquierdo, se recorre dicho nodo.
        if (raiz.getIzquierdo() != null) {
            postOrdenRecursivo(raiz.getIzquierdo());
        }
        //Se recorre el subárbol a la derecha si y sólo si existe.
        if (raiz.getDerecho() != null) {
            postOrdenRecursivo(raiz.getDerecho());
        }
        //Procesar la raíz.
    }

    /** Método isEmpty que informa si el árbol está vacío.
     * @return true en caso de que la raíz no haya sido establecida. **/
    public boolean isEmpty() {
        return raiz == null;
    }
}
