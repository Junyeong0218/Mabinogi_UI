package Mabinogi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelSkillAdvance extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel panelSkillAdvance;
	
	private JLabel smash_name;
	private JLabel smash_icon;
	private JLabel smash_rank;
	private JLabel smash_ex;
	private JLabel smash_neededAp;
	private JLabel finalHit_name;
	private JLabel finalHit_icon;
	private JLabel finalHit_rank;
	private JLabel finalHit_ex;
	private JLabel finalHit_neededAp;
	private JLabel defence_name;
	private JLabel defence_icon;
	private JLabel defence_rank;
	private JLabel defence_ex;
	private JLabel defence_neededAp;
	
	private JButton advance_smash;
	private JButton advance_finalHit;
	private JButton advance_defence;
	
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
	
	private ImageIcon skillAdvance = new ImageIcon(View.class.getResource("../Image/skillAdvance.png"));
	
	private Controller controller;
	
	Font font;
	
	public PanelSkillAdvance(Controller controller, Font font) {
		
		this.controller = controller;
		this.font = font;
		
		panelSkillAdvance = new JPanel();
		
		setBounds(10, 7, 610, 250);
		setLayout(null);
		setBackground(new Color(255, 0, 0, 0));
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), "스킬", 4, 0, font));
		
		selectIcon();
		
		smash_name = new JLabel("[ " + controller.getSkillName(controller.getSmashIndex()) + " ]");
		smash_icon = new JLabel(smash_Selected_Icon);
		smash_rank = new JLabel(controller.getSkillRank(controller.getSmashIndex()) + " 랭크");
		smash_ex = new JLabel(controller.getSkillEx(controller.getSmashIndex()));
		smash_neededAp = new JLabel("필요 어빌리티 포인트 : " + controller.getSkillAp(controller.getSmashIndex()+1));
		advance_smash = new JButton(skillAdvance);
		
		finalHit_name = new JLabel("[ " + controller.getSkillName(controller.getFinalHitIndex()) + " ]");
		finalHit_icon = new JLabel(finalHit_Selected_Icon);
		finalHit_rank = new JLabel(controller.getSkillRank(controller.getFinalHitIndex()) + " 랭크");
		finalHit_ex = new JLabel(controller.getSkillEx(controller.getFinalHitIndex()));
		finalHit_neededAp = new JLabel("필요 어빌리티 포인트 : " + controller.getSkillAp(controller.getFinalHitIndex()+1));
		advance_finalHit = new JButton(skillAdvance);
		
		defence_name = new JLabel("[ " + controller.getSkillName(controller.getDefenceIndex()) + " ]");
		defence_icon = new JLabel(defence_Selected_Icon);
		defence_rank = new JLabel(controller.getSkillRank(controller.getDefenceIndex()) + " 랭크");
		defence_ex = new JLabel(controller.getSkillEx(controller.getDefenceIndex()));
		defence_neededAp = new JLabel("필요 어빌리티 포인트 : " + controller.getSkillAp(controller.getDefenceIndex()+1));
		advance_defence = new JButton(skillAdvance);
		
		setLabels();
		
		add(smash_name);
		add(smash_icon);
		add(smash_rank);
		add(smash_ex);
		add(smash_neededAp);
		add(advance_smash);
		
		add(finalHit_name);
		add(finalHit_icon);
		add(finalHit_rank);
		add(finalHit_ex);
		add(finalHit_neededAp);
		add(advance_finalHit);
		
		add(defence_name);
		add(defence_icon);
		add(defence_rank);
		add(defence_ex);
		add(defence_neededAp);
		add(advance_defence);
		
		setVisible(true);
	}
	
	public void selectIcon() {
		int smash_index = controller.getSmashIndex();
		int finalHit_index = controller.getFinalHitIndex();
		int defence_index = controller.getDefenceIndex();
		
		for(int i = 0; i < 16; i++) {
			// 스매시 랭크 대조
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
			// 파이널 히트 랭크 대조
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
			// 디펜스 스킬 랭크 대조
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
		// VGAP = 4 / Icon = 42x42 / GAP_ICON_TO_NAME = 15
		smash_name.setBounds(15, 20, 250, 16);
		smash_icon.setBounds(15, 40, 42, 42);
		smash_rank.setBounds(61, 40, 250, 19);
		smash_ex.setBounds(61, 63, 250, 19);
		smash_neededAp.setBounds(300, 20, 250, 16);
		advance_smash.setBounds(300, 49, 80, 24);
		advance_smash.setBorderPainted(false);
		advance_smash.setBorderPainted(false);
		advance_smash.setContentAreaFilled(false);
		
		if(controller.judgeApEnough(controller.getSmashIndex())) {
			advance_smash.setEnabled(true);
		} else {
			advance_smash.setEnabled(false);
		}
		advance_smash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				controller.skillRankUp(controller.getSmashIndex());
			}
			
		});
		
		finalHit_name.setBounds(15, 97, 250, 16);
		finalHit_icon.setBounds(15, 117, 42, 42);
		finalHit_rank.setBounds(61, 117, 250, 19);
		finalHit_ex.setBounds(61, 140, 250, 19);
		finalHit_neededAp.setBounds(300, 97, 250, 16);
		advance_finalHit.setBounds(300, 126, 80, 24);
		advance_finalHit.setBorderPainted(false);
		advance_finalHit.setContentAreaFilled(false);
		
		if(controller.judgeApEnough(controller.getFinalHitIndex())) {
			advance_finalHit.setEnabled(true);
		} else {
			advance_finalHit.setEnabled(false);
		}
		advance_finalHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				controller.skillRankUp(controller.getFinalHitIndex());
			}
			
		});
		
		defence_name.setBounds(15, 174, 250, 16);
		defence_icon.setBounds(15, 194, 42, 42);
		defence_rank.setBounds(61, 194, 250, 19);
		defence_ex.setBounds(61, 217, 250, 19);
		defence_neededAp.setBounds(300, 174, 250, 16);
		advance_defence.setBounds(300, 203, 80, 24);
		advance_defence.setBorderPainted(false);
		advance_defence.setContentAreaFilled(false);
		
		if(controller.judgeApEnough(controller.getDefenceIndex())) {
			advance_defence.setEnabled(true);
		} else {
			advance_defence.setEnabled(false);
		}
		advance_defence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				controller.skillRankUp(controller.getDefenceIndex());
			}
			
		});
		
		smash_name.setFont(font);
		smash_rank.setFont(font);
		smash_ex.setFont(font);
		smash_neededAp.setFont(font);
		
		finalHit_name.setFont(font);
		finalHit_rank.setFont(font);
		finalHit_ex.setFont(font);
		finalHit_neededAp.setFont(font);
		
		defence_name.setFont(font);
		defence_rank.setFont(font);
		defence_ex.setFont(font);
		defence_neededAp.setFont(font);
	}
	
}
