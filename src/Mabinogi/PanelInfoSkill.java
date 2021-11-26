package Mabinogi;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelInfoSkill extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel status_skill;
	
	private ImageIcon smash = new ImageIcon(View.class.getResource("../Image/smash_Normal.png"));
	
	
	public PanelInfoSkill(Controller controller) {
		
		status_skill = new JPanel();
		
		setBounds(320, 7, 300, 240);
		setLayout(null);
		setBackground(new Color(255, 0, 0, 0));
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), "스킬 정보"));
		
		JLabel lbl_SmashName = new JLabel("[ " + controller.getSkillName(controller.getSmashIndex()) + " ]");
		JLabel lbl_SmashIcon = new JLabel(smash);
		JLabel lbl_SmashRank = new JLabel(controller.getSkillRank(controller.getSmashIndex()) + " 랭크");
		JLabel lbl_SmashEx = new JLabel(controller.getSkillEx(controller.getSmashIndex()));
		
		lbl_SmashName.setBounds(15, 20, 250, 16);
		lbl_SmashIcon.setBounds(15, 39, 35, 35);
		lbl_SmashRank.setBounds(55, 39, 250, 16);
		lbl_SmashEx.setBounds(55, 58, 250, 16);
				
		add(lbl_SmashName);
		add(lbl_SmashIcon);
		add(lbl_SmashRank);
		add(lbl_SmashEx);
		
		setVisible(true);
	}

}
