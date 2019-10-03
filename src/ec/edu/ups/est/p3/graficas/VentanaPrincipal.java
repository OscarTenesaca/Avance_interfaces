 package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Oscar Tenesaca
 *
 */
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField password;

	/**
	 * la ventana principal que arranca el programa.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Nos permite inicializar las variables .
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsusraio = new JLabel("Usuario");
		lblUsusraio.setBounds(52, 54, 46, 14);
		contentPane.add(lblUsusraio);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setBounds(52, 90, 77, 14);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(134, 51, 123, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(134, 87, 123, 20);
		contentPane.add(password);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(65, 154, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancear = new JButton("Cancelar");
		btnCancear.setBounds(211, 154, 89, 23);
		contentPane.add(btnCancear);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(String.valueOf(txtUsuario.getText()).compareTo("pepito")==0 && String .valueOf(password.getPassword()).compareTo("pepito")==0){
					Principal p= new Principal();
					p.setVisible(true);
					dispose();
				}else {
					
					JOptionPane.showMessageDialog(rootPane, "Usuario o contrsena");
				}
				
			}
		});
		
		
	}
}
