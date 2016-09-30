package aplicacion;

import java.util.Arrays;

import javax.swing.JOptionPane;
public class StackLimited extends Object {

	private static int[] stack;
	private static int top;
	private static boolean vacio, lleno;

	/**
	 * constructor que recive tamaño y se lo asigna a stack[]
	 * 
	 * @param tamaño
	 */
	public StackLimited() {
		stack = new int[10];
		top = 0;
	}

	/**
	 * metodo que ingresa un elemento a la pila
	 * 
	 * @param elemento
	 */
	public static void push(int elemento) {
		if (top < stack.length) {
			stack[top] = elemento;
			top++;
		}

	}

	/**
	 * metodo que extrae un elemento de la pila.
	 * 
	 * @return stack
	 */
	public static int pop() {
		if (top > 0) {
			return stack[--top];
		}
		return stack[top];

	}

	/**
	 * metodo que regresa si la pila esta vacia o no.
	 * 
	 * @return vacio
	 */
	public static boolean isEmpy() {
		if (top == 0) {
			vacio = true;
		} else {
			vacio = false;
		}
		return vacio;
	}

	/**
	 * metodo que regresa el valor del tope.
	 * 
	 * @return stack
	 */
	public static int top() {
		return stack[top - 1];
	}

	/**
	 * metodo que regresa si la pila esta llena o no.
	 * 
	 * @return lleno
	 */
	public static boolean isFull() {
		if (top == stack.length) {
			lleno = true;
		} else {
			lleno = false;
		}
		return lleno;
	}

	/**
	 * metodo main que brinda una interfas para el usuario
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int usuario;
		String[] menu = { "Ingresar elemento", "Desechar último elemento", "Saber si la pila esta vacia",
				"Conocer el último elemento", "Saber si la pila esta llena" };

		// interfaz

		// excepcion para el ingreso del tamaño del arreglo
		try {
			stack = new int[Integer.parseInt(JOptionPane.showInputDialog("¿De que tamaño quiere la pila?"))];
		} catch (NumberFormatException excepcion) {
			System.out.println("Error en el ingreso del tamaño");
			System.exit(0);
		} catch (NegativeArraySizeException exepcion) {
			System.out.println("Error. Solo se admiten numeros enteros positivos");
			System.exit(0);
		}
		do {
			String eleccion = (String) JOptionPane.showInputDialog(null, "¿Que desea hacer?",
					"Opciones para el usuario", JOptionPane.DEFAULT_OPTION, null, menu, menu[0]);
			// Excepcion para cuando se cancela el menu
			try {
				switch (eleccion) {
				case "Ingresar elemento":
					// Excepcion si ingresa una letra o numero que no sea entero
					// positivo
					try {
						push(Integer.parseInt(JOptionPane.showInputDialog("¿Que elemento desea ingresar?")));
					} catch (NumberFormatException e) {
						System.out.println("Error. Solo se admiten numeros enteros positivos");
						break;
					}
					break;
				case "Desechar último elemento":
					pop();
					break;
				case "Saber si la pila esta vacia":
					JOptionPane.showMessageDialog(null, isEmpy());
					break;
				case "Conocer el último elemento":
					JOptionPane.showMessageDialog(null, top());
					break;
				case "Saber si la pila esta llena":
					JOptionPane.showMessageDialog(null, isFull());
					break;
				}
			} catch (NullPointerException e) {
				// continuar
			}
			System.out.println(Arrays.toString(stack));
			usuario = JOptionPane.showConfirmDialog(null, "¿Realizar otra acción?", " ", JOptionPane.YES_NO_OPTION);
		} while (usuario == 0);
	}
}