package Interfaz;

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
		
		System.out.println("Que longitud quieres que tegan las passwords");
		int longitud = teclado.nextInt();
		
		return longitud;
	}
	
	// Metodo para pedir la dimension del array
	private static int pedirDimensionArray() {
		
		System.out.println("Introduce cuantas passwords quieres generar.");
		int size = teclado.nextInt();
		
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
			System.out.println(passwords[i].getPassword());
			System.out.println(passwordsFuertes[i]);
		}
		
	}
	
}
