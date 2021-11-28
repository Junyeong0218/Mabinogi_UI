package Mabinogi;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelInfoSkill extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel status_skill;
	
	private JLabel smash_name;
	private JLabel smash_icon;
	private JLabel smash_rank;
	private JLabel smash_ex;
	private JLabel finalHit_name;
	private JLabel finalHit_icon;
	private JLabel finalHit_rank;
	private JLabel finalHit_ex;
	private JLabel defence_name;
	private JLabel defence_icon;
	private JLabel defence_rank;
	private JLabel defence_ex;
	
	private ImageIcon smash_common = new ImageIcon(View.class.getResource("../Image/smash_Normal.png"));
	private ImageIcon smash_9Rank = new ImageIcon(View.class.getResource("../Image/smash_9Rank.png"));
	private ImageIcon smash_5Rank = new ImageIcon(View.class.getResource("../Image/smash_5Rank.png"));
	private ImageIcon smash_1Rank = new ImageIcon(View.class.getResource("../Image/smash_1Rank.png"));
	private ImageIcon finalHit_common = new ImageIcon(View.class.getResource("../Image/finalHit_Normal.png"));
	private ImageIcon finalHit_9Rank = new ImageIcon(View.class.getResource("../Image/finalHit_9Rank.png"));
	private ImageIcon finalHit_5Rank = new ImageIcon(View.class.getResource("../Image/finalHit_5Rank.png"));
	private ImageIcon finalHit_1Rank = new ImageIcon(View.class.getResource("../Image/finalHit_1Rank.png"));
	private ImageIcon defence_common = new ImageIcon(View.class.getResource("../Image/defence_Normal.png"));
	private ImageIcon defence_9Rank = new ImageIcon(View.class.getResource("../Image/defence_9Rank.png"));
	private ImageIcon defence_5Rank = new ImageIcon(View.class.getResource("../Image/defence_5Rank.png"));
	private ImageIcon defence_1Rank = new ImageIcon(View.class.getResource("../Image/defence_1Rank.png"));
	
	private ImageIcon smash_Selected_Icon;
	private ImageIcon finalHit_Selected_Icon;
	private ImageIcon defence_Selected_Icon;
	
	private Controller controller;
	
	Font font;
	
	public PanelInfoSkill(Controller controller, Font font) {
		
		this.controller = controller;
		this.font = font;
		
		status_skill = new JPanel();
		
		setBounds(320, 7, 300, 230);
		setLayout(null);
		setBackground(new Color(255, 0, 0, 0));
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), "½ºÅ³ Á¤º¸", 4, 0, font));
		
		selectIcon();
		
		smash_name = new JLabel("[ " + controller.getSkillName(controller.getSmashIndex()) + " ]");
		smash_icon = new JLabel(smash_Selected_Icon);
		smash_rank = new JLabel(controller.getSkillRank(controller.getSmashIndex()) + " ·©Å©");
		smash_ex = new JLabel(controller.getSkillEx(controller.getSmashIndex()));
		
		finalHit_name = new JLabel("[ " + controller.getSkillName(controller.getFinalHitIndex()) + " ]");
		finalHit_icon = new JLabel(finalHit_Selected_Icon);
		finalHit_rank = new JLabel(controller.getSkillRank(controller.getFinalHitIndex()) + " ·©Å©");
		finalHit_ex = new JLabel(controller.getSkillEx(controller.getFinalHitIndex()));
		
		defence_name = new JLabel("[ " + controller.getSkillName(controller.getDefenceIndex()) + " ]");
		defence_icon = new JLabel(defence_Selected_Icon);
		defence_rank = new JLabel(controller.getSkillRank(controller.getDefenceIndex()) + " ·©Å©");
		defence_ex = new JLabel(controller.getSkillEx(controller.getDefenceIndex()));
				
		setLabels();
		
		add(smash_name);
		add(smash_icon);
		add(smash_rank);
		add(smash_ex);
		
		add(finalHit_name);
		add(finalHit_icon);
		add(finalHit_rank);
		add(finalHit_ex);
		
		add(defence_name);
		add(defence_icon);
		add(defence_rank);
		add(defence_ex);
		
		setVisible(true);
	}
	
	public void selectIcon() {
		int smash_index = controller.getSmashIndex();
		int finalHit_index = controller.getFinalHitIndex();
		int defence_index = controller.getDefenceIndex();
		
		for(int i = 0; i < 16; i++) {
			// ½º¸Å½Ã ·©Å© ´ëÁ¶
			if(controller.getSkillRank(smash_index).equals(controller.getSkillRank(i))) {
				if(i > 14) {
					smash_Selected_Icon = smash_1Rank;
				} else if(i > 10) {
					smash_Selected_Icon = smash_5Rank;
				} else if(i > 6) {
					smash_Selected_Icon = smash_9Rank;
				} else {
					smash_Selected_Icon = smash_common;
				}
			}
			// ÆÄÀÌ³Î È÷Æ® ·©Å© ´ëÁ¶
			if(controller.getSkillRank(finalHit_index).equals(controller.getSkillRank(i+16))) {
				if(i > 14) {
					finalHit_Selected_Icon = finalHit_1Rank;
				} else if(i > 10) {
					finalHit_Selected_Icon = finalHit_5Rank;
				} else if(i > 6) {
					finalHit_Selected_Icon = finalHit_9Rank;
				} else {
					finalHit_Selected_Icon = finalHit_common;
				}
			}
			// µðÆæ½º ½ºÅ³ ·©Å© ´ëÁ¶
			if(controller.getSkillRank(defence_index).equals(controller.getSkillRank(i+32))) {
				if(i > 14) {
					defence_Selected_Icon = defence_1Rank;
				} else if(i > 10) {
					defence_Selected_Icon = defence_5Rank;
				} else if(i > 6) {
					defence_Selected_Icon = defence_9Rank;
				} else {
					defence_Selected_Icon = defence_common;
				}
			}
		}
	}
	
	public void setLabels() {
		// VGAP = 4 / Icon = 42x42 / GAP_ICON_TO_NAME = 10
		smash_name.setBounds(15, 25, 250, 16);
		smash_icon.setBounds(15, 45, 42, 42);
		smash_rank.setBounds(61, 45, 250, 19);
		smash_ex.setBounds(61, 68, 250, 19);
		
		finalHit_name.setBounds(15, 91, 250, 16);
		finalHit_icon.setBounds(15, 111, 42, 42);
		finalHit_rank.setBounds(61, 111, 250, 19);
		finalHit_ex.setBounds(61, 134, 250, 19);
		
		defence_name.setBounds(15, 157, 250, 16);
		defence_icon.setBounds(15, 177, 42, 42);
		defence_rank.setBounds(61, 177, 250, 19);
		defence_ex.setBounds(61, 200, 250, 19);
		
		smash_name.setFont(font);
		smash_rank.setFont(font);
		smash_ex.setFont(font);
		
		finalHit_name.setFont(font);
		finalHit_rank.setFont(font);
		finalHit_ex.setFont(font);
		
		defence_name.setFont(font);
		defence_rank.setFont(font);
		defence_ex.setFont(font);
	}

}
