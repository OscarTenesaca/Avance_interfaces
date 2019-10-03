 
package ec.edu.ups.est.p3.graficas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


import ec.edu.ups.est.p3.modelo.MiHilo;
import ec.edu.ups.est.p3.modelo.Tickets;
import ec.edu.ups.est.p3.oad.TarifaBD;
import ec.edu.ups.est.p3.oad.TicketBD;
import ec.edu.ups.est.p3.utilidades.Imprimir;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
/**
 * 
 * @author Oscar Tenesaca
 *
 */
public class Principal extends JFrame {
// inicializacion de las variables de tipo JTextField, JLabel,JButton y jMENU ETC..
	 JPanel contentPane;
	 JTextField txt_ticket_codigo;
	 JTextField txt_ticket_placa;
	 JTextField txt_ticket_fecha;
	 JTextField txt_ticket_entrada;
	 JTextField txt_facturar_ticket;
	 JTextField txt_facturar_placa;
	 JTextField txt_facturar_ingreso;
	 JTextField txt_facturar_salida;
	 JTextField txtDisponibles;
	 JTextField txtOcupados;
	 JTextField txt_facturar_fecha;
	 JLabel lblbienbenido;
	JTextPane txtmsj;
	JLabel lblCodigoticket;
	JLabel lblFecha;
	JLabel lblHoraentrada;
	JLabel lblPlacavehiculo;
	JLabel lblHorarios;
	JLabel lblLunesAViernes;
	JLabel lblNumerodefactura;
	JLabel lbl_Factura_Fecha_1;
	JLabel lblCapacidad;
	JLabel lblOcupados;
	JLabel lbl_Factura_Placa;
	JLabel lbl_Factura_ingreso;
	JLabel lbl_Factura_HoraSalida;
	
	JButton btnFacturar;
	JButton btnImprimir;
	JMenu mnPropiedades;
	long codigo_Generado;
	double precioTAC;
	private Locale localizacion;
	private  ResourceBundle mensaje;
	
	TicketBD tbd=new TicketBD();
	Tickets t=new Tickets();
	TarifaBD tarbd=new TarifaBD();
	// Variable que representa el puerto USB y permite realizar la conexion con el mismo
    private gnu.io.NRSerialPort puertoUSB;
    // Variable que representa el flujo de datos que envia el puerto USB
    private java.io.DataInputStream flujoUSB;
    java.io.DataOutputStream enviar;
    private JTextField txtTiempo;
    private JTextField txtSegundos;
    private JTextField txt1;
    private JTextField txt2;


