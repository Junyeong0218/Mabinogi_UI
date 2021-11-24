package Mabinogi;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PanelInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel panelInfo;
	
	Controller controller;
	
	public PanelInfo(Controller controller) {
		
		this.controller = controller;
		
		panelInfo = new JPanel();		
		//setBounds(10, 7, 605, 300);
		setBounds(0, 0, 640, 360);
		setLayout(null);
		
		Box status = Box.createVerticalBox();
		status.setBounds(10, 7, 300, 300);
		status.setLayout(new GridLayout(11, 2));
		
		JLabel lbl_level = new JLabel(" ���� : " + controller.user.getLevel());
		JLabel lbl_hp = new JLabel(" ü�� : \t\t" + (int)controller.user.getHp() + " / " + (int)controller.user.getFullHp());
		JLabel lbl_stamina = new JLabel(" ���׹̳� :\t\t");
		JLabel lbl_exp = new JLabel(" ����ġ :\t\t");
		JLabel lbl_ap = new JLabel(" �����Ƽ ����Ʈ :\t\t");
		JLabel lbl_money = new JLabel("���� :\t\t");
		
		JLabel lbl_str = new JLabel(" str :\t\t");
		JLabel lbl_will = new JLabel(" will :\t\t");
		JLabel lbl_damage = new JLabel(" ���ݷ� :\t\t");
		JLabel lbl_defence = new JLabel(" ���� :\t\t");
		JLabel lbl_critical = new JLabel(" ũ��Ƽ�� :\t\t");
		
		status.add(lbl_level);
		status.add(lbl_hp);
		
		status.setBorder(new TitledBorder( new EtchedBorder(), controller.user.getName()));
		
		add(status);
	}

}
