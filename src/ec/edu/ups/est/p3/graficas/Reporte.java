package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.omg.CORBA.OBJ_ADAPTER;

import ec.edu.ups.est.p3.modelo.Cliente;
import ec.edu.ups.est.p3.oad.ClienteBD;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtCiudad;
	private JButton btnImprimir;
	ClienteBD cbd=new ClienteBD();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reporte() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object filas [][]=new Object[10][4];
		String columnas[] = new String[]{"Cedula","Nombre","telefono","E-mail"};
		table = new JTable(filas,columnas);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(6, 136, 545, 111);
		table.setValueAt("Cedula", 0, 0);
		table.setValueAt("Nombre", 0, 1);
		table.setValueAt("telefono", 0, 2);
		table.setValueAt("E-mail", 0, 3);
		getContentPane().add(table);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(6, 86, 67, 16);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int con=0;
			for(Cliente c: cbd.listar(txtCiudad.getText())){
				con++;
				table.setValueAt(c.getCedula(), con, 0);
				table.setValueAt(c.getNombre(), con, 1);
				table.setValueAt(c.getTelefono(), con, 2);
				table.setValueAt(c.getE_Mail(), con, 3);
				
			}
				
			}
		});
		txtCiudad.setBounds(73, 80, 161, 28);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(230, 259, 117, 29);
		contentPane.add(btnImprimir);
		
		JLabel lblReporteDeCliente = new JLabel("Reporte de Clientes");
		lblReporteDeCliente.setFont(new Font("Viner Hand ITC", Font.PLAIN, 24));
		lblReporteDeCliente.setForeground(new Color(0, 0, 153));
		lblReporteDeCliente.setBounds(159, 11, 226, 28);
		contentPane.add(lblReporteDeCliente);
		
	}
}
