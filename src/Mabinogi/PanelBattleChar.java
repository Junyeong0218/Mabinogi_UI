package Mabinogi;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelBattleChar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JLabel lbl_level;
	JLabel lbl_level_data;
	JLabel lbl_hp;
	JLabel lbl_hp_data;
	JLabel lbl_stamina;
	JLabel lbl_stamina_data;
	JLabel lbl_exp;
	JLabel lbl_exp_data;
	JLabel lbl_damage;
	JLabel lbl_damage_data;
	JLabel lbl_defence;
	JLabel lbl_defence_data;
	JLabel lbl_critical;
	JLabel lbl_critical_data;
	
	Font font;
	
	public PanelBattleChar(Controller controller, Font font) {
		
		this.font = font;
		
		setBounds(6, 7, 230, 122);
		setLayout(new GridLayout(7, 2));
		setBackground(new Color(255, 255, 255, 150));
		setFont(font);
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), controller.getUserName(), 4, 0, font));
		
		lbl_level = new JLabel(" 레벨 :");				lbl_level_data = new JLabel(Integer.toString(controller.getUserLevel()));
		lbl_hp = new JLabel(" 체력 : "); 				lbl_hp_data = new JLabel(Integer.toString(controller.getUserHp()) + " / " + Integer.toString(controller.getUserFullHp()));
		lbl_stamina = new JLabel(" 스테미너 :");		lbl_stamina_data = new JLabel(Integer.toString(controller.getUserStamina()) + " / " + Integer.toString(controller.getUserFullStamina()));
		lbl_exp = new JLabel(" 경험치 :");				lbl_exp_data = new JLabel(Integer.toString(controller.getUserExp()) + " / " + Integer.toString(controller.getUserNeededExp()) );
		lbl_damage = new JLabel(" 공격력 :");			lbl_damage_data = new JLabel(Integer.toString(controller.getUserMinDamage()) + " ~ " + Integer.toString(controller.getUserMaxDamage()));			
		lbl_defence = new JLabel(" 방어력 :");			lbl_defence_data = new JLabel(Integer.toString(controller.getUserDefence()));
		lbl_critical = new JLabel(" 크리티컬 :");		lbl_critical_data = new JLabel(Integer.toString(controller.getUserCritical()) + " %");
		
		setFont();
		
		add(lbl_level);
		add(lbl_level_data);
		add(lbl_hp);
		add(lbl_hp_data);
		add(lbl_stamina);
		add(lbl_stamina_data);
		add(lbl_exp);
		add(lbl_exp_data);
		add(lbl_damage);
		add(lbl_damage_data);
		add(lbl_defence);
		add(lbl_defence_data);
		add(lbl_critical);
		add(lbl_critical_data);
		
		setVisible(true);
	}
	
	public void setFont() {
		lbl_level.setFont(font);
		lbl_level_data.setFont(font);
		lbl_hp.setFont(font);
		lbl_hp_data.setFont(font);
		lbl_stamina.setFont(font);
		lbl_stamina_data.setFont(font);
		lbl_exp.setFont(font);
		lbl_exp_data.setFont(font);
		lbl_damage.setFont(font);
		lbl_damage_data.setFont(font);
		lbl_defence.setFont(font);
		lbl_defence_data.setFont(font);
		lbl_critical.setFont(font);
		lbl_critical_data.setFont(font);
	}
	
}
