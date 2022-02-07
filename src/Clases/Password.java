package Clases;

public class Password {

	// ATRIBUTOS
	private String password = "";
	private int longitud = 5;

	// CONSTRUCTOR VACIO
	public Password() {

	}

	// CONSTRUCTOR CON LONGITUD
	public Password(int longitud) {
		this.longitud = longitud;

	}

	// Metodo que cuenta la cantidad de mayusculas, minusculas y numeros que hay en la password y devuelve true si hay la cantidad minima
	public boolean esFuerte() {
		boolean passwordFuerte = false;

		int mayus = 0;
		int minus = 0;
		int nums = 0;
						
		for (int i = 0; i < longitud; i++) {
			
			if (Character.isUpperCase(this.password.charAt(i))){
				mayus++;
			} else if (Character.isLowerCase(this.password.charAt(i))) {
				minus++;
			} else {
				nums++;
			}
			
		}
		
		if (mayus > 1 && minus > 0 && nums > 5) {
			passwordFuerte = true;
		}
		
		return passwordFuerte;

	}

	// Metodo para generar un caracter aleatorio, 0-9, A-Z y a-z
	private char generarCaracter() {
		char caracter = ' ';
		int caracterAscii;

		int num = (int) (Math.random() * 3) + 1; // Genero un numero aleatorio del 1 al 3

		// Genero un tipo de caracter segun el numero aleatorio
		switch (num) {

		case 1: // Genero un numero
			caracterAscii = (int) (Math.random() * (57 - 48)) + 48;

			caracter = (char) caracterAscii;
			return caracter;

		case 2: // Genero una mayuscula
			caracterAscii = (int) (Math.random() * (90 - 65)) + 65;

			caracter = (char) caracterAscii;
			return caracter;

		case 3: // Genero una minuscula
			caracterAscii = (int) (Math.random() * (122 - 97)) + 97;

			caracter = (char) caracterAscii;
			return caracter;
		}

		return caracter;
	}

	// Metodo que genera una password concatenando caracteres
	public void generarPassword() {

		for (int i = 0; i < longitud; i++) {

			this.password += generarCaracter();

		}

	}

	// GETTERS Y SETTERS
	public String getPassword() {
		return password;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

}
