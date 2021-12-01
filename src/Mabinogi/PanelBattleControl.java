package Mabinogi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBattleControl extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton attack;
	JButton dungeonEscape;
	JButton defaultAttack;
	JButton smash;
	JButton finalHit;
	JButton defence;
	JButton backToMainControl;
	
	private int controlIndex;
	
	ImageIcon attack_icon = new ImageIcon(View.class.getResource("../Image/button_Battle_Attack.png"));
	ImageIcon dungeonEscape_icon = new ImageIcon(View.class.getResource("../Image/button_Battle_Escape.png"));
	ImageIcon defaultAttack_icon = new ImageIcon(View.class.getResource("../Image/button_Battle_default.png"));
	ImageIcon smash_icon = new ImageIcon(View.class.getResource("../Image/button_Battle_Smash.png"));
	ImageIcon finalHit_icon = new ImageIcon(View.class.getResource("../Image/button_Battle_finalHit.png"));
	ImageIcon defence_icon = new ImageIcon(View.class.getResource("../Image/button_Battle_Defence.png"));
	ImageIcon backToMainControl_icon = new ImageIcon(View.class.getResource("../Image/button_backTo2.png"));
	
	Controller controller;
	
	public PanelBattleControl(Controller controller, int controlIndex) {
		
		this.controller = controller;
		this.controlIndex = controlIndex;
		
		setBounds(494, 136, 122, 180);
		//setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setBackground(new Color(255, 255, 255, 150));
		setLayout(null);
		
		setButtons();
		
		if(this.controlIndex == 0) {
			add(attack);
			add(dungeonEscape);
		} else {
			add(defaultAttack);
			add(smash);
			add(finalHit);
			add(defence);
			add(backToMainControl);
		}
		
		
		setVisible(true);
	}
	
	public void setButtons() {
		// ¹öÆ° 120*30 // VGAP = 7
		attack = new JButton(attack_icon);
		attack.setBorderPainted(false);
		attack.setContentAreaFilled(false);
		attack.setFocusPainted(false);
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toggleBattleControl(controlIndex);
			}
		});
		
		dungeonEscape = new JButton(dungeonEscape_icon);
		dungeonEscape.setBorderPainted(false);
		dungeonEscape.setContentAreaFilled(false);
		dungeonEscape.setFocusPainted(false);
		dungeonEscape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToSelectMap();
			}
		});
		
		defaultAttack = new JButton(defaultAttack_icon);
		defaultAttack.setBorderPainted(false);
		defaultAttack.setContentAreaFilled(false);
		defaultAttack.setFocusPainted(false);
		defaultAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.attackToMob(0);
			}
		});
		
		smash = new JButton(smash_icon);
		smash.setBorderPainted(false);
		smash.setContentAreaFilled(false);
		smash.setFocusPainted(false);
		smash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.attackToMob(1);
			}
		});
		
		finalHit = new JButton(finalHit_icon);
		finalHit.setBorderPainted(false);
		finalHit.setContentAreaFilled(false);
		finalHit.setFocusPainted(false);
		finalHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.attackToMob(2);
			}
		});
		
		defence = new JButton(defence_icon);
		defence.setBorderPainted(false);
		defence.setContentAreaFilled(false);
		defence.setFocusPainted(false);
		defence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.attackToMob(3);
			}
		});
		
		backToMainControl = new JButton(backToMainControl_icon);
		backToMainControl.setBorderPainted(false);
		backToMainControl.setContentAreaFilled(false);
		backToMainControl.setFocusPainted(false);
		backToMainControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toggleBattleControl(controlIndex);
			}
		});
		
		attack.setBounds(1, 29, 120, 30);
		dungeonEscape.setBounds(1, 119, 120, 30);
		
		defaultAttack.setBounds(1, 1, 120, 30);
		smash.setBounds(1, 38, 120, 30);
		finalHit.setBounds(1, 75, 120, 30);
		defence.setBounds(1, 112, 120, 30);
		backToMainControl.setBounds(1, 149, 120, 30);
	}

}
