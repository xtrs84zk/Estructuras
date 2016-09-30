package aplicacion;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class AdivinaEn10Maximo {
	public static void main(String[] args) {
		Random numAl = new Random();
		int numero = numAl.nextInt(500);
		System.out.println(numero);
		int respuesta = 2;
		int array[] = new int[10];
		JOptionPane.showMessageDialog(null, "Adivina el numero del 1 al 500 en almenos 10 intentos");
		for (int i = 0; i < 10; i++) {
			// Pregunta al usuario cual numero cree que sea el correcto
			int usuario = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el intento N°" + (i + 1)));
			array[i]=usuario;
			//Consecuencia si agota el numero de intentos
			if (i == 9) {
				respuesta = JOptionPane.showConfirmDialog(null,
						"El numero era: " + numero + ".\nTú ingresaste: \n" + Arrays.toString(array)
						+ "\n¿Deseas jugar de nuevo?", "Agotaste todas tus oportunidades",
						JOptionPane.YES_NO_OPTION);
			//consecuancia si acierta
			} else if (usuario == numero) {
				respuesta = JOptionPane.showOptionDialog(null, "Correcto!\nAcertaste en el intento N°" + (i + 1)
						+ ".\nTú ingresaste: \n" + Arrays.toString(array), "Selector de opciones",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Jugar de nuevo", "Salir" }, "Jugar de nuevo");
			} else if (usuario < numero) {
				JOptionPane.showMessageDialog(null, "Intenta un numero mayor");
			} else if (usuario > numero) {
				JOptionPane.showMessageDialog(null, "Intenta con un numero menor");
			}
			
			//consecuencia de la opcion tomada por el usuario
			if (respuesta == 1) {
				break;
			} else if (respuesta == 0) {
				i = -1;
				numero = numAl.nextInt(500);
				System.out.println(numero);
				respuesta--;
			}
		}
	}
}
