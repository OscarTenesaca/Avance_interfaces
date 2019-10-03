package ec.edu.ups.est.p3.modelo;

import java.util.Date;

/**
 * 
 * @author Oscar tenesaca
 *
 */
public class Factura {
	
	int codigoFactura;
	String Cedula;
	int  numero_ticket;
	double monto;
	double iva;
	double total;
	double pago;
	double cambio;
	
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public double getCambio() {
		return cambio;
	}
	public void setCambio(double cambio) {
		this.cambio = cambio;
	}
	public int getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	
	public int getNumero_ticket() {
		return numero_ticket;
	}
	public void setNumero_ticket(int numero_ticket) {
		this.numero_ticket = numero_ticket;
	}
	
	@Override
	public String toString() {
		return "Factura [codigoFactura=" + codigoFactura + ", Cedula=" + Cedula
				+ ", N_Ticket=" + numero_ticket + ", Monto=" + monto + ", iva=" + iva 
				+ " , total=" + total + ", pago=" + pago + ", cambio=" + cambio + "]";
	}

}
