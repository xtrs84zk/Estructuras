package estructuras;

/**
 * Clase que contiene metodos generales de arreglos, tales como: inicia1,
 * inicia2, inicia3, cuentaNumerosNegativos, sumaImpar, cuentaRepeticiones,
 * sustituye, intercambia, invierte, rotaDerecha, mayor, posMayor, ordena2,
 * iguales.
 */

public class MetodosDeArreglos extends Object {
	// 1. Declaracion de los arreglos del punto 1
	float[] A1 = new float[100000];
	boolean[] A2 = new boolean[7];
	int[] A3 = new int[450];
	String[] A4 = new String[150];

	/**
	 * Constuctor de la clase con valores por default
	 */
	private MetodosDeArreglos() {
		super();
	}

	/**
	 * 3. a) Método que recibe un arreglo de enteros y le asigna a cada
	 * localidad los valores 0,3,6,..,3*n-1. Donde n es la longitud del arreglo.
	 * 
	 * @param arregloNumeros[]
	 *            que es un arrreglo de variables int
	 * @return no tiene valor de retorno
	 */
	public static void inicia1(int arregloNumeros[]) {
		for (int i = 0; i < arregloNumeros.length; i++)
			arregloNumeros[i] = (3 * i) - 1;
	}

	/**
	 * 3. b) Método que que recibe un arreglo de enteros y le asigna a cada
	 * localidad los valores n-1, n-2,...,2,1,0 donde n es la longitud del
	 * arreglo.
	 * 
	 * @param arregloNumeros[]
	 *            que es un arreglo de valores enteros
	 * @return no tiene valor retorno.
	 */
	public static void inicia2(int arregloNumeros[]) {
		for (int i = 1; i < arregloNumeros.length; i++)
			arregloNumeros[i] = (arregloNumeros.length - i);
	}

	/**
	 * 3. c) Método que crea un arreglo boolean y lo va inicializando.
	 * 
	 * @param ArrB[]
	 *            que es un arreglo de valores tipo boolean
	 * @return no tiene valor de retorno
	 */
	public static void inicia3(boolean ArrB[]) {
		// arr[i] = i%2 != 0;
		for (int i = 1; i < ArrB.length; i++) {
			int j = i % 2;
			if (i == 0) {
				ArrB[i] = false;
			} else if (i == 1) {
				ArrB[i] = true;
			} else if (j == 0) {
				ArrB[i] = false;
			} else if (j == 1) {
				ArrB[i] = true;
			}
		}
	}