	/**
	 * La ventana principal donde se mostrara despues de ingresar de la ventana
	 * de Usuario.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * La ventana principal la cual se mostrara la interface que no pedira la placa  y 
	 * automaticamente nos va imprimir el N_de Ticket
	 */
	public Principal() {
		
		
		/*
		 * La conexion de Arduino con el proyecto 
		 */
		//	conectar();
		
		Calendar tiempo=new GregorianCalendar();

		localizacion =new Locale("es","EC");
		mensaje=ResourceBundle.getBundle("recursos.lang.mensajes",localizacion);
		
		precioTAC=tarbd.codigo();
		 codigo_Generado=tbd.codigo();
		 
		 System.out.println(precioTAC);
		 
		
		SimpleDateFormat forma_dato= new SimpleDateFormat("yyyy-MM-dd");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(20, 32, 353, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblbienbenido = new JLabel(mensaje.getString("lblBienvenido"));
		lblbienbenido.setBounds(106, 25, 82, 22);
		panel.add(lblbienbenido);
		
		lblCodigoticket = new JLabel(mensaje.getString("lblCodigoticket"));
		lblCodigoticket.setBounds(10, 201, 103, 14);
		panel.add(lblCodigoticket);
		
	    lblFecha = new JLabel(mensaje.getString("lblFecha"));
		lblFecha.setBounds(10, 251, 82, 14);
		panel.add(lblFecha);
		
		lblHoraentrada = new JLabel(mensaje.getString("lblHoraentrada"));
		lblHoraentrada.setBounds(10, 277, 118, 14);
		panel.add(lblHoraentrada);
		
		lblPlacavehiculo = new JLabel(mensaje.getString("lblPlacavehiculo"));
		lblPlacavehiculo.setBounds(10, 226, 94, 14);
		panel.add(lblPlacavehiculo);
		
		lblHorarios = new JLabel(mensaje.getString("lblHorarios"));
		lblHorarios.setBounds(106, 58, 82, 14);
		panel.add(lblHorarios);
		
		lblLunesAViernes = new JLabel(mensaje.getString("lblLunesAViernes"));
		lblLunesAViernes.setBounds(43, 83, 253, 14);
		panel.add(lblLunesAViernes);
		
		txtmsj = new JTextPane();
		txtmsj.setBounds(20, 106, 276, 83);
		panel.add(txtmsj);
		txtmsj.setEnabled(false);
				
		
		txt_ticket_codigo = new JTextField();
		txt_ticket_codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txt_ticket_codigo.setBounds(114, 198, 125, 20);
		txt_ticket_codigo.setText(""+codigo_Generado); 
		panel.add(txt_ticket_codigo);
		txt_ticket_codigo.setColumns(10);
		txt_ticket_codigo.setEditable(false);
		
				
		txt_ticket_placa = new JTextField();
		txt_ticket_placa.setBounds(114, 223, 125, 20);
		panel.add(txt_ticket_placa);
		txt_ticket_placa.setColumns(10);
		
		
		txt_ticket_fecha = new JTextField();
		txt_ticket_fecha.setBounds(114, 248, 125, 20);
		txt_ticket_fecha.setText(forma_dato.format(tiempo.getTime()));
		panel.add(txt_ticket_fecha);
		txt_ticket_fecha.setColumns(10);
		txt_ticket_fecha.setEnabled(false);
		
		txt_ticket_entrada = new JTextField();
		txt_ticket_entrada.setBounds(114, 274, 125, 20);
		txt_ticket_entrada.setText(tiempo.get(Calendar.HOUR_OF_DAY)+":"+tiempo.get(Calendar.MINUTE)+":"+tiempo.get(Calendar.SECOND));
		
		panel.add(txt_ticket_entrada);
		txt_ticket_entrada.setColumns(10);
		txt_ticket_entrada.setEnabled(false);
		MiHilo mH=new MiHilo(txt_ticket_entrada);
		mH.start();
		
		
		btnImprimir = new JButton(mensaje.getString("btnImprimir"));
		btnImprimir.setBounds(111, 338, 89, 23);
		panel.add(btnImprimir);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(375, 32, 326, 381);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNumerodefactura = new JLabel(mensaje.getString("lblCodigoticket"));
		lblNumerodefactura.setBounds(10, 63, 126, 14);
		panel_1.add(lblNumerodefactura);
		
		txt_facturar_ticket = new JTextField();
		txt_facturar_ticket.setBounds(103, 60, 98, 20);
		panel_1.add(txt_facturar_ticket);
		txt_facturar_ticket.setColumns(10);
		
		lbl_Factura_Placa = new JLabel(mensaje.getString("lblFecha"));
		lbl_Factura_Placa.setBounds(10, 127, 46, 14);
		panel_1.add(lbl_Factura_Placa);
		
		lbl_Factura_ingreso = new JLabel(mensaje.getString("lblHoraentrada"));
		lbl_Factura_ingreso.setBounds(10, 152, 98, 14);
		panel_1.add(lbl_Factura_ingreso);
		
		lbl_Factura_HoraSalida = new JLabel(mensaje.getString("lblHoraSalida"));
		lbl_Factura_HoraSalida.setBounds(10, 177, 98, 14);
		panel_1.add(lbl_Factura_HoraSalida);
		
		txt_facturar_placa = new JTextField();
		txt_facturar_placa.setBounds(103, 124, 98, 20);
		panel_1.add(txt_facturar_placa);
		txt_facturar_placa.setColumns(10);
		
		txt_facturar_ingreso = new JTextField();
		txt_facturar_ingreso.setBounds(103, 149, 98, 20);
		panel_1.add(txt_facturar_ingreso);
		txt_facturar_ingreso.setColumns(10);
		
		txt_facturar_salida = new JTextField();
		txt_facturar_salida.setBounds(103, 174, 98, 20);
		panel_1.add(txt_facturar_salida);
		txt_facturar_salida.setColumns(10);
		
		lbl_Factura_Fecha_1 = new JLabel(mensaje.getString("lblFecha"));
		lbl_Factura_Fecha_1.setBounds(10, 102, 46, 14);
		panel_1.add(lbl_Factura_Fecha_1);
		
		txt_facturar_fecha = new JTextField();
		txt_facturar_fecha.setBounds(103, 99, 98, 20);
		panel_1.add(txt_facturar_fecha);
		txt_facturar_fecha.setColumns(10);
		
		btnFacturar = new JButton(mensaje.getString("btnFacturar"));
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				FacturaGF ft=new FacturaGF(mensaje);
				ft.txtplaca.setText(txt_facturar_placa.getText());
				ft.txtfecha.setText(txt_facturar_fecha.getText());
				ft.txt_Entrada.setText(txt_facturar_ingreso.getText());
				ft.txt_Salida.setText(txt_facturar_salida.getText());
				ft.txt_Tic.setText(txt_facturar_ticket.getText());
				ft.txtplaca.setText(txt_facturar_placa.getText());
				ft.txttiempo.setText(txtTiempo.getText());
				
				ft.txtmonto.setText(txt1.getText());
				ft.txttotal.setText(txt2.getText());
				
				
				ft.setVisible(true);
				/*
				enviar=new java.io.DataOutputStream(puertoUSB.getOutputStream());
				try {
					enviar.write(2);
					enviar.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			*/
				int ocupados=0;
				int sum=1;
				int ocutotal=0;
				if(e.getSource()==btnFacturar){
					
									
					System.out.println (ocupados+sum);
					txtOcupados.setText(String.valueOf(ocutotal));
				}
				
			
			}
		});
		btnFacturar.setBounds(112, 281, 89, 23);
		panel_1.add(btnFacturar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(711, 33, 135, 380);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblCapacidad = new JLabel("Disponibles");
		lblCapacidad.setBounds(9, 36, 85, 14);
		panel_2.add(lblCapacidad);
		
		txtDisponibles = new JTextField();
		txtDisponibles.setBounds(8, 61, 86, 20);
		panel_2.add(txtDisponibles);
		txtDisponibles.setColumns(10);
		txtDisponibles.setText("20");
		
		lblOcupados = new JLabel("Ocupados");
		lblOcupados.setBounds(9, 100, 85, 14);
		panel_2.add(lblOcupados);
		
		txtOcupados = new JTextField();
		txtOcupados.setBounds(9, 125, 85, 20);
		panel_2.add(txtOcupados);
		txtOcupados.setColumns(10);

		int ocupados=0;
		txtOcupados.setText(String.valueOf(ocupados));
		
		
		
		JLabel imagen = new JLabel(" ");
		imagen.setForeground(new Color(0, 0, 0));
		imagen.setIcon(new ImageIcon("carro.png"));
		imagen.setBounds(9, 202, 106, 137);
		panel_2.add(imagen, BorderLayout.CENTER);
		
		txt1 = new JTextField();
		txt1.setBounds(81, 61, 7, 20);
		panel_2.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(88, 125, 7, 20);
		panel_2.add(txt2);
		txt2.setColumns(10);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 12, 277, 22);
		contentPane.add(menuBar);
		
		mnPropiedades = new JMenu(mensaje.getString("mnPropiedades"));
		menuBar.add(mnPropiedades);
	
		
		JMenuItem mnrep = new JMenuItem("Rerpote");
		mnrep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reporte ob=new Reporte();
				ob.setVisible(true);
				
			}
		});
		mnPropiedades.add(mnrep);
		
		JMenuItem report = new JMenuItem("Rerpote_Tiket");
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reporte_Ticket op=new Reporte_Ticket();
				op.setVisible(true);
				
			}
		});
		mnPropiedades.add(report);
		
		JMenuItem Tarifa = new JMenuItem("Tarifas");
		Tarifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TarifaGF op=new TarifaGF();
				op.setVisible(true);
				
			}
		});
		mnPropiedades.add(Tarifa);
		
		txt_facturar_fecha.setEnabled(false);
		txt_facturar_ingreso.setEnabled(false);
		txt_facturar_placa.setEnabled(false);
		txt_facturar_salida.setEnabled(false);
		
		JButton btnLimpiar = new JButton("limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Limpia la caja de texto 
				
				txt_facturar_ticket.setText("");
				txt_facturar_fecha.setText("");
				txt_facturar_ingreso.setText("");
				txt_facturar_placa.setText("");
				txt_facturar_salida.setText("");
				txt_ticket_placa.setText("");
				txtTiempo.setText("");

			}
		});
		btnLimpiar.setBounds(222, 59, 29, 23);
		panel_1.add(btnLimpiar);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setBounds(20, 202, 46, 14);
		panel_1.add(lblTiempo);
		
		txtTiempo = new JTextField();
		txtTiempo.setBounds(103, 202, 98, 20);
		panel_1.add(txtTiempo);
		txtTiempo.setColumns(10);
		
		txtSegundos = new JTextField();
		txtSegundos.setBounds(222, 202, 86, 20);
		panel_1.add(txtSegundos);
		txtSegundos.setColumns(10);
		
		JButton btnespanol = new JButton("Espanol");
		btnespanol.setBounds(10, 424, 89, 23);
		contentPane.add(btnespanol);
		
		JButton btnIngles = new JButton("Ingles");
		btnIngles.setBounds(109, 424, 89, 23);
		contentPane.add(btnIngles);
		
		JButton btnFrances = new JButton("Frances");
		btnFrances.setBounds(208, 424, 89, 23);
		contentPane.add(btnFrances);
		btnFrances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cambiarIdiomas(new Locale("fr", "FR"));
			
			}
		});
		btnIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarIdiomas(new Locale("en", "US"));	
				new FacturaGF(mensaje);


			}
		});
		btnespanol.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
					cambiarIdiomas(new Locale("es", "EC"));
						new FacturaGF(mensaje);
				
			}
		});
		 
		
		btnImprimir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					t.setNumero_ticket(new Integer(txt_ticket_codigo.getText()).intValue());
					t.setPlaca(txt_ticket_placa.getText());
				String dato=txt_ticket_fecha.getText().trim();
				Date fecha= null;
				try {
					
					SimpleDateFormat forma= new SimpleDateFormat("yyyy-MM-dd");
					fecha=forma.parse(dato);
					System.out.println(dato);
					
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
				t.setFecha(fecha);
				
				SimpleDateFormat fromaHora= new SimpleDateFormat("hh:mm:ss");
				
				String horat=txt_ticket_entrada.getText();
				Date hora= null;
				try{
					hora=fromaHora.parse(horat);
				}catch(Exception ec){
					ec.printStackTrace();
				}
				t.setHora_entrada(hora);
		
				
			tbd.insertar(t);
			
			codigo_Generado=1+Long.parseLong(txt_ticket_codigo.getText());
			txt_ticket_codigo.setText(""+codigo_Generado);
			
			
			String ticket1=txt_ticket_codigo.getText();
			String placa1=txt_ticket_placa.getText();
			String fecha1=txt_ticket_fecha.getText();
			String horaEntrada1=txt_ticket_entrada.getText();
			
			PrinterJob j= PrinterJob.getPrinterJob();
			j.setPrintable(new Imprimir(ticket1, placa1, fecha1, horaEntrada1));
			if(j.printDialog()){
				try {
					j.print();
				}catch(PrinterException pe){
					System.out.println(pe);
				}
			}
			
			
			int d=20;
			
			txtDisponibles.setText(String.valueOf(d));
		//	d=d+1;
		//	txtDisponibles.setText(String.valueOf(d));
				
			
			
			enviar=new java.io.DataOutputStream(puertoUSB.getOutputStream());
			
			try {
				enviar.write(1);
				enviar.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}	
			
			
		});
		
		
		txt_facturar_ticket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Calendar tiempo=new GregorianCalendar();
				SimpleDateFormat fromaHora= new SimpleDateFormat("hh:mm:ss");
				Calendar tiempo1=new GregorianCalendar();
				 
				txt_facturar_salida.setText(tiempo1.get(Calendar.HOUR_OF_DAY)+":"+tiempo1.get(Calendar.MINUTE)+":"+tiempo1.get(Calendar.SECOND));
				String horaSale=txt_facturar_salida.getText();
				SimpleDateFormat formaHora= new SimpleDateFormat("hh:mm:ss");

				Date horasalet=null;
				try{
					
					horasalet=formaHora.parse(horaSale);
					
				}catch(Exception el){
					el.printStackTrace();
					
				}
				
				

					int codigo;				
					codigo=Integer.parseInt(txt_facturar_ticket.getText());
				
					txt_facturar_placa.setText(tbd.leer(codigo).getPlaca());
					txt_facturar_fecha.setText(tbd.leer(codigo).getFecha()+"");
					txt_facturar_ingreso.setText(tbd.leer(codigo).getHora_entrada()+"");
					
				// tiempo calculo entrada
					
					String horaEntra=txt_facturar_ingreso.getText();
					System.out.println(horaEntra);
					// tiempo salida
					System.out.println(horaSale);
					
					
				String h1[]=horaEntra.split(":");
				String h2[]=horaSale.split(":");
				int restas=0;
				int segundo1=Integer.parseInt(h2[2]);	
				int segundo2=Integer.parseInt(h1[2]);
				
				int min1=Integer.parseInt(h2[1]);
				int min2=Integer.parseInt(h1[1]);
				//System.out.println(min1);
				
				int hora1=Integer.parseInt(h2[0]);
				int hora2=Integer.parseInt(h1[0]);
			//	System.out.println(hora1);
				
				restas=segundo2-segundo1;
				//int restam=min2-min1;
				int restah=hora2-hora1;
				int restam=min2-min1;
					
					if(restas<0){
						restas=restas+60;
						System.out.println(restas);
							
					}else {
						restas=segundo2-segundo1;
						System.out.println("else"+restas);
					}
					
					if(restam<0){
						restam=restam+60;
						restam=restam-1;
						System.out.println(restam);
							
					}else {
						restam=min2-min1;
						
						
						System.out.println("else"+restam);
					}
					if(restah<0){
						restah=(hora2-hora1)*-1;
						System.out.println(restah);
							
					}else{
						restah=(hora2-hora1);
					}
					
					txtTiempo.setText(String.valueOf(restah)+":"+String.valueOf(restam)+":"+String.valueOf(restas));
					String tm=txtTiempo.getText();
					
					
				//	calcular(tm);
					
					
						System.out.println(tm);
						String tm1[]=tm.split(":");
						
						int hora=Integer.parseInt(tm1[0]);
						int min=Integer.parseInt(tm1[1]);
						int segundo=Integer.parseInt(tm1[2]); 
						
						hora=hora*3600;
						min=min*60;
						segundo=segundo*1;
						
					int sumat=hora+min+segundo;
						System.out.println(hora+"h"+min+"m"+segundo+""+sumat);
						txtSegundos.setText(String.valueOf(sumat));
						
						//monto
						
						double monto=sumat*precioTAC;
						System.out.println(monto+"monto");
						double total=((monto*12)/100)+monto;
						System.out.println(total);
					
						String calculoMonto=String.valueOf(monto);	
						
						
						String calculo=calculoMonto;
					tbd.actualizarHoraSalida(codigo,tm);
					
				txt1.setText(String.valueOf(monto));
				txt2.setText(String.valueOf(total));
			}
		});
		
		String horasalida=txt_facturar_salida.getText();
		
	}
	/**
	 * permite la interaccion del arduino y Java
	 */
			
