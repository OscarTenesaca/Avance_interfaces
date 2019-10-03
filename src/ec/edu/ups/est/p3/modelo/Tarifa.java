package ec.edu.ups.est.p3.modelo;


public class Tarifa {
	
	private int codigo;
	private double precio;
	
	

	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Tarifa [codigo=" + codigo + ", Precio=" + precio + "]";
	
	}
}
