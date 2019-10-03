package ec.edu.ups.est.p3.modelo;

import java.sql.Time;
import java.util.Date;
/**
 * 
 * @author Oscar Tenesaca
 *
 */
public class Tickets {
	
	private int  numero_ticket;
	private String placa;
	private Date fecha;
	private Date hora_entrada;
	private Date hora_salida; 
	private String tiempo;
	int tiempoSegundo;
	
	
	
	
	public int getTiempoSegundo() {
		return tiempoSegundo;
	}
	public void setTiempoSegundo(int tiempoSegundo) {
		this.tiempoSegundo = tiempoSegundo;
	}
	public int getNumero_ticket() {
		return numero_ticket;
	}
	public void setNumero_ticket(int numero_ticket) {
		this.numero_ticket = numero_ticket;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(Date hora_entrada) {
		this.hora_entrada = hora_entrada;
	
	}
	
	public Date getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(Date hora_salida) {
		this.hora_salida = hora_salida;
	}
	
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	@Override
	public String toString() {
		return "Ticket [numero_ticket=" + numero_ticket + ", placa=" + placa
				+ ", fecha=" + fecha + ", Hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", Tiempo=" + tiempo + " ]";
	}
	

}
