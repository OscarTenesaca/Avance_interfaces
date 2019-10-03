package ec.edu.ups.est.p3.oad;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.est.p3.modelo.Tickets;
import ec.edu.ups.est.p3.utilidades.ConexionTicketsBD;
/**
 * 
 * @author Oscar tenesaca
 *
 */
public class TicketBD {
	
	public void insertar(Tickets tickets){
		Connection c=null;
		String sql =  "INSERT INTO TICKET (NUMERO_TICKET, "
				+ "      PLACA, FECHA, HORA_ENTRADA) "
			
				+ "VALUES (?,?,?,?);";
		try {
			c= ConexionTicketsBD.getConnection();
		    
			PreparedStatement ps= c.prepareStatement(sql);
			ps.setInt(1,tickets.getNumero_ticket());
		    ps.setString(2, tickets.getPlaca());
		    ps.setDate(3, new java.sql.Date(tickets.getFecha().getTime()));
		    ps.setTime(4, new java.sql.Time(tickets.getHora_entrada().getTime()));
		    
		    ps.executeUpdate();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionTicketsBD.close(c);
		}	
	}

	/**
	 * 
	 * @return retorna el codigo de ticket automaticamente
	 * 
	 */
	public long codigo(){
		
		long codigos=1;
		Connection c=null;
		String sql= "SELECT MAX (NUMERO_TICKET) AS NUMERO_TICKET"
				+"		FROM TICKET";
		try{
			c=ConexionTicketsBD.getConnection();
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
		codigos=rs.getInt("NUMERO_TICKET")+1;
			
		}catch(Exception e1){
			e1.printStackTrace();
			
		}finally {
			ConexionTicketsBD.close(c);
		}
		return codigos;	
	}
	
	/**
	 * 
	 * @param Ticket
	 *  actualiza la hora de salida del vehiculo
	 * y guarda en nuestra tabla
	 */
public void actualizarHoraSalida(int Ticket, String tiempo ){

	String sql="UPDATE TICKET " 
			+"SET HORA_SALIDA=?, "
			+"TIEMPO=? "
			+"WHERE NUMERO_TICKET=? " ;
	System.out.println((sql));
	Connection con=null;
	try{
		con=ConexionTicketsBD.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);

		ps.setTime(1,new java.sql.Time(new java.util.Date().getTime())); 
		ps.setString(2,tiempo);
		ps.setInt(3, Ticket);

		ps.executeUpdate();
	}catch(Exception exe){
		exe.printStackTrace();
	}finally{
		ConexionTicketsBD.close(con);
	}
		
		
	}
	

	/**
	 * 
	 * @param numeroTicket
	 *  leera un numero de ticket para buscar el la base de datos
	 * @return datos
	 * las variables con los datos
	 * y lee las variables del sql
	 */
	public Tickets leer(int numeroTicket){
        
		String sql="SELECT NUMERO_TICKET, PLACA, "
				+ "       FECHA, HORA_ENTRADA "
				+ " FROM TICKET"
				+ " WHERE NUMERO_TICKET= ?";
		
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionTicketsBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ps.setInt(1, numeroTicket);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		        
		       Tickets tk = new Tickets();
		       
		       tk.setPlaca(rs.getString("PLACA").trim());
		       tk.setFecha(rs.getDate("FECHA"));
		       tk.setHora_entrada(rs.getTime("HORA_ENTRADA"));
		     return tk;
		        
		    }
		   
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionTicketsBD.close(con);
		}
		return null;
	}
	
	/**
	 * 
	 * @param fecha para buscar de una fecha a otra
	 * @param fecha1 la segunda fecha para la comparacion
	 * @return listar 
	 */
public List<Tickets> listar(String fecha, String fecha1){
		
		List<Tickets> tickets= new ArrayList<Tickets>();             
		String sql="SELECT NUMERO_TICKET, PLACA, "
				+ "       FECHA, HORA_ENTRADA "
				+ "FROM TICKET "
				+" WHERE TO_CHAR(FECHA, 'yyyy-MM-dd')>=? AND TO_CHAR (FECHA, 'yyyy-MM-dd')<=? ;";
		
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionTicketsBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ps.setString(1, fecha);
		    ps.setString(2, fecha1);
		    
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		        Tickets tk = new Tickets();
		        tk.setNumero_ticket(rs.getInt("NUMERO_TICKET"));
		        tk.setPlaca(rs.getString("PLACA").trim());
		        tk.setFecha(rs.getDate("FECHA"));
		        tk.setHora_entrada(rs.getTime("HORA_ENTRADA"));
		        tickets.add(tk);  
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionTicketsBD.close(con);
		}
		return tickets;
	}

}
