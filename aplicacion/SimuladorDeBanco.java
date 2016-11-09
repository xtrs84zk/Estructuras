package aplicacion;
import estructuras.Queue;
import estructuras.QueueUnlimited;
import java.util.Random;
import java.util.Scanner;
/** Created on 06/11/2016. **/
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
        System.out.println("-------------------  Bienvenido al Banco BankIt. -------------------");
        //Pidiendo y asignando la cantidad de horas que el banco abrirá
        do {
            System.out.print("¿Cuántas horas estará abierto el banco? ");
            tiempoLimite = s.nextInt();
        }while(tiempoLimite<0 || tiempoLimite>7);
        //Comienza el día a las nueve de la mañana.
        tiempoActual= 32400;
        //Convirtiendo las horas elegidas a segundos y agregando nueve horas que es la hora a la que abre el banco.
        tiempoLimite *= 3600;
        tiempoLimite += 32400;
        //Pidiendo y asignando la cantidad de cajas que estarán abiertas
        System.out.print("¿Cuántas cajas estarán abiertas? ");
        cantidadDeCajasAbiertas = s.nextInt();
        //Inicializando la fila del banco, las cajas que se abrirán y el turno.
        filaDelBanco  = new QueueUnlimited();
        turno = 0;
        caja = new Object[cantidadDeCajasAbiertas];
        //Pidiendo el día actual para ponderar la probabilidad de que lleguen
        //nuevos clientes o sean atendidos los que están en el banco.
        do{
            System.out.print("¿Qué día del mes es? ");
            dia = s.nextInt();
        }while(dia>31 || dia<1);
        //Según si es quincena o no, la probabilidad de que llegue un nuevo cliente variará.
        if(dia == 15 || dia == 30){
            //Si es quincena, la probabilidad oscilará entre 70% y 94%
            probabilidad = rdn.nextInt(25)+70;
        } else {
            //Si no es quincena, varia entre 50% y 64%
            probabilidad = rdn.nextInt(15) + 50;
        }
        //Se imprime la hora a la que el banco abre sus puertas, así como un mensaje.
        imprimirElTiempoActual();
        System.out.println("El banco abre sus puertas.");
        //Mientras el tiempo a abrir el banco no sea excedido, los clientes pueden
        //llegar y ser atendidos.
        do{
            tiempoActual += rdn.nextInt(60);
            decidirSiLlegaOSaleUnCliente(probabilidad);
        }while(tiempoActual<= tiempoLimite);
        //Si el tiempo ha sobrepasado el tiempo que el banco debe estar abierto,
        // se dejan de aceptar nuevos clientes y se comienza a vaciar la fila.
            try {
                while (!filaDelBanco.isEmpty()) {
                    //Mientras haya clientes en la fila, los pasa a caja hasta llenar las cajas.
                    elClienteLlegaAlaCaja();
                }
            }catch(Exception e){
                //La excepción será atrapada cuando las cajas estén llenas, en cuyo caso, se imprimira el tiempo actual.
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
            //
            int valorConElCualCompararLaProbabilidad = rdn.nextInt(99)+1;
            //En caso de que el valor con el cual comparar la probabilidad sea menor que ésta.
            if(valorConElCualCompararLaProbabilidad<=probabilidad){
                //Llega un nuevo cliente al banco.
                llegadaDeClienteAlBanco();
            } else {
                //En caso de que el valor sea mayor.
                try {
                    //Se intenta atender los clientes.
                    atenderClientes();
                }catch(Exception e) {
                    try {
                        //Si no hay clientes por atender, se intenta pasar clientes a la caja.
                        elClienteLlegaAlaCaja();
                    }catch(Exception exs){
                        System.err.print("");
                    }
                }
            }
            //Mientras haya al menos una caja libre, los clientes pasan a caja.
            while(hayAlMenosUnaCajaLibre() && !filaDelBanco.isEmpty()){
                try {
                    elClienteLlegaAlaCaja();
                }catch(Exception ex){
                    System.err.print("");
                }
            }
        }
    }
    /** Método llegadaDeClienteAlBanco que introduce un nuevo cliente a la fila del banco.
     * Muestra el tiempo en que dicho cliente llega y lo agrega a la fila.
     * Ademas incrementa el turno actual.**/
    private static  void llegadaDeClienteAlBanco(){
        if(tiempoActual<tiempoLimite-300)
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
            //Se busca una caja vacía.
            while(caja[cajaQueSeUsara] != null){
                cajaQueSeUsara = rdn.nextInt(cantidadDeCajasAbiertas);
            }
        } else { //En caso de no haber cajas libres, se lanza un mensaje de error.
            throw new Exception("No hay cajas libres.");
        }
        if(filaDelBanco.isEmpty()) {throw new Exception("No hay clientes en la fila");}
        //Se imprime el momento en que el cliente llega a la caja.
            imprimirElTiempoActual();
        //Se imprime cuál cliente pasa a cuál caja.
            System.out.println("El cliente " + filaDelBanco.front() + " pasa a la caja " + (cajaQueSeUsara+1));
            //Se pasa el cliente de la fila a la caja.
            caja[cajaQueSeUsara] = filaDelBanco.extract();
            //Se intenta atender clientes.
            atenderClientes();
    }
    /** Método atenderClientes que se encarga de atender los clientes en las cajas.
     * Define qué cliente atender con base en la cantidad de cajas ocupadas.
     * Imprime el momento en que un cliente es atendido, junto con su turno.
     * Finalmente, vacía la caja en la que estuvo el cliente.**/
    private static void atenderClientes()throws Exception{
        //Antes de comenzar a atender clientes, verifica que haya al menos un cliente por atender.
        if(lasCajasEstanVacias()) throw new Exception("Todas las cajas están vacías.");
        int cajaAVaciarPorqueElClienteYaFueAtendido;
        //Hace un recorrido por las cajas hasta encontrar algún cliente.
        do{
            cajaAVaciarPorqueElClienteYaFueAtendido = rdn.nextInt(cantidadDeCajasAbiertas);
            if(caja[cajaAVaciarPorqueElClienteYaFueAtendido] != null) break;
        }while(true);
        //Al encontrar algún cliente, incrementa el tiempo actual entre 0 y 299 segundos para simular
        //que el cliente ha realizado una operación que le llevó cierto tiempo.
        tiempoActual += rdn.nextInt(300);
        //Se muestra el momento en que el cliente termina de ser atendido.
        imprimirElTiempoActual();
        //Se muestra qué cliente fue atendido.
        System.out.println("El cliente con turno " + caja[cajaAVaciarPorqueElClienteYaFueAtendido] +
                           " ha sido atendido y saldrá del banco. ");
        //Finalmente, se vacía la caja poniendo un valor nulo en su lugar.
        caja[cajaAVaciarPorqueElClienteYaFueAtendido] = null;
    }
    /** Método lasCajasEstanVacias que devuelve un valor falso cuando alguna de
     * alguna de las cajas está ocupada y uno positivo cuando todas están vacías.**/
    private static boolean lasCajasEstanVacias() {
        //Se recorre el conjunto de cajas para verificar si hay alguna que no esté vacía.
        int i = 0;
        while (i<caja.length) {
            //Al encontrar que una caja contiene algún cliente, regresa false.
            if(caja[i] != null) return false;
            i++;
        }
        //Al terminar de verificar todas las cajas sin encontrar clientes, regresa true.
        return true;
    }
    /** Método hayAlMenosUnaCajaLibre que verifica que haya al menos una caja libre.
     *  En caso de encontrar al menos una caja libre, regresa true.
     *  Al no encontrar cajas libres, regresará false.**/
    private static boolean hayAlMenosUnaCajaLibre(){
        //No hay cajas libres a menos que se demuestre lo contrario.
        int i = 0;
        //Se verifica que haya al menos una caja libre de una en una.
        while (i<caja.length) {
            //Al encontrar una caja libre, regresa true.
            if(caja[i] == null) return true;
            i++;
        }
        //En caso de terminar de recorrer las cajas y no encontrar una vacía, regresa false.
        return false;
    }
    /** Método imprimirElTiempoActual que imprime el tiempo actual.
     * El tiempo actual está dado en segundos, al imprimirlo lo más conveniente
     * será hacerlo en horas, minutos y segundos. Para ello se necesita convertir
     * los segundos a cada unidad de tiempo. En caso de que algún valor tenga menos
     * de dos dígitos, se agrega un cero al inicio. Al hacer esto, se convierte el
     * 3757 en un ---------------01:02:37--------------- haciendo la comprensión
     * para el usuario final mas fácil.**/
    private static void imprimirElTiempoActual(){
        //Se divide entre 3600 tomando el cociente porque cada hora cuenta con 3600 segundos.
        //Después se convierte a un String para una manipulación más fácil.
        String horas = tiempoActual/3600 + "";
        //En caso de que la longitud de horas sea menor a dos, se agrega un cero al inicio.
        if(horas.length()<2) horas = 0 + horas;
        //Se toma el residuo de dividir el tiempo actual entre 3600 y se divide entre 60 para obtener los minutos
        String minutos = (tiempoActual%3600)/60 + "";
        //En caso de que la longitud de minutos sea menor a dos, se agrega un cero al inicio.
        if(minutos.length()<2) minutos = 0 + minutos;
        //Se toma el residuo de la división anterior (minutos) para obtener los segundos.
        String segundos = (tiempoActual%3600)%60 +"";
        //En caso de que la longitud de minutos sea menor a dos, se agrega un cero al inicio.
        if(segundos.length()<2) segundos = 0 + segundos;
        //Finalmente, se concatenan los datos en un mensaje y se muestra al ususario.
        System.out.println("--------------- " + horas + ":" + minutos + ":" + segundos + " ---------------");
    }
}