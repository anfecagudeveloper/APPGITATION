package OPT;


import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;

public class datosSel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoFecha;
	private JTextField textoNo;
	private JTextField textoCliente;
	private JTextField textoElaboro;
	private JTextField textotagtank;
	private JTextField textotagag;
	private elementoprincipal ep;
	private String Mensaje;
	private Window winDS;
	private JPanel panel_1;
	private JPanel Panelbotones;
	
	public datosSel(elementoprincipal up) {
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		ep=up;
		setTitle("Datos de selección");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-449/2,(int)screen.getHeight()/4-348/2, 449, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66,103,178));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos de Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 434, 223);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(224,224,224));
		panel_8.setBounds(432, 0, 17, 325);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(224,224,224));
		panel_7.setBounds(0, 305, 460, 18);
		contentPane.add(panel_7);
		panel_7.setLayout(null);		
		
		Panelbotones = new JPanel();
		Panelbotones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Panelbotones.setBackground(Color.WHITE);
		Panelbotones.setBounds(0, 258, 434, 47);
		contentPane.add(Panelbotones);
		Panelbotones.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(47, 40, 70, 15);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		
		textoFecha = new JTextField();
		textoFecha.setBounds(244, 38, 151, 19);
		textoFecha.setToolTipText("Ej. 16/08/2020");
		panel_1.add(textoFecha);
		textoFecha.setColumns(10);
		textoFecha.setText(ep.getFecha());
		
		JLabel lblNoCotizacion = new JLabel("No. Cotización:");
		lblNoCotizacion.setBounds(47, 67, 138, 15);
		panel_1.add(lblNoCotizacion);
		lblNoCotizacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textoNo = new JTextField();
		textoNo.setBounds(244, 65, 151, 19);
		textoNo.setToolTipText("Ej. CA_125_20");
		panel_1.add(textoNo);
		textoNo.setColumns(10);
		textoNo.setText(ep.getCotizacion());
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setBounds(47, 94, 70, 15);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textoCliente = new JTextField();
		textoCliente.setBounds(244, 92, 151, 19);
		textoCliente.setToolTipText("Ej. Ondina S.A");
		panel_1.add(textoCliente);
		textoCliente.setColumns(10);
		textoCliente.setText(ep.getCliente());
		
		JLabel lblElabor = new JLabel("Elaboró:");
		lblElabor.setBounds(47, 121, 70, 15);
		panel_1.add(lblElabor);
		lblElabor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textoElaboro = new JTextField();
		textoElaboro.setBounds(244, 119, 151, 19);
		textoElaboro.setToolTipText("Ej. Andres Cardona");
		panel_1.add(textoElaboro);
		textoElaboro.setColumns(10);
		textoElaboro.setText(ep.getElaboro());
		
		JLabel lblNewLabel_2 = new JLabel("Tag del Tanque:");
		lblNewLabel_2.setBounds(47, 150, 138, 15);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textotagtank = new JTextField();
		textotagtank.setBounds(244, 148, 151, 19);
		textotagtank.setToolTipText("Ej. Tanque de Lodos -TK-01-");
		panel_1.add(textotagtank);
		textotagtank.setColumns(10);
		textotagtank.setText(ep.getTagTanque());
		
		JLabel lblTagDelAgitador = new JLabel("Tag del Agitador:");
		lblTagDelAgitador.setBounds(47, 177, 138, 15);
		panel_1.add(lblTagDelAgitador);
		lblTagDelAgitador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textotagag = new JTextField();
		textotagag.setBounds(244, 175, 151, 19);
		textotagag.setToolTipText("Ej. Floculacion");
		panel_1.add(textotagag);
		textotagag.setColumns(10);
		textotagag.setText(ep.getTagAgitador());
		
		JButton botonsiguiente = new JButton("Siguiente");
		botonsiguiente.setBounds(280, 10, 117, 25);
		botonsiguiente.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mensaje=null;
				String []Msjs= {"","","","","",""};
				ep.setFecha(textoFecha.getText());
				if(textoFecha.getText().equals("")) {
					Mensaje="ERROR";
					Msjs[0]=" 'Fecha'";
				}
				ep.setCotizacion(textoNo.getText());
				if(textoNo.getText().equals("")) {
					Mensaje="ERROR";
					Msjs[1]=" 'No. Cotización'";
				}
				ep.setCliente(textoCliente.getText());
				if(textoCliente.getText().equals("")) {
					Mensaje="ERROR";
					Msjs[2]=" 'Cliente'";
				}
				ep.setElaboro(textoElaboro.getText());
				if(textoElaboro.getText().equals("")) {
					Mensaje="ERROR";
					Msjs[3]=" 'Elaboro'";
				}
				ep.setTanque(textotagtank.getText());
				if(textotagtank.getText().equals("")) {
					Mensaje="ERROR";
					Msjs[4]=" 'Tag. Tanque'";
				}
				ep.setTagAgitador(textotagag.getText());
				if(textotagag.getText().equals("")){
					Mensaje="ERROR";
					Msjs[5]=" 'Tag. Agitador'";
				}
				if(Mensaje==null){
					try {
						DatosTanque frame = new DatosTanque(ep);
						frame.setVisible(true);
						JComponent comp=(JComponent)e.getSource();
						winDS=SwingUtilities.getWindowAncestor(comp);
						winDS.setVisible(false);
						} catch (Exception e3) {
							e3.printStackTrace();
						}
					}else {
						Mensaje="Las siguientes casillas no pueden estar en blanco:" + Msjs[0] + Msjs[1] +
								Msjs[2] + Msjs[3]+Msjs[4]+Msjs[5];
						
						JOptionPane.showMessageDialog(contentPane, Mensaje);
					}
				}
		});
		Panelbotones.add(botonsiguiente);
		botonsiguiente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBounds(180, 10, 87, 25);
		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				ep.setFecha(textoFecha.getText());
				ep.setCotizacion(textoNo.getText());
				ep.setCliente(textoCliente.getText());
				ep.setElaboro(textoElaboro.getText());
				ep.setTanque(textotagtank.getText());
				ep.setTagAgitador(textotagag.getText());
				Inicio frameIni = new Inicio(ep);
				frameIni.setVisible(true);
				JComponent comp=(JComponent)e.getSource();
				winDS=SwingUtilities.getWindowAncestor(comp);
				winDS.setVisible(false);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				
				
			}
			
		});
		Panelbotones.add(botonAtras);
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
}
