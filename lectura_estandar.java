package ejemplos_excepciones;

import java.io.*;

class lectura_estandar {
	public static void main(String args[]) throws IOException {
		int caracter;
		System.out.println("Escribe lo que quieras.Para terminar, pulsa ENTER");
		System.out.println();
		while ((caracter = System.in.read()) != 13)
			System.out.println((char) caracter);
	}
}
