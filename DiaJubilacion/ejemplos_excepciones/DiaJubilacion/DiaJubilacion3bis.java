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
 
// Clase para calcular la fecha de jubilaci�n a los 65 a�os
public class DiaJubilacion3bis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaraciones
		Calendar fechaNacimiento = Calendar.getInstance();
		Calendar fechaHoy = Calendar.getInstance();
		//fecha m�nima para calcular la fecha de jubilaci�n
		Calendar fechaMinima = Calendar.getInstance(); 
		fechaMinima.add(Calendar.YEAR, -65);
		
		int dia, mes, anio;
		
		String cadenaFechaNacimiento;
		String arrayDiaSemana[] = { "Domingo", "Lunes", "Martes", "Mi�rcoles", "Jueves", "Viernes", "S�bado" };

		//Asignaci�n de la fecha de nacimiento
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce la fecha de nacimiento en formato dd/mm/yyyy (dia/mes/a�o): ");
		cadenaFechaNacimiento = sc.nextLine();
		
		//Validaci�n de la fecha de nacimiento mediante validarFecha
		boolean res = validarFecha(cadenaFechaNacimiento);
		
		//Asignaci�n de d�a, mes y a�o como elementos 0, 1 y 2 de un vector de cadenas
		String arrayFecha[] = cadenaFechaNacimiento.split("/");

			//si la fecha de nacimiento es v�lida conforme a validarFecha...
			if (res == true) { 
				
				//...construimos la fecha para que Calendar la pueda manejar...
				dia = Integer.parseInt(arrayFecha[0]);
				mes = Integer.parseInt(arrayFecha[1]);
				anio = Integer.parseInt(arrayFecha[2]);
				fechaNacimiento.set(Calendar.YEAR, anio);
				fechaNacimiento.set(Calendar.MONTH, mes - 1);
				fechaNacimiento.set(Calendar.DATE, dia);
				
				//... comprobamos que la fecha sea anterior al d�a de hoy y posterior al a�o actual menos 65...
				if (fechaNacimiento.before(fechaHoy) && fechaNacimiento.after(fechaMinima)) { 
					// a�adimos 65 a�os a la fecha de nacimiento.
					fechaNacimiento.add(Calendar.YEAR, 65); 
					
					// ... comprobamos si el d�a de jubilaci�n es Domingo y adelantamos la fecha en consecuencia...
					if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 1) {
						System.out.print(
								"El d�a de su jubilaci�n es el " + formatearFecha(fechaNacimiento) + ", pero como es ");
						System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						fechaNacimiento.add(Calendar.DAY_OF_YEAR, -2);
						System.out.print(" se le adelanda al viernes " + formatearFecha(fechaNacimiento));
						
					// ... comprobamos si el d�a de jubilaci�n es s�bado y adelantamos la fecha en consecuencia...
					} else {	
						if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 7) {
							System.out.print("El d�a de su jubilaci�n es el " + formatearFecha(fechaNacimiento)
									+ ", pero como es ");
							System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
							fechaNacimiento.add(Calendar.DAY_OF_YEAR, -1);
							System.out.print(" se le adelanda al viernes " + formatearFecha(fechaNacimiento));
						
						// Y si no es s�bado ni domingo...
						} else {
							System.out.print("El d�a de su jubilaci�n es el " + formatearFecha(fechaNacimiento) + ": ");
							System.out.println(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						}

					}
				
				// Si la fecha no est� entre ahora y hace 65 a�os...
				} else {
					System.out.print(  //" + fechaReferencia.toString() + "
							"\nLa fecha introducida no es est� en rango (desde hace 65 a hoy)... �INT�NTALO DE NUEVO! ");
				}
				
			// Si la fecha no es correcta por su formato o por ser una fecha inexistente, seg�n validarFecha...
			} else {

				System.out.print("\nLa fecha introducida no es correcta �INT�NTALO DE NUEVO! ");

			}
			
			sc.close();
		}

	
		
	// M�todo para formatear la fecha que se introduzca 
	// (se necesita java.text.DateFormat y java.util.Locale) 
	public static String formatearFecha(Calendar fechaNacimiento) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
		return df.format(fechaNacimiento.getTime());
	}

	//M�todo para comprobar que la fecha introducida se ajusta al formato y es correcta
	public static boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false); //no se aplica heur�stica al de la fecha introducida
			formatoFecha.parse(fecha); //este m�todo es el de DateFormat (clase padre)
		} catch (ParseException e) {
			return false;
		}
		return true;

	}

}
