package OPT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

public class DatosTanque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel tipoTanque;
	private JLabel lblDiametro;
	private JLabel lblAncho;
	private JLabel unidades;
	private JTextField TDiametro;
	private JTextField altUtil;
	private JTextField altTotal;
	private JTextField viscosidad;
	private JTextField densidad;
	private JTextField tAncho;
	private JTextField datoCirculacion;
	private elementoprincipal ep;
	private JComboBox <String>tTanque;
	private JComboBox <String>baffles;
	private JComboBox <String>pCirculacion;
	private JComboBox <String>proceso;
	private String Mensaje;

	

	public DatosTanque(elementoprincipal up) {
		ep=up;
		setResizable(false);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Datos del Tanque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-225,(int)screen.getHeight()/4-275, 450, 550);
		tipoTanque = new JPanel();
		tipoTanque.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(tipoTanque);
		tipoTanque.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Tanque", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 39, 434, 269);
		tipoTanque.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(242, 191, 169, 67);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 349, 434, 119);
		tipoTanque.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Fluido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 454, 434, 57);
		tipoTanque.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTipoDeTanque = new JLabel("Tipo de Tanque:");
		lblTipoDeTanque.setBounds(24, 23, 115, 14);
		panel_1.add(lblTipoDeTanque);
		lblTipoDeTanque.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblDiametro = new JLabel("Diámetro (m):");
		lblDiametro.setBounds(24, 48, 115, 14);
		panel_1.add(lblDiametro);
		lblDiametro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAlturaUtil = new JLabel("Altura Util (m):");
		lblAlturaUtil.setBounds(24, 98, 169, 14);
		panel_1.add(lblAlturaUtil);
		lblAlturaUtil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAlturaTotal = new JLabel("Altura Total (m):");
		lblAlturaTotal.setBounds(24, 123, 169, 14);
		panel_1.add(lblAlturaTotal);
		lblAlturaTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBaffles = new JLabel("Baffles:");
		lblBaffles.setBounds(24, 148, 169, 14);
		panel_1.add(lblBaffles);
		lblBaffles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblParametroDeCirculacion = new JLabel("Parámetro de Circulación:");
		lblParametroDeCirculacion.setBounds(24, 204, 169, 14);
		panel_1.add(lblParametroDeCirculacion);
		lblParametroDeCirculacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblAncho = new JLabel("Ancho (m):");
		lblAncho.setBounds(24, 73, 115, 14);
		panel_1.add(lblAncho);
		lblAncho.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		tAncho = new JTextField();
		tAncho.setText("");
		tAncho.setHorizontalAlignment(SwingConstants.TRAILING);
		tAncho.setColumns(10);
		tAncho.setBounds(251, 70, 160, 20);
		panel_1.add(tAncho);
		tAncho.setText(String.valueOf(ep.getAncho()));
		
		tTanque = new JComboBox<String>();
		tTanque.setBounds(250, 19, 161, 22);
		tTanque.addItem("CIRCULAR");
		tTanque.addItem("RECTANGULAR");
		tTanque.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tTanque.getSelectedItem().toString().equals("CIRCULAR")) {
					lblDiametro.setText("Diámetro (m):");	
					lblAncho.setVisible(false);
					tAncho.setVisible(false);
				}else{
					lblDiametro.setText("Longitud (m):");
					lblAncho.setVisible(true);
					tAncho.setVisible(true);
				}
			}
			
		});
		panel_1.add(tTanque);
		tTanque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		try{
			tTanque.setSelectedItem(ep.getTipoTanque());
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		TDiametro = new JTextField();
		TDiametro.setText("");
		TDiametro.setHorizontalAlignment(SwingConstants.TRAILING);
		TDiametro.setColumns(10);
		TDiametro.setBounds(250, 45, 160, 20);
		panel_1.add(TDiametro);
		TDiametro.setText(Double.toString(ep.getDiametroTanque()));
		
		altUtil = new JTextField();
		altUtil.setText("dist");
		altUtil.setHorizontalAlignment(SwingConstants.TRAILING);
		altUtil.setColumns(10);
		altUtil.setBounds(251, 95, 160, 20);
		panel_1.add(altUtil);
		altUtil.setText(Double.toString(ep.getAlturaUtil()));
		
		altTotal = new JTextField();
		altTotal.setText("dist");
		altTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		altTotal.setColumns(10);
		altTotal.setBounds(250, 120, 160, 20);
		panel_1.add(altTotal);
		altTotal.setText(Double.toString(ep.getAlturaTotal()));
		
		baffles = new JComboBox<String>();
		baffles.setBounds(250, 144, 161, 22);
		baffles.addItem("SI");
		baffles.addItem("NO");
		panel_1.add(baffles);
		baffles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		try{
			baffles.setSelectedItem(ep.getBaffles());
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		unidades = new JLabel("");
		unidades.setBounds(10, 39, 71, 14);
		panel_5.add(unidades);
		unidades.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		datoCirculacion = new JTextField();
		datoCirculacion.setBounds(101, 36, 61, 20);
		datoCirculacion.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setDatoCirculacion((Double.parseDouble(datoCirculacion.getText())));
				}catch(Exception e2) {
					
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setDatoCirculacion((Double.parseDouble(datoCirculacion.getText())));

				}catch(Exception e2) {
					
				}
				
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setDatoCirculacion((Double.parseDouble(datoCirculacion.getText())));
				}catch(Exception e2) {
					
				}
				
			}
		});
		panel_5.add(datoCirculacion);
		datoCirculacion.setHorizontalAlignment(SwingConstants.TRAILING);
		datoCirculacion.setColumns(10);
		datoCirculacion.setText(String.valueOf(ep.getDatoCirculacion()));
		
		
		pCirculacion = new JComboBox<String>();
		pCirculacion.setBounds(10, 11, 152, 22);
		pCirculacion.addItem("TIEMPO DE RESIDENCIA");
		pCirculacion.addItem("FLUJO DEL TANQUE");
		pCirculacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pCirculacion.getSelectedItem().toString().equals("TIEMPO DE RESIDENCIA")) {
					unidades.setText("horas");
				}else {
					unidades.setText("m3/h");
				}
						
			}
		});
		panel_5.add(pCirculacion);
		pCirculacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pCirculacion.setBackground(Color.WHITE);
		try{
			pCirculacion.setSelectedItem(ep.getParamCirculacion());
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		JLabel lblProceso = new JLabel("Proceso:");
		lblProceso.setBounds(25, 23, 169, 14);
		panel_3.add(lblProceso);;
		lblProceso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblViscosidadcp = new JLabel("Viscosidad (cp):");
		lblViscosidadcp.setBounds(25, 48, 150, 14);
		panel_3.add(lblViscosidadcp);
		lblViscosidadcp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDensidadkgm = new JLabel("Densidad (kg/m3) :");
		lblDensidadkgm.setBounds(25, 73, 169, 14);
		panel_3.add(lblDensidadkgm);
		lblDensidadkgm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		viscosidad = new JTextField();
		viscosidad.setHorizontalAlignment(SwingConstants.TRAILING);
		viscosidad.setText("");
		viscosidad.setColumns(10);
		viscosidad.setBounds(249, 45, 160, 20);
		panel_3.add(viscosidad);
		viscosidad.setText(Double.toString(ep.getViscosidad()));
		
		densidad = new JTextField();
		densidad.setHorizontalAlignment(SwingConstants.TRAILING);
		densidad.setText("dist");
		densidad.setColumns(10);
		densidad.setBounds(249, 70, 160, 20);
		panel_3.add(densidad);
		densidad.setText(Double.toString(ep.getDensidad()));
		
		proceso = new JComboBox<String>();
		proceso.setBounds(249, 15, 161, 22);
		String[] opciones= {"Acon. Lodos","Homo. Lodos Floculentos","Homo. Lodos No Floculentos",
				"Prep. De Polímeros Sólidos","Mad. De Polímeros","Mtto. y Prep. Lechada De Cal",
				"Susp. Carbon Activado","Prep. Coag. Solidos","Coag. O Neutralización","Floculación",
				"Mezcla Líquidos Miscibles","Homo Temperatura","Almacenamiento","Suspension de solidos"};
		for(String j:opciones) {
			proceso.addItem(j);
		}
		panel_3.add(proceso);
		proceso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		try{
			proceso.setSelectedItem(ep.getProceso());
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(329, 23, 95, 23);
		btnNewButton.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					Mensaje=null;
					try{
						ep.setTipoTanque(tTanque.getSelectedItem().toString());
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"El desplegable 'Tipo de Tanque' debe tener una opción seleccionada");
					}
					try {
						ep.setDiametroTanque(Double.parseDouble(TDiametro.getText()));
					}catch (Exception e2){
						Mensaje="FALLA";
						if(tTanque.getSelectedItem().toString().equals("CIRCULAR")) {
							JOptionPane.showMessageDialog(tipoTanque,"La casilla 'Diámetro' debe tener datos de tipo 'número'");
						}else {
							JOptionPane.showMessageDialog(tipoTanque,"La casilla 'Longitud' debe tener datos de tipo 'número'");

						}
					}
					if(tTanque.getSelectedItem().toString().equals("RECTANGULAR")) {
						try {
							ep.setAncho(Double.parseDouble(tAncho.getText()));
						}catch(Exception e2){
							Mensaje="FALLA";
							JOptionPane.showMessageDialog(tipoTanque, "La casilla 'Ancho' debe tener datos de tipo 'número'");
						}
					}
					try {
						ep.setAlturaUtil(Double.parseDouble(altUtil.getText()));
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"La casilla 'Altura Util' debe tener datos de tipo 'número'");
					}
					try {
						ep.setAlturaTotal(Double.parseDouble(altTotal.getText()));
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"La casilla 'Altura Total' debe tener datos de tipo 'número'");
					}
					try{
						ep.setBaffles(baffles.getSelectedItem().toString());
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"El desplegable 'Baffles' debe tener una opción seleccionada");
					}
					try{
						ep.setParamCirculacion(pCirculacion.getSelectedItem().toString());
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"El desplegable 'Parámetro de Circulación' debe tener una opción seleccionada");
					}
					try{
						ep.setProceso(proceso.getSelectedItem().toString());
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"El desplegable 'Proceso' debe tener una opción seleccionada");
					}
					try {
						ep.setViscosidad(Double.parseDouble(viscosidad.getText()));
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"La casilla 'Viscosidad' debe tener datos de tipo 'número'");
					}
					try {
						ep.setDensidad(Double.parseDouble(densidad.getText()));
					}catch (Exception e2){
						Mensaje="FALLA";
						JOptionPane.showMessageDialog(tipoTanque,"La casilla 'Densidad' debe tener datos de tipo 'número'");
					}
										
					if(Mensaje==null) {
						try {
							selAg frame = new selAg(ep);
							frame.setVisible(true);
							JComponent comp=(JComponent)e.getSource();
							Window win=SwingUtilities.getWindowAncestor(comp);
							win.setVisible(false);
							} catch (Exception e2) {
								e2.printStackTrace();
							}
					}
			}		
		});
		panel_4.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(235, 23, 84, 23);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setTipoTanque(tTanque.getSelectedItem().toString());
				}catch (Exception e2){
				}
				try {
					ep.setDiametroTanque(Double.parseDouble(TDiametro.getText()));
				}catch (Exception e2){
				}
				if(tTanque.getSelectedItem().toString().equals("RECTANGULAR")) {
					try {
						ep.setAncho(Double.parseDouble(tAncho.getText()));
					}catch(Exception e2){
						
					}
				}
				try {
					ep.setAlturaUtil(Double.parseDouble(altUtil.getText()));
				}catch (Exception e2){
				}
				try {
					ep.setAlturaTotal(Double.parseDouble(altTotal.getText()));
				}catch (Exception e2){
				}
				try{
					ep.setBaffles(baffles.getSelectedItem().toString());
				}catch (Exception e2){
				}
				try{
					ep.setParamCirculacion(pCirculacion.getSelectedItem().toString());
				}catch (Exception e2){
				}
				try{
					ep.setProceso(proceso.getSelectedItem().toString());
				}catch (Exception e2){
				}
				try {
					ep.setViscosidad(Double.parseDouble(viscosidad.getText()));
				}catch (Exception e2){
				}
				try {
					ep.setDensidad(Double.parseDouble(densidad.getText()));
				}catch (Exception e2){
				}
				datosSel frame = new datosSel(ep);
				frame.setVisible(true);
				JComponent comp=(JComponent)e.getSource();
				Window win=SwingUtilities.getWindowAncestor(comp);
				win.setVisible(false);
						
			}
		});
		panel_4.add(btnAtras);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 434, 38);
		tipoTanque.add(panel);
		panel.setBackground(new Color(66,103,178));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		panel_2.setBackground(new Color(66,103,178));
		panel_2.setBounds(0, 306, 434, 38);
		tipoTanque.add(panel_2);
				
	}
	
}


