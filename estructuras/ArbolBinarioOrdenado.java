package estructuras;

/**
 * Created by xtrs84zk on 23/11/2016.
 **/
public class ArbolBinarioOrdenado {
    private NodoArbolBinario raiz;

    public ArbolBinarioOrdenado() {
        raiz = null;
    }

    public ArbolBinarioOrdenado(Object dato) {
        raiz = new NodoArbolBinario(dato, null, null);
    }

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

    private void inOrdenRecursivo(NodoArbolBinario raiz) {
        inOrdenRecursivo(raiz.getIzquierdo());
        //procesar la raíz.
        inOrdenRecursivo(raiz.getDerecho());
    }

    public void postOrden() {
        if (!isEmpty()) {
            postOrdenRecursivo(raiz);
        }
    }

    private void postOrdenRecursivo(NodoArbolBinario raiz) {
        postOrdenRecursivo(raiz.getIzquierdo());
        postOrdenRecursivo(raiz.getDerecho());
        //Procesar la raíz.
    }

    public boolean isEmpty() {
        return raiz == null;
    }
}
