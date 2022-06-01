/**
 * 
 */
package ejemplos_excepciones.DiaJubilacion;

import java.util.Scanner;
import java.util.Calendar;

/**
 * @author Santiago Acevedo Rocha
 */
 
// Clase para calcular la fecha de jubilaci�n a los 65 a�os
public class DiaJubilacion3bis2 {

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
		boolean res = AuxFechas.validarFecha(cadenaFechaNacimiento);
		
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
				
				//... comprobamos que la fecha sea anterior al d�a de hoy y posterior a la actual menos 65 a�os...
				if (fechaNacimiento.before(fechaHoy) && fechaNacimiento.after(fechaMinima)) { 
					// a�adimos 65 a�os a la fecha de nacimiento.
					fechaNacimiento.add(Calendar.YEAR, 65); 
					
					// ... comprobamos si el d�a de jubilaci�n es Domingo y adelantamos la fecha en consecuencia...
					if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 1) {
						System.out.print(
								"El d�a de su jubilaci�n es el " + AuxFechas.formatearFecha(fechaNacimiento) + ", pero como es ");
						System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
						fechaNacimiento.add(Calendar.DAY_OF_YEAR, -2);
						System.out.print(" se le adelanda al viernes " + AuxFechas.formatearFecha(fechaNacimiento));
						
					// ... comprobamos si el d�a de jubilaci�n es s�bado y adelantamos la fecha en consecuencia...
					} else {	
						if (fechaNacimiento.get(Calendar.DAY_OF_WEEK) == 7) {
							System.out.print("El d�a de su jubilaci�n es el " + AuxFechas.formatearFecha(fechaNacimiento)
									+ ", pero como es ");
							System.out.print(arrayDiaSemana[fechaNacimiento.get(Calendar.DAY_OF_WEEK) - 1]);
							fechaNacimiento.add(Calendar.DAY_OF_YEAR, -1);
							System.out.print(" se le adelanda al viernes " + AuxFechas.formatearFecha(fechaNacimiento));
						
						// Y si no es s�bado ni domingo...
						} else {
							System.out.print("El d�a de su jubilaci�n es el " + AuxFechas.formatearFecha(fechaNacimiento) + ": ");
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

	}
