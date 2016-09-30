package dominio;
public abstract class Persona{
	protected String nombre;
	protected String direccion;
	protected String telefono;
	protected String email;
	static int numeroDePersonas = 0;

	/**
	 * Construtor de la clase persona que iniciliza los valores por defecto.
	 */
	public Persona() {
		super();
	}

	/**
	 * Constructor para la clase Persona que inicializa los valores con
	 * parametros dados.
	 */
	public Persona(String nombre, String direccion, String telefono, String email) {
		numeroDePersonas++;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;

		// this(nombre, direccion, telefono, email);
	}

	/**
	 * Método que regresa el nombre de la persona.
	 * 
	 * @param void
	 * @return nombre Nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método que regresa la dirección de la persona.
	 * 
	 * @param void
	 * @return Direccion de la persona
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método que regresa el teléfono de la persona.
	 * 
	 * @param void
	 * @return Teléfono de la persona.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Método que regresa el email de la persona.
	 * 
	 * @param void
	 * @return E-mail de la persona.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método que establece el nombre de la persona.
	 * 
	 * @param Nombre
	 *            de la persona
	 * @return void
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que establece la dirección de la persona.
	 * 
	 * @param Dirección
	 *            de la persona
	 * @return void
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Método que establece el teléfono de la persona.
	 * 
	 * @param Telefono
	 *            de la persona.
	 * @return void
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método que establece el email de la persona.
	 * 
	 * @param void
	 * @return E-mail de la persona.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método que regresa el número de Objetos tipo Persona creados.
	 * 
	 * @param void
	 * @return Regresa el número de Personas que se han creado.
	 */
	public static int getNumeroDePersonas() {
		return numeroDePersonas;
	}

	/**
	 * Método toString que regresa los valores del Objeto Persona.
	 * 
	 * @param void
	 * @return Regresa el nombre, dirección, teléfono y correo electrónico de la
	 *         persona.
	 */
	public String toString() {
		return "Nombre: " + nombre + "\nDirección: " + direccion + "\nTeléfono: " + "\nCorreo electrónico: " + email;
	}

	public abstract String informacionPersona();

	public abstract void modificarTelefono(String nuevoTelefono);
}
