package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitle extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JButton startButton;
	JLabel bg;
	
	ImageIcon title_Background = new ImageIcon(View.class.getResource("../Image/MainTitle.png"));
	ImageIcon start_icon = new ImageIcon(View.class.getResource("../Image/button_titleStartGame.png"));
	
	public PanelTitle(Controller controller) {
		setLayout(null);
		
		bg = new JLabel(title_Background);
		bg.setBounds(0, -20, 640, 360);
		
		startButton = new JButton(start_icon);
		startButton.setBounds(170, 220, 300, 60);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.createCharacter();
			}
		});
		
		add(startButton);
		add(bg);
		
		setBounds(0, 0, 640, 360);
		setVisible(true);
	}
	
	
}
