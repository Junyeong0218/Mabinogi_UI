package Mabinogi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel panelInfoStatus;
	JPanel panelInfoSkill;
	
	JLabel info_bg;
	
	JButton backToMain;
	
	ImageIcon info_Background = new ImageIcon(View.class.getResource("../Image/Main.png"));
	ImageIcon backTo_icon = new ImageIcon(View.class.getResource("../Image/button_backTo.png"));
	
	public PanelInfo(Controller controller, Font font) {
		
		//setBounds(10, 7, 605, 300);
		setBounds(0, 0, 640, 360);
		setLayout(null);
		
		info_bg = new JLabel(info_Background);
		info_bg.setBounds(0, -20, 640, 360);
		
		panelInfoStatus = new PanelInfoStatus(controller, font);
		panelInfoSkill = new PanelInfoSkill(controller, font);
		backToMain = new JButton(backTo_icon);
		backToMain.setBounds(320, 245, 300, 60);
		backToMain.setBorderPainted(false);
		backToMain.setContentAreaFilled(false);
		
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToMain();
			}
		});
		
		add(panelInfoStatus);
		add(panelInfoSkill);
		add(backToMain);
		add(info_bg);
				
		
		setVisible(true);
	}

}
