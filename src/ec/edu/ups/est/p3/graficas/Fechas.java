package ec.edu.ups.est.p3.graficas;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * 
 * @author Oscar tenesaca
 *
 */
public class Fechas {
	/**
	 *la Clse fecha nos permite retornar las horas y Fechas  
	 */
	
	 public static void main(String[] args) {
	       
	        Calendar fecha = new GregorianCalendar();
	        

	        int ano = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH);
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
	        int hora = fecha.get(Calendar.HOUR_OF_DAY);
	        int minuto = fecha.get(Calendar.MINUTE);
	        int segundo = fecha.get(Calendar.SECOND);
	        System.out.println("Fecha Actual: "   + dia + "/" + (mes+1) + "/" + ano);
	        System.out.printf("Hora Actual: %02d:%02d:%02d %n",  hora, minuto, segundo);
	    }
	 
	 
	 

}
