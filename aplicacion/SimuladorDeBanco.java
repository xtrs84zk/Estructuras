package aplicacion;
import estructuras.Queue;
import estructuras.QueueUnlimited;

import java.util.Random;
import java.util.Scanner;

/** Created by xtrs84zk on 06/11/2016. **/
public class SimuladorDeBanco {
    /** Declaración de variables de clase **/
    private static Queue filaDelBanco;
    private static Random rdn = new Random();
    private static int tiempoLimite, tiempoActual, turno, cantidadDeCajasAbiertas, caja[];

    public static void main (String [] args){
        //Declaración de variables y creación de objetos.
        int dia, probabilidad;
        Scanner s = new Scanner(System.in);
        //Pidiendo y asignando la cantidad de horas que el banco abrirá
        System.out.print("¿Cuántas horas estará abierto el banco?");
        tiempoLimite= (s.nextInt()*3600);
        //Pidiendo y asignando la cantidad de cajas que estarán abiertas
        System.out.print("¿Cuántas cajas estarán abiertas?");
        cantidadDeCajasAbiertas = s.nextInt();
        //Inicializando la fila del banco, el tiempo actual, las cajas que se abrirán y el turno.
        filaDelBanco  = new QueueUnlimited();
        tiempoActual= 0;
        turno = 1;
        caja = new int[cantidadDeCajasAbiertas];
        //Pidiendo el día actual para ponderar la probabilidad de que lleguen
        //nuevos clientes o sean atendidos los que están en el banco.
        do{
            System.out.println("¿Qué día es?");
            dia = s.nextInt();
        }while(dia>31 || dia<1);
        if(dia == 15 || dia == 30){
            probabilidad = rdn.nextInt(25)+70;
        } else {
            probabilidad = 60;
        }
        //Mientras el tiempo a abrir el banco no sea excedido, los clientes pueden
        //llegar y ser atendidos.
        do{
            tiempoActual += rdn.nextInt(300);
            System.out.print("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
            decidirSiLlegaOSaleUnCliente(probabilidad);
        }while(tiempoActual<= tiempoLimite);
        //Si el tiempo ha sobrepasado el tiempo que el banco debe estar abierto,
        // se dejan de aceptar nuevos clientes y se comienza a vaciar la fila.
        if(tiempoActual>tiempoLimite){
            try {
                while (!filaDelBanco.isEmpty()) {
                    elClienteLlegaAlaCaja();
                }
            }catch(Exception e){
                System.out.print("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
                System.out.println("La fila del banco está vacía.");
            }
        }
        //Una vez que se ha vaciado la fila, se revisa que las cajas estén vacías
        //y se atiende a los clientes remanentes.
            while(!lasCajasEstanVacias()){
                atenderClientes();
            }
        System.out.print("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
        System.out.println("El banco ha terminado sus actividades.");
    }
    /** Método que decide si llegan nuevos clientes o son atendidos los que ya están ahí.
     * Recibe la probabilidad de que un nuevo cliente llegue.
     * En caso de ser invocado cuando el tiempo ha terminado, no puede recibir más clientes
     * así que comienza a pasar los clientes que estén en la fila hacía las cajas para ser atendidos.**/
    private static void  decidirSiLlegaOSaleUnCliente(int probabilidad){
        if(tiempoActual<=tiempoLimite){
            int auxiliar = rdn.nextInt(99)+1;
            if(auxiliar<=probabilidad){
                llegadaDeClienteAlBanco();
            } else {
                try {
                    elClienteLlegaAlaCaja();
                }catch(Exception e){
                    System.err.println("Ya no hay clientes en la fila.");
                }
            }
        } else {
            try {
                while (!filaDelBanco.isEmpty()) {
                    elClienteLlegaAlaCaja();
                }
            }catch(Exception e){
                System.err.println("Ya no hay clientes en la fila.");
            }
        }
    }
    /** Método llegadaDeClienteAlBanco que introduce un nuevo cliente a la fila del banco.
     * Muestra el tiempo en que dicho cliente llega y lo agrega a la fila.
     * Ademas incrementa el turno actual.**/
    private static  void llegadaDeClienteAlBanco(){
        tiempoActual += rdn.nextInt(300);
        System.out.print("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
        System.out.println("Llega el cliente " + ++turno + " al banco.");
        filaDelBanco.insert(turno);
    }
    /** Método elClienteLlegaALaCaja que se encarga de pasar clientes a la caja.
     * En caso de que no haya clientes en la fila, lanza una excepcion.
     * Define a qué caja pasará el cliente con base en las cajas abiertas
     * y a las cajas que estén vacías en dicho momento.**/
    private static void elClienteLlegaAlaCaja() throws Exception{
        int cajaQueSeUsara;
        do{
            cajaQueSeUsara = rdn.nextInt(cantidadDeCajasAbiertas);
        }while(caja[cajaQueSeUsara] != 0);
            System.out.println("------ " + tiempoActual / 60 + ":" + tiempoActual % 60 + "------");
            System.out.println("El cliente " + filaDelBanco.front() +
                    "pasa a la caja +" + cajaQueSeUsara);
            caja[cajaQueSeUsara] = (int) filaDelBanco.extract();
            atenderClientes();
    }
    /** Método atenderClientes que se encarga de atender los clientes en las cajas.
     * Define qué cliente atender con base en la cantidad de cajas ocupadas.
     * Imprime el momento en que un cliente es atendido, junto con su turno.
     * Finalmente, vacía la caja en la que estuvo el cliente.**/
    private static void atenderClientes(){
        tiempoActual += rdn.nextInt(300);
        System.out.println("------ " + tiempoActual/60 +  ":" + tiempoActual%60 + "------");
        int laCajaQueSeVaciaraPorqueElClienteYaFueAtendido;
        do{
            laCajaQueSeVaciaraPorqueElClienteYaFueAtendido = rdn.nextInt(cantidadDeCajasAbiertas);
        }while(caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] == 0);
        System.out.println("El cliente " + caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] +
                "ha sido atendido y saldrá del banco. ");
        caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] = 0;
    }

    /** Método lasCajasEstanVacias que devuelve un valor falso cuando alguna de
     * alguna de las cajas está ocupada y uno positivo cuando todas están vacías.**/
    private static boolean lasCajasEstanVacias() {
        for(int i = 0; i<cantidadDeCajasAbiertas; i++) {
            if (caja[i] != 0) return false;
        }
        return true;
    }
}
