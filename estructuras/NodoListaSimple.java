package estructuras;

/** Created by Xavier Sánchez on 15/11/2016. **/
public class NodoListaSimple {
    private Object dato;
    private NodoListaSimple siguiente;

    public NodoListaSimple(Object dato) {
        this.dato = dato;
    }

    public NodoListaSimple(Object dato, NodoListaSimple siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaSimple siguiente) {
        this.siguiente = siguiente;
    }

    public String toString() {
        return "NodoListaSimple{" +
                "dato=" + dato +
                ", siguiente=" + siguiente +
                '}';
    }
}
