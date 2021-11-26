package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel panelInfo;
	JPanel panelInfoStatus;
	JPanel panelInfoSkill;
	
	JLabel info_bg;
	
	JButton backToMain;
	
	ImageIcon info_Background = new ImageIcon(View.class.getResource("../Image/Main.png"));
	
	public PanelInfo(Controller controller) {
		
		panelInfo = new JPanel();		
		//setBounds(10, 7, 605, 300);
		setBounds(0, 0, 640, 360);
		setLayout(null);
		
		info_bg = new JLabel(info_Background);
		info_bg.setBounds(0, -20, 640, 360);
		
		panelInfoStatus = new PanelInfoStatus(controller);
		panelInfoSkill = new PanelInfoSkill(controller);
		backToMain = new JButton("뒤로가기");
		backToMain.setBounds(322, 255, 296, 50);
		
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
