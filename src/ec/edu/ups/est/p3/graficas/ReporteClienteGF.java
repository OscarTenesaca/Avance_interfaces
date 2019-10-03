package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReporteClienteGF extends JFrame {

	private JPanel contentPane;

	/**
	 * La ventana del reporte de los clientes
	 * .
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteClienteGF frame = new ReporteClienteGF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * la ventana que nos permitira ingresar la fecha y nos mostrara los datos 
	 * en la tabla de la Base de datos
	 */
	public ReporteClienteGF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
