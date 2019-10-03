package ec.edu.ups.est.p3.modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
/**
 * 
 * @author Oscar Tenesaca
 *
 */
public class MiHilo extends Thread{
	private JTextField txt;
	private Date hora;
	
	public MiHilo(JTextField txt){
		this.txt=txt;
	
		
	}
	/**
	 * metodo para que arranque el hilo
	 */
	public  void run(){
		
		while(true){
			try{
				sleep(1000);
				
			}catch (Exception e){
			}
			
			Calendar tiempo=new GregorianCalendar();
		
			txt.setText(tiempo.get(Calendar.HOUR_OF_DAY)+":"+tiempo.get(Calendar.MINUTE)+":"+tiempo.get(Calendar.SECOND));

		}
	}

}
