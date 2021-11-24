package Mabinogi;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelMainShortcut extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel mainShortcut;
	
	JLabel label_Shortcut;
	
	ImageIcon shortcut = new ImageIcon(View.class.getResource("../Image/Shortcut.png"));
	
	public PanelMainShortcut() {
		
		mainShortcut = new JPanel();
		setBounds(71, 7, 154, 305);
		
		label_Shortcut = new JLabel(shortcut);
		label_Shortcut.setSize(183, 305);
		
		add(label_Shortcut);
		
		setVisible(true);
	}
	

}
