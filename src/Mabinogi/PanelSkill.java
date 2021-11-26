package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSkill extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel panelSkill;
	JPanel panelSkillAdvance;
	
	JLabel skill_bg;
	JLabel current_ap;
	
	JButton backToMain;
	
	ImageIcon skill_bg_icon = new ImageIcon(View.class.getResource("../Image/Main.png"));
	
	public PanelSkill(Controller controller) {
		
		panelSkill = new JPanel();
		
		setBounds(0, 0, 640, 360);
		setLayout(null);
		
		skill_bg = new JLabel(skill_bg_icon);
		current_ap = new JLabel("현재 어빌리티 포인트 : " + controller.getUserAp());
		skill_bg.setBounds(0, -20, 640, 360);
		current_ap.setBounds(472, 0, 250, 16);
		
		panelSkillAdvance = new PanelSkillAdvance(controller);
		
		backToMain = new JButton("뒤로가기");
		backToMain.setBounds(322, 265, 296, 50);
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToMain();
			}
		});
		
		add(current_ap);
		add(panelSkillAdvance);
		add(backToMain);
		add(skill_bg);
		
		
		setVisible(true);
	}
}