	/**
	 * 4. a) Método que recibe un arreglo de enteros y regresa el número menores
	 * de cero que se encuentran dentro del arreglo.
	 * 
	 * @param Arr[]
	 *            que es un arreglo de enteros
	 * @return negativos entero que muestra la cantidad de numeros negativos
	 */
	public static int cuentaNumerosNegativos(int Arr[]) {
		int negativos = 0;
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] < 0) {
				negativos++;
			}
		}
		return negativos;
	}

	/**
	 * 4. b) Método que recibe un arreglo de enteros y regresa el resultado de
	 * sumar sólo los números impares que hay dentro del arreglo.
	 * 
	 * @param Arr[],
	 *            que es un arreglo de valores tipo entero.
	 * @return suma, valor entero que es el valor de la suma entre los valores
	 *         impares.
	 */
	public static int sumaImpar(int Arr[]) {
		int suma = 0;
		for (int i = 0; i < Arr.length; i++) {
			int j = Arr[i] % 2;
			if (j == 1 || j == -1) {
				suma += Arr[i];
			}
		}
		return suma;
	}

	/**
	 * 4. c) Método que recibe un arreglo de enteros y un valor entero x. La
	 * función regresa el número de veces que se repite el valor de x en el
	 * arreglo.
	 * 
	 * @param Arr[],x
	 *            donde Arr es un arreglo de enteros y x el número que se
	 *            comprobará.
	 * @return repeticiones, valor entero que es el número de veces que aparece
	 *         el número en el arreglo.
	 */
	public static int cuentaRepeticiones(int Arr[], int x) {
		int repeticiones = 0;
		for (int i = 0; i < Arr.length; i++) {
			if (x == Arr[i]) {
				repeticiones++;
			}
		}
		return repeticiones;
	}

	/**
	 * 4. d) Método que recibe un arreglo de enteros y dos valores enteros old y
	 * nuevo. El método debe reemplazar todos los valores old del arreglo por el
	 * valor de nuevo.
	 * 
	 * @param Arr[],old,nuevo
	 *            Donde Arr es un arreglo de enteros, old el valor que será
	 *            reemplazado, y nuevo, el valor que se pondrá en su lugar.
	 * @return sin valores de retorno
	 */
	public static void sustituye(int Arr[], int old, int nuevo) {
		if (old >= 0 && old < Arr.length && nuevo >= 0 && nuevo < Arr.length) {
			for (int i = 0; i < Arr.length; i++) {
				if (Arr[i] == old) {
					Arr[i] = nuevo;
				}
			}
		}
	}

	// Ejercicios propuestos con arreglos

	/**
	 * 1. Método que recibe un arreglo de enteros y dos valores enteros que
	 * corresponden a dos localidades del arreglo.
	 * 
	 * @param A[],i,j
	 *            Donde A[] es un arreglo de enteros, i y j son los valores que
	 *            intercambiarán lugares
	 * @return sin valores de retorno
	 */
	public static void intercambia(int A[], int i, int j) {
		if (i >= 0 && i < A.length && j >= 0 && j < A.length) {
			int aux1 = A[i];
			A[i] = A[j];
			A[j] = aux1;
		}
	}

	/**
	 * 2. Método que recibe un arreglo de enteros. El método invierte la
	 * secuencia de valores del arreglo
	 * 
	 * @param Arr[]
	 *            que es un arreglo de enteros
	 * @return sin valores de retorno
	 */
	public static void invierte(int Arr[]) {
		int[] aux = new int[Arr.length];
		for (int i = 0; i < Arr.length; i++)
			aux[Arr.length - (i + 1)] = Arr[i];
		for (int i = 0; i < Arr.length; i++)
			Arr[i] = aux[i];
	}

	/**
	 * 3. Método que recibe un arreglo de enteros. El método mueve a cada
	 * elemento una posición adelante, colocando el último valor del arreglo en
	 * la primera localidad del arreglo resultante.
	 * 
	 * @param A[]
	 *            que es un arreglo de enteros
	 * @return no tiene retorno
	 */
	public static void rotaDerecha(int A[]) {
		int aux = A[A.length - 1];
		for (int i = A.length - 1; i > 0; i--) {
			A[i] = A[i - 1];
		}
		A[0] = aux;
	}

	/**
	 * 4. Método que recibe un arreglo de enteros y dos valores enteros inf y
	 * sup. La función regresa el mayor valor del arreglo dentro del rango
	 * definido por inf y sup.
	 * 
	 * @param A[],inf,sup
	 *            Donde A[] es un arreglo de enteros, inf el número inferior en
	 *            el rango y sup el superior.
	 * @return mayor, variable entero con el mayor valor dentro del arreglo.
	 */
	public static int mayor(int A[], int inf, int sup) {
		int mayor = 0;
		if (inf >= 0 && inf < A.length && sup >= inf && sup < A.length) {
			for (int i = inf; i < sup; i++) {
				if (A[i] > mayor) {
					mayor = A[i];
				}
			}
		}else{
			mayor = 999999999;
		}
		return mayor;
	}

	/**
	 * 5. Método que recibe un arreglo de enteros y dos valores enteros inf y
	 * sup. La función regresa la posición de la localidad que contiene al mayor
	 * valor del arreglo.
	 * 
	 * @param A[],inf,sup
	 *            Donde A[] es un arreglo de enteros y "inf y sup" definen el
	 *            rango.
	 * @return posicion, que es la posición en que se encuentra el mayor valor.
	 */
	public static int posMayor(int A[], int inf, int sup) {
		int mayor = inf;
		int posicion = 0;
		if (inf >= 0 && inf < A.length && sup >= inf && sup < A.length) {
			for (int i = inf; i < sup; i++) {
				if (A[i] > mayor) {
					posicion = i;
				}
			}
		}else{
			posicion = 999999999;
		}
		return posicion;
	}

	/**
	 * 6. Método que recibe un arreglo de enteros y los ordena de mayor a menor.
	 * 
	 * @param A[]
	 *            Que es un arreglo de enteros
	 * @return Sin valores de retorno
	 */
	public static void ordena2(int A[]) {
		int aux;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[j] < A[i]) {
					aux = A[i];
					A[i] = A[j];
					A[j] = aux;
				}
			}
		}
	}

	/**
	 * 7. Método que recibe dos arreglos de enteros y el método regresa true si
	 * los dos arreglos contienen la misma secuencia de valores y false de otra
	 * manera.
	 * 
	 * @param A1[],A2[]
	 *            que son arreglos de tipo entero
	 * @return respuesta, que define si ambos arreglos son iguales o no.
	 */
	public static boolean iguales(int A1[], int A2[]) {
		boolean respuesta = false;
		if (A1.length == A2.length) {
			for (int i = 0; i < A1.length; i++) {
				if (A1[i] == A2[i]) {
					respuesta = true;
				} else {
					respuesta = false;
					break;
				}
			}
		}
		return respuesta;
	}
}