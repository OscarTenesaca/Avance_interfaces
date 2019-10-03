package ec.edu.ups.est.p3.modelo;
/**
 * 
 * @author Oscar Tenesaca
 *
 */
public class Cliente {
	
	String Cedula;
	String Nombre;
	String Direccion;
	String Telefono;
	String E_Mail;


	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getE_Mail() {
		return E_Mail;
	}
	public void setE_Mail(String e_Mail) {
		E_Mail = e_Mail;
	}
	/**
	 * para que se imprima 
	 */
			
	@Override
	public String toString() {
		return "Cliente [ Cedula=" + Cedula
				+ ", Nombre=" + Nombre  + ", Direccion=" +Direccion + ", Telefono=" + Telefono + ", E_Mail=" + E_Mail + " ]";
	}

}
	
	

