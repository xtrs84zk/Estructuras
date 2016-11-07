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
    private static int tiempoLimite, tiempoActual, turno, cantidadDeCajasAbiertas;
    private static Object[] caja;

    public static void main (String [] args){
        //Declaración de variables y creación de objetos.
        int dia, probabilidad;
        Scanner s = new Scanner(System.in);
        //Pidiendo y asignando la cantidad de horas que el banco abrirá
        do {
            System.out.print("¿Cuántas horas estará abierto el banco? ");
            tiempoLimite = s.nextInt();
        }while(tiempoLimite<0 || tiempoLimite>7);
        //Convirtiendo las horas elegidas a segundos.
        tiempoLimite*=3600;
        //Pidiendo y asignando la cantidad de cajas que estarán abiertas
        System.out.print("¿Cuántas cajas estarán abiertas? ");
        cantidadDeCajasAbiertas = s.nextInt();
        //Inicializando la fila del banco, el tiempo actual, las cajas que se abrirán y el turno.
        filaDelBanco  = new QueueUnlimited();
        tiempoActual= 0;
        turno = 0;
        caja = new Object[cantidadDeCajasAbiertas];
        //Pidiendo el día actual para ponderar la probabilidad de que lleguen
        //nuevos clientes o sean atendidos los que están en el banco.
        do{
            System.out.print("¿Qué día del mes es? ");
            dia = s.nextInt();
        }while(dia>31 || dia<1);
        if(dia == 15 || dia == 30){
            probabilidad = rdn.nextInt(25)+70;
        } else {
            probabilidad = 60;
        }
        imprimirElTiempoActual();
        System.out.println("El banco abre sus puertas.");
        //Mientras el tiempo a abrir el banco no sea excedido, los clientes pueden
        //llegar y ser atendidos.
        do{
            tiempoActual += rdn.nextInt(300);
            decidirSiLlegaOSaleUnCliente(probabilidad);
        }while(tiempoActual<= tiempoLimite);
        //Si el tiempo ha sobrepasado el tiempo que el banco debe estar abierto,
        // se dejan de aceptar nuevos clientes y se comienza a vaciar la fila.
            try {
                while (!filaDelBanco.isEmpty()) {
                    elClienteLlegaAlaCaja();
                }
            }catch(Exception e){
                imprimirElTiempoActual();
            }
            System.out.println("La fila del banco está vacía.");

        //Una vez que se ha vaciado la fila, se revisa que las cajas estén vacías
        //y se atiende a los clientes remanentes.
            while(!lasCajasEstanVacias()) {
                try {
                    atenderClientes();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        imprimirElTiempoActual();
        System.out.println("Todos los clientes han sido atendidos.");
        System.out.println("El banco ha terminado sus actividades.");
    }
    /** Método que decide si llegan nuevos clientes o son atendidos los que ya están ahí.
     * Recibe la probabilidad de que un nuevo cliente llegue.**/
    private static void  decidirSiLlegaOSaleUnCliente(int probabilidad){
        if(tiempoActual<=tiempoLimite){
            int auxiliar = rdn.nextInt(99)+1;
            if(auxiliar<=probabilidad){
                llegadaDeClienteAlBanco();
            } else {
                //Mientras haya al menos una caja libre, los clientes pasan a caja.
                while(hayAlMenosUnaCajaLibre() && !filaDelBanco.isEmpty()){
                    try {
                        elClienteLlegaAlaCaja();
                    }catch(Exception ex){
                        System.err.print("");
                    }
                }
                try {
                    atenderClientes();
                }catch(Exception e) {
                    //Es normal que esta excepción se produzca.
                }
            }
        }
    }
    /** Método llegadaDeClienteAlBanco que introduce un nuevo cliente a la fila del banco.
     * Muestra el tiempo en que dicho cliente llega y lo agrega a la fila.
     * Ademas incrementa el turno actual.**/
    private static  void llegadaDeClienteAlBanco(){
        tiempoActual += rdn.nextInt(300);
        imprimirElTiempoActual();
        System.out.println("Llega el cliente " + ++turno + " al banco.");
        filaDelBanco.insert(turno);
    }
    /** Método elClienteLlegaALaCaja que se encarga de pasar clientes a la caja.
     * En caso de que no haya clientes en la fila, lanza una excepcion.
     * Define a qué caja pasará el cliente con base en las cajas abiertas
     * y a las cajas que estén vacías en dicho momento.**/
    private static void elClienteLlegaAlaCaja() throws Exception{
        int cajaQueSeUsara = rdn.nextInt(cantidadDeCajasAbiertas);
        //En caso de que haya cajas libres, "el cliente decide a cuál ir".
        if(hayAlMenosUnaCajaLibre()){
            while(caja[cajaQueSeUsara] != null){
                cajaQueSeUsara = rdn.nextInt(cantidadDeCajasAbiertas);
            }
        } else {
            throw new Exception("No hay cajas libres.");
        }
            imprimirElTiempoActual();
            System.out.println("El cliente " + filaDelBanco.front() + " pasa a la caja " + (cajaQueSeUsara+1));
            caja[cajaQueSeUsara] = filaDelBanco.extract();
            atenderClientes();
    }
    /** Método atenderClientes que se encarga de atender los clientes en las cajas.
     * Define qué cliente atender con base en la cantidad de cajas ocupadas.
     * Imprime el momento en que un cliente es atendido, junto con su turno.
     * Finalmente, vacía la caja en la que estuvo el cliente.**/
    private static void atenderClientes()throws Exception{
        int cajaAVaciarPorqueElClienteYaFueAtendido;
        if(lasCajasEstanVacias()) throw new Exception("Todas las cajas están vacías.");
        do{
            cajaAVaciarPorqueElClienteYaFueAtendido = rdn.nextInt(cantidadDeCajasAbiertas);
            if(caja[cajaAVaciarPorqueElClienteYaFueAtendido] != null) break;
        }while(true);
        tiempoActual += rdn.nextInt(300);
        imprimirElTiempoActual();
        System.out.println("El cliente con turno " + caja[cajaAVaciarPorqueElClienteYaFueAtendido] +
                           " ha sido atendido y saldrá del banco. ");
        caja[cajaAVaciarPorqueElClienteYaFueAtendido] = null;
    }
    /** Método lasCajasEstanVacias que devuelve un valor falso cuando alguna de
     * alguna de las cajas está ocupada y uno positivo cuando todas están vacías.**/
    private static boolean lasCajasEstanVacias() {
        for(int i = 0; i<caja.length; i++){
            if(caja[i] != null) return false;
        }
            return true;
    }
    /** Método hayAlMenosUnaCajaLibre que verifica que haya al menos una caja libre.
     *  En caso de encontrar al menos una caja libre, regresa true.
     *  Al no encontrar cajas libres, regresará false.**/
    private static boolean hayAlMenosUnaCajaLibre(){
        //Se verifica que haya cajas libres de una en una.
        for(int i = 0; i<caja.length; i++){
            if(caja[i] != null) return false;
        }
        return true;
    }
    /** Método imprimirElTiempoActual que imprime el tiempo actual.
     * No tiene valores de retorno ni recibe parámetros.**/
    private static void imprimirElTiempoActual(){
        String horas = tiempoActual/3600 + "";
        if(horas.length()<2) horas = 0 + "" + horas;
        String minutos = (tiempoActual%3600)/60 + "";
        if(minutos.length()<2) minutos = 0 + "" + minutos;
        String segundos = (tiempoActual%3600)%60 +"";
        if(segundos.length()<2) segundos = 0 + "" + segundos;
        System.out.println("--------------- " + horas + ":" + minutos + ":" + segundos + " ---------------");
    }
}