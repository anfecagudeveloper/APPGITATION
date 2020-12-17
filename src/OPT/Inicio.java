package OPT;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_3;
	private JLabel lblAppSeleccionDe;
	private JButton btnSeleccionar;
	public Window winIni;
	public JComponent compIni;
	public Inicio frameIni;
	private elementoprincipal ep;


	public Inicio(elementoprincipal up) {
		ep=up;
		setResizable(false);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-225, (int)screen.getHeight()/4-75, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(24, 12, 63, 41);
		logoOPT logo=new logoOPT(lblNewLabel_3);
		contentPane.add(lblNewLabel_3);
		
		lblAppSeleccionDe = new JLabel("APP SELECCION DE AGITADORES VERTICALES");
		lblAppSeleccionDe.setBounds(99, 5, 305, 54);
		contentPane.add(lblAppSeleccionDe);
		lblAppSeleccionDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton Cargar = new JButton("Cargar ");
		Cargar.setBounds(109, 64, 117, 25);
		Cargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//----------------Genera buscador de archivo---------------------//
				
				chooser = new JFileChooser();
				filter = new FileNameExtensionFilter(
			        "dat Files", "dat");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(contentPane);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       file=chooser.getSelectedFile();
			    }
			    try {
					ObjectInputStream leeObjeto=new ObjectInputStream(new FileInputStream(file));
					ep=(elementoprincipal)leeObjeto.readObject();
					leeObjeto.close();
					datosSel frameDS = new datosSel(ep);
					frameDS.setVisible(true);
					compIni=(JComponent)e.getSource();
					winIni=SwingUtilities.getWindowAncestor(compIni);
					winIni.setVisible(false);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
			}
			
		});
		contentPane.add(Cargar);
		Cargar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(236, 64, 117, 25);
		btnSeleccionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					datosSel frameDS = new datosSel(ep);
					frameDS.setVisible(true);
					compIni=(JComponent)e.getSource();
					winIni=SwingUtilities.getWindowAncestor(compIni);
					winIni.setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
					
		});
		contentPane.add(btnSeleccionar);
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
	public Inicio() {
		setResizable(false);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-225, (int)screen.getHeight()/4-75, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(24, 12, 63, 41);
		logoOPT logo=new logoOPT(lblNewLabel_3);
		contentPane.add(lblNewLabel_3);
		
		lblAppSeleccionDe = new JLabel("APP SELECCION DE AGITADORES VERTICALES");
		lblAppSeleccionDe.setBounds(99, 5, 305, 54);
		contentPane.add(lblAppSeleccionDe);
		lblAppSeleccionDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton Cargar = new JButton("Cargar ");
		Cargar.setBounds(109, 64, 117, 25);
		Cargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//----------------Genera buscador de archivo---------------------//
				chooser = new JFileChooser();
				filter = new FileNameExtensionFilter(
			        "dat Files", "dat");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(contentPane);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       file=chooser.getSelectedFile();
			    }
			    try {
					ObjectInputStream leeObjeto=new ObjectInputStream(new FileInputStream(file));
					ep=(elementoprincipal)leeObjeto.readObject();
					leeObjeto.close();
					datosSel frameDS = new datosSel(ep);
					frameDS.setVisible(true);
					compIni=(JComponent)e.getSource();
					winIni=SwingUtilities.getWindowAncestor(compIni);
					winIni.setVisible(false);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
			}
			
		});
		contentPane.add(Cargar);
		Cargar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(236, 64, 117, 25);
		btnSeleccionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ep=new elementoprincipal();
				try {
					factAg[]prueba= {new factAg("Tripala","200",0,0,200,10),
							new factAg("N.A","N.A",0,0,0,10),
							new factAg("N.A","N.A",0,0,0,10),
							new factAg("N.A","N.A",0,0,0,10)
					};
					ep.setPropelas(prueba);
					ep.setVelocidad(113);
					ep.setCliente("");
					ep.setCotizacion("");
					ep.setElaboro("");
					ep.setTagAgitador("");
					ep.setTanque("");
					ep.setFecha("");
					ep.setDiametroTanque(1);
					ep.setAlturaUtil(0.8);
					ep.setAlturaTotal(1);
					ep.setDensidad(1000);
					ep.setViscosidad(10);
					ep.setProceso("Almacenamiento");
					ep.setTipoTanque("CIRCULAR");
					ep.setParamCirculacion("TIEMPO DE RESIDENCIA");
					ep.setDatoCirculacion(1);
					ep.setBaffles("SI");
					ep.setAncho(1);
					ep.setMat("304SS");
					ep.setDiametroEje("1 1/4'");
					ep.setSch("--");
					ep.setEstanc("Ligero");
					ep.setDistrod(0.3);
					ep.setDminr(20);
					ep.setCrl(4200);
					ep.setDistFondo(0);
					datosSel frameDS = new datosSel(ep);
					frameDS.setVisible(true);
					compIni=(JComponent)e.getSource();
					winIni=SwingUtilities.getWindowAncestor(compIni);
					winIni.setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
					
		});
		contentPane.add(btnSeleccionar);
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
	JFileChooser chooser;
	File file;
	FileNameExtensionFilter filter;
}
		
		
		
		
		
		
		

