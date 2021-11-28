package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

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
	ImageIcon backTo_icon = new ImageIcon(View.class.getResource("../Image/button_backTo.png"));
	
	public PanelSkill(Controller controller, Font font) {
		
		panelSkill = new JPanel();
		
		setBounds(0, 0, 640, 360);
		setLayout(null);
		
		skill_bg = new JLabel(skill_bg_icon);
		skill_bg.setBounds(0, -20, 640, 360);
		
		current_ap = new JLabel("현재 어빌리티 포인트 : " + controller.getUserAp());
		current_ap.setFont(font);
		current_ap.setBounds(472, 0, 250, 16);
		
		panelSkillAdvance = new PanelSkillAdvance(controller, font);
		
		backToMain = new JButton(backTo_icon);
		backToMain.setBounds(320, 260, 300, 60);
		backToMain.setBorderPainted(false);
		backToMain.setContentAreaFilled(false);
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
