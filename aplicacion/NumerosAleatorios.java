package aplicacion;
import java.util.Arrays;
import java.util.Random;
/** Created by Xavier Sánchez on 06/10/2016. **/
public class NumerosAleatorios {
    public static void main(String[] args) {
        Random rdn = new Random();
        int random; //Declarando la variable random
        int[] aleatorios = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //Declarar y llenar el arreglo que será "randomizado"
        int[] usados = new int[10]; //Arreglo donde se guardarán los números ya movidos
        for (int j = aleatorios.length - 1; j >= 0; j--) { //Recorriendo el arreglo de diez.
            random = rdn.nextInt(10); //Generando un número aleatorio cada vez.
            if (Arrays.asList(usados).contains(random)) { //Si se ha usado el número aleatorio generado
                j++; //Incrementar j para no afectar al for
            } else { //Si el número aleatorio no se ha usado
                usados[j] = random; //Agregar dicho aleatorio al arreglo usados
                int temporal = aleatorios[j]; //Salvando el valor en la posición a alterar
                aleatorios[j] = aleatorios[random]; //Moviendo el valor en la posición aleatoria a la posición j
                aleatorios[random] = temporal; //Guardando el valor original de la posición j en la posición aleatoria.
            }
        }
        for (int aleatorio : aleatorios) System.out.print(aleatorio + ", "); /* Foreach que recorre el arreglo de aleatorio y lo muestra.*/
    }
}