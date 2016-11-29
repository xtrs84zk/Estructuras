package estructuras;

/**
 * Created by xtrs84zk on 23/11/2016.
 **/
public class NodoArbolBinario {
    private Object dato;
    private NodoArbolBinario izquierdo;
    private NodoArbolBinario derecho;

    /**
     * Constructor para la clase NodoArbolBinario que inicializa los
     * valores con parámetros dados.
     *
     * @param dato      que es el dato que contendrá el nodo raíz.
     * @param derecho   que es el nodo que estará a la izquierda.
     * @param izquierdo que es el nodo que estará a la derecha.
     **/
    public NodoArbolBinario(Object dato, NodoArbolBinario izquierdo, NodoArbolBinario derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    /**
     * Método que regresa el dato contenido en el nodo.
     *
     * @return dato que es el contenido del nodo.
     **/
    public Object getDato() {
        return dato;
    }

    /**
     * Metodo que establece el contenido del nodo.
     *
     * @param dato que es el dato a insertar en el nodo.
     **/
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * Método que regresa la referencia del nodo a la izquierda.
     *
     * @return izquierdo que es el nodo a la izquierda.
     **/
    public NodoArbolBinario getIzquierdo() {
        return izquierdo;
    }

    /**
     * Método que establece un nodo a la izquierda del nodo actual.
     *
     * @param izquierdo que es el nodo que estará a la izquierda.
     **/
    public void setIzquierdo(NodoArbolBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Método que regresa la referencia del nodo a la derecha.
     *
     * @return derecho que es el nodo a la derecha.
     **/
    public NodoArbolBinario getDerecho() {
        return derecho;
    }

    /**
     * Método que establece un nodo a la derecha del nodo actual.
     *
     * @param derecho que es el nodo que estará a la derecha.
     **/
    public void setDerecho(NodoArbolBinario derecho) {
        this.derecho = derecho;
    }

    /**
     * Método toString que regresa el contenido del nodo
     **/
    public String toString() {
        return "Contenido: " + dato;
    }
}
