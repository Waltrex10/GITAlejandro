package ejemplos_excepciones.pila_vacia;

import java.util.EmptyStackException;

public class desapilador {

	public static void main(String[] args) throws EmptyStackException {
		// TODO Auto-generated method stub
		lanzador_pila_vacia lanzador = new lanzador_pila_vacia();
		int size = 100;
		
		//Inicialización de la pila de objetos con objetos null
		Object pila[] = new Object[size];
		for(int i=0;i<100;i++) {
			pila[i]=null;
		}
		
		
		lanzador.objectAt(size-1, pila);
		
		while (true) {
		lanzador.pop(size-1, pila);

		size--;
		}

	//	System.out.println("Tenlo en cuenta");
		
	}
}
