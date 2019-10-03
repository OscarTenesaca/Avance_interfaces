package ec.edu.ups.est.p3.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * @author Oscar tenesaca
 *
 */
public class ConexionTicketsBD {
	/**
	 * 
	 * @return la conexion conel sql
	 */
	public static Connection getConnection() {
        try {
        	
        	Class.forName("org.hsqldb.jdbcDriver");  
        	Connection con = DriverManager.getConnection(  
                    "jdbc:hsqldb:file:resources/bd/bdparqueadero", "Oscar", "");  
        	  System.out.println("conectando:");
        	
        	return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
	/**
	 * 
	 * @param con
	 * permite la conexion de la base de datos 
	 * conexion
	 * 
	 */
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
	
	
/**
 * fin del programa
 */
}
