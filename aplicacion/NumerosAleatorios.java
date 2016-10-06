package aplicacion;
import java.util.Arrays;
import java.util.Random;

/** Created by Xavier Sánchez on 06/10/2016. **/
public class NumerosAleatorios {
    public static void main(String[] args) {
        Random rdn = new Random();
        int random;
        int[] aleatorios = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] usados = new int[10];
            for (int j = aleatorios.length-1; j >= 0; j--) {
                random = rdn.nextInt(10);
                if (Arrays.asList(usados).contains(random)) {
                    j++;
                } else {
                    usados[j] = random;
                    int temporal = aleatorios[j];
                    aleatorios[j] = aleatorios[random];
                    aleatorios[random] = temporal;
                }
            }
        for (int aleatorio : aleatorios) System.out.print(aleatorio + ", ");
    }
}