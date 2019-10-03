package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.commons.collections.map.HashedMap;

import ec.edu.ups.est.p3.jasperreport.CallReport;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
/**
 * 
 * @author
 *
 */
public class VentanaFacturaPDF extends JFrame{

	private JRViewer viewer;
	
	private JTextField txtEdadMinima;
	
	public VentanaFacturaPDF(String cedula,int nTicket,int nFactura){
		
		
		String cedulapdf=cedula;
		int N_TicketPDF=nTicket;
		int N_FacturaPDF=nFactura;
		try{
			getContentPane().remove(viewer);
		}catch(Exception e){}
		
		
		HashMap parametros = new HashMap();
		parametros.put("codCliente", cedulapdf);
		parametros.put("N_TICKET_IR", N_TicketPDF);
		parametros.put("N_FACTURA_IR", N_FacturaPDF);
		
		CallReport cr = new CallReport();
		JasperPrint jasperPrint = cr.generateReport("reportesPDF/PDF/reporteFactura1", parametros);
		
		viewer = new JRViewer(jasperPrint);
		getContentPane().add(viewer, BorderLayout.CENTER);
		


	}

	
	
}
