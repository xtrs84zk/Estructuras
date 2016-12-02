package aplicacion;

import estructuras.ListaSimple;

import javax.swing.JOptionPane;

/**
 * Created by Javier Sánchez on 01/12/2016.
 **/
public class ListTest {
    public static void main(String[] args) {
        //String que contiene el mensaje con las opciones disponibles.
        final String opciones;
        opciones = "1. Crear lista.\n" +
                "2. Insertar al inicio.\n" +
                "3. Insertar al final.\n" +
                "4. Eliminar al inicio.\n" +
                "5. Eliminar al final.\n" +
                "6. Buscar un elemento.\n" +
                "7. Mostrar lista.\n" +
                "8. Salir.";
        //La lista se inicializa como una lista simple.
        ListaSimple lista = new ListaSimple();
        //Variable en que se almacenará la opción elegida por el usuario.
        int elegidoPorElUsuario;
        //Se muestra un mensaje de inicio.
        JOptionPane.showMessageDialog(null, "Aplicación de prueba para la clase lista.");
        do {
            //Se muestra un mensaje con las opciones para que el usuario elija una.
            elegidoPorElUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            //Se realiza una acción dependiendo de la elegidoPorElUsuario del usuario.
            switch (elegidoPorElUsuario) {
                case 1:
                    //Se crea una nueva lista reemplazando la anterior.
                    lista = new ListaSimple();
                    break;
                case 2:
                    //Se pide el elemento a insertar y se inserta.
                    lista.insertarAlInicio(JOptionPane.showInputDialog(null, "Elemento a insertar:"));
                    break;
                case 3:
                    //Se pide el elemento a insertar y se inserta.
                    lista.insertarAlFinal(JOptionPane.showInputDialog(null, "Elemento a insertar:"));
                    break;
                case 4:
                    //Si la lista está vacía, se muestra un mensaje de error.
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Imposible eliminar un elemento, la lista está vacía.");
                    } else {
                        //Si hay elementos en la lista, se elimina el primero.
                        try {
                            JOptionPane.showMessageDialog(null, "Se eliminó el siguiente elemento: \n" + lista.eliminarAlInicio());
                        } catch (Exception e) {
                            System.err.println("Se intentó eliminar un elemento de una lista vacía.");
                        }
                    }
                    break;
                case 5:
                    //Si la lista está vacía, se muestra un mensaje de error.
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Imposible eliminar un elemento, la lista está vacía.");
                    } else {
                        //Si hay elementos en la lista, se elimina el último.
                        try {
                            JOptionPane.showMessageDialog(null, "Se eliminó el siguiente elemento: \n" + lista.eliminarElUltimo());
                        } catch (Exception e) {
                            System.err.println("Se intentó eliminar un elemento de una lista vacía.");
                        }
                    }
                    break;
                case 6:
                    //Se pide el elemento a buscar y se verifica que esté en la lista.
                    if (lista.buscarUnElemento(JOptionPane.showInputDialog(null, "¿Qué elemento desea buscar?"))) {
                        //En caso de encontrarlo.
                        JOptionPane.showMessageDialog(null, "El elemento se encontró.");
                    } else {
                        //En caso de no encontrarlo.
                        JOptionPane.showMessageDialog(null, "No se encontró el elemento.");
                    }
                    break;
                case 7:
                    //Se listan los elementos de... la lista.
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
                case 8:
                    //Se muestra un mensaje antes de salir.
                    JOptionPane.showMessageDialog(null, "Saliendo.");
                    break;
                default:
                    //Cualquier otra opción es inválida.
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (elegidoPorElUsuario != 8);
    }
}
