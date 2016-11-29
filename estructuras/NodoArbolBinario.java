package estructuras;

/**
 * Created by xtrs84zk on 23/11/2016.
 **/
public class NodoArbolBinario {
    Object dato;
    NodoArbolBinario izquierdo;
    NodoArbolBinario derecho;

    public NodoArbolBinario(Object dato) {
        this.dato = dato;
    }

    public NodoArbolBinario(Object dato, NodoArbolBinario izquierdo, NodoArbolBinario derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoArbolBinario getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbolBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbolBinario getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbolBinario derecho) {
        this.derecho = derecho;
    }

    public String toString() {
        return "Contenido: " + dato;
    }
}
