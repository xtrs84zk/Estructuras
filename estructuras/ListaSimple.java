package estructuras;

/** Created by Javier Sánchez on 15/11/2016. **/
public class ListaSimple {
    private NodoListaSimple primero;

    /** Constructor para la clase ListaSimple que inicializa los valores en null. **/
    public ListaSimple() {
        primero = null;
    }
    /** Constructor para la clase ListaSimple que inicializa los valores con
     * parámetros definidos por el usuario.
     * @param dato que es lo que contendrá el primer nodo en la lista.**/
    public ListaSimple(Object dato) {
        //Se crea el primer nodo con el dato recibido en su interior.
        this.primero = new NodoListaSimple(dato);
    }
    /** Método que inserta un valor al inicio de una lista enlazada.
     * @param dato que es el dato a insertar en el nuevo nodo de la lista. **/
    public void insertarAlInicio(Object dato){
        //Se crea un nuevo NodoListaSimple para almacenar el dato recibido.
        NodoListaSimple nuevoNodo = new NodoListaSimple(dato);
        //Se establece el nodo actualmente en primer lugar como el siguiente.
        nuevoNodo.setSiguiente(primero);
        //Se cambia la referencia del primer nodo hacía el nuevo nodo.
        primero = nuevoNodo;
    }
    /** Método que elimina el valor (y el nodo) que se encuentre al inicio de
     *  una lista enlazada. Al final regresa dicho valor.
     *  @return temporal.getDato() que es lo que contenía el nodo eliminado.**/
    public Object eliminarAlInicio(){
        //Se crea un nuevo NodoListaSimple para almacenar el nodo a eliminar.
        NodoListaSimple temporal;
        //Se copia la referencia de primero hacía temporal.
        temporal = primero;
        //Se establece el primer nodo de la lista en el segundo.
        primero = primero.getSiguiente();
        //Se regresa el contenido del nodo eliminado.
        return temporal.getDato();
    }
}
