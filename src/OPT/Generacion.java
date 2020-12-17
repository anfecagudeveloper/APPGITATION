package OPT;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JCheckBox;


public class Generacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textConc;
	private JTextField textDiaEje;
	private JTextField textMatPle;
	private JTextField textDimPle;
	private JTextField textRefRed;
	private JTextField textMosVel;
	private JTextField textFS;
	private JTextField textpeso;
	private elementoprincipal ep;
	private JComboBox <String>comboDiaEje;
	private JComboBox<String> comboOriAg;
	private JComboBox<String> comboMosVel;
	private JComboBox<String> matPle;
	private JComboBox<String> comboLinterna;
	private JComboBox<String> comboTipRed;
	private JComboBox<String> comboMarRed;
	private JComboBox <String> comboAcabado;
	private JComboBox<String> comboSello;
	private JCheckBox chlWD;
	private JCheckBox chk110;
	private JCheckBox chkID;
	private JCheckBox chkXP;
	private JCheckBox chkNeu;
	private String codigo;
	private String[][]alabes= {{"Tripala","3"},
			{"G. Caudal","3"},
			{"Bipala","2"},
			{"Turbina","4"}
	};
	private String[][]flujo= {{"Tripala","Axial"},
			{"G. Caudal","Axial"},
			{"Bipala","Axial-Tangencial"},
			{"Turbina","Radial-Tangencial"}
	};
	
	


	public Generacion(elementoprincipal up)  {
		ep=up;
		setFont(new Font("Tahoma", Font.PLAIN, 13));
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Generación de Documentación");
		setResizable(false);
		setBackground(new Color(66,103,178));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-463/2, (int)screen.getHeight()/4-655/2, 463, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66,103,178));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(224,224,224));
		panel_8.setBounds(447, 0, 18, 705);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(224,224,224));
		panel_7.setBounds(0, 637, 460, 18);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agitador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 100, 450, 233);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Proceso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 0, 450, 62);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 595, 450, 44);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Motoreductor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 370, 450, 235);
		contentPane.add(panel_2);
		
		JLabel lblMostrarDimetroDe = new JLabel("Mostrar diámetro de eje:");
		lblMostrarDimetroDe.setToolTipText("");
		lblMostrarDimetroDe.setBounds(24, 28, 200, 14);
		panel_1.add(lblMostrarDimetroDe);
		lblMostrarDimetroDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboDiaEje = new JComboBox<String>();
		comboDiaEje.setBounds(327, 24, 80, 22);
		String[]diaEje= {"Si","No"};
		for(String e:diaEje) {
			comboDiaEje.addItem(e);
		}
		panel_1.add(comboDiaEje);
		comboDiaEje.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		comboOriAg = new JComboBox<String>();
		comboOriAg.setBounds(327, 49, 80, 22);
		String[]oriAg= {"Vertical","Horizontal"};
		for(String e:oriAg) {
			comboOriAg.addItem(e);
		}
		panel_1.add(comboOriAg);
		comboOriAg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textDimPle = new JTextField();
		textDimPle.setColumns(10);
		textDimPle.setBounds(327, 75, 80, 20);
		panel_1.add(textDimPle);
		
		JLabel lblDimetroDeBrida = new JLabel("Dimensiones pletina (mm):");
		lblDimetroDeBrida.setToolTipText("");
		lblDimetroDeBrida.setBounds(24, 78, 189, 14);
		panel_1.add(lblDimetroDeBrida);
		lblDimetroDeBrida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMaterialPletina = new JLabel("Material pletina:");
		lblMaterialPletina.setToolTipText("");
		lblMaterialPletina.setBounds(24, 103, 189, 14);
		panel_1.add(lblMaterialPletina);
		lblMaterialPletina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblOrientacinAgitador = new JLabel("Orientación Agitador:");
		lblOrientacinAgitador.setToolTipText("");
		lblOrientacinAgitador.setBounds(24, 53, 135, 14);
		panel_1.add(lblOrientacinAgitador);
		lblOrientacinAgitador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMostrarVelocidad = new JLabel("Mostrar Velocidad:");
		lblMostrarVelocidad.setToolTipText("");
		lblMostrarVelocidad.setBounds(24, 128, 135, 14);
		panel_1.add(lblMostrarVelocidad);
		lblMostrarVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboMosVel = new JComboBox<String>();
		comboMosVel.setBounds(327, 124, 80, 22);
		String[]mosVel= {"Si","No"};
		for(String e:mosVel) {
			comboMosVel.addItem(e);
		}
		panel_1.add(comboMosVel);
		comboMosVel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		JLabel lblLinterna = new JLabel("Linterna:");
		lblLinterna.setBounds(24, 153, 189, 14);
		panel_1.add(lblLinterna);
		lblLinterna.setToolTipText("");
		lblLinterna.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		matPle = new JComboBox<String>();
		matPle.setBounds(327, 99, 80, 22);
		String[]matple= {"304SS","A36 - Galvanizado","316SS"};
		for(String e:matple) {
			matPle.addItem(e);
		}
		panel_1.add(matPle);
		matPle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		comboLinterna = new JComboBox<String>();
		comboLinterna.setBounds(327, 150, 80, 22);
		String[]comboLin= {"No","Si"};
		for(String e:comboLin) {
			comboLinterna.addItem(e);
		}
		panel_1.add(comboLinterna);
		comboLinterna.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		comboSello = new JComboBox<String>();
		comboSello.setBounds(327, 174, 80, 22);
		String[]comSel= {"No","Si"};
		for(String e:comSel) {
			comboSello.addItem(e);
		}
		panel_1.add(comboSello);
		comboSello.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblSello = new JLabel("Sello:");
		lblSello.setBounds(24, 178, 189, 14);
		panel_1.add(lblSello);
		lblSello.setToolTipText("");
		lblSello.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAcabado = new JLabel("Acabado:");
		lblAcabado.setBounds(24, 203, 189, 14);
		panel_1.add(lblAcabado);
		lblAcabado.setToolTipText("");
		lblAcabado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		comboAcabado = new JComboBox<String>();
		comboAcabado.setBounds(327, 199, 80, 22);
		String[]acab= {"SandBlasting","Recubrimiento en fibra de Vidrio","Brillado a espejo"};
		for(String e:acab) {
			comboAcabado.addItem(e);
		}
		panel_1.add(comboAcabado);
		comboAcabado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		
		JLabel lblPropela = new JLabel("Concentración sólidos (%):");
		lblPropela.setBounds(24, 24, 200, 14);
		panel_4.add(lblPropela);
		lblPropela.setToolTipText("");
		lblPropela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textConc = new JTextField();
		textConc.setBounds(325, 21, 80, 20);
		panel_4.add(textConc);
		textConc.setColumns(10);
		
		JLabel peso=new JLabel("Peso del Reductor (kg):");
		peso.setBounds(24, 124, 189, 14);
		panel_2.add(peso);
		peso.setToolTipText("");
		peso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
        textpeso=new JTextField();
    	textpeso.setBounds(327, 121, 80, 20);
		panel_2.add(textpeso);
		textpeso.setColumns(10);

		
		JButton button = new JButton("Atrás");
		button.setBounds(219, 11, 84, 23);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] finales= {textConc.getText(),
						comboDiaEje.getSelectedItem().toString(),
						comboOriAg.getSelectedItem().toString(),
						textDimPle.getText(),
						matPle.getSelectedItem().toString(),
						comboMosVel.getSelectedItem().toString(),
						comboLinterna.getSelectedItem().toString(),
						comboSello.getSelectedItem().toString(),
						comboAcabado.getSelectedItem().toString(),
						comboMarRed.getSelectedItem().toString(),
						comboTipRed.getSelectedItem().toString(),
						textRefRed.getText(),
						textFS.getText(),
						String.valueOf(chkNeu.isSelected()),
						String.valueOf(chkXP.isSelected()),
						String.valueOf(chkID.isSelected()),
						String.valueOf(chk110.isSelected()),
						String.valueOf(chlWD.isSelected()),
						textpeso.getText(),
				};
				ep.setFinales(finales);
				selEje frameDS = new selEje(ep);
				frameDS.setVisible(true);
				JComponent compIni=(JComponent)e.getSource();
				Window winIni=SwingUtilities.getWindowAncestor(compIni);
				winIni.setVisible(false);
			}
			
		});
		panel.add(button);
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(313, 11, 95, 23);
		btnFinalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] finales= {textConc.getText(),
						comboDiaEje.getSelectedItem().toString(),
						comboOriAg.getSelectedItem().toString(),
						textDimPle.getText(),
						matPle.getSelectedItem().toString(),
						comboMosVel.getSelectedItem().toString(),
						comboLinterna.getSelectedItem().toString(),
						comboSello.getSelectedItem().toString(),
						comboAcabado.getSelectedItem().toString(),
						comboMarRed.getSelectedItem().toString(),
						comboTipRed.getSelectedItem().toString(),
						textRefRed.getText(),
						textFS.getText(),
						String.valueOf(chkNeu.isSelected()),
						String.valueOf(chkXP.isSelected()),
						String.valueOf(chkID.isSelected()),
						String.valueOf(chk110.isSelected()),
						String.valueOf(chlWD.isSelected()),
						textpeso.getText(),
				};
				ep.setFinales(finales);
				try{
					codigo=codifica();
				}catch(Exception e2) {
					codigo="NOCODE";
				}
				try {
					guardadatos();
					JOptionPane.showMessageDialog(contentPane,"Se generó el directorio "+ file +"/"+ codigo +"/");
					System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "No se pudo generar el directorio. Debe seleccionar un directorio y verificar que no esté protegido contra escritura.");
				}
				
			}
			
		});
		panel.add(btnFinalizar);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		comboTipRed = new JComboBox<String>();
		comboTipRed.setBounds(327, 45, 80, 22);
		String[]tRed= {"Ejes Paralelos","Engranajes Helicoidales","Engranajes Cónicos","Sinfin Corona"};
		for(String e:tRed) {
			comboTipRed.addItem(e);
		}
		panel_2.add(comboTipRed);
		comboTipRed.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textRefRed = new JTextField();
		textRefRed.setColumns(10);
		textRefRed.setBounds(327, 71, 80, 20);
		panel_2.add(textRefRed);
		
		JLabel lblReferenciaReductor = new JLabel("Referencia reductor:");
		lblReferenciaReductor.setToolTipText("");
		lblReferenciaReductor.setBounds(24, 74, 189, 14);
		panel_2.add(lblReferenciaReductor);
		lblReferenciaReductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMarcaDeReductor = new JLabel("Marca de Reductor:");
		lblMarcaDeReductor.setBounds(24, 24, 135, 14);
		panel_2.add(lblMarcaDeReductor);
		lblMarcaDeReductor.setToolTipText("");
		lblMarcaDeReductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblReferenciaDeReductor = new JLabel("Tipo de Reductor:");
		lblReferenciaDeReductor.setBounds(24, 49, 189, 14);
		panel_2.add(lblReferenciaDeReductor);
		lblReferenciaDeReductor.setToolTipText("");
		lblReferenciaDeReductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		comboMarRed = new JComboBox<String>();
		comboMarRed.setBounds(327, 19, 80, 22);
		String[]marRed= {"SEW","NORD","No especifica"};
		for(String e:marRed) {
			comboMarRed.addItem(e);
		}
		panel_2.add(comboMarRed);
		comboMarRed.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblFactorDeServicio = new JLabel("Factor de Servicio:");
		lblFactorDeServicio.setBounds(24, 99, 189, 14);
		panel_2.add(lblFactorDeServicio);
		lblFactorDeServicio.setToolTipText("");
		lblFactorDeServicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textFS = new JTextField();
		textFS.setColumns(10);
		textFS.setBounds(327, 96, 80, 20);
		panel_2.add(textFS);
		
		JLabel lblAdicionalesMotoreductor = new JLabel("Adicionales Motoreductor");
		lblAdicionalesMotoreductor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdicionalesMotoreductor.setToolTipText("");
		lblAdicionalesMotoreductor.setBounds(24, 149, 189, 14);
		panel_2.add(lblAdicionalesMotoreductor);
		lblAdicionalesMotoreductor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chkNeu = new JCheckBox("Neum\u00E1tico");
		chkNeu.setBounds(24, 170, 97, 23);
		panel_2.add(chkNeu);
		chkNeu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chkXP = new JCheckBox("Explosion Proof");
		chkXP.setBounds(162, 170, 116, 23);
		panel_2.add(chkXP);
		chkXP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chkID = new JCheckBox("Invert Duty");
		chkID.setBounds(310, 170, 97, 23);
		panel_2.add(chkID);
		chkID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chk110 = new JCheckBox("110V");
		chk110.setBounds(24, 196, 97, 23);
		panel_2.add(chk110);
		chk110.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chlWD = new JCheckBox("WashDown");
		chlWD.setBounds(310, 196, 97, 23);
		panel_2.add(chlWD);
		chlWD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		if(ep.getFinales()!=null) {
			
			textConc.setText(ep.getFinales()[0]);
			comboDiaEje.setSelectedItem(ep.getFinales()[1]);
			comboOriAg.setSelectedItem(ep.getFinales()[2]);
			textDimPle.setText(ep.getFinales()[3]);		
			matPle.setSelectedItem(ep.getFinales()[4]);		
			comboMosVel.setSelectedItem(ep.getFinales()[5]);
			comboLinterna.setSelectedItem(ep.getFinales()[6]);
			comboSello.setSelectedItem(ep.getFinales()[7]);
			comboAcabado.setSelectedItem(ep.getFinales()[8]);
			comboMarRed.setSelectedItem(ep.getFinales()[9]);
			comboTipRed.setSelectedItem(ep.getFinales()[10]);
			textRefRed.setText(ep.getFinales()[11]);
			textFS.setText(ep.getFinales()[12]);
			chkNeu.setSelected(Boolean.valueOf(ep.getFinales()[13]));
			chkXP.setSelected(Boolean.valueOf(ep.getFinales()[14]));
			chkID.setSelected(Boolean.valueOf(ep.getFinales()[15]));
			chk110.setSelected(Boolean.valueOf(ep.getFinales()[16]));
			chlWD.setSelected(Boolean.valueOf(ep.getFinales()[17]));
			textpeso.setText(ep.getFinales()[18]);
		}
	
		
		
		
	}
	
	public void guardadatos() throws IOException {
		///---------*************** GENERA RUTA-----------***************
		
		chooser= new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setDialogTitle("Guardar");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if(chooser.showOpenDialog(contentPane)==JFileChooser.APPROVE_OPTION) {
			file=chooser.getSelectedFile();
			
		}
		///--***********-------------***************-----------***********---------****///////
		///---------*************** CREA PDF   FICHA TECNICA-----------***************
		///--***********-------------***************-----------***********---------****///////
		///--***********-------------***************-----------***********---------****///////
		
		
				
				InputStream pdfRef=this.getClass().getResourceAsStream("/resources/FT.pdf");
				DecimalFormatSymbols separador=new DecimalFormatSymbols();
				separador.setDecimalSeparator('.');
				DecimalFormat fiag=new DecimalFormat("0.0##",separador);
				DecimalFormat fiat=new DecimalFormat("0.#",separador);
				PDDocument document=PDDocument.load(pdfRef);
	
				
				//-----------Inicio de texto en pdf-----------------///
				
				PDPage page=document.getPage(1);
				PDPageContentStream contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
				contentStream.setNonStrokingColor(Color.BLACK);
				contentStream.beginText();
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
				contentStream.setLeading(14.9f);
				
				
				//-----------Primera seccion ------------------------------------///
				
				contentStream.newLineAtOffset(200, 661);
				contentStream.showText(ep.getTagAgitador());
				contentStream.newLine();
				if (!ep.getFinales()[0].equals("")) {
					contentStream.showText(ep.getFinales()[0]+"%");
				}else {
					contentStream.showText("N.A");
				}
				contentStream.newLine();
				contentStream.showText(String.valueOf((int)ep.getDensidad())+" kg/m3");
				contentStream.newLine();
				contentStream.showText(String.valueOf((int)ep.getViscosidad())+ " cP");
				contentStream.newLine();
				contentStream.showText(String.valueOf((int)ep.getCaudal()) + " m3/h");
				contentStream.newLine();
				contentStream.showText(String.valueOf(fiag.format(ep.getnAg())));
				contentStream.endText();
				contentStream.close();
				
				//-------------------------Seccion 2---------------------------///
				
				contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
				contentStream.setNonStrokingColor(Color.BLACK);
				contentStream.beginText();
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
				contentStream.setLeading(14.9f);
				contentStream.newLineAtOffset(200, 530);
				if(ep.tipoTanque.equals("CIRCULAR")) {
					contentStream.showText(String.valueOf(ep.getDiametroTanque())+" m");
				}else {
					contentStream.showText(String.valueOf(fiag.format(Math.sqrt(4*ep.getDiametroTanque()*ep.getAncho()/Math.PI)))+
							" m      ---Diámetro equivalente para L= " +  String.valueOf(fiag.format(ep.getDiametroTanque())) + " m y A= " + 
							String.valueOf(ep.getAncho()) + " m---");
				}
				contentStream.newLine();
				contentStream.showText(String.valueOf(ep.getAlturaTotal())+ " m");
				contentStream.newLine();
				if(ep.tipoTanque.equals("CIRCULAR")) {
					contentStream.showText(String.valueOf(fiag.format(Math.PI*Math.pow(ep.getDiametroTanque(), 2)/4*ep.getAlturaTotal()))+ " m");
				}else {
					contentStream.showText(String.valueOf(fiag.format(ep.getDiametroTanque()*ep.getAncho()*ep.getAlturaTotal()))+ " m");
				}
			
				contentStream.endText();
				contentStream.close();
				
				//----------------------Seccion DATOS AGITADOR----------------------------//////
				
				contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
				contentStream.setNonStrokingColor(Color.BLACK);
				contentStream.beginText();
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
				contentStream.setLeading(14.9f);
				contentStream.newLineAtOffset(200, 442);
				contentStream.showText(codigo);
				contentStream.newLine();
				contentStream.showText(comboOriAg.getSelectedItem().toString());
				contentStream.newLine();
				int np=0;
				for(int i=0;i<ep.getPropelas().length;i++) {
					
					if(ep.getPropelas()[i].getTipo().equals("N.A")) break;
					np++;
				}
				contentStream.showText(String.valueOf(np));
				
				////-----------------SECCION DATOS PROPELA 1-------------------------------//
				
				contentStream.newLine();
				contentStream.showText("1");
				contentStream.newLine();
				contentStream.showText(ep.getPropelas()[0].getTipo());
				contentStream.newLine();
				contentStream.showText(ep.getPropelas()[0].getDiametro() + " mm");
				contentStream.newLine();
				String alabesel="";
				for (int i=0;i<alabes.length;i++) {
					if(alabes[i][0].equals(ep.getPropelas()[0].getTipo())) {
						alabesel=alabes[i][1];
					}
				}
				contentStream.showText(alabesel);
				contentStream.newLine();
				contentStream.showText(String.valueOf(ep.getPropelas()[0].getPeso()) + " kg");
				contentStream.newLine();
				contentStream.showText(ep.getMat());
				contentStream.newLine();
				String flujosel="";
				for (int i=0;i<flujo.length;i++) {
					if(flujo[i][0].equals(ep.getPropelas()[0].getTipo())) {
						flujosel=flujo[i][1];
					}
				}
				contentStream.showText(flujosel);
				contentStream.newLine();
				contentStream.showText("Si");
				
				//--------------Secciòn Datos agitador final
				
				contentStream.newLine();
				contentStream.showText(String.valueOf(ep.getlEje())+ " m");
				contentStream.newLine();
				if (comboDiaEje.getSelectedItem().toString().equals("Si")) {
					contentStream.showText(ep.getDiametroEje());
				}else {
					contentStream.showText("Información reservada");
					
				}
				contentStream.newLine();
				contentStream.showText(ep.getMat());
				contentStream.newLine();
				contentStream.showText(ep.getPesoeje()+ " kg");
				contentStream.newLine();
				try{
					 double pesoagitador=Double.parseDouble(ep.getPesoeje())+ep.getPropelas()[0].getPeso()+ep.getPropelas()[1].getPeso()+
								ep.getPropelas()[2].getPeso()+ep.getPropelas()[3].getPeso()+Double.parseDouble(ep.getPesoeje())*0.25
								+Double.parseDouble(ep.getFinales()[18]);
					 contentStream.showText(String.valueOf(fiat.format(pesoagitador))+ " kg");
				}catch(Exception e) {
					contentStream.showText("Información insuficiente: Peso de reductor desconocido");	
				}
				       
				
				contentStream.endText();
				contentStream.close();
				
				//-----------------Seccion propela 2-------------------------------------//
				
				if(!ep.getPropelas()[1].getTipo().equals("N.A")) {
					contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
					contentStream.setNonStrokingColor(Color.BLACK);
					contentStream.beginText();
					contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
					contentStream.setLeading(14.9f);
					contentStream.newLineAtOffset(300, 397);
					contentStream.showText("2");
					contentStream.newLine();
					contentStream.showText(ep.getPropelas()[1].getTipo());
					contentStream.newLine();
					contentStream.showText(ep.getPropelas()[1].getDiametro() + " mm");
					contentStream.newLine();
					alabesel="";
					for (int i=0;i<alabes.length;i++) {
						if(alabes[i][0].equals(ep.getPropelas()[1].getTipo())) {
							alabesel=alabes[i][1];
						}
					}
					contentStream.showText(alabesel);
					contentStream.newLine();
					contentStream.showText(String.valueOf(ep.getPropelas()[1].getPeso()) + " kg");
					contentStream.newLine();
					contentStream.showText(ep.getMat());
					contentStream.newLine();
					flujosel="";
					for (int i=0;i<flujo.length;i++) {
						if(flujo[i][0].equals(ep.getPropelas()[1].getTipo())) {
							flujosel=flujo[i][1];
						}
					}
					contentStream.showText(flujosel);
					contentStream.newLine();
					contentStream.showText("Si");
					contentStream.endText();
					contentStream.close();
				}
				
				
				//-----------Seccion propela 3-------------------------////
				
				if(!ep.getPropelas()[2].getTipo().equals("N.A")) {
					contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
					contentStream.setNonStrokingColor(Color.BLACK);
					contentStream.beginText();
					contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
					contentStream.setLeading(14.9f);
					contentStream.newLineAtOffset(400, 397);
					contentStream.showText("3");
					contentStream.newLine();
					contentStream.showText(ep.getPropelas()[2].getTipo());
					contentStream.newLine();
					contentStream.showText(ep.getPropelas()[2].getDiametro() + " mm");
					contentStream.newLine();
					alabesel="";
					for (int i=0;i<alabes.length;i++) {
						if(alabes[i][0].equals(ep.getPropelas()[2].getTipo())) {
							alabesel=alabes[i][1];
						}
					}
					contentStream.showText(alabesel);
					contentStream.newLine();
					contentStream.showText(String.valueOf(ep.getPropelas()[2].getPeso()) + " kg");
					contentStream.newLine();
					contentStream.showText(ep.getMat());
					contentStream.newLine();
					flujosel="";
					for (int i=0;i<flujo.length;i++) {
						if(flujo[i][0].equals(ep.getPropelas()[2].getTipo())) {
							flujosel=flujo[i][1];
						}
					}
					contentStream.showText(flujosel);
					contentStream.newLine();
					contentStream.showText("Si");
					contentStream.endText();
					contentStream.close();
				}
				
				
				//----------Seccion Propela 4------------------------------//
				
				if(!ep.getPropelas()[3].getTipo().equals("N.A")) {
					contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
					contentStream.setNonStrokingColor(Color.BLACK);
					contentStream.beginText();
					contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
					contentStream.setLeading(14.9f);
					contentStream.newLineAtOffset(500, 397);
					contentStream.showText("4");
					contentStream.newLine();
					contentStream.showText(ep.getPropelas()[3].getTipo());
					contentStream.newLine();
					contentStream.showText(ep.getPropelas()[3].getDiametro() + " mm");
					contentStream.newLine();
					alabesel="";
					for (int i=0;i<alabes.length;i++) {
						if(alabes[i][0].equals(ep.getPropelas()[3].getTipo())) {
							alabesel=alabes[i][1];
						}
					}
					contentStream.showText(alabesel);
					contentStream.newLine();
					contentStream.showText(String.valueOf(ep.getPropelas()[3].getPeso()) + " kg");
					contentStream.newLine();
					contentStream.showText(ep.getMat());
					contentStream.newLine();
					flujosel="";
					for (int i=0;i<flujo.length;i++) {
						if(flujo[i][0].equals(ep.getPropelas()[3].getTipo())) {
							flujosel=flujo[i][1];
						}
					}
					contentStream.showText(flujosel);
					contentStream.newLine();
					contentStream.showText("Si");
					contentStream.endText();
					contentStream.close();
				}
								
				//---------------Seccion Motoreductor----------------------//
				
				contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
				contentStream.setNonStrokingColor(Color.BLACK);
				contentStream.beginText();
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
				contentStream.setLeading(14.9f);
				contentStream.newLineAtOffset(200, 161);
				contentStream.showText(comboMarRed.getSelectedItem().toString());
				contentStream.newLine();
				contentStream.showText(comboTipRed.getSelectedItem().toString());
				contentStream.newLine();
				contentStream.showText(textRefRed.getText());
				contentStream.newLine();
				if(comboMosVel.getSelectedItem().toString().equals("Si")) {
					contentStream.showText(String.valueOf(ep.getVelocidad())+ " rpm");
				}else {
					contentStream.showText("Información Reservada");
				}
				contentStream.newLine();
				contentStream.showText(String.valueOf(ep.getPots())+" KW");
				contentStream.newLine();
				contentStream.showText(textFS.getText());
				contentStream.newLine();
				contentStream.showText(textDimPle.getText() + " mm");
				contentStream.newLine();
				contentStream.showText(matPle.getSelectedItem().toString());
				contentStream.endText();
				contentStream.close();
				File dir=new File(file+"/"+codigo);
				dir.mkdir();
				document.save(file +"/"+ codigo + "/"+ codigo+"_FT"+ ".pdf");
				document.close();
				pdfRef.close();
				
				//---------------GUARDA OBJETO--------------------------------------//
				
				try{
					ObjectOutputStream guardaObjeto=new ObjectOutputStream(new FileOutputStream(file +"/"+ codigo + "/"+ codigo+ ".dat"));
					guardaObjeto.writeObject(ep);
					guardaObjeto.close();
				}catch(IOException e){
					
				}
				
				/////********************************************************************///
				////----***********---------GUARDA PDFS ADICIONALES--------------****------------
				////----*****************-----------------------------------******-------------
				
				InputStream pdfRef2=this.getClass().getResourceAsStream("/resources/REFAG.pdf");
				document=PDDocument.load(pdfRef2);
				document.save(file +"/"+ codigo + "/"+ "Referencias Agitacion.pdf");
				document.close();
				pdfRef2.close();
			
				InputStream pdfRef3=this.getClass().getResourceAsStream("/resources/CATAG.pdf");
				document=PDDocument.load(pdfRef3);
				document.save(file +"/"+ codigo + "/"+ "Catalogo.pdf");
				document.close();	
				pdfRef3.close();
				
				///--***********-------------***************-----------***********---------****///////
				///---------*************** CREA PDF MEMORIA DE CALCULO-----------***************
				///--***********-------------***************-----------***********---------****///////
				///--***********-------------***************-----------***********---------****///////
				
						
						InputStream pdfRef4=this.getClass().getResourceAsStream("/resources/MCAL2.pdf");
						separador=new DecimalFormatSymbols();
						separador.setDecimalSeparator('.');
						fiag=new DecimalFormat("0.0#",separador);
						DecimalFormat fiap=new DecimalFormat("0",separador);
						
						document=PDDocument.load(pdfRef4);
						
						//-----------Inicio de texto en pdf-----------------///
						
						page=document.getPage(4);
						contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
						contentStream.setNonStrokingColor(Color.BLACK);
						contentStream.beginText();
						contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
						contentStream.setLeading(15.5f);
						
						
						//-----------Primera seccion ------------------------------------///
						
						contentStream.newLineAtOffset(195, 575);
						contentStream.showText(String.valueOf(fiap.format(ep.getVelocidad())));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiag.format(ep.getVelocidad()/60)));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiap.format(ep.getVelocidad()*60)));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiap.format(ep.getViscosidad())));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiag.format(ep.getViscosidad()/1000)));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiag.format(ep.getDensidad()/1000)));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiap.format(ep.getDensidad())));
						contentStream.endText();
						contentStream.close();
						
						//--------------Seccion PROPELA 1 --------------------------------------------------//
						
						contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
						contentStream.setNonStrokingColor(Color.BLACK);
						contentStream.beginText();
						contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
						contentStream.setLeading(15.5f);
						contentStream.newLineAtOffset(195, 432);
						contentStream.showText(String.valueOf(fiag.format(ep.getPropelas()[0].getDiacalc()/1000)));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiap.format(ep.getVelocidad()/60*
								Math.pow(ep.getPropelas()[0].getDiacalc()/1000, 2)*ep.getDensidad()/(ep.getViscosidad()/1000))));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiag.format(
								ep.getPotencias()[0]*1000/(ep.getDensidad()*Math.pow(ep.getVelocidad()/60, 3)*
										Math.pow(ep.getPropelas()[0].getDiacalc()/1000, 5)))));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiat.format(ep.getPotencias()[0])));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiag.format(ep.getCaudales()[0]/(ep.getVelocidad()*60
								*Math.pow(ep.getPropelas()[0].getDiacalc()/1000, 3)))));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiap.format(ep.getCaudales()[0])));
						contentStream.endText();
						contentStream.close();
						
					//--------------Seccion PROPELA 2 --------------------------------------------------//
						
						if(!ep.getPropelas()[1].getTipo().equals("N.A")) {
							contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
							contentStream.setNonStrokingColor(Color.BLACK);
							contentStream.beginText();
							contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
							contentStream.setLeading(15.5f);
							contentStream.newLineAtOffset(447, 432);
							contentStream.showText(String.valueOf(fiag.format(ep.getPropelas()[1].getDiacalc()/1000)));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiap.format(ep.getVelocidad()/60*
									Math.pow(ep.getPropelas()[1].getDiacalc()/1000, 2)*ep.getDensidad()/(ep.getViscosidad()/1000))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiag.format(
									ep.getPotencias()[1]*1000/(ep.getDensidad()*Math.pow(ep.getVelocidad()/60, 3)*
											Math.pow(ep.getPropelas()[1].getDiacalc()/1000, 5)))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiat.format(ep.getPotencias()[1])));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiag.format(ep.getCaudales()[1]/(ep.getVelocidad()*60
									*Math.pow(ep.getPropelas()[1].getDiacalc()/1000, 3)))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiap.format(ep.getCaudales()[1])));
							contentStream.endText();
							contentStream.close();
						}
												
						//--------------Seccion PROPELA 3 --------------------------------------------------//
						
						if(!ep.getPropelas()[2].getTipo().equals("N.A")) {
							contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
							contentStream.setNonStrokingColor(Color.BLACK);
							contentStream.beginText();
							contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);	
							contentStream.setLeading(15.5f);
							contentStream.newLineAtOffset(195, 304);
							contentStream.showText(String.valueOf(fiag.format(ep.getPropelas()[2].getDiacalc()/1000)));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiap.format(ep.getVelocidad()/60*
									Math.pow(ep.getPropelas()[2].getDiacalc()/1000, 2)*ep.getDensidad()/(ep.getViscosidad()/1000))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiag.format(
									ep.getPotencias()[2]*1000/(ep.getDensidad()*Math.pow(ep.getVelocidad()/60, 3)*
											Math.pow(ep.getPropelas()[2].getDiacalc()/1000, 5)))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiat.format(ep.getPotencias()[2])));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiag.format(ep.getCaudales()[2]/(ep.getVelocidad()*60
									*Math.pow(ep.getPropelas()[2].getDiacalc()/1000, 3)))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiap.format(ep.getCaudales()[2])));
							contentStream.endText();
							contentStream.close();
						}
						
						
						//--------------Seccion PROPELA 4 --------------------------------------------------//
						
						if(!ep.getPropelas()[3].getTipo().equals("N.A")) {
							contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
							contentStream.setNonStrokingColor(Color.BLACK);
							contentStream.beginText();
							contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
							contentStream.setLeading(15.5f);
							contentStream.newLineAtOffset(447, 304);
							contentStream.showText(String.valueOf(fiag.format(ep.getPropelas()[3].getDiacalc()/1000)));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiap.format(ep.getVelocidad()/60*
									Math.pow(ep.getPropelas()[3].getDiacalc()/1000, 2)*ep.getDensidad()/(ep.getViscosidad()/1000))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiat.format(
									ep.getPotencias()[3]*1000/(ep.getDensidad()*Math.pow(ep.getVelocidad()/60, 3)*
											Math.pow(ep.getPropelas()[3].getDiacalc()/1000, 5)))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiat.format(ep.getPotencias()[3])));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiag.format(ep.getCaudales()[3]/(ep.getVelocidad()*60
									*Math.pow(ep.getPropelas()[3].getDiacalc()/1000, 3)))));
							contentStream.newLine();
							contentStream.showText(String.valueOf(fiap.format(ep.getCaudales()[3])));
							contentStream.endText();
							contentStream.close();
						}
					
						
						//--------------Seccion Final --------------------------------------------------//
						
						contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
						contentStream.setNonStrokingColor(Color.BLACK);
						contentStream.beginText();
						contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
						contentStream.setLeading(15.5f);
						contentStream.newLineAtOffset(195, 176);
						contentStream.showText(String.valueOf(fiag.format(ep.getPot()/1.3)));
						contentStream.newLine();
						contentStream.showText("1.3");
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiag.format(ep.getPot())));
						contentStream.newLine();
						contentStream.showText(String.valueOf(ep.getPots()));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiap.format(ep.getCaudal())));
						contentStream.newLine();
						contentStream.showText(String.valueOf(fiat.format(ep.getnAg())));
						contentStream.endText();
						contentStream.close();
						
						//-----------------------------REFERENCIA DE EQUIPO---------------------------------------//
						
						contentStream=new PDPageContentStream(document,page,AppendMode.APPEND,false);
						contentStream.setNonStrokingColor(Color.BLACK);
						contentStream.beginText();
						contentStream.setFont(PDType1Font.TIMES_ROMAN, 15);
						contentStream.setLeading(15.5f);
						contentStream.newLineAtOffset(362, 543);
						contentStream.showText(codigo);
						contentStream.endText();
						contentStream.close();
						
						////------------GUARDA EL DOCUMENTO----------------------///
						document.save(file +"/"+ codigo + "/"+ codigo+"_MC"+ ".pdf");
						document.close();
	}
	public String codifica() {
		String tipo1="1";
		String tipo2="0";
		if (ep.getPropelas()[0].getTipo().equals(ep.getPropelas()[1].getTipo()) && 
				ep.getPropelas()[0].getDiametro().equals(ep.getPropelas()[1].getDiametro())) {
				tipo1="2";
				if(ep.getPropelas()[2].getTipo().equals(ep.getPropelas()[1].getTipo()) && 
						ep.getPropelas()[2].getDiametro().equals(ep.getPropelas()[1].getDiametro())) {
						tipo1="3";
						if(ep.getPropelas()[2].getTipo().equals(ep.getPropelas()[3].getTipo()) && 
								ep.getPropelas()[2].getDiametro().equals(ep.getPropelas()[3].getDiametro())) {
								tipo1="4";
						}else {
								tipo2="1";
						}
				}else {
						if(ep.getPropelas()[2].getTipo().equals(ep.getPropelas()[3].getTipo()) && 
						ep.getPropelas()[2].getDiametro().equals(ep.getPropelas()[3].getDiametro())) {
							tipo2="2";						
						}else {
							
						}
				}
		}else {
			tipo2="1";
			if(ep.getPropelas()[2].getTipo().equals(ep.getPropelas()[1].getTipo()) && 
					ep.getPropelas()[2].getDiametro().equals(ep.getPropelas()[1].getDiametro())) {
					tipo2="2";
					if(ep.getPropelas()[2].getTipo().equals(ep.getPropelas()[3].getTipo()) && 
							ep.getPropelas()[2].getDiametro().equals(ep.getPropelas()[3].getDiametro())) {
							tipo2="3";
					}else {
						
					}
			}else {
				
			}
		}
		String char1="V";
		String char2="";
		String char3="";
		String char4="";
		String char5="";
		String char6="";
		String char7="";
		if(comboOriAg.getSelectedItem().toString().equals("Horizontal")) char1="H";
		if(!ep.getPropelas()[0].getTipo().equals("N.A")) {
			for(int i=0;i<TIProps.length;i++) {
				if(ep.getPropelas()[0].getTipo().equals(TIProps[i][0])) {
					char2=TIProps[i][1];
				}
			}
			for(int i=0;i<cProps.length;i++) {
				if(tipo1.equals(cProps[i][0])) {
					char3=cProps[i][1];
				}
			}
			for(int i=0;i<TAMProps.length;i++) {
				if(ep.getPropelas()[0].getDiametro().equals(TAMProps[i][0])) {
					char4=TAMProps[i][1];
				}
			}
		}
		if(!ep.getPropelas()[Integer.parseInt(tipo1)].getTipo().equals("N.A") && !tipo2.equals("4")) {
			for(int i=0;i<TIProps.length;i++) {
				if(ep.getPropelas()[Integer.parseInt(tipo1)].getTipo().equals(TIProps[i][0])) {
					char5=TIProps[i][1];
				}
			}
			for(int i=0;i<cProps.length;i++) {
				if(tipo2.equals(cProps[i][0])) {
					char6=cProps[i][1];
				}
			}
			for(int i=0;i<TAMProps.length;i++) {
				if(ep.getPropelas()[Integer.parseInt(tipo1)].getDiametro().equals(TAMProps[i][0])) {
					char7=TAMProps[i][1];
				}
			}
		}else {
			char5="-";
		}
		double leje=ep.getlEje()*10;
		double leje1=Math.round(leje);
		double leje2=leje1*10;
		int leje3=(int)leje2;
		int leje4=leje3/10;
		String char8="";
		char8=String.valueOf(leje4);
		if(leje3<100) char8="0"+String.valueOf(leje4);
		String char9="";
		for(int i=0;i<Pots.length;i++)	{
			if(ep.getPots()==Double.parseDouble((Pots[i][0]))) {
				char9=Pots[i][1];
			}
		}
		int rpm=(int)Math.round(ep.getVelocidad());
		String char10=String.valueOf(rpm);
		if(rpm<100) char10="0"+String.valueOf(rpm);
		String char11="";
		for(int i=0;i<Mats.length;i++) {
			if(ep.getMat().equals(Mats[i][0])) {
				char11=Mats[i][1];
			}
		}
		String char12="";
		if(comboLinterna.getSelectedItem().toString().equals("Si")) char12="L";
		String char13="";
		if(comboSello.getSelectedItem().toString().equals("Si"))char13="Q";
		String char14="";
		if(chkNeu.isSelected()) char14="N";
		String char15="";
		if(chkID.isSelected()) char15="I";
		String char16="";
		if(chkXP.isSelected()) char16="X";
		String char17="";
		if(chlWD.isSelected()) char17="Z";
		String char18="";
		if(chk110.isSelected()) char18="V";
		String char19="";
		for(int i=0;i<Acabados.length;i++) {
			if(comboAcabado.getSelectedItem().toString().equals(Acabados[i][0])) {
				char19=Acabados[i][1];
			}
		}
		return char1+char2+char3+char4+char5+char6+char7+char8+char9+char10+char11+char12+char13+char14+char15+
				char16+char17+char18+char19;
		
				
	}
	
