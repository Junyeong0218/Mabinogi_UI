package Mabinogi;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelMainShortcut extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JLabel label_Shortcut;
	
	ImageIcon shortcut = new ImageIcon(View.class.getResource("../Image/Shortcut.png"));
	
	public PanelMainShortcut() {
		
		setBounds(71, 7, 154, 305);
		setBackground(new Color(255, 0, 0, 0));
		
		label_Shortcut = new JLabel(shortcut);
		label_Shortcut.setSize(183, 305);
		
		add(label_Shortcut);
		
		setVisible(true);
	}
	

}
