package ejemplos_excepciones.pila_vacia;

import java.util.EmptyStackException;

public class lanzador_pila_vacia {

	public Object pop(int tamano, Object[] vector) throws EmptyStackException {
		int size = tamano; // Asignaci�n arbitraria de tama�o para evitar errores
		Object obj;

		if (size == 0)
			// si la pila esta vac�a se crea una instancia de la excepci�n
			throw new EmptyStackException();
			
		// se desapila el elemento de la pila
		obj = objectAt(size - 1, vector);
		// setObjectAt(size-1,null);
		size--;

		return obj; // se devuelve el elemento desapilado
	}

	// A�adido por m�
	Object objectAt(int size, Object[] vector) {

		Object pila[] = vector;
		return pila[size];
	}
/*
	void setObjectAt(int size, Object obj) {
		Object vector_objetos[] = new Object[size];
		vector_objetos[size - 1] = obj;
	}
*/
	/*
	 * public void miMetodo(int size) throws EmptyStackException{ Object objeto;
	 * objeto = pop(size);
	 * 
	 * 
	 * }
	 */
}
