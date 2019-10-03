package ec.edu.ups.est.p3.oad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ec.edu.ups.est.p3.modelo.Factura;
import ec.edu.ups.est.p3.modelo.Tickets;
import ec.edu.ups.est.p3.utilidades.ConexionTicketsBD;
/**
 * 
 * @author Oscar tenesaca
 *
 */
public class FacturaBD {

	/**
	 * 
	 * @param factura
	 *  Para ingresar los datos en la base de datos del SQL
	 * de la tabla Factura factura
	 * 
	 */
	public void insertar(Factura factura){
		Connection c=null;
		String sql= "INSERT INTO FACTURA(N_FACTURA, CEDULA, N_TICKET,MONTO,IVA,TOTAL_PAGAR,PAGO,CAMBIO ) "
				
				+"VALUES(?,?,?,?,?,?,?,?)";
		try{
			c=ConexionTicketsBD.getConnection();
			
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, factura.getCodigoFactura());
			ps.setString(2, factura.getCedula());
			ps.setInt(3, factura.getNumero_ticket());
			ps.setDouble(4, factura.getMonto());
			ps.setDouble(5, factura.getIva());
			ps.setDouble(6, factura.getTotal());
			ps.setDouble(7, factura.getPago());
			ps.setDouble(8, factura.getCambio());
			
			ps.executeUpdate();
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			ConexionTicketsBD.close(c);
		}
		
	}
	
	/**
	 * 
	 * @return nos numera el ticket automaticamente
	 */
	public long codigoF(){
		long codigo=1;
		
		Connection c=null;
		String sql= "SELECT MAX (N_FACTURA) AS N_FACTURA"
				+"		FROM FACTURA";
		try{
			c=ConexionTicketsBD.getConnection();
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
		codigo=rs.getInt("N_FACTURA")+1;
			
		}catch(Exception e1){
			e1.printStackTrace();
			
		}finally {
			ConexionTicketsBD.close(c);
		}
		return codigo;	
	}
	
	

		
	}
	
	

