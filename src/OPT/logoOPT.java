package OPT;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public  class logoOPT {
	public logoOPT(JLabel i) {
		ImageIcon logo=new ImageIcon(new ImageIcon(this.getClass().getResource("/resources/logo.png")).getImage().getScaledInstance(i.getWidth(), i.getHeight(), Image.SCALE_DEFAULT));
		i.setIcon(logo);	
	}
}

