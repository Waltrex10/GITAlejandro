package ejemplos_excepciones.DiaJubilacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AuxFechas {

	// Método para formatear la fecha que se introduzca 
	// (se necesita java.text.DateFormat y java.util.Locale) 
	public static String formatearFecha(Calendar fecha) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
		return df.format(fecha.getTime());
	}

	//Método para comprobar que la fecha introducida se ajusta al formato y es correcta
	public static boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false); //no se aplica heurística a la fecha introducida
			formatoFecha.parse(fecha); //este método es el de DateFormat (clase padre)
		} catch (ParseException e) {
			return false;
		}
		return true;

	}
}
