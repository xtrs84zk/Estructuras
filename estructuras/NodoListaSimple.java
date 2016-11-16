package estructuras;

/** Created by Javier Sánchez on 15/11/2016. **/
public class NodoListaSimple {
    private Object dato;
    private NodoListaSimple siguiente;
    /** Constructor para la clase NodoListaSimple que inicializa los
     * valores con los parámetros recibidos. Sólo inserta el dato.
     * @param dato que es el dato a insertar en el nodo.**/
    public NodoListaSimple(Object dato) {
        this.dato = dato;
    }
    /** Constructor para la clase NodoListaSimple que inicializa los
     * valores con los parámetros recibidos. Inserta el contenido y
     * especifica cuál será el siguiente nodo.
     * @param dato que es el dato a insertar en el nodo.
     * @param siguiente que es el siguiente nodo.**/
    public NodoListaSimple(Object dato, NodoListaSimple siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /** Método getDato que regresa el contenido del nodo.
     * @return dato que es el contenido del nodo. **/
    public Object getDato() {
        return dato;
    }

    /** Método setDato que establece el contenido del nodo.
     * @param dato que es el contenido que tendrá el nodo. **/
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /** Método getSiguiente que regresa el siguiente nodo.
     * @return siguiente que es el siguiente nodo. **/
    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    /** Método setSiguiente que establece el nodo que seguirá.
     * @param siguiente que es el siguiente nodo en la lista. **/
    public void setSiguiente(NodoListaSimple siguiente) {
        this.siguiente = siguiente;
    }

    /** Método toString que regresa un resumen del contenido del nodo.**/
    public String toString() {
        return  "Contenido: " + dato +
                "\nSiguiente nodo: " + siguiente;
    }
}
