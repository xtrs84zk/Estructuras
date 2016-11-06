package aplicacion;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/** Created by xtrs84zk on 06/11/2016. **/
public class SimuladorDeBanco {
    static Queue filaDelBanco;
    static Random rdn = new Random();
    static int turno;
    static int numeroDeCajasAbiertas;
    static int[] caja;
    static int tiempoLimite, tiempoActual,  dia, probabilidad;

    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("¿Cuánto estará abierto el banco?");
        tiempoLimite= s.nextInt();
        System.out.print("¿Cuántas cajas estarán abiertas?");
        numeroDeCajasAbiertas = s.nextInt();
        filaDelBanco  = new QueueUnlimited();
        tiempoActual= 0;
        turno = 1;
        caja = new int[numeroDeCajasAbiertas];
        do{
            System.out.println("¿Qué día es?");
            dia = s.nextInt();
        }while(dia>31 || dia<1);
        if(dia == 15 || dia == 30){
            probabilidad = rdn.nextInt(25)+70;
        } else {
            probabilidad = 60;
        }
        do{
            tiempoActual += rdn.nextInt(300);
            System.out.print("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
            decidirSiLlegaOSaleUnCliente(probabilidad);
        }while(tiempoActual<= tiempoLimite);
        if(tiempoActual>tiempoLimite){
            while(!filaDelBanco.isEmpty()){
                elClienteLlegaAlaCaja();
            }
        }
            while(!lasCajasEstanVacias()){
                atenderClientes();
            }

    }
    private static void  decidirSiLlegaOSaleUnCliente(int probabilidad){
        if(tiempoActual<=tiempoLimite){
            int auxiliar = rdn.nextInt(99);
            if(auxiliar<=probabilidad){

                llegadaDeClienteAlBanco();
            } else {
                elClienteLlegaAlaCaja();
            }
        } else {
            while(!filaDelBanco.isEmpty(){
                elClienteLlegaAlaCaja();
            }
        }
    }

    private static  void llegadaDeClienteAlBanco(){
        tiempoActual += rdn.nextInt(300);
        System.out.print("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
        System.out.println("Llega el cliente " + ++turno + " al banco.");
        filaDelBanco.insert(turno);
    }

    private static void elClienteLlegaAlaCaja(){
        int cajaQueSeUsara;
        do{
            cajaQueSeUsara = rdn.nextInt(numeroDeCajasAbiertas);
        }while(caja[cajaQueSeUsara] != 0);
        System.out.println("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
        System.out.println("El cliente " + (int) filaDelBanco.front() +
                "pasa a la caja +" + cajaQueSeUsara);
        caja[cajaQueSeUsara] = (int) filaDelBanco.extract();
        atenderClientes();
    }

    private static void atenderClientes(){
        tiempoActual += rdn.nextInt(300);
        System.out.println("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
        int laCajaQueSeVaciaraPorqueElClienteYaFueAtendido;
        do{
            laCajaQueSeVaciaraPorqueElClienteYaFueAtendido = rdn.nextInt(numeroDeCajasAbiertas);
        }while(caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] == 0);
        System.out.println("El cliente " + caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] +
                "ha sido atendido y saldrá del banco. ");
        caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] = 0;
    }

    private static boolean lasCajasEstanVacias() {
        for(int i = 0; i<numeroDeCajasAbiertas; i++) {
            if (caja[i] != 0) return false;
        }
        return true;
    }
}
