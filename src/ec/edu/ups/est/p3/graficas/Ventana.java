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
 * @author Oscar Tenesaca
 *
 */
public class Ventana extends JFrame{

	private JRViewer viewer;
	
	private JTextField txtEdadMinima;
	
	public Ventana(String desde, String hasta){
		String desdepdf=desde;
		String hastapdf=hasta;
		try{
			getContentPane().remove(viewer);
		}catch(Exception e){}
		
		
		HashMap parametros = new HashMap();
		parametros.put("desdejr", desdepdf);
		parametros.put("hastajr", hastapdf);
		
		CallReport cr = new CallReport();
		JasperPrint jasperPrint = cr.generateReport("/reportesPDF/PDF/reporteParqueaderoPDF", parametros);
		
		viewer = new JRViewer(jasperPrint);
		getContentPane().add(viewer, BorderLayout.CENTER);
		


	}

	
	
}
