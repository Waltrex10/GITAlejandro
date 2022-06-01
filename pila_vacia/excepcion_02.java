// Ejemplo sacado y adaptado para evitar errores del libro de texto

package ejemplos_excepciones.pila_vacia;

//import java.io.*;
import java.util.*;

// se muestra uso de throws y uso de throw
public class excepcion_02 {
	public Object pop() throws EmptyStackException {
		int size = 100; // Asignación arbitraria de tamaño para evitar errores
		Object obj;
		if (size == 0)
			// si la pila esta vacía se crea una instancia de la excepción
			throw new EmptyStackException();
		// se desapila el elemento de la pila
		obj = objectAt(size - 1);
		setObjectAt(size - 1, null);
		size--;
		return obj; // se devuelve el elemento desapilado
	}

	// Añadido por mí
	Object objectAt(int size) {

		Object vector_objetos[] = new Object[size];
		return vector_objetos[size];
	}

	void setObjectAt(int size, Object obj) {
		Object vector_objetos[] = new Object[size];
		vector_objetos[size + 1] = obj;
	}

	public void miMetodo() throws EmptyStackException {
		Object objeto;
		objeto = pop();

	}

}
