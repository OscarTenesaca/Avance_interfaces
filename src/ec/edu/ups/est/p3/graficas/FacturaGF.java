package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


import javax.swing.JCheckBox;

import ec.edu.ups.est.p3.modelo.Factura;
import ec.edu.ups.est.p3.oad.ClienteBD;
import ec.edu.ups.est.p3.oad.FacturaBD;
import ec.edu.ups.est.p3.utilidades.ImprimirFactura;


/**
 * Esta clase es generar la factura.
 * 
 * @author OSCAR TENESACA
 *
 */
public class FacturaGF extends JFrame {
	Factura f=new Factura();
	FacturaBD fbd=new FacturaBD();
	ClienteBD cbd=new ClienteBD();
	 JPanel contentPane;
	 JTextField txtplaca;
	 JTextField txtcliente;
	 JTextField txtruc;
	 JTextField txtdireccion;
	 JTextField txttelefono;
	 JTextField txttiempo;
	 JTextField txtmonto;
	 JTextField txtiva;
	 JTextField txttotal;
	 JTextField txtfecha;
	 JTextField txt_pago;
	 JTextField txt_cambio;
	 JTextField txtEmail;
	 ButtonGroup grupo;
	 JTextField txt_nFactura;
	
	
	 JTextField txt_Entrada;
	 JLabel lblNombre;
	 JLabel lblRuccedula;
	 JLabel lblDireccion;
	 JLabel lblTelefono;
	 JLabel lblPlaca ;
	 JLabel lblMonto;
	 JLabel lblIva;
	 JLabel lblTiempo;
	 JLabel lblTotalapagar;
	 JLabel lblFecha;
	 JLabel lblPago;
	 JLabel lblCambio;
	 JLabel lblEmail;
	 JLabel lblHoraEntrada;
	 JLabel lblHoraSalida;
	 JLabel lblNFactura ;
	 JCheckBox chckbxCliente ;
	 JCheckBox chckbxConsumidorFinal;
	 
	 long codigo_Factura;
	 JButton btnImprimir; 
	 JTextField txt_Salida;
	 
	
	 
	 private Locale localizacion;
	 static ResourceBundle mensaje;
	 private JButton btnGenerarCliente;
	 private JLabel lblTicket;
	  JTextField txt_Tic;
	 
	 
	 
