package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ec.edu.ups.est.p3.modelo.Cliente;
import ec.edu.ups.est.p3.oad.ClienteBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * OSCAR TENESACA
 * UPS
 */
public class ClienteGF extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	Cliente c=new Cliente();
	ClienteBD cbd=new ClienteBD();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGF frame = new ClienteGF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * es la ventana de la interface que nos va a permitir ingresar los datos
	 * de un cliente 
	 */
	public ClienteGF() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(50, 44, 46, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 68, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(50, 94, 46, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(50, 119, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(50, 144, 46, 14);
		contentPane.add(lblEmail);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(126, 41, 86, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(126, 65, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(126, 91, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(126, 116, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(126, 141, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				c.setCedula(txtCedula.getText());
				c.setNombre(txtNombre.getText());
				c.setDireccion(txtDireccion.getText());
				c.setTelefono(txtTelefono.getText());
				c.setE_Mail(txtEmail.getText());
				
				cbd.insertar(c);
				
			}
		});
		btnGuardar.setBounds(50, 195, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(167, 195, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(274, 195, 89, 23);
		contentPane.add(btnBorrar);
	}
}
