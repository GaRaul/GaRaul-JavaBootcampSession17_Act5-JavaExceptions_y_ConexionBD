package Interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;

import Clases.*;

public class Interfaz {

	static Scanner teclado = new Scanner(System.in);

	// Declaro arrays y variables
	static Password[] passwords = new Password[pedirDimensionArray()];
	static boolean[] passwordsFuertes = new boolean[passwords.length];
	static int longitud = pedirLongitudPasswords();

	// EJECUTA LOS METODOS
	public static void ejecucion() {

		rellenarArrays(passwords.length, longitud);

		mostrarArrays();

	}

	// Metodo para pedir la longitud de las passwords
	private static int pedirLongitudPasswords() {
		int longitud = 0;
		boolean formatoValido = false;

		System.out.println("Que longitud quieres que tegan las passwords");

		do {

			try {
				longitud = teclado.nextInt();
				formatoValido = true;

			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero entero por favor.");
				teclado.nextLine();
			}

		} while (!formatoValido);

		return longitud;
	}

	// Metodo para pedir la dimension del array
	private static int pedirDimensionArray() {

		int size = 0;
		boolean formatoValido = false;

		System.out.println("Introduce cuantas passwords quieres generar.");
		
		do {

			try {
				size = teclado.nextInt();
				formatoValido = true;

			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero entero por favor.");
				teclado.nextLine();
			}

		} while (!formatoValido);

		return size;
	}

	// Metodo para rellenar los arrays
	private static void rellenarArrays(int size, int longitud) {

		for (int i = 0; i < passwords.length; i++) {
			passwords[i] = new Password(longitud);
			passwords[i].generarPassword();
			passwordsFuertes[i] = passwords[i].esFuerte();
		}

	}

	// Metodo para mostrar los arrays
	private static void mostrarArrays() {

		for (int i = 0; i < passwords.length; i++) {
			System.out.println(passwords[i].getPassword() + " [" + passwordsFuertes[i] + "]");

		}

	}

}