/*	private void conectar() {

		try{
            // Abrimos el puerto en el puerto COM4 y con 9600 baudios de velocidad
            puertoUSB=new gnu.io.NRSerialPort("COM18",9600);
           
            // Nos conectamos al puerto USB
            puertoUSB.connect();
            // Indicamos que queremos saber cuando lleguen nuevos datos. Que nos notifique.
            puertoUSB.notifyOnDataAvailable(true);
            // Agregamos un listener para saber que hacer cuando llegan nuevos datos.
            puertoUSB.addEventListener(null);
           
           
            System.out.println("Puerto USB Listo...");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
	}*/
/**
 * la conexion del puerto usb con el arduino 
 * @param evento
 */
		public void serialEvent(SerialPortEvent evento) {
		// TODO Auto-generated method stub
		
		try{
            // Verificamos que el evento generado sea de llegada de datos del puerto
            if(evento.getEventType()==gnu.io.SerialPortEvent.DATA_AVAILABLE){
                //System.out.println("LLegan datos....");
                // Obtenemos el lector del flujo
                flujoUSB=new java.io.DataInputStream(puertoUSB.getInputStream());
                
                if(flujoUSB.available()>0){
                  int  x=flujoUSB.read();
                    System.out.println("evento del pulsante"+x);
               
                  //  Potenciometro.setText((((99*x)-25500)/-255)+"%");
                    contentPane.repaint();
                    flujoUSB.close();
                  
                 // enviar= new java.io.DataOutputStream(puertoUSB.getOutputStream());
                   //enviar.writeUTF("1");
                  
                    
                    repaint();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	/**
	 * 
	 * @param localizacion del idioma 
	 */
	public void cambiarIdiomas(Locale localizacion){
		mensaje=ResourceBundle.getBundle("recursos.lang.mensajes", localizacion);
		lblbienbenido.setText(mensaje.getString("lblBienvenido"));
		lblHorarios.setText(mensaje.getString("lblHorarios"));
		lblCodigoticket.setText(mensaje.getString("lblCodigoticket"));
		lblFecha.setText(mensaje.getString("lblFecha"));
		lblHoraentrada.setText(mensaje.getString("lblHoraentrada"));
		lblPlacavehiculo.setText(mensaje.getString("lblPlacavehiculo"));
		lblLunesAViernes.setText(mensaje.getString("lblLunesAViernes"));
		txtmsj.setText(mensaje.getString("txtmsj"));
		btnImprimir.setText(mensaje.getString("btnImprimir"));
		mnPropiedades.setText(mensaje.getString("mnPropiedades"));

		lblNumerodefactura.setText(mensaje.getString("lblCodigoticket"));
		lbl_Factura_Fecha_1.setText(mensaje.getString("lblFecha"));
		lbl_Factura_Placa.setText(mensaje.getString("lblPlacavehiculo"));
		lbl_Factura_ingreso.setText(mensaje.getString("lblHoraentrada"));
		lbl_Factura_HoraSalida.setText(mensaje.getString("lblHoraSalida"));
		btnFacturar.setText(mensaje.getString("btnFacturar"));
		
		
		
	}
	
	
}

