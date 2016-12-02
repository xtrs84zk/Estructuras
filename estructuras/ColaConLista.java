package estructuras;

/**
 * Created by Javier Sanchez on 29/11/2016.
 **/
public class ColaConLista implements Queue {
    //Lista simple que actuará como cola.
    private ListaSimple cola;

    /**
     * Constructor para la clase ColaConLista
     * que inicializa la cola vacía.
     **/
    public ColaConLista() {
        cola = new ListaSimple();
    }

    /**
     * Método que regresa un booleano dependiendo
     * de si la cola está vacía o no.
     *
     * @return true si la cola está vacía.
     **/
    public boolean isEmpty() {
        return cola.isEmpty();
    }

    /**
     * Método que regresa el elemento encontrado
     * al frente de la cola.
     *
     * @return elementoAlFrente
     **/
    public Object front() throws Exception {
        //En caso de que la cola esté vacía,
        //se procede a lanzar una excepción.
        if (cola.isEmpty()) {
            throw new Exception("La cola está vacía.");
        } else {
            //Se crea una variable de tipo Object y se le asigna
            //el valor del último objeto en la lista.
            Object elementoAlFrente = cola.eliminarElUltimo();
            //Debido a que el elemento fue eliminado, se vuelve a
            // insertar en la posición que tenía.
            cola.insertarAlFinal(elementoAlFrente);
            //Finalmente, se regresa el elemento.
            return elementoAlFrente;
        }
    }

    /**
     * Método para insertar un elemento a la cola.
     *
     * @param dato que es dato a insertar.
     **/
    public void insert(Object dato) {
        //Se llama al método que inserta el
        //dato a la lista.
        cola.insertarAlInicio(dato);
    }

    /**
     * Método que extrae un elemento de la cola.
     * Lanza una excepción si la cola está vacía.
     *
     * @return el elemento que estuviera al frente
     * de la cola.
     **/
    public Object extract() throws Exception {
        //En caso de que la cola esté vacía
        if (isEmpty()) {
            //Se lanza una excepción
            throw new Exception("La cola está vacía.");
        }
        //Se regresa (y elimina) el elemento al frente de la cola.
        return cola.eliminarElUltimo();
    }
}
