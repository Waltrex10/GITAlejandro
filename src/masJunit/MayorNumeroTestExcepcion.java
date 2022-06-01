package masJunit;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

class MayorNumeroTestExcepcion {
	
	/*
	 Voy a realizar una prueba unitaria de excepciones, en esta pondremos varios numros, y tendra que leer el mas grande que en este caso es 12, como comprobaremos sera un error,
	 si pones mas numeros de los permitidos por el int tambien te dara error.
	 */

	@Test
	public void ArrayIndexOutOfBoundsTestExcepcion() {
		
		Exception ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			MayorNumero m = new MayorNumero();
			int numeros[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 999999999};
			int mayor = m.obt_mayorNumero(numeros);
			System.out.println(mayor);
		});
		String mensajeaEsperar = "outofboundsException";
		String mensajeObtenido = ex.getMessage();
		assertTrue(mensajeObtenido.contains(mensajeaEsperar));
		
	}
	
}
