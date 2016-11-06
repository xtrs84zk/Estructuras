Queue filaDelBanco;
Random rdn = new Random();
int turno;
int numeroDeCajasAbiertas; 
int[] caja;
int tiempoLimite, tiempoActual,  dia, probabilidad;

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
		tiempo += rdn.nextInt(300);
		System.out.print("------ " tiempo/60 +  ":" + tiempo%60 + "------");
		decidirSiLlegaOSaleUnCliente(probabilidad);
	}
}
private decidirSiLlegaOSaleUnCliente(int probabilidad){
	if(tiempoActual<=tiempoLimite){
		int auxiliar = aleatorio.nextInt(99);
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

private llegadaDeClienteAlBanco(){
	tiempo += rdn.nextInt(300);
	System.out.print("------ " tiempo/60 +  ":" + tiempo%60 + "------");
	System.out.println("Llega el cliente " + ++turno + " al banco.");
	filaDelBanco.insert(turno);
}

private elClienteLlegaAlaCaja(){
	do{
		cajaQueSeUsara = rdn.nextInt(numeroDeCajasAbiertas);
	}while(caja[cajaQueSeUsara] != 0);
	int cajaQueSeUsara = rdn.nextInt(numeroDeCajasAbiertas);
	System.out.println("------ " tiempo/60 +  ":" + tiempo%60 + "------");
	System.out.println("El cliente " + (int) filaDelBanco.front() + 
					   "pasa a la caja +" cajaQueSeUsara);
	caja[cajaQueSeUsara] = (int) filaDelBanco.extract();
	atenderClientes();
}

private atenderClientes(){
	tiempo += rdn.nextInt(300);
	System.out.println("------ " tiempo/60 +  ":" + tiempo%60 + "------");
	int laCajaQueSeVaciaraPorqueElClienteYaFueAtendido;
	do{
		laCajaQueSeVaciaraPorqueElClienteYaFueAtendido = rdn.nextInt(numeroDeCajasAbiertas);
	}while(caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] == 0);
	System.out.println("El cliente " + caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] +
					   "ha sido atendido y saldrá del banco. ");
	caja[laCajaQueSeVaciaraPorqueElClienteYaFueAtendido] = 0;
}	