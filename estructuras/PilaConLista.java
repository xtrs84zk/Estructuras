package estructuras;

/**
 * Created by Javier Sánchez on 16/11/2016.
 **/
public class PilaConLista implements Stack {
    private ListaSimple pila;

    public PilaConLista() {
        pila = new ListaSimple();
    }

    public void push(Object elemento) {
        pila.insertarAlInicio(elemento);
    }

    public Object pop() throws Exception {
        return pila.eliminarAlInicio();
    }


    public Object top() throws Exception {
        Object temporal = pila.eliminarAlInicio();
        pila.insertarAlInicio(temporal);
        return temporal;
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }
}
