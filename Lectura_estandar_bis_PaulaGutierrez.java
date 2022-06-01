package ejemplos_excepciones;

import java.io.*;

public class Lectura_estandar_bis_PaulaGutierrez {
	
		public static void main(String args[]) {
			int car;
			System.out.println("Escribe lo que quieras y pulsa ENTER");
			System.out.println();
			
			
			try 
			{
				while ((car = System.in.read()) != 13)
					System.out.println((char) car);
			} 
			
			catch (IOException exc) 
			{
				
				System.err.println("Error entrada/salida");
				
			}
		}
	}



