package Mabinogi;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMain extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelMainShortcut;
	JPanel panelMainButtons;
	
	JLabel main_bg;
	
	ImageIcon main_Background = new ImageIcon(View.class.getResource("../Image/Main.png"));
	
	public PanelMain(Controller controller) {
		
		setLayout(null);
		setBounds(0, 0, 640, 360);
		
		main_bg = new JLabel(main_Background);
		main_bg.setBounds(0, -20, 640, 360);
		
		panelMainShortcut = new PanelMainShortcut();
		panelMainButtons = new PanelMainButtons(controller);
		
		add(panelMainShortcut);
		add(panelMainButtons);
		add(main_bg);
		setVisible(true);
	}
	
}
