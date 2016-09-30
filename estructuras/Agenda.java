package estructuras;

import dominio.Persona;
public class Agenda extends Persona {
	private Persona[] contacto;

	public Agenda() {
		contacto = new Persona[35];
	}

	/**
	 * Constructor de la clase Agenda que inicializa los atributos con
	 * parametros dados.
	 * 
	 * @param Nombre
	 *            de la persona
	 * @param Dirección
	 *            de la persona
	 * @param Teléfono
	 *            de la persona
	 * @param Correo
	 *            electrónico de la persona
	 */
	public Agenda(int tamaño) {
		this();
		if (tamaño > 0) {
			contacto = new Persona[tamaño];
		}
	}

	/**
	 * Método que regresa la información de la persona en cuestión.
	 * 
	 * @param void
	 * @return Regresa la información contenida en los atributos de la persona.
	 */
	public Persona[] informacionPersona(String nombre) {
		for (int i = 0; i < contacto.length; i++) {
			if (contacto[i].getNombre().equals(nombre)) {
				return contacto[i];
			}
		}
		return contacto[0];
	}

	/**
	 * Método void que modifica el número de teléfono.
	 * 
	 * @param Recibe
	 *            el nuevo número de teléfono.
	 * @return No tiene retorno.
	 */
	public void modificarTelefono(String telefono) {
		setTelefono(telefono);
	}
}
