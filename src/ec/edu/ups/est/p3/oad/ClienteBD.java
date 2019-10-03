package ec.edu.ups.est.p3.oad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.est.p3.modelo.Cliente;
import ec.edu.ups.est.p3.modelo.Factura;
import ec.edu.ups.est.p3.utilidades.ConexionTicketsBD;
/**
 * 
 * @author Oscar tenesaca
 *
 */
public class ClienteBD {

	/**
	 * 
	 * @param cliente
	 * parametro para insertar los datos de cliente e interactua con el EXECUTE QUERY
	 * y luego usarla en otros metodos
	 * 
	 */
		
	
	public void insertar(Cliente cliente){
		Connection c=null;
		String sql= "INSERT INTO CLIENTE(CEDULA, NOMBRE,"
				+" DIRECCION, TELEFONO,E_MAIL)"
				+"VALUES(?,?,?,?,?)";
		try{
			c=ConexionTicketsBD.getConnection();
			
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setString(4, cliente.getTelefono());
			ps.setString(5, cliente.getE_Mail());
			ps.executeUpdate();
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			ConexionTicketsBD.close(c);
		}
		
	}
/**
 * 
 * @param cedulaC El paso de parametros de la cedula para mostrar los datos
 * @return una variables o datos.
 */
		
	public Cliente leer(String cedulaC){
		
		String sql="SELECT  CEDULA, NOMBRE, "
				+" DIRECCION, TELEFONO,E_MAIL "
				+" FROM CLIENTE"
				+" WHERE CEDULA= ?";
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionTicketsBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ps.setString(1, cedulaC);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		        
		     Cliente f= new Cliente();
		     f.setNombre(rs.getString("NOMBRE").trim());
		     f.setDireccion(rs.getString("DIRECCION"));
		     f.setTelefono(rs.getString("TELEFONO"));
		     f.setE_Mail(rs.getString("E_Mail"));
		     
		     
		     return f;
		        
		    }
		   
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionTicketsBD.close(con);
		}
		return null;
	}
	
public List<Cliente> listar(String Direccion){
		
		List<Cliente> cliente= new ArrayList<Cliente>();             
		String sql="SELECT  CEDULA, NOMBRE, "
				+" DIRECCION, TELEFONO,E_MAIL "
				+" FROM CLIENTE"
				+" WHERE DIRECCION= ?";
				
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionTicketsBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ps.setString(1, Direccion);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		       Cliente c=new Cliente();
		       c.setCedula(rs.getString("Cedula").trim());
		       c.setNombre(rs.getString("Nombre"));
		       c.setDireccion(rs.getString("Direccion"));
		       c.setTelefono(rs.getString("Telefono"));
		       c.setE_Mail(rs.getString("E_Mail"));
		       
		        
		        cliente.add(c);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionTicketsBD.close(con);
		}
		return cliente;
	}
		
		
	}
	
	

