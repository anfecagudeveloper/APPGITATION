package OPT;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Logo extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logo frameIni = new Logo();
					frameIni.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Window winIni;
	public JComponent compIni;
	public Inicio frameIni;
	private JLabel logodevelop;
	private JButton boton;
	
	public Logo() {
		
		setResizable(false);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Developing Soft.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)screen.getWidth()/4-225, (int)screen.getHeight()/4-75, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logodevelop = new JLabel("");
		logodevelop.setBounds(100, -30, 450, 300);
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/resources/logoDeveloping.gif"));
		logodevelop.setIcon(icon);
		contentPane.add(logodevelop);
		
		boton=new JButton("Inicio");
		boton.setBounds(350, 220, 117, 25);
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Inicio frameDS = new Inicio();
				frameDS.setVisible(true);
				compIni=(JComponent)e.getSource();
				winIni=SwingUtilities.getWindowAncestor(compIni);
				winIni.setVisible(false);
			}
			
		});
		add(boton);
		boton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	}

}