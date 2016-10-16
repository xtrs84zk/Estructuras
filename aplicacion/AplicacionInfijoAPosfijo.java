package aplicacion;

import estructuras.InfijoAPosfijo;

import java.util.Scanner;

/** Created by xtrs84zk on 16/10/2016. **/
public class AplicacionInfijoAPosfijo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la expresión: ");
        try {
            InfijoAPosfijo expresion = new InfijoAPosfijo(entrada.next());
            System.out.print(expresion.convertirInfijoAPosfijo());
        } catch (Exception e){
            System.out.println(e.toString() );
        } finally {
            System.out.println("");
        }
    }
}
