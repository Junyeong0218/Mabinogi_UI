package Mabinogi;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;

public class PanelInfoStatus extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel status;
	
	Controller controller;
	
	public PanelInfoStatus(Controller controller) {
		
		this.controller = controller;
		
		status = new JPanel();
		
		setBounds(10, 7, 300, 300);
		setLayout(new GridLayout(11, 2));
		setBackground(new Color(255, 0, 0, 0));
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), controller.user.getName()));
		
		JLabel lbl_level = new JLabel(" 레벨 :");				JLabel lbl_level_data = new JLabel(Integer.toString(controller.user.getLevel()));
		JLabel lbl_hp = new JLabel(" 체력 : "); 				JLabel lbl_hp_data = new JLabel(Integer.toString((int)controller.user.getHp()) + " / " + Integer.toString(controller.user.getFullHp()));
		JLabel lbl_stamina = new JLabel(" 스테미너 :");			JLabel lbl_stamina_data = new JLabel(Integer.toString((int)controller.user.getStamina()) + " / " + Integer.toString(controller.user.getFullStamina()));
		JLabel lbl_exp = new JLabel(" 경험치 :");				JLabel lbl_exp_data = new JLabel(Integer.toString(controller.user.getExp()) + " / " + Integer.toString(controller.user.getNeededExp(controller.user.getLevel())) );
		JLabel lbl_ap = new JLabel(" 어빌리티 포인트 :");		JLabel lbl_ap_data = new JLabel(Integer.toString(controller.user.getAbilityPoint()));
		JLabel lbl_money = new JLabel(" 금전 :");				JLabel lbl_money_data = new JLabel(Integer.toString(controller.user.getMoney()));
		
		JLabel lbl_str = new JLabel(" str :");					JLabel lbl_str_data = new JLabel(Integer.toString((int)controller.user.getStr()));
		JLabel lbl_will = new JLabel(" will :");				JLabel lbl_will_data = new JLabel(Integer.toString((int)controller.user.getWill()));
		JLabel lbl_damage = new JLabel(" 공격력 :");			JLabel lbl_damage_data = new JLabel(Integer.toString(controller.user.getMinDamage(controller.user.getStr())) + " ~ " + Integer.toString(controller.user.getMaxDamage(controller.user.getStr())) );			
		JLabel lbl_defence = new JLabel(" 방어력 :");			JLabel lbl_defence_data = new JLabel(Integer.toString(controller.user.getDefence(controller.user.getStr())));
		JLabel lbl_critical = new JLabel(" 크리티컬 :");		JLabel lbl_critical_data = new JLabel(Integer.toString(controller.user.getCritical(controller.user.getWill())) + " %");
		
		add(lbl_level);
		add(lbl_level_data);
		add(lbl_hp);
		add(lbl_hp_data);
		add(lbl_stamina);
		add(lbl_stamina_data);
		add(lbl_exp);
		add(lbl_exp_data);
		add(lbl_ap);
		add(lbl_ap_data);
		add(lbl_money);
		add(lbl_money_data);
		add(lbl_str);
		add(lbl_str_data);
		add(lbl_will);
		add(lbl_will_data);
		add(lbl_damage);
		add(lbl_damage_data);
		add(lbl_defence);
		add(lbl_defence_data);
		add(lbl_critical);
		add(lbl_critical_data);
		
		setVisible(true);
	}

}
