//import java.io.UnsupportedEncodingException;

package ejemplos_excepciones;
import java.io.UnsupportedEncodingException;

public class T8859_1bis {

	public static void main(String[] args) throws UnsupportedEncodingException{
		// TODO Auto-generated method stub

		
		byte datos[] = {97,98,99,126};	
		
		//Charset 
//	try {	
		String codificada = new String(datos, "8859_1");
		System.out.print(codificada);
//	}
/*	 catch (UnsupportedEncodingException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

	}
*/
	

	}	
}
