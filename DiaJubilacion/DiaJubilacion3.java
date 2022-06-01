/**
 * 
 */
package ejemplos_excepciones.DiaJubilacion;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author Santiago Acevedo Rocha
 *
 */
public class DiaJubilacion3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar fechaNacimiento = Calendar.getInstance();
		Calendar fechaHoy = Calendar.getInstance();

		String error;
		int edad, dia, mes, anio, limite;

		String cadenaFechaNacimiento;
		String arrayDiaSemana[] = { "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una Fecha en formato dd/mm/yyyy (dia/mes/año): ");
		cadenaFechaNacimiento = sc.nextLine();
		// System.out.println(cadenaFechaNacimiento);

		String arrayFecha[] = cadenaFechaNacimiento.split("/");

		if (cadenaFechaNacimiento.length() != 10) {
			System.out.print("\nLa fecha introducida no es correcta ¡INTENTALO DE NUEVO! ");
		} else {
			boolean res = validarFecha(cadenaFechaNacimiento);
			if (res == true) {
				dia = Integer.parseInt(arrayFecha[0]);
				mes = Integer.parseInt(arrayFecha[1]);
				anio = Integer.parseInt(arrayFecha[2]);
				fechaNacimiento.set(Calendar.YEAR, anio);
				fechaNacimiento.set(Calendar.MONTH, mes - 1);
				fechaNacimiento.set(Calendar.DATE, dia);
				if (fechaNacimiento.before(fechaHoy)) { // Comprobamos que la fecha sea menor que el día de hoy.
					fechaNacimiento.add(Calendar.YEAR, 65); // añadimos 65 años a la fecha de nacimiento.
					if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 1) {// Comprobamos si el día de jubilación es
																			// Domingo
						System.out.print(
								"El día de su jubilación es el " + formatearFecha(fechaNacimiento) + ", pero como es ");
						System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						fechaNacimiento.add(Calendar.DAY_OF_YEAR, -2);
						System.out.print(" se le adelanda al viernes " + formatearFecha(fechaNacimiento));

					} else {
						if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 7) {// Comprobamos si el día de jubilación es
																				// sábado.
							System.out.print("El día de su jubilación es el " + formatearFecha(fechaNacimiento)
									+ ", pero como es ");
							System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
							fechaNacimiento.add(Calendar.DAY_OF_YEAR, -1);
							System.out.print(" se le adelanda al viernes " + formatearFecha(fechaNacimiento));

						} else {
							System.out.print("El día de su jubilación es el " + formatearFecha(fechaNacimiento) + ": ");
							System.out.println(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						}

					}

				} else {
					System.out.print(
							"\nLa fecha introducida no es mayor que la fecha del día de hoy... ¡INTENTALO DE NUEVO! ");
				}
			} else {

				System.out.print("\nLa fecha introducida no es correcta ¡INTENTALO DE NUEVO! ");

			}
		}

	}

	// PROCEDIMIENTO PARA FORMATEAR LA FECHA NECESITAMOS IMPORTAR TEXT.DATAFORMAT Y
	// UTIL.LOCALE
	public static String formatearFecha(Calendar fechaNacimiento) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
		return df.format(fechaNacimiento.getTime());
	}

	public static boolean validarFecha(String fecha) {

		try {

			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

			formatoFecha.setLenient(false);

			formatoFecha.parse(fecha);

		} catch (ParseException e) {

			return false;

		}

		return true;

	}

}
