package masJunit;

public class MayorNumero {
	/**
	 * Devuelve el elemento de mayor valor de una lista
	 *
	 * @param list
	 *            Un array de enteros
	 * @return El entero de mayor valor de la lista
	 */
	public static int obt_mayorNumero(int lista[]) {
		int indice, max = Integer.MIN_VALUE;
		for (indice = 0; indice < lista.length; indice++) {
			if (lista[indice] > max) {
				max = lista[indice];
			}
		}
		return max;
	}

}
