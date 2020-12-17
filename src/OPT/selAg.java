package OPT;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class selAg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rpm;
	private JTextField disFondo;
	private JLabel lEje;
	private JLabel pSel;
	private JLabel pReq;
	private JLabel vH;
	private JLabel caudal;
	private JLabel nAgt;
	private JLabel IL1;
	private JLabel IL2;
	private JLabel IL3;
	private JLabel IL4;
	private JLabel rel1;
	private JLabel rel2;
	private JLabel rel3;
	private JLabel rel4;
	private elementoprincipal ep;

	
	
	
	private factAg[] dCalculo= {new factAg("Tripala","200",calculaNpNq(0.07,364,200,150)[0],calculaNpNq(0.07,364,200,150)[1],200,0.9),
			new factAg("Tripala","300",calculaNpNq(0.51,359,300,498)[0],calculaNpNq(0.51,359,300,498)[1],300,1.6),
			new factAg("Tripala","400",calculaNpNq(0.51,359,300,498)[0]*1.15,calculaNpNq(0.51,359,300,498)[1]*1.15,400,3.2),
			new factAg("Tripala","500",calculaNpNq(0.34,99,600,1100)[0],calculaNpNq(0.34,99,600,1100)[1],500,4.8),
			new factAg("Tripala","600",calculaNpNq(0.34,99,600,1100)[0],calculaNpNq(0.34,99,600,1100)[1],600,5.5),
			new factAg("Tripala","700",calculaNpNq(0.34,99,600,1100)[0],calculaNpNq(0.34,99,600,1100)[1],700,9.8),
			new factAg("Tripala","800",calculaNpNq(0.61,113,1000,2298)[0],calculaNpNq(0.61,113,1000,2298)[1],800,11.3),
			new factAg("Tripala","1000",calculaNpNq(0.61,113,1000,2298)[0],calculaNpNq(0.61,113,1000,2298)[1],1000,22.5),
			new factAg("Tripala","1200",calculaNpNq(1.06,100,1200,3515)[0],calculaNpNq(1.06,100,1200,3515)[1],1200,28.5),
			new factAg("Tripala","1500",calculaNpNq(1.06,100,1200,3515)[0],calculaNpNq(1.06,100,1200,3515)[1],1500,40.9),
			new factAg("Tripala","1800",calculaNpNq(1.06,100,1200,3515)[0],calculaNpNq(1.06,100,1200,3515)[1],1800,62),
			new factAg("Tripala","2000",calculaNpNq(1.06,100,1200,3515)[0],calculaNpNq(1.06,100,1200,3515)[1],2000,79),
			new factAg("Tripala","2500",calculaNpNq(1.06,100,1200,3515)[0],calculaNpNq(1.06,100,1200,3515)[1],2500,92),
			new factAg("Turbina","200",calculaNpNq(0.003,103,200,46)[0],calculaNpNq(0.003,103,200,46)[1],200,0.97),
			new factAg("Turbina","350",calculaNpNq(0.05,126,350,174)[0],calculaNpNq(0.05,126,350,174)[1],350,2.91),
			new factAg("Turbina","500",calculaNpNq(0.1,100,500,281)[0],calculaNpNq(0.1,100,500,281)[1],500,4),
			new factAg("Turbina","550",calculaNpNq(0.61,137,550,746)[0],calculaNpNq(0.61,137,550,746)[1],550,4.08),
			new factAg("Turbina","700",calculaNpNq(0.99,102,700,1349)[0],calculaNpNq(0.99,102,700,1349)[1],700,16.63),
			new factAg("Turbina","800",calculaNpNq(1.59,100,800,1728)[0],calculaNpNq(1.59,100,800,1728)[1],800,24),
			new factAg("Turbina","900",calculaNpNq(1.59,100,800,1728)[0],calculaNpNq(1.59,100,800,1728)[1],900,26),
			new factAg("Turbina","1000",calculaNpNq(1.59,100,800,1728)[0],calculaNpNq(1.59,100,800,1728)[1],1000,28),
			new factAg("Turbina","1200",calculaNpNq(1.59,100,800,1728)[0],calculaNpNq(1.59,100,800,1728)[1],1200,32),
			new factAg("G. Caudal","200",calculaNpNq(0.26,289,200,149)[0],calculaNpNq(0.26,289,200,149)[1],200,1.5),
			new factAg("G. Caudal","300",calculaNpNq(0.525,293,300,509)[0],calculaNpNq(0.525,293,300,509)[1],300,2.9),
			new factAg("G. Caudal","400",calculaNpNq(0.385,158,400,650)[0],calculaNpNq(0.385,158,400,650)[1],400,4.3),
			new factAg("G. Caudal","600",calculaNpNq(0.77,99,600,1379)[0],calculaNpNq(0.77,99,600,1379)[1],600,8),
			new factAg("G. Caudal","800",calculaNpNq(2.8,126,800,4152)[0],calculaNpNq(2.8,126,800,4152)[1],800,12),
			new factAg("G. Caudal","1000",calculaNpNq(1.54,69.3,1000,4450)[0],calculaNpNq(1.54,69.3,1000,4450)[1],1000,38),
			new factAg("G. Caudal","1200",calculaNpNq(2.8,63.7,1200,7065)[0],calculaNpNq(2.8,63.7,1200,7065)[1],1200,64),
			new factAg("G. Caudal","1400",calculaNpNq(3.85,53.3,1400,9391)[0],calculaNpNq(3.85,53.3,1400,9391)[1],1400,85),
			new factAg("G. Caudal","1600",calculaNpNq(5.25,47.7,1600,12549)[0],calculaNpNq(5.25,47.7,1600,12549)[1],1600,110),
			new factAg("Bipala","400",calculaNpNq(0.259,70.3,400,155)[0],calculaNpNq(0.259,70.3,400,155)[1],400,1),
			new factAg("Bipala","500",calculaNpNq(0.259,56.3,500,240)[0],calculaNpNq(0.259,56.3,500,240)[1],500,3),
			new factAg("Bipala","600",calculaNpNq(0.259,49.3,600,365)[0],calculaNpNq(0.259,49.3,600,365)[1],600,6),
			new factAg("Bipala","800",calculaNpNq(0.259,35.2,800,620)[0],calculaNpNq(0.259,35.2,800,620)[1],800,9),
			new factAg("Bipala","1000",calculaNpNq(0.06,28.7,1000,1000)[0],calculaNpNq(0.06,28.7,1000,1000)[1],1000,20),
			new factAg("Bipala","1200",calculaNpNq(0.259,22.6,1200,1350)[0],calculaNpNq(0.259,22.6,1200,1350)[1],1200,26),
			new factAg("Bipala","1400",calculaNpNq(0.259,18.7,1400,1750)[0],calculaNpNq(0.259,18.7,1400,1750)[1],1400,35),
			new factAg("Bipala","1600",calculaNpNq(0.259,16.7,1600,2350)[0],calculaNpNq(0.259,16.7,1600,2350)[1],1600,52),
			new factAg("Bipala","2000",calculaNpNq(0.259,15,2000,4055)[0],calculaNpNq(0.259,15,2000,4055)[1],2000,82),
			new factAg("Bipala","2500",calculaNpNq(0.385,11.6,2500,5900)[0],calculaNpNq(0.385,11.6,2500,5900)[1],2500,106),
			new factAg("Bipala","3000",calculaNpNq(0.525,9.8,3000,9000)[0],calculaNpNq(0.525,9.8,3000,9000)[1],3000,150),
			new factAg("Bipala","3600",calculaNpNq(0.77,8,3600,12750)[0],calculaNpNq(0.77,8,3600,12750)[1],3600,190),
			new factAg("N.A","N.A",0,0,0,0),				
	};
	private JComboBox<String> P1D;
	private JComboBox<String>P1T;
	private JComboBox<String> P2T;
	private JComboBox<String> P2D;
	private JComboBox<String> P3D;
	private JComboBox<String> P3T;
	private JComboBox<String> P4D;
	private JComboBox<String> P4T;
	private int cont;
	private int cont1;


