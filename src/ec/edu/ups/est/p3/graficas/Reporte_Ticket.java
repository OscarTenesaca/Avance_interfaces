package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ec.edu.ups.est.p3.modelo.Tickets;
import ec.edu.ups.est.p3.oad.TicketBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Oscar
 *
 */
public class Reporte_Ticket extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt_desde;
	private JTextField txt_hasta;
	private JTable table_1;
	private JSeparator separador;
	TicketBD tBD=new TicketBD();


	/**
	 * Launch the nos muestra los datosn ingresados en la tabla.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte_Ticket frame = new Reporte_Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Reporte_Ticket pues el metodo donde se muetra los datos
	 */
	public Reporte_Ticket() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 58, 538, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(6, 28, 61, 16);
		panel.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(6, 67, 61, 16);
		panel.add(lblHasta);
		
		txt_desde = new JTextField();
		txt_desde.setBounds(73, 16, 134, 28);
		panel.add(txt_desde);
		txt_desde.setColumns(10);
		
		txt_hasta = new JTextField();
		txt_hasta.setBounds(73, 61, 134, 28);
		panel.add(txt_hasta);
		txt_hasta.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cont=0;
				for(Tickets t: tBD.listar(txt_desde.getText(),txt_hasta.getText())){
				cont++;
				
				
				
				table.setValueAt(t.getNumero_ticket(), cont, 0);
				table.setValueAt(t.getPlaca(), cont, 1);
				table.setValueAt(t.getFecha(), cont, 2);
				table.setValueAt(t.getHora_entrada(), cont, 3);
				
				
				
				
				}
				
			}
		});
		btnBuscar.setBounds(316, 42, 89, 23);
		panel.add(btnBuscar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String desde=txt_desde.getText();
				String hasta=txt_hasta.getText();
				Ventana tr= new Ventana(desde, hasta);
				
				tr.setVisible(true);
				tr.setSize(700,700);
				
			}
		});
		btnImprimir.setBounds(26, 298, 117, 29);
		contentPane.add(btnImprimir);
		
		
		Object filas [][]=new Object[100][4];
		String columnas[] = new String[]{"N_Ticket","Placa_Vehiculo","fecha","hora de entrada"};
		table = new JTable(filas,columnas);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(16, 175, 529, 111);
		table.setValueAt("N_Ticket", 0, 0);
		table.setValueAt("Placa_Vehiculo", 0, 1);
		table.setValueAt("Fecha", 0, 2);
		table.setValueAt("Hora de entrada", 0, 3);
		getContentPane().add(table);
		
		
	}
	
	
}
