package dominio;

public class MetodosDeArreglos {
    int n; //aquí se va a almacenar la longitud del arreglo

    /**
     * Método que recibe un arreglo de enteros y le asigna a cada localidad los valores 0,3,6,..,3*n-1
     * donde n es la longitud del arreglo.
     *
     * @param arregloNumeros que es un arrreglo de valores int
     * @return no tiene valor de retorno
     */
    public void inicia1(int arregloNumeros[]) {
        n = arregloNumeros.length;
        for (int i = 0; i < arregloNumeros.length; i++) {
            arregloNumeros[i] = (3 * i) - 1;
        }
    }

    /**
     * Método que que recibe un arreglo de enteros y le asigna a cada localidad los valores
     * n-1, n-2,...,2,1,0   donde n es la longitud del arreglo.
     *
     * @param arregloNumeros que es un arreglo de valores enteros
     * @return no tiene retorno
     */
    public void inicia2(int arregloNumeros[]) {
        n = arregloNumeros.length;
        for (int i = 1; i < n; i++) {
            arregloNumeros[i] = (n - i);
        }
    }

    /**
     * Método que crea un arreglo de boolean's y lo va inicializando.
     *
     * @param Arr que es un arreglo de valores tipo boolean
     * @return no tiene retorno
     */
    public void inicia3(boolean Arr[]) {
        n = Arr.length;

        //arr[i] = i%2 != 0;
        for (int i = 1; i < n; i++) {
            int k = i % 2;
            if (i == 0) {
                Arr[i] = false;
            } else if (i == 1) {
                Arr[i] = true;
            } else if (k == 1) {
                Arr[i] = true;
            } else if (k == 0) {
                Arr[i] = false;
            }
        }
    }

    /**
     * Método que recibe un arreglo de enteros y regresa el número menores de cero que se encuentran dentro del arreglo.
     *
     * @param Arr que es un arreglo de enteros
     * @return void
     */
    public int cuentaNumerosNegativos(int Arr[]) {
        n = Arr.length;
        int A = 0;
        for (int i = 0; i < n; i++) {
            if (Arr[i] < 0) {
                A = A + 1;
            }
        }
        return A;
    }

    /**
     * Método que recibe un arreglo de enteros y regresa el resultado de sumar sólo los números impares que hay dentro del arreglo.
     *
     * @param Arr que es un arreglo de valores tipo boolean
     * @return suma que es el valor de la suma entre los valores impares.
     */
    public int sumaImpar(int Arr[]) {
        n = Arr.length;
        int suma = 0;
        for (int i = 0; i < n; i++) {
            int k = Arr[i] % 2;
            if (k == 1) {
                suma = suma + Arr[i];
            }
        }
        return suma;
    }

    /**
     * Método que recibe un arreglo de enteros y un valor entero x. La función regresa el número de veces que se repite el valor de x en el arreglo.
     *
     * @param Arr, x donde Arr es un arreglo de enteros y x el número que se comprobará.
     * @return repeticiones que es el número de veces que aparece el número en el arreglo.
     */
    public int cuentaRepeticiones(int Arr[], int x) {
        n = Arr.length;
        int repeticiones = 0;
        for (int i = 0; i < n; i++) {
            if (x == Arr[i]) {
                repeticiones++;
            }
        }
        return repeticiones;
    }

    /**
     * Método que recibe un arreglo de enteros y dos valores enteros old y nuevo. El método debe reemplazar todos los valores old del arreglo por el valor de nuevo.
     *
     * @param Arr, old, nuevo donde Arr es un arreglo de enteros, old el valor que será reemplazado y nuevo el valor que se pondrá en su lugar.
     * @return no tiene retorno
     */
    public void sustituye(int Arr[], int old, int nuevo) {
        n = Arr.length;
        for (int i = 0; i < n; i++) {
            if (Arr[i] == old) {
                Arr[i] = nuevo;
            }
        }
    }

    /**
     * Método que recibe un arreglo de enteros y dos valores enteros que corresponden a dos localidades del arreglo.
     *
     * @param A, i, j donde A[] es un arreglo de enteros, i y j son los valores que intercambiarán lugares
     * @return no tiene retorno
     */
    public void intercambia(int A[], int i, int j) {
        int z = 0;
        z = A[i];
        A[i] = A[j];
        A[j] = z;
    }

    /**
     * Método que recibe un arreglo de enteros. El método invierte la secuencia de valores del arreglo
     *
     * @param Arr que es un arreglo de enteros
     * @return no tiene retorno
     */
    public void invierte(int Arr[]) {
        n = Arr.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[n - i] = Arr[i];
        }
        for (int i = 0; i < n; i++) {
            Arr[i] = B[i];
        }
    }

    /**
     * Método que recibe un arreglo de enteros.
     * El método mueve a cada elemento una posición adelante, colocando el último valor del arreglo en la primera localidad del arreglo resultante.
     *
     * @param A que es un arreglo de enteros
     * @return no tiene retorno
     */
    public void RotaDerecha(int A[]) {
        n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == n) {
                B[0] = A[n];
            } else {
                B[i + 1] = A[i];
            }
        }
    }

    /**
     * Método que recibe un arreglo de enteros y dos valores enteros inf y sup.
     * La función regresa el mayor valor del arreglo dentro del rango definido por inf y sup.
     *
     * @param A, inf, sup donde A[] es un arreglo de enteros, inf el número inferior en el rango y sup el superior.
     * @return mayor que es la posición con el mayor valor dentro del arreglo.
     */
    public int mayor(int A[], int inf, int sup) {
        int mayor = 0;
        for (int i = inf; i < sup; i++) {
            if (A[i] > mayor) {
                mayor = A[i];
            }
        }
        return mayor;
    }

    /**
     * Método que recibe un arreglo de enteros y dos valores enteros inf y sup.
     * La función regresa la posición de la localidad que contiene al mayor valor del arreglo.
     *
     * @param A, inf, sup donde A[] es un arreglo de enteros y "inf y sup" definen el rango.
     * @return pos que es la posición en que se encuentra el mayor valor.
     */
    public int posMayor(int A[], int inf, int sup) {
        int mayor = 0;
        int pos = 0;
        for (int i = inf; i < sup; i++) {
            if (A[i] > mayor) {
                mayor = A[i];
                pos = i;
            }
        }
        return pos;
    }

    /**
     * Método que recibe dos arreglos de enteros y el método regresa true si los dos arreglos contienen la misma secuencia de valores y false de otra manera.
     *
     * @param A1, A2 que son arreglos de tipo boolean
     * @return p que define si ambos arreglos son iguales o no.
     */
    public boolean iguales(int A1[], int A2[]) {
        boolean p = false;
        if (A1.length == A2.length) {
            for (int i = 0; i < n; i++) {
                if (A1[i] == A2[i]) {
                    p = true;
                } else {
                    p = false;
                    break;
                }
            }
        } else {
            p = false;
        }
        return p;
    }
}