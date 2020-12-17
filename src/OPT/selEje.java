package OPT;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class selEje extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel_3;
	private JTextField txtDist;
	private JTextField txtdia;
	private JTextField txtcr;
	private JComboBox <String> eEjeSel;
	private JComboBox <String> mEje;
	private JComboBox <String> estancamiento;
	private JComboBox<String> schedule;
	private JLabel lblEsfuerzo;
	private JLabel lblVelocidadrpm;
	private JLabel rpmCrit;
	private JLabel rpm;
	private JLabel crl;
	private JLabel dmin;
	materiales[] meje={new materiales("4140",7.35E8),
		new materiales("1045",5.30E8),
		new materiales("1020",3.52E8),
		new materiales("304SS",2.30E8),
		new materiales("316SS",1.38E8),
		new materiales("4340",7.84E8),
		new materiales("A36",2.50E8)};
	ejesd[] eejesd= {new ejesd("1'",0.0254,0.0334,0.02664,2.55,3.98,0.0243078,3.24),
			new ejesd("1 1/4'",0.03175,0.04216,0.03505,3.45,6.23,0.0324612,4.47),
			new ejesd("1 1/2'",0.0381,0.04826,0.04089,4.13,8.97,0.0381,5.41),
			new ejesd("2'",0.0508,0.060325,0.0525018,5.44,15.94,0.0492506,7.48),
			new ejesd("2 1/2'",0.0635,0.073025,0.0627126,8.63,24.9,0.0590042,11.42),
			new ejesd("3'",0.0762,0.0889,0.0779272,11.30,35.86,0.07366,15.28),
			new ejesd("4'",0.1016,0.1143,0.1022604,16.09,63.76,0.0971804,22.34),
			new ejesd("6'",0.1524,0.168275,0.154051,28.29,143.47,0.1463294,42.6),
			new ejesd("8'",0.2032,0.219075,0.2027174,42.57,255.07,0.193675,64.7),
			new ejesd("10'",0.254,0.27305,0.254508,60.36,405.36,0.24765,81.63),
		};
	private elementoprincipal ep;

	public selEje(elementoprincipal up) {
		ep=up;
		setResizable(false);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Selección de Eje y Linterna");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-225, (int)screen.getHeight()/4-290, 450, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66,103,178));
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		panel.setBounds(0, 0, 434, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del agitador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 39, 434, 273);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLACK, null, Color.BLACK, null));
		panel_2.setBackground(new Color(66,103,178));
		panel_2.setBounds(0, 308, 434, 38);
		contentPane.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 346, 434, 149);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 495, 434, 46);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		lblEsfuerzo = new JLabel("3");
		lblEsfuerzo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEsfuerzo.setBounds(309, 212, 46, 14);
		panel_1.add(lblEsfuerzo);
		lblEsfuerzo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblVelocidadrpm = new JLabel("Velocidad Ag (rpm):");
		lblVelocidadrpm.setBounds(61, 104, 169, 14);
		panel_1.add(lblVelocidadrpm);
		lblVelocidadrpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rpmCrit = new JLabel("Velocidad");
		rpmCrit.setHorizontalAlignment(SwingConstants.TRAILING);
		rpmCrit.setBounds(309, 239, 46, 14);
		panel_1.add(rpmCrit);
		rpmCrit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtDist = new JTextField();
		txtDist.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDist.setText("");
		txtDist.setBounds(288, 20, 67, 20);
		txtDist.setColumns(10);	
		txtDist.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setDistrod(Double.parseDouble(txtDist.getText()));
					calculo();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setDistrod(Double.parseDouble(txtDist.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setDistrod(Double.parseDouble(txtDist.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});	
		panel_3.add(txtDist);
		txtDist.setText(String.valueOf(ep.getDistrod()));
		
		crl = new JLabel("");
		crl.setHorizontalAlignment(SwingConstants.TRAILING);
		crl.setBounds(309, 98, 46, 14);
		panel_3.add(crl);
		crl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		dmin = new JLabel("pMotor");
		dmin.setHorizontalAlignment(SwingConstants.TRAILING);
		dmin.setBounds(309, 123, 46, 14);
		panel_3.add(dmin);
		dmin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rpm = new JLabel("");
		rpm.setHorizontalAlignment(SwingConstants.TRAILING);
		rpm.setBounds(309, 104, 46, 14);
		panel_1.add(rpm);
		rpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rpm.setText(String.valueOf(ep.getVelocidad()));
		
		JLabel lblNewLabel_2 = new JLabel("Longitud del Eje (m) :");
		lblNewLabel_2.setBounds(61, 23, 115, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lEje = new JLabel("");
		lEje.setHorizontalAlignment(SwingConstants.TRAILING);
		lEje.setBounds(309, 23, 46, 14);
		panel_1.add(lEje);
		lEje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lEje.setText(String.valueOf(ep.getlEje()));
		
		JLabel lblMaterialDelEje = new JLabel("Material del Eje:");
		lblMaterialDelEje.setBounds(61, 50, 115, 14);
		panel_1.add(lblMaterialDelEje);
		lblMaterialDelEje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		mEje = new JComboBox<String>();
		mEje.setBounds(285, 46, 70, 22);
		for(materiales j:meje) {
			mEje.addItem(j.getMat());
		}
		mEje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setMat(mEje.getSelectedItem().toString());
					calculo();					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		panel_1.add(mEje);
		mEje.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mEje.setSelectedItem(ep.getMat());
		
		JLabel lblPotenciaDelMotor = new JLabel("Potencia del motor (KW) :");
		lblPotenciaDelMotor.setBounds(61, 77, 169, 14);
		panel_1.add(lblPotenciaDelMotor);
		lblPotenciaDelMotor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel pMotor = new JLabel("");
		pMotor.setHorizontalAlignment(SwingConstants.TRAILING);
		pMotor.setBounds(309, 77, 46, 14);
		panel_1.add(pMotor);
		pMotor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pMotor.setText(String.valueOf(ep.getPots()));
		
		JLabel lblEstancamiento = new JLabel("Estancamiento:");
		lblEstancamiento.setBounds(61, 131, 169, 14);
		panel_1.add(lblEstancamiento);
		lblEstancamiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		estancamiento = new JComboBox<String>();
		estancamiento.setBounds(285, 125, 70, 22);
		panel_1.add(estancamiento);
		estancamiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		String[]est= {"Ligero","Medio","Severo"};
		for(String j:est) {
			estancamiento.addItem(j);
		}
		estancamiento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setEstanc(estancamiento.getSelectedItem().toString());
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		estancamiento.setSelectedItem(ep.getEstanc());
		
		JLabel lblDiametroDeEje = new JLabel("Diametro de eje:");
		lblDiametroDeEje.setBounds(61, 158, 169, 14);
		panel_1.add(lblDiametroDeEje);
		lblDiametroDeEje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		eEjeSel = new JComboBox<String>();
		eEjeSel.setBounds(285, 152, 70, 22);
		eEjeSel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		for(ejesd j:eejesd) {
			eEjeSel.addItem(j.getDiam());
		}
		eEjeSel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ep.setDiametroEje(eEjeSel.getSelectedItem().toString());
				try {
					calculo();
				} catch (Exception e1) {

				}
			}
		});
		panel_1.add(eEjeSel);
		eEjeSel.setSelectedItem(ep.getDiametroEje());
		
		JLabel lblSchedule = new JLabel("Schedule:");
		lblSchedule.setBounds(61, 185, 169, 14);
		panel_1.add(lblSchedule);
		lblSchedule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		schedule = new JComboBox<String>();
		schedule.setBounds(285, 179, 70, 22);
		String[]sch={"--","SCH40","SCH80"};
		for(String s:sch) {
			schedule.addItem(s);
		}
		schedule.setFont(new Font("Tahoma", Font.PLAIN, 11));
		schedule.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ep.setSch((schedule.getSelectedItem().toString()));
				try {
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		panel_1.add(schedule);
		schedule.setSelectedItem(ep.getSch());
		
		JLabel lblVelocidad = new JLabel("Esfuerzo (MPa):");
		lblVelocidad.setBounds(61, 212, 169, 14);
		panel_1.add(lblVelocidad);
		lblVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblVelocidadCriticarpm = new JLabel("Velocidad crítica (rpm):");
		lblVelocidadCriticarpm.setBounds(61, 239, 169, 14);
		panel_1.add(lblVelocidadCriticarpm);
		lblVelocidadCriticarpm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDistanciaEntreRodamientos = new JLabel("Distancia entre rodamientos (m):");
		lblDistanciaEntreRodamientos.setBounds(61, 23, 169, 14);
		panel_3.add(lblDistanciaEntreRodamientos);
		lblDistanciaEntreRodamientos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDiametroEjeReductor = new JLabel("Diámetro eje Reductor (mm):");
		lblDiametroEjeReductor.setBounds(61, 48, 150, 14);
		panel_3.add(lblDiametroEjeReductor);
		lblDiametroEjeReductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCargaRadialReductor = new JLabel("Carga radial Reductor (N):");
		lblCargaRadialReductor.setBounds(61, 73, 169, 14);
		panel_3.add(lblCargaRadialReductor);
		lblCargaRadialReductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCargaRadialReductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCargaRadialLmite = new JLabel("Carga radial L\u00EDmite (N):");
		lblCargaRadialLmite.setBounds(61, 98, 169, 14);
		panel_3.add(lblCargaRadialLmite);
		lblCargaRadialLmite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDimetroMn = new JLabel("Diámetro mínimo eje reductor (mm):");
		lblDimetroMn.setBounds(61, 123, 169, 14);
		panel_3.add(lblDimetroMn);
		lblDimetroMn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_11 = new JLabel("Esfuerzo (MPa):");
		label_11.setBounds(61, 223, 169, 14);
		panel_3.add(label_11);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_12 = new JLabel("Esfuerzo");
		label_12.setHorizontalAlignment(SwingConstants.TRAILING);
		label_12.setBounds(309, 223, 46, 14);
		panel_3.add(label_12);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_13 = new JLabel("Velocidad cr\u00EDtica (rpm):");
		label_13.setBounds(61, 248, 169, 14);
		panel_3.add(label_13);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtdia = new JTextField();
		txtdia.setHorizontalAlignment(SwingConstants.TRAILING);
		txtdia.setText("dist");
		txtdia.setColumns(10);
		txtdia.setBounds(288, 45, 67, 20);
		txtdia.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setDminr(Double.parseDouble(txtdia.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setDminr(Double.parseDouble(txtdia.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setDminr(Double.parseDouble(txtdia.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		panel_3.add(txtdia);
		txtdia.setText(String.valueOf(ep.getDminr()));
		
		txtcr = new JTextField();
		txtcr.setHorizontalAlignment(SwingConstants.TRAILING);
		txtcr.setText("dist");
		txtcr.setColumns(10);
		txtcr.setBounds(288, 70, 67, 20);
		txtcr.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setCrl(Double.parseDouble(txtcr.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setCrl(Double.parseDouble(txtcr.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					ep.setCrl(Double.parseDouble(txtcr.getText()));
					calculo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				}
			}
		});
		panel_3.add(txtcr);
		txtcr.setText(String.valueOf(ep.getCrl()));
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(230, 5, 80, 23);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		});
		panel_4.add(btnAtras);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JButton btnFinalizar = new JButton("Siguiente");
		btnFinalizar.setBounds(323, 5, 100, 23);
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Generacion frameDS = new Generacion(ep);
				frameDS.setVisible(true);
				JComponent compIni=(JComponent)e.getSource();
				Window winIni=SwingUtilities.getWindowAncestor(compIni);
				winIni.setVisible(false);
				
			}
		});
		panel_4.add(btnFinalizar);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
	
	public void calculo() throws Exception{
		
		///------------------------------------------///////
		//////////DECLARACION DE VARIABLES///////////////////
		//--------------------------------------------------///
		
		DecimalFormatSymbols separador=new DecimalFormatSymbols();
		separador.setDecimalSeparator('.');
		DecimalFormat fiag=new DecimalFormat("0.0",separador);
		DecimalFormat ficr=new DecimalFormat("0",separador);
		double torque=ep.getPots()*1000/(2*Math.PI*ep.getVelocidad()/60);
		double fest=1.5;
		if(estancamiento.getSelectedItem().toString().equals("Medio")) fest=2;
		if(estancamiento.getSelectedItem().toString().equals("Severo")) fest=2.5;
		double torqueEst=torque*fest;
		double dprop=ep.getPropelas()[0].getDiacalc()/1000;
		double frad=8*torqueEst/(3*dprop);
		double Mb=frad*ep.getlEje();
		double Mpt=Math.sqrt(Math.pow(Mb, 2)+Math.pow(torqueEst, 2));
		double diaEcalc=0;
		double diaIcalc=0;
		double pesoeje=0;
		double pesopropela1=ep.getPropelas()[0].getPeso();
		double pesopropela2=ep.getPropelas()[1].getPeso();
		double pesopropela3=ep.getPropelas()[2].getPeso();
		double pesopropela4=ep.getPropelas()[3].getPeso();
		double pesopropelas=pesopropela1+pesopropela2+pesopropela3+pesopropela4;
		
		for(ejesd j:eejesd) {
			switch (ep.getSch()) {
			case "--":
				if(ep.getDiametroEje().equals(j.getDiam())){
					diaEcalc=j.getDmac();
					pesoeje=j.getPmac()*ep.getlEje();
				}
				break;
			case "SCH40":
				if(ep.getDiametroEje().equals(j.getDiam())){
					diaEcalc=j.getDext();
					diaIcalc=j.getDintsch40();
					pesoeje=j.getPtubsch40()*ep.getlEje();
				}
				break;
			case "SCH80":
				if(ep.getDiametroEje().equals(j.getDiam())){
					diaEcalc=j.getDext();
					diaIcalc=j.getDintsch80();
					pesoeje=j.getPtubsch80()*ep.getlEje();
				}
				break;
			}
		}
		ep.setPesoeje(String.valueOf(fiag.format(pesoeje)));
		
		///----------------------------------//
		//CALCULO ESFUERZO
		//-----------------------------------//
		
		double esfuerzocal=0;
		try{
					esfuerzocal=32*Mpt*diaEcalc/(Math.PI*(Math.pow(diaEcalc,4)-Math.pow(diaIcalc,4)))
					+4*pesopropelas*9.81/(Math.PI*(Math.pow(diaEcalc,2)-Math.pow(diaIcalc,2)))
					+ep.getlEje()*9.91*8000;
		}catch(Exception e) {
			e.printStackTrace();
		}
		lblEsfuerzo.setText(String.valueOf(fiag.format(esfuerzocal/1E6)));				
		
		//--------------------//
		//CALCULO VEL CRITICA
		//-------------------//
		
		double velcrit=0;
		try{
				velcrit=5.33*60*(Math.pow((Math.pow(diaEcalc, 4)-Math.pow(diaIcalc, 4)), 0.5)
					*Math.pow(2E11/8000, 0.5)/(Math.pow(ep.getlEje(), 1.5)
							*Math.pow(pesopropelas+pesoeje/4, 0.5)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		rpmCrit.setText(String.valueOf(fiag.format(velcrit)));
		
		//------------------//
		//CALCULO DE CARGA RADIAL LIMITE///
		///-------------------//
		
		double crL=0;
		try{
			crL=torque/(ep.getPropelas()[0].getDiacalc()/2000)*(ep.getlEje()+Double.parseDouble(txtDist.getText()))/Double.parseDouble(txtDist.getText());
		}catch(Exception e){
			crl.setText("ERROR");
		}
		crl.setText(String.valueOf(ficr.format(crL)));
		
		//---------------------------//
		//CALCULO DIAMETRO EJE MINIMO REDUCTOR
		///----------------------------------------//
		
		double i=0.001;
		while(32*Mpt/(Math.PI*(Math.pow(i,3)))
					+4*pesopropelas*9.81/(Math.PI*(Math.pow(i,2)))
					+ep.getlEje()*9.91*8000>7.84E8) {
			i+=0.00001;
		}
		dmin.setText(String.valueOf(fiag.format(i*1000)));
		
		///---------------------------------------//
		//REVISAR CUMPLIMIENTO  ESFUERZO///////////
		///-------------------------------------///
		
		double esfuerzoflu=0;
		for(materiales j:meje) {
			if(mEje.getSelectedItem().toString().equals(j.getMat())) {
				esfuerzoflu=j.getEsf();
			}
		}
		if(esfuerzocal<=esfuerzoflu && velcrit>=1.2*ep.getVelocidad()) {
			panel_1.setBorder(new TitledBorder(null, "Cumple", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		}else {
			panel_1.setBorder(new TitledBorder(null, "No Cumple", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		}
		
		
		///---------------------------------------//
		//REVISAR CUMPLIMIENTO LINTERNA---------////////
		///-------------------------------------///
		if(ep.getDminr()/1000>i && ep.getCrl()>crL) {
			panel_3.setBorder(new TitledBorder(null, "No Requiere Linterna", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		}else {
			panel_3.setBorder(new TitledBorder(null, "Requiere Linterna", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		}
		
	}
	
	
	
}



class materiales{
	
	public materiales(String mat, double esf) {
		super();
		this.mat = mat;
		this.esf = esf;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public double getEsf() {
		return esf;
	}
	public void setEsf(double esf) {
		this.esf = esf;
	}

	private String mat;
	private double esf;
}
class ejesd{
	
	
	public ejesd(String diam, double dmac, double dext, double dintsch40, double ptubsch40, double pmac,
			double dintsch80, double ptubsch80) {
		super();
		this.diam = diam;
		this.dmac = dmac;
		this.dext = dext;
		this.dintsch40 = dintsch40;
		this.ptubsch40 = ptubsch40;
		this.pmac = pmac;
		this.dintsch80 = dintsch80;
		this.ptubsch80 = ptubsch80;
	}
	
	public String getDiam() {
		return diam;
	}
	public void setDiam(String diam) {
		this.diam = diam;
	}
	public double getDmac() {
		return dmac;
	}
	public void setDmac(double dmac) {
		this.dmac = dmac;
	}
	public double getDext() {
		return dext;
	}
	public void setDext(double dext) {
		this.dext = dext;
	}
	public double getDintsch40() {
		return dintsch40;
	}
	public void setDintsch40(double dintsch40) {
		this.dintsch40 = dintsch40;
	}
	public double getPtubsch40() {
		return ptubsch40;
	}
	public void setPtubsch40(double ptubsch40) {
		this.ptubsch40 = ptubsch40;
	}
	public double getPmac() {
		return pmac;
	}
	public void setPmac(double pmac) {
		this.pmac = pmac;
	}
	public double getDintsch80() {
		return dintsch80;
	}
	public void setDintsch80(double dintsch80) {
		this.dintsch80 = dintsch80;
	}
	public double getPtubsch80() {
		return ptubsch80;
	}
	public void setPtubsch80(double ptubsch80) {
		this.ptubsch80 = ptubsch80;
	}

	@Override
	public String toString() {
		return "ejesd [diam=" + diam + ", dmac=" + dmac + ", dext=" + dext + ", dintsch40=" + dintsch40 + ", ptubsch40="
				+ ptubsch40 + ", pmac=" + pmac + ", dintsch80=" + dintsch80 + ", ptubsch80=" + ptubsch80 + "]";
	}

	private String diam;
	private double dmac;
	private double dext;
	private double dintsch40;
	private double ptubsch40;
	private double pmac;
	private double dintsch80;
	private double ptubsch80;
}


