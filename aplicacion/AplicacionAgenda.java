package aplicacion;

import dominio.Persona;
import estructuras.Agenda;
import javax.swing.JOptionPane;
public class AplicacionAgenda {
	public static void main(String[] args) {
		// Declaración de variables
		String nombre, direccion, telefono, email, buscarPersona, nombrePersona;
		int cantidadPersonas, repetir;
		String nuevoTelefono;

		// Ingresando cantidad de personas que se agregarán.
		cantidadPersonas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas personas ingresará?"));

		// Declarar y crear el arreglo de objetos
		Persona[] contacto = new Persona[cantidadPersonas];

		// Pidiendo datos de cada persona
		for (int i = 0; i < contacto.length; i++) {
			nombre = JOptionPane.showInputDialog("\nPersona N°" + (i + 1) + "\nNombre: ");
			direccion = JOptionPane.showInputDialog("\nPersona N°" + (i + 1) + "\nDirección: ");
			telefono = JOptionPane.showInputDialog("\nPersona N°" + (i + 1) + "\nTelefono: ");
			email = JOptionPane.showInputDialog("\nPersona N°" + (i + 1) + "\nE-mal: ");
			
			// LLenando el arreglo de objetos
			contacto[i] = new Agenda(nombre, direccion, telefono, email);
		}
		
		do{
		String[] opciones = {
			"Mostrar información de determinada persona",
			"Modificar el teléfono de determinada persona",
			"Saber cuántas personas hay en la agenda"
		};
		String eleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una acción:",
				"Opciones", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
		switch (eleccion) {
		case "Mostrar información de determinada persona":
			buscarPersona=JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
			repetir = JOptionPane.showConfirmDialog(null, contacto[buscarPersona].informacionPersona(), "Información", JOptionPane.YES_NO_OPTION);
			System.out.println(agenda[persona].informacionPersona());
			break;
		case 2:
			System.out.println("Ingrese el número de la persona. ");
			//persona = (entrada.nextInt() - 1);
			System.out.println("Ingrese el nuevo número de teléfono.");
			nuevoTelefono = entrada.nextLine();
			agenda[persona].modificarTelefono(nuevoTelefono);
			System.out.println("Listo.");
			break;
		case 3:
			System.out.println("El número de personas registradas es: " + Persona.getNumeroDePersonas());
			break;
		}
		}whyle(repetir == 0);
	}
}