	/**
	 * Nos muestra la ventana de la factura para ingresar los datoscorrespondiente como 
	 * consumidor final o Cliente
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaGF frame = new FacturaGF(mensaje);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * es el contenedor donde se inicialisaran las variables .
	 */
	public FacturaGF(ResourceBundle mensaje) {
		this.mensaje=mensaje;

		
		codigo_Factura=fbd.codigoF();
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 515, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNombre = new JLabel(mensaje.getString("lblNombre"));
		lblNombre.setBounds(10, 121, 61, 16);
		panel.add(lblNombre);
		
		lblRuccedula = new JLabel(mensaje.getString("lblRuccedula"));
		lblRuccedula.setBounds(10, 93, 84, 16);
		panel.add(lblRuccedula);
		
		lblDireccion = new JLabel(mensaje.getString("lblDireccion"));
		lblDireccion.setBounds(267, 81, 61, 16);
		panel.add(lblDireccion);
		
		lblTelefono = new JLabel(mensaje.getString("lblTelefono"));
		lblTelefono.setBounds(267, 109, 61, 16);
		panel.add(lblTelefono);
		
		lblPlaca = new JLabel(mensaje.getString("lblPlacavehiculo"));
		lblPlaca.setBounds(10, 146, 61, 16);
		panel.add(lblPlaca);
		
		lblMonto = new JLabel(mensaje.getString("lblMonto"));
		lblMonto.setBounds(10, 260, 61, 16);
		panel.add(lblMonto);
		
		lblIva = new JLabel(mensaje.getString("lblIva"));
		lblIva.setBounds(21, 287, 61, 16);
		panel.add(lblIva);
		
		lblTotalapagar = new JLabel(mensaje.getString("lblTotalapagar"));
		lblTotalapagar.setBounds(0, 315, 94, 16);
		panel.add(lblTotalapagar);
		
		lblTiempo = new JLabel(mensaje.getString("lblTiempo"));
		lblTiempo.setBounds(10, 233, 61, 16);
		panel.add(lblTiempo);
		
		lblFecha = new JLabel(mensaje.getString("lblFecha"));
		lblFecha.setBounds(267, 54, 61, 16);
		panel.add(lblFecha);
		
		lblPago = new JLabel(mensaje.getString("lblPago"));
		lblPago.setBounds(9, 406, 61, 16);
		panel.add(lblPago);
		
		lblCambio = new JLabel(mensaje.getString("lblCambio"));
		lblCambio.setBounds(279, 400, 61, 16);
		panel.add(lblCambio);
		
		lblEmail = new JLabel(mensaje.getString("lblEmail"));
		lblEmail.setBounds(267, 146, 61, 16);
		panel.add(lblEmail);
		
		lblHoraEntrada = new JLabel(mensaje.getString("lblHoraEntrada"));
		lblHoraEntrada.setBounds(0, 173, 72, 14);
		panel.add(lblHoraEntrada);
		
		lblHoraSalida = new JLabel(mensaje.getString("lblHoraSalida"));
		lblHoraSalida.setBounds(261, 173, 67, 14);
		panel.add(lblHoraSalida);
		
		
		btnImprimir = new JButton(mensaje.getString("btnImprimir"));
		btnImprimir.setBounds(173, 473, 117, 29);
		panel.add(btnImprimir);
		
		txtplaca = new JTextField();
		txtplaca.setBounds(105, 137, 134, 25);
		panel.add(txtplaca);
		txtplaca.setColumns(10);
		
		txtcliente = new JTextField();
		txtcliente.setBounds(105, 109, 134, 25);
		panel.add(txtcliente);
		txtcliente.setColumns(10);
		
		txtruc = new JTextField();
		txtruc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CedulaCom;
			CedulaCom=txtruc.getText();	
			txtcliente.setText(cbd.leer(CedulaCom).getNombre());
			txtdireccion.setText(cbd.leer(CedulaCom).getDireccion());
			txttelefono.setText(cbd.leer(CedulaCom).getTelefono());
			txtEmail.setText(cbd.leer(CedulaCom).getE_Mail());
			
				
			}
		});
		txtruc.setBounds(105, 81, 134, 28);
		panel.add(txtruc);
		txtruc.setColumns(10);
		
		txtdireccion = new JTextField();
		txtdireccion.setBounds(347, 78, 134, 28);
		panel.add(txtdireccion);
		txtdireccion.setColumns(10);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(347, 109, 134, 25);
		panel.add(txttelefono);
		txttelefono.setColumns(10);
		
		txttiempo = new JTextField();
		txttiempo.setBounds(105, 219, 134, 28);
		panel.add(txttiempo);
		txttiempo.setColumns(10);
		
		
		
		txtmonto = new JTextField();
		txtmonto.setBounds(105, 243, 134, 28);
		panel.add(txtmonto);
		txtmonto.setColumns(10);
		
		txtiva = new JTextField();
		txtiva.setBounds(105, 270, 134, 28);
		panel.add(txtiva);
		txtiva.setColumns(10);
		txtiva.setText("0.14");
		
		
		txttotal = new JTextField();
		txttotal.setBounds(105, 303, 134, 28);
		panel.add(txttotal);
		txttotal.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(347, 48, 134, 28);
		panel.add(txtfecha);
		txtfecha.setColumns(10);
		
		txt_pago = new JTextField();
		txt_pago.setBounds(10, 439, 134, 28);
		panel.add(txt_pago);
		txt_pago.setColumns(10);
		
		txt_cambio = new JTextField();
		txt_cambio.setBounds(279, 433, 134, 28);
		panel.add(txt_cambio);
		txt_cambio.setColumns(10);
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(347, 134, 134, 28);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
	
		
		chckbxCliente = new JCheckBox(mensaje.getString("chckbxCliente"));
		chckbxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcliente.setText("");
				txtruc.setText(""); 
				
				
				
			}
		});
		chckbxCliente.setBounds(65, 7, 97, 23);
		panel.add(chckbxCliente);
		
		chckbxConsumidorFinal = new JCheckBox(mensaje.getString("chckbxConsumidorFinal"));
		chckbxConsumidorFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcliente.setText("xxxxxxxx");
				txtruc.setText("000000000");
				txtdireccion.setText("xxxxxx");
				txtEmail.setText("xxxxxx");
				txttelefono.setText("9999999999");
				
				
			}
		});
		chckbxConsumidorFinal.setBounds(193, 7, 134, 23);
		panel.add(chckbxConsumidorFinal);
		

		grupo =new ButtonGroup();
		grupo.add(chckbxCliente);
		grupo.add(chckbxConsumidorFinal);
		
		lblNFactura = new JLabel(mensaje.getString("lblNFactura"));
		lblNFactura.setBounds(10, 62, 61, 14);
		panel.add(lblNFactura);
		
		txt_nFactura = new JTextField();
		txt_nFactura.setText(""+codigo_Factura);
		txt_nFactura.setEnabled(false);
		txt_nFactura.setBounds(105, 48, 134, 29);
		panel.add(txt_nFactura);
		txt_nFactura.setColumns(10);
		
		
		txt_Entrada = new JTextField();
		txt_Entrada.setBounds(105, 164, 134, 25);
		panel.add(txt_Entrada);
		txt_Entrada.setColumns(10);
		
		txt_Salida = new JTextField();
		txt_Salida.setBounds(347, 166, 134, 28);
		panel.add(txt_Salida);
		txt_Salida.setColumns(10);

		
		btnGenerarCliente = new JButton("Generar Cliente");
		btnGenerarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteGF op=new ClienteGF();
				op.setVisible(true);
				
			}
		});
		btnGenerarCliente.setBounds(347, 11, 134, 23);
		panel.add(btnGenerarCliente);
		
		lblTicket = new JLabel("Ticket");
		lblTicket.setBounds(300, 226, 46, 14);
		panel.add(lblTicket);
		
		txt_Tic = new JTextField();
		txt_Tic.setBounds(347, 223, 86, 20);
		panel.add(txt_Tic);
		txt_Tic.setColumns(10);
		
	
		
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula=txtruc.getText();
				int N_Ticket=Integer.parseInt(txt_Tic.getText());
				int N_Factura=Integer.parseInt(txt_nFactura.getText());
				VentanaFacturaPDF vf=new VentanaFacturaPDF(cedula, N_Ticket,N_Factura);
				vf.setVisible(true);
				vf.setSize(700,700);
								
			
			String placa;
			placa=txtplaca.getText();
			placa.trim();
			
			f.setCodigoFactura(new Integer(txt_nFactura.getText()).intValue());
			f.setCedula(txtruc.getText());
			f.setNumero_ticket(new Integer(txt_Tic.getText()).intValue());
			f.setMonto(Double.parseDouble(txtmonto.getText()));
			f.setIva(Double.parseDouble(txtiva.getText()));
			f.setTotal(Double.parseDouble(txttotal.getText()));
			f.setPago(Double.parseDouble(txt_pago.getText()));
			f.setCambio(Double.parseDouble(txt_cambio.getText()));
			
			
			fbd.insertar(f);
			
		
			codigo_Factura=1+Long.parseLong(txt_nFactura.getText());
			txt_nFactura.setText(""+codigo_Factura);
			
			txt_nFactura.setText("");
			txtruc.setText("");
			txtcliente.setText("");
			txtplaca.setText("");
			txt_Entrada.setText("");
			txtfecha.setText("");
			txtdireccion.setText("");
			txttelefono.setText("");
			txtEmail.setText("");
			txt_Salida.setText("");
			txttiempo.setText("");
			txtmonto.setText("");
			txtiva.setText("");
			txttotal.setText("");
			txt_pago.setText("");
			txt_cambio.setText("");
			}
			
			int codigo=Integer.parseInt(txt_nFactura.getText());
			String codigoticket="1";
			
		
			
		});
		
		
	}
	
	
}
