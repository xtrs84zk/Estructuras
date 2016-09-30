package aplicacion;

/**
 * Aplicacion que utiliza la clase instanciable MetodosDeArreglos
 */

import javax.swing.JOptionPane;
import estructuras.MetodosDeArreglos;

public class AplicacionMetodosDeArregelo {
	public static void main(String[] ars) {

		// Parametros con valores por default
		int x, old, nuevo, i, j, inf, sup;
		x = 3;
		old = 2;
		nuevo = 3;
		i = 1;
		j = 3;
		inf = 0;
		sup = 6;

		// Valores de retorno
		int negativos, suma, repeticiones, mayor, posicion;
		boolean respuesta;

		// Arreglos con valores por default
		int[] arregloNumeros = { -1, 2, -3, -4, 5, 3, 2, 1 }, Arr = { -1, 2, -3, -4, 5, 3, 2, 1 },
				A1 = { -1, 2, -3, -4, 5, 3, 2, 1 }, A2 = { -1, 2, -3, -4, 5, 3, 2, 1 },
				A = { -1, 2, -3, -4, 5, 3, 2, 1 };
		boolean[] ArrB = new boolean[7];

		// interfaz grafica
		int usuario;
		do {
			String[] metodos = { "inicia1", "inicia2", "inicia3", "cuentaNumerosNegativos", "sumaImpar",
					"cuentaRepeticiones", "sustituye", "intercambia", "invierte", "rotaDerecha", "mayor", "posMayor",
					"ordena2", "iguales" };
			String resp = (String) JOptionPane.showInputDialog(null, "Seleccione un m�todo:",
					"Opciones para el usuario", JOptionPane.DEFAULT_OPTION, null, metodos, metodos[0]);
			switch (resp) {
			case "inicia1":
				MetodosDeArreglos.inicia1(arregloNumeros);
				break;
			case "inicia2":
				MetodosDeArreglos.inicia2(arregloNumeros);
				break;
			case "inicia3":
				MetodosDeArreglos.inicia3(ArrB);
				break;
			case "cuentaNumerosNegativos":
				negativos = MetodosDeArreglos.cuentaNumerosNegativos(Arr);
				JOptionPane.showMessageDialog(null, "La canidad de n�meros negativos en el arreglo es : " + negativos);
				break;
			case "sumaImpar":
				suma = MetodosDeArreglos.sumaImpar(Arr);
				JOptionPane.showMessageDialog(null, "La suma de los valores impares del arreglo es: " + suma);
				break;
			case "cuentaRepeticiones":
				repeticiones = MetodosDeArreglos.cuentaRepeticiones(Arr, x);
				JOptionPane.showMessageDialog(null,
						"El numero '" + x + "' se repiti� " + repeticiones + " vez/veces en el arreglo.");
				break;
			case "sustituye":
				MetodosDeArreglos.sustituye(Arr, old, nuevo);
				break;
			case "intercambia":
				MetodosDeArreglos.intercambia(A, i, j);
				break;
			case "invierte":
				MetodosDeArreglos.invierte(Arr);
				break;
			case "rotaDerecha":
				MetodosDeArreglos.rotaDerecha(A);
				break;
			case "mayor":
				mayor = MetodosDeArreglos.mayor(A, inf, sup);
				if (mayor == 999999999) {
					JOptionPane.showMessageDialog(null, "Hubo un error en el ingreso de los parametros");
				} else {
					JOptionPane.showMessageDialog(null,
							"El numero de mayor valor dentro de los parametros dados es: " + mayor);
				}
				break;
			case "posMayor":
				posicion = MetodosDeArreglos.posMayor(A, inf, sup);
				if (posicion == 999999999) {
					JOptionPane.showMessageDialog(null, "Hubo un error en el ingreso de los parametros");
				} else {
					JOptionPane.showMessageDialog(null, "El valor mayor se encuentra en la posicion: " + (posicion + 1)
							+ ".\nBajo el subindice " + posicion);
				}
				break;
			case "ordena2":
				MetodosDeArreglos.ordena2(A);
				break;
			case "iguales":
				respuesta = MetodosDeArreglos.iguales(A1, A2);
				if (respuesta) {
					JOptionPane.showMessageDialog(null, "Los arreglos SI son iguales.");
				} else {
					JOptionPane.showMessageDialog(null, "Los arreglos NO son iguales.");
				}
				break;
			}

			usuario = JOptionPane.showConfirmDialog(null, "¿Quiere probar otro método?", " ", JOptionPane.YES_NO_OPTION);
		} while (usuario == 0);
	}
}