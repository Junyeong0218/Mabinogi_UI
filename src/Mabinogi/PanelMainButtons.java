package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMainButtons extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel mainButtons;
	
	JButton btnInfo;
	JButton btnSkill;
	JButton btnBattle;
	JButton btnExit;
	
	Controller controller;
	
	public PanelMainButtons(Controller controller) {
		
		this.controller = controller;
		
		mainButtons = new JPanel();
		setLayout(null);
		setBounds(375, 12, 240, 300);
		//setBounds(325, 12, 290, 300);
		
		setBackground(new Color(255, 0, 0, 0));
		
		btnInfo = new JButton("캐릭터 정보");
		btnSkill = new JButton("스킬");
		btnBattle = new JButton("전투");
		btnExit = new JButton("게임 종료");
		
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
		btnInfo.setBounds(0, 0, 240, 60);
		btnSkill.setBounds(0, 80, 240, 60);
		btnBattle.setBounds(0, 160, 240, 60);
		btnExit.setBounds(0, 240, 240, 60);
	} 
}
