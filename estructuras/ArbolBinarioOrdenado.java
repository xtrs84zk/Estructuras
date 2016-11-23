package estructuras;

/**
 * Created by xtrs84zk on 23/11/2016.
 **/
public class ArbolBinarioOrdenado {
    NodoArbolBinario raiz;

    public ArbolBinarioOrdenado() {

    }

    public ArbolBinarioOrdenado(Object dato) {
        raiz = new NodoArbolBinario(dato);
    }

    public void insertar(Object dato) {

    }

    private void insertarRecursivo(Object dato) {

    }

    public void preOrden() {
        preOrdenRecursivo(raiz);
    }

    private void preOrdenRecursivo(NodoArbolBinario raiz) {
        if (!isEmpty()) {
            //Procesar la raiz.
            preOrdenRecursivo(raiz.getIzquierdo());
            preOrdenRecursivo(raiz.getIzquierdo());
        }
    }

    public void inOrden() {

    }

    public void postOrden() {

    }

    public boolean isEmpty() {
        return raiz == null;
    }
}