public selAg(elementoprincipal up) {
		ep=up;	
		DecimalFormatSymbols separador=new DecimalFormatSymbols();
		separador.setDecimalSeparator('.');
		DecimalFormat fleje=new DecimalFormat("0.0#",separador);
		cont1=0;
		cont=0;
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(false);
		DecimalFormat fiag=new DecimalFormat("0.0#",separador);
		String[][]process= {{"Acon. Lodos","5-7"},
				{"Homo. Lodos Floculentos","4-5"},
				{"Homo. Lodos No Floculentos","5-7"},
				{"Prep. De Polímeros Sólidos","6-7"},
				{"Mad. De Polímeros","5-6"},
				{"Mtto. y Prep. Lechada De Cal","8-9"},
				{"Susp. Carbon Activado","7-8"},
				{"Prep. Coag. Solidos","5-6"},
				{"Coag. O Neutralización","6-8"},
				{"Floculación","1-3"},
				{"Mezcla Líquidos Miscibles","2-4"},
				{"Homo Temperatura","1-3"},
				{"Almacenamiento","2-4"},
				{"Suspension de solidos","6-8"}};
		String[] indRec=null;
		for(int i=0; i<process.length;i++) {
			if (process[i][0].equals(ep.getProceso())){
				indRec=process[i];
				break;
			}else {
				indRec=process[12];
			}
		}
	
		
		setFont(new Font("Tahoma", Font.PLAIN, 13));
		setTitle("Selección de Agitador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-525/2, (int)screen.getHeight()/4-595/2, 525, 595);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(66,103,178));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 510, 35);
		contentPane.add(panel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		panel_6.setBackground(new Color(66,103,178));
		panel_6.setBounds(0, 291, 510, 35);
		contentPane.add(panel_6);
				
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		panel_2.setBackground(new Color(66,103,178));
		panel_2.setBounds(0, 180, 510, 35);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("El factor de servicio para la potencia es de 1.3. "+System.lineSeparator()+"El índice de agitación recomendado para la aplicaci\u00F3n '" + indRec[0] + "' es: '" + indRec[1]+"'");
		panel_3.setBounds(0, 326, 510, 178);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del Fluido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 504, 510, 49);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Seleccione el tipo de propela y el di\u00E1metro requerido. Las propelas se enumeran de abajo hacia arriba.");
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Propelas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 35, 510, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new TitledBorder(null, "Diseño", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(0, 215, 510, 76);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		pReq = new JLabel("");
		pReq.setHorizontalAlignment(SwingConstants.TRAILING);
		pReq.setBounds(410, 123, 64, 14);
		panel_3.add(pReq);
		
		pSel = new JLabel("");
		pSel.setHorizontalAlignment(SwingConstants.TRAILING);
		pSel.setBounds(410, 148, 64, 14);
		panel_3.add(pSel);
					
		IL1 = new JLabel("");
		IL1.setHorizontalAlignment(SwingConstants.CENTER);
		IL1.setBounds(331, 44, 80, 14);
		panel_1.add(IL1);
		IL1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		IL2 = new JLabel("");
		IL2.setHorizontalAlignment(SwingConstants.CENTER);
		IL2.setBounds(331, 69, 80, 14);
		panel_1.add(IL2);
		IL2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		IL3 = new JLabel("");
		IL3.setHorizontalAlignment(SwingConstants.CENTER);
		IL3.setBounds(331, 94, 80, 14);
		panel_1.add(IL3);
		IL3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		IL4 = new JLabel("");
		IL4.setHorizontalAlignment(SwingConstants.CENTER);
		IL4.setBounds(331, 119, 80, 14);
		panel_1.add(IL4);
		IL4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rel1 = new JLabel("sdf");
		rel1.setHorizontalAlignment(SwingConstants.CENTER);
		rel1.setBounds(421, 44, 80, 14);
		panel_1.add(rel1);
		rel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rel2 = new JLabel("sdf");
		rel2.setHorizontalAlignment(SwingConstants.CENTER);
		rel2.setBounds(421, 69, 80, 14);
		panel_1.add(rel2);
		rel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rel3 = new JLabel("dsf");
		rel3.setHorizontalAlignment(SwingConstants.CENTER);
		rel3.setBounds(421, 94, 80, 14);
		panel_1.add(rel3);
		rel3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		rel4 = new JLabel("sdf");
		rel4.setHorizontalAlignment(SwingConstants.CENTER);
		rel4.setBounds(421, 119, 80, 14);
		panel_1.add(rel4);
		rel4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JLabel lblTipoDePropela = new JLabel("Tipo");
		lblTipoDePropela.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDePropela.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDePropela.setBounds(111, 15, 109, 22);
		panel_1.add(lblTipoDePropela);
		lblTipoDePropela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblIndiceLocal = new JLabel("Indice Local");
		lblIndiceLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndiceLocal.setBounds(331, 15, 80, 22);
		panel_1.add(lblIndiceLocal);
		lblIndiceLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel relacion = new JLabel("Rel DP/DT");
		relacion.setHorizontalAlignment(SwingConstants.CENTER);
		relacion.setBounds(421, 15, 80, 22);
		panel_1.add(relacion);
		relacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDiametro = new JLabel("Diámetro (mm)");
		lblDiametro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiametro.setBounds(228, 15, 94, 22);
		panel_1.add(lblDiametro);
		lblDiametro.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
		JLabel lblPropela = new JLabel("Propela 1:");
		lblPropela.setBounds(24, 44, 68, 14);
		panel_1.add(lblPropela);
		lblPropela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPropela_1 = new JLabel("Propela 2:");
		lblPropela_1.setBounds(24, 69, 68, 14);
		panel_1.add(lblPropela_1);
		lblPropela_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label = new JLabel("Propela 3:");
		label.setBounds(24, 94, 68, 14);
		panel_1.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPropela_2 = new JLabel("Propela 4:");
		lblPropela_2.setBounds(24, 119, 68, 14);
		panel_1.add(lblPropela_2);
		lblPropela_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		String[]tp= {"N.A","Tripala","Turbina","G. Caudal","Bipala"};
		
		P2T = new JComboBox<String>();
		P2T.setBounds(111, 65, 109, 22);
		for(String e:tp) {
			P2T.addItem(e);
		}
		
		P2D = new JComboBox<String>();
		P2D.setBounds(241, 65, 68, 22);
		P2D.setFont(new Font("Tahoma", Font.PLAIN, 11));
		P2D.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(P2D.getSelectedItem().toString().equals("N.A")){
						rel2.setText("N.A");
					}else {
						if(ep.getTipoTanque().equals("CIRCULAR")) rel2.setText(String.valueOf(fiag.format(Double.parseDouble(P2D.getSelectedItem().toString())/1000/ep.getDiametroTanque())));
						if(ep.getTipoTanque().equals("RECTANGULAR")) rel2.setText(String.valueOf(fiag.format(Double.parseDouble(P2D.getSelectedItem().toString())/1000/Math.sqrt(4*ep.getAncho()*ep.getDiametroTanque()/Math.PI))));
					}
			}catch(Exception e3) {
				
			}
				calculototal();
			}
		});
		panel_1.add(P2D);
		
		P2T.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiaMenu(P2T.getSelectedItem().toString(),P2D);
				calculototal();
			}
		});
		panel_1.add(P2T);
		P2T.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
				
		P4T = new JComboBox<String>();
		P4T.setBounds(111, 115, 109, 22);
		for(String e:tp) {
			P4T.addItem(e);
		}
		
		P4D = new JComboBox<String>();
		P4D.setBounds(241, 115, 68, 22);
		P4D.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(P4D.getSelectedItem().toString().equals("N.A")){
						rel4.setText("N.A");
					}else {
						if(ep.getTipoTanque().equals("CIRCULAR")) rel4.setText(String.valueOf(fiag.format(Double.parseDouble(P4D.getSelectedItem().toString())/1000/ep.getDiametroTanque())));
						if(ep.getTipoTanque().equals("RECTANGULAR")) rel4.setText(String.valueOf(fiag.format(Double.parseDouble(P4D.getSelectedItem().toString())/1000/Math.sqrt(4*ep.getAncho()*ep.getDiametroTanque()/Math.PI))));				
					}
				}catch(Exception e3) {
				
				}
				calculototal();
			}
		});
		panel_1.add(P4D);
		P4D.setFont(new Font("Tahoma", Font.PLAIN, 11));
		P4T.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiaMenu(P4T.getSelectedItem().toString(),P4D);
				calculototal();
			}
		});
		panel_1.add(P4T);
		P4T.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		P3T = new JComboBox<String>();
		P3T.setBounds(111, 90, 109, 22);
		for(String e:tp) {
			P3T.addItem(e);
		}		
		
		P3D = new JComboBox<String>();
		P3D.setBounds(241, 90, 68, 22);
		P3D.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
						if(P3D.getSelectedItem().toString().equals("N.A")){
							rel3.setText("N.A");
						}else {
							if(ep.getTipoTanque().equals("CIRCULAR")) rel3.setText(String.valueOf(fiag.format(Double.parseDouble(P3D.getSelectedItem().toString())/1000/ep.getDiametroTanque())));
							if(ep.getTipoTanque().equals("RECTANGULAR")) rel3.setText(String.valueOf(fiag.format(Double.parseDouble(P3D.getSelectedItem().toString())/1000/Math.sqrt(4*ep.getAncho()*ep.getDiametroTanque()/Math.PI))));						}
				}catch(Exception e3) {
					
				}
				calculototal();
			}
		});
				
		panel_1.add(P3D);
		P3D.setFont(new Font("Tahoma", Font.PLAIN, 11));
		P3T.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiaMenu(P3T.getSelectedItem().toString(),P3D);
				calculototal();
			}
		});
		panel_1.add(P3T);
		P3T.setFont(new Font("Tahoma", Font.PLAIN, 11));
	
		
		JLabel lblVelocidadDeRotacion = new JLabel("Velocidad de rotación (rpm):");
		lblVelocidadDeRotacion.setBounds(26, 22, 250, 14);
		panel_5.add(lblVelocidadDeRotacion);
		lblVelocidadDeRotacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel distAlFondo = new JLabel("Distancia al fondo del tanque (m):");
		distAlFondo.setBounds(26, 47, 250, 14);
		panel_5.add(distAlFondo);
		distAlFondo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lEje = new JLabel("");
		lEje.setHorizontalAlignment(SwingConstants.TRAILING);
		lEje.setBounds(410, 23, 64, 14);
		panel_3.add(lEje);
		
		disFondo = new JTextField();
		disFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		disFondo.setColumns(10);
		disFondo.setBounds(424, 44, 65, 20);
		disFondo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setDistFondo(Double.parseDouble(disFondo.getText()));
				}catch(Exception e2) {
					
				}
				ep.setlEje(calculaAltura(ep.getAlturaTotal(),ep.getDistFondo()));
				if(ep.getlEje()!=0) {
					lEje.setText(String.valueOf(fleje.format(ep.getlEje())));
				}else {
					lEje.setText("Información Incorrecta");
				}
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setDistFondo(Double.parseDouble(disFondo.getText()));
				}catch(Exception e2) {
					
				}
				ep.setlEje(calculaAltura(ep.getAlturaTotal(),ep.getDistFondo()));
				if(ep.getlEje()!=0) {
					lEje.setText(String.valueOf(fleje.format(ep.getlEje())));
				}else {
					lEje.setText("Información Incorrecta");
				}
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setDistFondo(Double.parseDouble(disFondo.getText()));
				}catch(Exception e2) {
					
				}
				ep.setlEje(calculaAltura(ep.getAlturaTotal(),ep.getDistFondo()));
				if(ep.getlEje()!=0) {
					lEje.setText(String.valueOf(fleje.format(ep.getlEje())));
				}else {
					lEje.setText("Información Incorrecta");
				}
			}
		});		
		panel_5.add(disFondo);
		//disFondo.setText(String.valueOf(ep.getDistFondo()));
			
		P1T = new JComboBox<String>();
		P1T.setBounds(111, 40, 109, 22);
		for(String e:tp) {
			P1T.addItem(e);
		}
		
		P1D = new JComboBox<String>();
		P1D.setBounds(241, 40, 68, 22);
		P1D.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculototal();
				try {
					setvalor();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
			}

		private void setvalor() throws Exception {
				// TODO Auto-generated method stub
				double calc;
				if(P1T.getSelectedItem().toString().equals("N.A")){
					calc=0;
				}else {
					calc=Double.parseDouble(P1D.getSelectedItem().toString());
				}
				if(cont1!=0)  disFondo.setText(String.valueOf(calc/1000));
				try{
					if(P1D.getSelectedItem().toString().equals("N.A")){
						rel1.setText("N.A");
					}else {
						if(ep.getTipoTanque().equals("CIRCULAR")) rel1.setText(String.valueOf(fiag.format(Double.parseDouble(P1D.getSelectedItem().toString())/1000/ep.getDiametroTanque())));
						if(ep.getTipoTanque().equals("RECTANGULAR")) rel1.setText(String.valueOf(fiag.format(Double.parseDouble(P1D.getSelectedItem().toString())/1000/Math.sqrt(4*ep.getAncho()*ep.getDiametroTanque()/Math.PI))));						}
			}catch(Exception e) {
					
				}
			}
		});
		
		panel_1.add(P1D);
		P1D.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
		P1T.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cambiaMenu(P1T.getSelectedItem().toString(),P1D);
				calculototal();
			}
		});
		panel_1.add(P1T);
		P1T.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		rpm = new JTextField();
		rpm.setHorizontalAlignment(SwingConstants.TRAILING);
		rpm.setColumns(10);
		rpm.setBounds(424, 19, 65, 20);
		rpm.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				calculototal();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				calculototal();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				calculototal();
			}
		});	
		panel_5.add(rpm);
		rpm.setText(String.valueOf(ep.getVelocidad()));
		
		JLabel lblLongitudDelEje = new JLabel("Longitud del eje (m):");
		lblLongitudDelEje.setBounds(25, 23, 169, 14);
		panel_3.add(lblLongitudDelEje);
		lblLongitudDelEje.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
		JLabel lblNivelDeAgitacion = new JLabel("Nivel de agitación:");
		lblNivelDeAgitacion.setBounds(25, 48, 150, 14);
		panel_3.add(lblNivelDeAgitacion);
		lblNivelDeAgitacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMotorSeleccionadokw = new JLabel("Potencia MR Seleccionado (KW):");
		lblMotorSeleccionadokw.setBounds(25, 148, 219, 14);
		panel_3.add(lblMotorSeleccionadokw);
		lblMotorSeleccionadokw.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPotenciaRequeridakw = new JLabel("Potencia Requerida (KW):");
		lblPotenciaRequeridakw.setBounds(25, 123, 169, 14);
		panel_3.add(lblPotenciaRequeridakw);
		lblPotenciaRequeridakw.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCaudalmh = new JLabel("Caudal (m3/h):");
		lblCaudalmh.setBounds(25, 73, 169, 14);
		panel_3.add(lblCaudalmh);
		lblCaudalmh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblVueltash = new JLabel("Vueltas totales:");
		lblVueltash.setBounds(25, 98, 169, 14);
		panel_3.add(lblVueltash);
		lblVueltash.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		nAgt = new JLabel("");
		nAgt.setHorizontalAlignment(SwingConstants.TRAILING);
		nAgt.setBounds(410, 48, 64, 14);
		panel_3.add(nAgt);
		
		caudal = new JLabel("");
		caudal.setHorizontalAlignment(SwingConstants.TRAILING);
		caudal.setBounds(410, 73, 64, 14);
		panel_3.add(caudal);
		
		vH = new JLabel("");
		vH.setHorizontalAlignment(SwingConstants.TRAILING);
		vH.setBounds(410, 98, 64, 14);
		panel_3.add(vH);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(330, 11, 95, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					ep.setlEje(Double.parseDouble(lEje.getText()));
				}catch(Exception e2) {
					
				}
				selEje frameDS = new selEje(ep);
				frameDS.setVisible(true);
				JComponent compIni=(JComponent)e.getSource();
				Window winIni=SwingUtilities.getWindowAncestor(compIni);
				winIni.setVisible(false);
			}
			
		});
		panel_4.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(236, 11, 84, 23);
		panel_4.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DatosTanque frameDS = new DatosTanque(ep);
				frameDS.setVisible(true);
				JComponent compIni=(JComponent)e.getSource();
				Window winIni=SwingUtilities.getWindowAncestor(compIni);
				winIni.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		if(ep.getPropelas()!=null) {
			P4T.setSelectedItem(ep.getPropelas()[3].getTipo());
			P4D.setSelectedItem(ep.getPropelas()[3].getDiametro());
		}
		
		if(ep.getPropelas()!=null) {
			P1T.setSelectedItem(ep.getPropelas()[0].getTipo());
			P1D.setSelectedItem(ep.getPropelas()[0].getDiametro());
		}
		
		if(ep.getPropelas()!=null) {
			P3T.setSelectedItem(ep.getPropelas()[2].getTipo());
			P3D.setSelectedItem(ep.getPropelas()[2].getDiametro());
		}
		
		if(ep.getPropelas()!=null) {
			P2T.setSelectedItem(ep.getPropelas()[1].getTipo());
			P2D.setSelectedItem(ep.getPropelas()[1].getDiametro());
		}
		if(ep.getDistFondo()!=0) {
			disFondo.setText(String.valueOf(ep.getDistFondo()));
		}else {
			disFondo.setText("0.2");
		}
		cont=1;
		cont1=1;
		
		calculototal();
		
	}

