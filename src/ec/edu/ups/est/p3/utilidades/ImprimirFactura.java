package ec.edu.ups.est.p3.utilidades;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
/**
 * 
 * @author Oscar tenesaca
 *
 */
		
public class ImprimirFactura implements Printable{
	
	String nFactura;
	String placa;
	String nombre;
	String ruc;
	String diereccion;
	String telefono;
	String fecha;
	String eMail;
	String horaEntrada;
	String horaSalida;
	/**
	 * 
	 * @param nF factura
	 * @param p placa
	 * @param n nombre
	 * @param r ruc
	 * @param d direccion
	 * @param t telefono
	 * @param f fecha
	 * @param eM mail
	 * @param hE hora entrada
	 * @param hS hora salida
	 */
	
	public ImprimirFactura(String nF , String p , String n ,String r,String d, String t ,String f ,
				String eM,  String hE ,String hS){
	
		 nFactura=nF;
		 placa=p;
		 nombre=n;
		 ruc=r;
		 diereccion=d;
		 telefono=t;
		 fecha=f;
		 eMail=eM;
		 horaEntrada=hE;
		 horaSalida=hS;
		
	}
/**
 * 	metodo que nos permite  imprimir
 */
	public int print(Graphics g, PageFormat f, int pageIndex ){
		
		if(pageIndex==0){
			
			g.drawString("nFactura"+nFactura, 20, 40);
			g.drawString("Placa"+placa, 20, 60);
			g.drawString("ruc"+ruc, 20, 80);
			g.drawString("diereccion"+diereccion, 20, 100);
			g.drawString("telefono"+telefono, 20, 120);
			g.drawString("fecha"+fecha, 20, 140);
			
			return PAGE_EXISTS;
			
		}else{
			
			return NO_SUCH_PAGE;
		}
			
		}
	
}
