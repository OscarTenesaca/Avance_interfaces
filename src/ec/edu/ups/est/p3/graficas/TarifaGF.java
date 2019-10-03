package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import ec.edu.ups.est.p3.modelo.Tarifa;
import ec.edu.ups.est.p3.oad.TarifaBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Oscar Tenesaca
 *
 */
public class TarifaGF extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtcodigo;
	private JButton btnModificar;
	private JButton btnAceptar;
	Tarifa t=new Tarifa();
	TarifaBD tbd=new TarifaBD();
	
	

	/**
	 * Tarifa nos permite ingresar los valores para 
	 * los precios 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarifaGF frame = new TarifaGF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ventana nos permitira inicializar las variables 
	 */
	public TarifaGF() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 23, 330, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(75, 75, 46, 14);
		panel.add(lblPrecio);
		
		JLabel lblTarifa = new JLabel("Codigo");
		lblTarifa.setBounds(75, 42, 46, 14);
		panel.add(lblTarifa);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(159, 72, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		txtcodigo = new JTextField();
		txtcodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo=Integer.parseInt(txtcodigo.getText());
				txtPrecio.setText(String.valueOf(tbd.leer(codigo).getPrecio()));
				
			}
		});
		txtcodigo.setBounds(159, 39, 86, 20);
		panel.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				
				int codigo=Integer.parseInt(txtcodigo.getText());
				double precio=Double.parseDouble(txtPrecio.getText());
				System.out.println(codigo+"kkk"+precio);
				tbd.actualizar(codigo, precio);
				double precioTAC=tbd.codigo();
				  
			}
		});
		btnModificar.setBounds(53, 114, 89, 23);
		panel.add(btnModificar);
		
		btnAceptar = new JButton("Aceptar");
				btnAceptar.setBounds(180, 114, 89, 23);
		panel.add(btnAceptar);
		
		txtPrecio.setEditable(false);
		txtcodigo.setEditable(false);
		
		JRadioButton rdbtnActivar = new JRadioButton("Activar");
		rdbtnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtPrecio.setEditable(true);
				txtcodigo.setEditable(true);
			
			}
		});
		rdbtnActivar.setBounds(262, 7, 109, 23);
		panel.add(rdbtnActivar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setCodigo(Integer.parseInt(txtcodigo.getText()));
				t.setPrecio(Double.parseDouble(txtPrecio.getText()));
				
				tbd.Insertar(t);
				
				
			}
		});
	
	}

	
	
	

}
