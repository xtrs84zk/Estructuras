package estructuras;

/**
 * Created by Javier Sánchez on 15/11/2016.
 **/
public class ListaSimple {
    private NodoListaSimple primero;

    /**
     * Constructor para la clase ListaSimple que inicializa los valores en null.
     **/
    public ListaSimple() {
        primero = null;
    }

    /**
     * Constructor para la clase ListaSimple que inicializa los valores con
     * parámetros definidos por el usuario.
     *
     * @param dato que es lo que contendrá el primer nodo en la lista.
     **/
    public ListaSimple(Object dato) {
        //Se crea el primer nodo con el dato recibido en su interior.
        this.primero = new NodoListaSimple(dato);
    }

    /**
     * Método que inserta un valor al inicio de una lista enlazada.
     *
     * @param dato que es el dato a insertar en el nuevo nodo de la lista.
     **/
    public void insertarAlInicio(Object dato) {
        //Se crea un nuevo NodoListaSimple para almacenar el dato recibido.
        NodoListaSimple nuevoNodo = new NodoListaSimple(dato);
        //Se establece el nodo actualmente en primer lugar como el siguiente.
        nuevoNodo.setSiguiente(primero);
        //Se cambia la referencia del primer nodo hacía el nuevo nodo.
        primero = nuevoNodo;
    }

    /**
     * Método que elimina el valor (y el nodo) que se encuentre al inicio de
     * una lista enlazada. Al final regresa dicho valor.
     *
     * @return temporal.getDato() que es lo que contenía el nodo eliminado.
     **/
    public Object eliminarAlInicio() throws Exception {
        if (isEmpty()) {
            throw new Exception("La lista está vacía.");
        } else {
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

    /**
     * Método insertarAlFinal que inserta un elemento al final de una lista ordenada.
     *
     * @param dato que es el dato a insertar en la lista.
     **/
    public void insertarAlFinal(Object dato) {
        //Declarar una nueva referencia para, a partir del primer nodo, se mueva
        // hacia el último nodo sin modificar el primero.
        NodoListaSimple nuevoNodo = new NodoListaSimple(dato);
        //Si la lista no está vacía
        if (!isEmpty()) {
            NodoListaSimple ultimo = primero;
            //Se busca el último nodo en la lista.
            while (ultimo.getSiguiente() != null) {
                ultimo = ultimo.getSiguiente();
            }
            //Una vez encontrado, se establece una referencia hacia el nuevo nodo.
            ultimo.setSiguiente(nuevoNodo);
        } else {
            //En caso de que la lista esté vacía, se inserta como primer elemento.
            primero = nuevoNodo;
        }
    }

    /**
     * Método eliminarElUltimo encargado de eliminar el último elemento en
     * una lista ordenada. Lanza una excepción en caso de no encontrar elementos.
     *
     * @return contenidoDelUltimoNodo que es el contenido del nodo eliminado.
     **/
    public Object eliminarElUltimo() throws Exception {
        //Variable donde se almacenará el contenido del elemento eliminado
        Object contenidoDelUltimoNodo;
        //Para eliminar el elemento al final de la lista, primeramente se verifica
        // que haya elementos a eliminar.
        if (!isEmpty()) {
            //En caso de haber sólo un elemento en la lista, se elimina directamente.
            if (primero.getSiguiente() == null) {
                //En caso de que sólo haya un elemento en la lista, se almacena su contenido.
                contenidoDelUltimoNodo = primero.getDato();
                primero = null;
                return contenidoDelUltimoNodo;
            }
            //Se crea un NodoListaSimple que contendrá la referencia al penúltimo elemento.
            NodoListaSimple penultimo = primero;
            //Se recorre la lista hasta encontrar el penúltimo nodo.
            while (penultimo.getSiguiente().getSiguiente() != null) {
                penultimo = penultimo.getSiguiente();
            }
            //Se almacena el contenido del último nodo de la lista.
            contenidoDelUltimoNodo = penultimo.getSiguiente().getDato();
            //Se elimina la referencia en el penúltimo elemento.
            penultimo.setSiguiente(null);
        } else {
            //En caso de no haber elementos a eliminar, se lanza una excepción
            // indicando dicho estado.
            throw new Exception("La lista está vacía.");
        }
        //Finalmente, se regresa el contenido del nodo eliminado.
        return contenidoDelUltimoNodo;
    }

    /**
     * Método isEmpty que verifica que la lista esté vacía.
     *
     * @return true en caso de que la lista no contenga elementos.
     **/
    public boolean isEmpty() {
        return primero == null;
    }

    /**
     * Método buscarUnElemento que localiza un elemento en la lista enlazada.
     *
     * @param elementoABuscar que es el elemento a buscar en la lista.
     * @return true en caso de encontrar el elemento.
     **/
    public boolean buscarUnElemento(Object elementoABuscar) {
        //Se crea un nodo temporal que contendrá la referencia al elemento
        //que esté siendo comparado con el elemento a buscar.
        NodoListaSimple temporal = primero;
        //Mientras la referencia no sea nula (mientras haya elementos por comparar)
        while (temporal != null) {
            // Se verifica que el contenido de la referencia actual sea igual al
            // elemento a comparar; en caso de serlo, se regresa true.
            if (temporal.getDato().equals(elementoABuscar)) {
                return true;
            }
            // Si los contenidos no son iguales, se mueve la referencia hacia el
            // siguiente elemento en la lista.
            temporal = temporal.getSiguiente();
        }
        //Se regresa false en caso de no haber encontrado el elemento.
        return false;
    }

    /**
     * Método toString que regresa el contenido de la lista.
     *
     * @return mensaje que es un listado de lo contenido en la lista.
     **/
    public String toString() {
        //En caso de estar vacía
        if (isEmpty()) {
            return "La lista está vacía, no hay elementos para mostrar.";
        }
        //Se inicializa una variable para identificar cada nodo.
        int nodoActualEnLaLista = 0;
        //Se inicializa una variable para almacenar el contenido de los nodos.
        String mensaje = "El contenido de la lista es: \n";
        //Se inicializa un nodo para posicionarlo hasta llegar al ultimo.
        NodoListaSimple temporal = primero;
        //Se recorre la lista agregando el contenido de cada nodo a mensaje
        //junto con su número de nodo.
        while (temporal.getSiguiente() != null) {
            mensaje += ++nodoActualEnLaLista + ": " + temporal.getDato() + "\n";
            temporal = temporal.getSiguiente();
        }
        //Se agrega el contenido del último nodo.
        mensaje += ++nodoActualEnLaLista + ": " + temporal.getDato() + "\n";
        //Finalmente, se regresa el mensaje.
        return mensaje;
    }
}
