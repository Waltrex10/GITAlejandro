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
 */
 
// Clase para calcular la fecha de jubilación a los 65 años
public class DiaJubilacion3bis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaraciones
		Calendar fechaNacimiento = Calendar.getInstance();
		Calendar fechaHoy = Calendar.getInstance();
		//fecha mínima para calcular la fecha de jubilación
		Calendar fechaMinima = Calendar.getInstance(); 
		fechaMinima.add(Calendar.YEAR, -65);
		
		int dia, mes, anio;
		
		String cadenaFechaNacimiento;
		String arrayDiaSemana[] = { "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" };

		//Asignación de la fecha de nacimiento
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la fecha de nacimiento en formato dd/mm/yyyy (dia/mes/año): ");
		cadenaFechaNacimiento = sc.nextLine();
		
		//Validación de la fecha de nacimiento mediante validarFecha
		boolean res = validarFecha(cadenaFechaNacimiento);
		
		//Asignación de día, mes y año como elementos 0, 1 y 2 de un vector de cadenas
		String arrayFecha[] = cadenaFechaNacimiento.split("/");

			//si la fecha de nacimiento es válida conforme a validarFecha...
			if (res == true) { 
				
				//...construimos la fecha para que Calendar la pueda manejar...
				dia = Integer.parseInt(arrayFecha[0]);
				mes = Integer.parseInt(arrayFecha[1]);
				anio = Integer.parseInt(arrayFecha[2]);
				fechaNacimiento.set(Calendar.YEAR, anio);
				fechaNacimiento.set(Calendar.MONTH, mes - 1);
				fechaNacimiento.set(Calendar.DATE, dia);
				
				//... comprobamos que la fecha sea anterior al día de hoy y posterior al año actual menos 65...
				if (fechaNacimiento.before(fechaHoy) && fechaNacimiento.after(fechaMinima)) { 
					// añadimos 65 años a la fecha de nacimiento.
					fechaNacimiento.add(Calendar.YEAR, 65); 
					
					// ... comprobamos si el día de jubilación es Domingo y adelantamos la fecha en consecuencia...
					if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 1) {
						System.out.print(
								"El día de su jubilación es el " + formatearFecha(fechaNacimiento) + ", pero como es ");
						System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						fechaNacimiento.add(Calendar.DAY_OF_YEAR, -2);
						System.out.print(" se le adelanda al viernes " + formatearFecha(fechaNacimiento));
						
					// ... comprobamos si el día de jubilación es sábado y adelantamos la fecha en consecuencia...
					} else {	
						if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 7) {
							System.out.print("El día de su jubilación es el " + formatearFecha(fechaNacimiento)
									+ ", pero como es ");
							System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
							fechaNacimiento.add(Calendar.DAY_OF_YEAR, -1);
							System.out.print(" se le adelanda al viernes " + formatearFecha(fechaNacimiento));
						
						// Y si no es sábado ni domingo...
						} else {
							System.out.print("El día de su jubilación es el " + formatearFecha(fechaNacimiento) + ": ");
							System.out.println(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						}

					}
				
				// Si la fecha no está entre ahora y hace 65 años...
				} else {
					System.out.print(  //" + fechaReferencia.toString() + "
							"\nLa fecha introducida no es está en rango (desde hace 65 a hoy)... ¡INTÉNTALO DE NUEVO! ");
				}
				
			// Si la fecha no es correcta por su formato o por ser una fecha inexistente, según validarFecha...
			} else {

				System.out.print("\nLa fecha introducida no es correcta ¡INTÉNTALO DE NUEVO! ");

			}
			
			sc.close();
		}

	
		
	// Método para formatear la fecha que se introduzca 
	// (se necesita java.text.DateFormat y java.util.Locale) 
	public static String formatearFecha(Calendar fechaNacimiento) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
		return df.format(fechaNacimiento.getTime());
	}

	//Método para comprobar que la fecha introducida se ajusta al formato y es correcta
	public static boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false); //no se aplica heurística al de la fecha introducida
			formatoFecha.parse(fecha); //este método es el de DateFormat (clase padre)
		} catch (ParseException e) {
			return false;
		}
		return true;

	}

}
