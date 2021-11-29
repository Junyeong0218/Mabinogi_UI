package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMainButtons extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton btnInfo;
	JButton btnSkill;
	JButton btnBattle;
	JButton btnExit;
	
	ImageIcon info_icon = new ImageIcon(View.class.getResource("../Image/button_Info.png"));
	ImageIcon skill_icon = new ImageIcon(View.class.getResource("../Image/button_Skill.png"));
	ImageIcon battle_icon = new ImageIcon(View.class.getResource("../Image/button_Battle.png"));
	ImageIcon exit_icon = new ImageIcon(View.class.getResource("../Image/button_Exit.png"));
	
	public PanelMainButtons(Controller controller) {
		
		setLayout(null);
		setBounds(375, 12, 240, 300);
		//setBounds(325, 12, 290, 300);
		
		setOpaque(false);
		
		btnInfo = new JButton(info_icon);
		btnSkill = new JButton(skill_icon);
		btnBattle = new JButton(battle_icon);
		btnExit = new JButton(exit_icon);
		
		setButtons();
		
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToInfo();
			}
		});
		
		btnSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToSkillInfo();
			}
		});
		
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToSelectMap();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(btnInfo);
		add(btnSkill);
		add(btnBattle);
		add(btnExit);
		
		setVisible(true);
	}
	public void setButtons() {
		btnInfo.setBorderPainted(false);
		btnSkill.setBorderPainted(false);
		btnBattle.setBorderPainted(false);
		btnExit.setBorderPainted(false);
		
		btnInfo.setContentAreaFilled(false);
		btnSkill.setContentAreaFilled(false);
		btnBattle.setContentAreaFilled(false);
		btnExit.setContentAreaFilled(false);
		
		/*btnInfo.setFocusPainted(false);
		btnSkill.setFocusPainted(false);
		btnBattle.setFocusPainted(false);
		btnExit.setFocusPainted(false);*/
		
		btnInfo.setBounds(0, 0, 240, 60);
		btnSkill.setBounds(0, 80, 240, 60);
		btnBattle.setBounds(0, 160, 240, 60);
		btnExit.setBounds(0, 240, 240, 60);
	} 
}