public void calculototal() {
	if (cont==0){
		return;
	}
	DecimalFormatSymbols separador=new DecimalFormatSymbols();
	separador.setDecimalSeparator('.');
	factAg[] temporal= {new factAg("","",0.0,0.0,0.0,0),
			new factAg("","",0.0,0.0,0.0,0),
			new factAg("","",0.0,0.0,0.0,0),
			new factAg("","",0.0,0.0,0.0,0),
	};
	try {
		ep.setVelocidad(Double.parseDouble(rpm.getText()));
		for(factAg p1:dCalculo) {
				if(P1T.getSelectedItem().toString().equals(p1.getTipo()) && P1D.getSelectedItem().toString().equals(p1.getDiametro())){
					temporal[0]=p1;
				}
				if(P2T.getSelectedItem().toString().equals(p1.getTipo()) && P2D.getSelectedItem().toString().equals(p1.getDiametro())){
					temporal[1]=p1;
				}
				if(P3T.getSelectedItem().toString().equals(p1.getTipo()) && P3D.getSelectedItem().toString().equals(p1.getDiametro())){
					temporal[2]=p1;
				}
				if(P4T.getSelectedItem().toString().equals(p1.getTipo()) && P4D.getSelectedItem().toString().equals(p1.getDiametro())){
					temporal[3]=p1;
				}
			}
		ep.setPropelas(temporal);
		ep.setVelocidad(Double.parseDouble(rpm.getText()));
		
		//--------------------------CALCULO DE POTENCIA--------------------------------//
		
		double potp1=temporal[0].getKp()*Math.pow(ep.getVelocidad(), 3)*Math.pow(temporal[0].getDiacalc(), 5);
		double potp2=temporal[1].getKp()*Math.pow(ep.getVelocidad(), 3)*Math.pow(temporal[1].getDiacalc(), 5);
		double potp3=temporal[2].getKp()*Math.pow(ep.getVelocidad(), 3)*Math.pow(temporal[2].getDiacalc(), 5);
		double potp4=temporal[3].getKp()*Math.pow(ep.getVelocidad(), 3)*Math.pow(temporal[3].getDiacalc(), 5);
		double fbaffles=1;
		if(ep.getBaffles().equals("SI")) {
			fbaffles=1.2;
		}
		double fvisco=1.1;
		double fserv=1.3;
		if(ep.getViscosidad()<=20) fvisco=1.1;
		if(ep.getViscosidad()>20) fvisco=0.18612*Math.log(ep.getViscosidad())+0.54256;
		double pottl=(potp1+potp2+potp3+potp4)*fserv*fbaffles*fvisco*ep.getDensidad()/1000;
		DecimalFormat fipo=new DecimalFormat("0.00#",separador);
		try{
			pReq.setText(String.valueOf(fipo.format(pottl)));
		}catch(Exception e) {
			pReq.setText("ERROR");
		}
		ep.setPot(pottl);
		
		//-------------------------ARCHIVO DE POTENCIAS PARA GENERACION DE MEMORIA DE CALCULO-----------///
		
		double []potMemCal=new double[4];
		potMemCal[0]=potp1*fvisco*fbaffles*ep.getDensidad()/1000;
		potMemCal[1]=potp2*fvisco*fbaffles*ep.getDensidad()/1000;
		potMemCal[2]=potp3*fvisco*fbaffles*ep.getDensidad()/1000;
		potMemCal[3]=potp4*fvisco*fbaffles*ep.getDensidad()/1000;
		ep.setPotencias(potMemCal);
		
		//--------------------------------CALCULO DE CAUDAL---------------------------//
		
		double qcp1=temporal[0].getNq()*ep.getVelocidad()*Math.pow(temporal[0].getDiacalc()/1000, 3)*60;
		double qcp2=temporal[1].getNq()*ep.getVelocidad()*Math.pow(temporal[1].getDiacalc()/1000, 3)*60;
		double qcp3=temporal[2].getNq()*ep.getVelocidad()*Math.pow(temporal[2].getDiacalc()/1000, 3)*60;
		double qcp4=temporal[3].getNq()*ep.getVelocidad()*Math.pow(temporal[3].getDiacalc()/1000, 3)*60;
		double qtot=qcp1+0.25*(qcp2+qcp3+qcp4);
		DecimalFormat fica=new DecimalFormat("0",separador);
		try{
			caudal.setText(String.valueOf(fica.format(qtot)));
		}catch(Exception e) {
			caudal.setText("ERROR");
		}
		ep.setCaudal(qtot);
		
		//-------------------------ARCHIVO DE CAUDALES PARA GENERACION MEMORIA DE CALCULO------------///
		
		double []caudales= {qcp1,qcp2,qcp3,qcp4};
		ep.setCaudales(caudales);
		
		//-----------------CALCULO DE INDICE-------------------------------///
		
		DecimalFormat fiag=new DecimalFormat("0.0",separador);
		double area=0;
		if(ep.getTipoTanque().equals("CIRCULAR")) area=Math.PI*Math.pow(ep.getDiametroTanque(), 2)/4;
		if(ep.getTipoTanque().equals("RECTANGULAR")) area=ep.getAncho()*ep.getDiametroTanque();
		double ip1=qcp1/(area*108);
		IL1.setText(String.valueOf(fiag.format(ip1)));
		double ip2=qcp2/(area*108);
		IL2.setText(String.valueOf(fiag.format(ip2)));
		double ip3=qcp3/(area*108);
		IL3.setText(String.valueOf(fiag.format(ip3)));
		double ip4=qcp4/(area*108);
		IL4.setText(String.valueOf(fiag.format(ip4)));
		double iptot=qtot/(area*108);
		
		try{
			nAgt.setText(String.valueOf(fiag.format(iptot)));
		}catch(Exception e) {
			nAgt.setText("ERROR");
		}
		ep.setnAg(iptot);
		
		
		//---------------CALCULO VUELTAS POR HORA----------------------//
		
		double vol=0;
		double tr=0;
		if(ep.tipoTanque.equals("CIRCULAR")) {
			vol=Math.PI*Math.pow(ep.getDiametroTanque(), 2)/4*ep.getAlturaTotal();
		}else {
			vol=ep.getDiametroTanque()*ep.getAncho()*ep.getAlturaTotal();
		}
		if(ep.getParamCirculacion().equals("TIEMPO DE RESIDENCIA")) tr=ep.getDatoCirculacion();
		if(ep.getParamCirculacion().equals("FLUJO DEL TANQUE")) tr=vol/ep.getDatoCirculacion();
		vH.setText(String.valueOf(fiag.format(qtot*tr/vol)));
		
		//--------**********-----SELECCION DE MOTOR---------************---------------////////
		double inf=0;
		double sup=0.25;
		double msel=0;
		double[]motores= {0.25,0.37,0.55,0.75,1.1,1.5,2.2,3,4,5.5,7.5,9.2,11,15,18.5,22,30,37,45,55,75,90,110,132,160};
		for(int k=0;k<motores.length;k++) {
			if(pottl>inf && pottl<=(sup*1.05)) {
				msel=motores[k];
				break;
			}
			inf=motores[k];
			sup=motores[k+1];
		}
			
			
		try{
			pSel.setText(String.valueOf(msel));
		}catch(Exception e) {
			pSel.setText("ERROR");
		}
		ep.setPots(msel);

	}catch(Exception e) {
				
	}
}

