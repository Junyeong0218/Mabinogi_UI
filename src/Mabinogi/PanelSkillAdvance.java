package Mabinogi;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelSkillAdvance extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panelSkillAdvance;
	
	private JLabel smash_name;
	private JLabel smash_icon;
	private JLabel smash_rank;
	private JLabel smash_ex;
	
	private ImageIcon smash = new ImageIcon(View.class.getResource("../Image/Skill_Smash.png"));
	
	public Controller controller;
	
	public PanelSkillAdvance(Controller controller) {
		
		panelSkillAdvance = new JPanel();
		
		setBounds(10, 7, 610, 240);
		setLayout(null);
		setBackground(new Color(255, 0, 0, 0));
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), "½ºÅ³"));
		
		smash_name = new JLabel("[ " + controller.user.skill[controller.user.skillIndex].getName() + " ]");
		smash_icon = new JLabel(smash);
		smash_rank = new JLabel(controller.user.skill[controller.user.skillIndex].getRank() + " ·©Å©");
		smash_ex = new JLabel(controller.user.skill[controller.user.skillIndex].getExplanation());
		
		smash_name.setBounds(15, 20, 250, 16);
		smash_icon.setBounds(15, 39, 35, 35);
		smash_rank.setBounds(55, 39, 250, 16);
		smash_ex.setBounds(55, 58, 250, 16);
		
		add(smash_name);
		add(smash_icon);
		add(smash_rank);
		add(smash_ex);
		
		setVisible(true);
	}
	
	
	
}
