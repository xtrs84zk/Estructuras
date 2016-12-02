package aplicacion;

import estructuras.ListaSimple;

import javax.swing.*;

/**
 * Created by Javier Sánchez on 01/12/2016.
 **/
public class ListTest {
    public static void main(String[] args) {
        //String
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
        int opcion;
        //Se muestra
        JOptionPane.showMessageDialog(null, "Aplicación de prueba para la clase lista.");
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (opcion) {
                case 1:
                    //Se crea una nueva lista reemplazando la anterior.
                    lista = new ListaSimple();
                    break;
                case 2:
                    //Se pide el elemento a insertar y se inserta.
                    lista.insertarAlInicio(JOptionPane.showInputDialog(null, "Elemento a insertar:"));
                    break;
                case 3:
                    lista.insertarAlFinal(JOptionPane.showInputDialog(null, "Elemento a insertar:"));
                    break;
                case 4:
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Imposible eliminar un elemento, la lista está vacía.");
                    } else {
                        try {
                            JOptionPane.showMessageDialog(null, "Se eliminó el siguiente elemento: \n" + lista.eliminarAlInicio());
                        } catch (Exception e) {
                            System.err.println("Se intentó eliminar un elemento de una lista vacía.");
                        }
                    }
                    break;
                case 5:
                    if (lista.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Imposible eliminar un elemento, la lista está vacía.");
                    } else {
                        try {
                            JOptionPane.showMessageDialog(null, "Se eliminó el siguiente elemento: \n" + lista.eliminarElUltimo());
                        } catch (Exception e) {
                            System.err.println("Se intentó eliminar un elemento de una lista vacía.");
                        }
                    }
                    break;
                case 6:
                    if (lista.buscarUnElemento(JOptionPane.showInputDialog(null, "¿Qué elemento desea buscar?"))) {
                        JOptionPane.showMessageDialog(null, "El elemento se encontró.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el elemento.");
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saliendo.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 8);
    }
}