public static void cambiaMenu (String ini,JComboBox<String> res) {
	
		res.removeAllItems();
		switch (ini){
		case "Tripala":
			int[]tripala= {200,300,400,500,600,700,800,1000,1200,1500,1800,2000,2500};
			for(int e:tripala) {
				res.addItem(String.valueOf(e));
			}
			break;
		case "Turbina":
			int[]turbina= {200,350,500,550,700,800,900,1000,1200};
			for(int e:turbina) {
				res.addItem(String.valueOf(e));
				
			}
			break;
		case "G. Caudal":
			int[]gCaudal= {200,300,400,600,800,1000,1200,1400};
			for(int e:gCaudal) {
				res.addItem(String.valueOf(e));
				
			}
			break;
		case "Bipala":
			int[]bipala= {400,500,600,800,1000,1200,1400,1600,2000,2500,3000,3600};
			for(int e:bipala) {
				res.addItem(String.valueOf(e));
				
			}
			break;
		case "N.A":
			res.addItem("N.A");
			break;
		}
	}

private static double calculaAltura(double alTank,double altDes) {
	
		if((alTank>=0) && (alTank>altDes)) {
			
			return alTank-altDes;
		}else {
			return 0;	
		}
}

public double []calculaNpNq(double pot,double rpm, double diametro,double caudal) {
	
	double[]res= {pot/(Math.pow(rpm, 3)* Math.pow(diametro,5)),caudal/(60*rpm*Math.pow((diametro/1000), 3))};
	return res;
	
}


}


