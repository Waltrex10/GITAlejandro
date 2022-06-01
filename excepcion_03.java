package ejemplos_excepciones;
import java.io.*;

/*Este ejemplo muestra un caso de tratamiento con try-catch obligatorios para
el tratamiento de una entrada de datos pero no en el sentido de que 
sean obligatorios sintácticamente hablando, sino en el de que para la lectura
de datos de diversos tipos es necesario en Java provocar una excepción EOF 
para poder salir del bucle infinito while(true) cuando acabe de leerse un 
fichero.
*/
public class excepcion_03 {

	public void leeDatos() throws IOException{
		DataInputStream entrada = new DataInputStream(new FileInputStream("datos.dat"));
		int precio;
		int unidad;
		String desc;
		int total = 0;
		try{
		while (true){
		precio = entrada.readInt();
		entrada.readChar(); // Ignoramos el tabulador
		unidad = entrada.readInt();
		entrada.readChar(); // Ignoramos el tabulador
		desc = entrada.readLine();
		System.out.println("Has pedido " +
		unidad + " unidades de " +
		desc + " a " + precio + " pts.");
		total = total + unidad * precio;
		}
		}
		catch (EOFException e) {System.out.println("Por un total de: " + total + " Pts.");}
		catch (IOException e) {}
		//System.out.println("Por un total de: " + total + " Pts.");
		entrada.close();
		}

	}
	
//}
