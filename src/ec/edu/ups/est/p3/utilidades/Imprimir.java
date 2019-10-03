package ec.edu.ups.est.p3.utilidades;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
/**
 * 
 * @author 	Oscar tenesaca
 *
 */
public class Imprimir implements Printable{
	
	String numero_ticket;
	String placa;
	String fecha;
	String hora_entrada;
	
	public Imprimir(String n , String p ,String f,String h){
	
		 numero_ticket=n;
		 placa=p;
		 fecha=f;
		 hora_entrada=h;
		
	}
	/**
	 * metodo que nos permite imprimir 
	 */
	public int print(Graphics g, PageFormat f, int pageIndex ){
		
		if(pageIndex==0){
			
			g.drawString("Tichet"+numero_ticket, 20, 40);
			g.drawString("Placa"+placa, 20, 55);
			g.drawString("fecha"+fecha, 120, 40);
			g.drawString("hora_entrada"+hora_entrada, 120, 55);
			
			return PAGE_EXISTS;
			
		}else{
			
			return NO_SUCH_PAGE;
		}
			
		}
	
}
