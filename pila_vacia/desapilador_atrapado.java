package ejemplos_excepciones.pila_vacia;
import java.util.EmptyStackException;
public class desapilador_atrapado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lanzador_pila_vacia lanzador = new lanzador_pila_vacia();
		int size = 100;
		
		//Inicialización de la pila de objetos con objetos null
		Object pila[] = new Object[size];
		for(int i=0;i<100;i++) {
			pila[i]=null;
		}
		
		try {
		
		
		lanzador.objectAt(size-1, pila);
		
		while (true) {
		lanzador.pop(size-1, pila);

		size--;
		}

		}
		
		catch (EmptyStackException e){
			
			System.out.println("La pila está vacía");
			
		}
		
	/*	
		finally {
			
			
		}
		*/
		
		System.out.println("Tenlo en cuenta");
	}
}
