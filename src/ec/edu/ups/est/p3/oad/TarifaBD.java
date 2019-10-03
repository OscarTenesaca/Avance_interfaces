package ec.edu.ups.est.p3.oad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ec.edu.ups.est.p3.modelo.Tarifa;
import ec.edu.ups.est.p3.utilidades.ConexionTicketsBD;

public class TarifaBD {
	
	
	public void Insertar(Tarifa tarifa){
		
		Connection c=null;
		String sql= "INSERT INTO PRECIOS(CODIGO, PRECIO)"
		+"VALUES (?,?)";
		
		try{
			c=ConexionTicketsBD.getConnection();
			
			PreparedStatement ps=c.prepareStatement(sql);
			
			 ps.setInt(1, tarifa.getCodigo());
			 ps.setDouble(2, tarifa.getPrecio());
			 ps.executeUpdate();
			 
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			ConexionTicketsBD.close(c);
		}
		
	}
	
	public void actualizar( int codigo, double precio){
		
		String sql="UPDATE PRECIOS " 
				+"SET PRECIO=? "
				+"WHERE CODIGO=? " ;
		System.out.println((sql));
		Connection con=null;
		try{
			con=ConexionTicketsBD.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);

			ps.setDouble(1,precio);
			ps.setInt(2, codigo);
		
			
			ps.executeUpdate();
		}catch(Exception exe){
			exe.printStackTrace();
		}finally{
			ConexionTicketsBD.close(con);
		}
			
		
	}

public Tarifa leer( int codigomod){
        
		String sql="SELECT CODIGO ,PRECIO"
				+ " FROM PRECIOS"
				+ " WHERE CODIGO= ?";
		
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionTicketsBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ps.setInt(1, codigomod);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		        
		      Tarifa t=new Tarifa();
		      
		       t.setPrecio(rs.getDouble("PRECIO"));
		  
		      
		     return t; 
		    }
		   
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionTicketsBD.close(con);
		}
		return null;
	}
/*public double codigo(){
	double precio=0;
		Connection c=null;
	String sql= ""SELECT CODIGO ,PRECIO"
				+ " FROM PRECIOS"
				+ " WHERE CODIGO= ?"; "
			
	try{
		c=ConexionTicketsBD.getConnection();
		PreparedStatement ps=c.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
	codigos=rs.getDouble("PRECIO");
		
	}catch(Exception e1){
		e1.printStackTrace();
		
	}finally {
		ConexionTicketsBD.close(c);
	}
	return codigos;	
}
*/

public double codigo(){
	double codigos=0;
		Connection c=null;
	String sql= "SELECT MAX (PRECIO) AS PRECIO "
			+"		FROM PRECIOS ";
	try{
		c=ConexionTicketsBD.getConnection();
		PreparedStatement ps=c.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
	codigos=rs.getDouble("PRECIO");
		
	}catch(Exception e1){
		e1.printStackTrace();
		
	}finally {
		ConexionTicketsBD.close(c);
	}
	return codigos;	
}
		
	}
