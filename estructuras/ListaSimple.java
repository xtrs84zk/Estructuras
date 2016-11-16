package estructuras;

/** Created by Javier Sánchez on 15/11/2016. **/
public class ListaSimple {
    private NodoListaSimple primero;

    public ListaSimple() {
        primero = null;
    }

    public ListaSimple(Object dato) {
        this.primero = new NodoListaSimple(dato);
    }

    public void insertarAlInicio(Object dato){
        NodoListaSimple nuevoNodo = new NodoListaSimple(dato);
        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
    }

    public Object eliminarAlInicio(){
        NodoListaSimple temporal;
        temporal = primero;
        primero = primero.getSiguiente();
        return temporal.getDato();
    }
}
