package ejemplos_excepciones;

import java.io.*;

public class PruebaTipos {

	// Se lanza la excepción de los métodos de lectura/escritura, no se trata con
	// try-catch.
	public static void main(String[] args) throws IOException {
		PruebaTipos obj = new PruebaTipos();
		obj.escribeDatos();
		obj.leeDatos();
	}

	// Se lanza la excepción de los métodos de escritura, no se trata con try-catch.
	public void escribeDatos() throws IOException {
		DataOutputStream salida = new DataOutputStream(new FileOutputStream("datos.dat"));
		int[] precios = { 3000, 5000, 7000, 6500, 750 };
		int[] unidades = { 12, 8, 13, 29, 50 };
		String[] descripcion = { "Camisetas", "Bañadores", "Pantalones", "Zapatillas", "Calcetines" };
		for (int i = 0; i < precios.length; i++) {
			salida.writeInt(precios[i]);
			salida.writeChar('\t');
			salida.writeInt(unidades[i]);
			salida.writeChar('\t');
			salida.writeBytes(descripcion[i]);
			salida.writeChar('\n');
		}
		salida.close();
	}

	// Se lanza la excepción de los métodos de lectura que no se tratan con
	// try-catch.
	// Los que se tratan con try-catch sirven para controlar el final de fichero,
	// que
	// en la lectura de ficheros con diversos tipos de datos no tiene otra forma de
	// hacerse.
	public void leeDatos() throws IOException {
		DataInputStream entrada = new DataInputStream(new FileInputStream("datos.dat"));
		int precio;
		int unidad;
		String desc;
		int total = 0;
		try {
			while (true) {
				precio = entrada.readInt();
				entrada.readChar(); // Ignoramos el tabulador
				unidad = entrada.readInt();
				entrada.readChar(); // Ignoramos el tabulador
				desc = entrada.readLine();
				System.out.println("Has pedido " + unidad + " unidades de " + desc + " a " + precio + " pts.");
				total = total + unidad * precio;
			}
		} catch (EOFException e) {System.out.println("Por un total de: " + total + " Pts.");
		}
		//System.out.println("Por un total de: " + total + " Pts.");
		entrada.close();
	}

}