private File file;	
private JFileChooser chooser;		
private String [][] TIProps= {{"Turbina","2"},
		{"Tripala","3"},
		{"G. Caudal","4"},
		{"Bipala","5"},
		{"N.A",""}};
private String [][] Mats= {{"304SS",""},
		{"316SS","S"},
		{"A36","C"},
		{"4340","T"},};
private String [][] cProps= {{"1","A"},
		{"2","B"},
		{"3","C"},
		{"4","B"},};
private String [][]TAMProps= {{"200","B"},
		{"300","C"},
		{"350","D"},
		{"400","E"},
		{"500","F"},
		{"550","G"},
		{"600","H"},
		{"700","I"},
		{"800","J"},
		{"1000","K"},
		{"1200","L"},
		{"1500","M"},
		{"1600","N"},
		{"1800","O"},
		{"2000","P"},
		{"2500","Q"},
		{"3600","X"},
		{"3000","Y"},};
private String [][]Pots= {{"0.25","A"},
		{"0.37","B"},
		{"0.55","C"},
		{"0.75","D"},
		{"1.1","E"},
		{"1.5","F"},
		{"2.2","G"},
		{"3","H"},
		{"4","I"},
		{"5.5","J"},
		{"7.5","K"},
		{"9.2","M"},
		{"11","N"},
		{"15","0"},
		{"18.5","P"},
		{"22","Q"},
		{"30","R"},
		{"37","S"},};
private String [][] Motors= {{"Neumatico","N"},
		{"Explosion Proof","X"},
		{"Invert Duty","I"},
		{"110V","V"},
		{"WashDown","Z"}};
private String [][] Acabados= {{"Recubrimiento en fibra de Vidrio","E"},
		{"Brillado a espejo","M"},
		{"SandBlasting",""}};
}

