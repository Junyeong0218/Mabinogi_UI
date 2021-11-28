package Mabinogi;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSelectMapInfo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel panelSelectMapInfo;
	
	JLabel lbl_recommendLevel;
	JLabel recommendLevel;
	JLabel lbl_apearMob;
	JLabel apearMob_1;
	JLabel apearMob_2;
	JLabel apearMob_3;
	JLabel apearMob_4;
	JLabel apearMob_5;
	
	Controller controller;
	
	Font font;
	
	public PanelSelectMapInfo(Controller controller, int selectedMapIndex, Font font) {
		
		this.controller = controller;
		this.font = font;
		
		setBounds(415, 7, 200, 200);
		setLayout(null);
		setBackground(new Color(255, 255, 255, 150));
		
		selectData(selectedMapIndex);
		
		add(lbl_recommendLevel);
		add(recommendLevel);
		add(lbl_apearMob);
		add(apearMob_1);
		add(apearMob_2);
		add(apearMob_3);
		add(apearMob_4);
		add(apearMob_5);
		
		
		setVisible(true);
	}
	
	public void selectData(int selectedMapIndex) {
		lbl_recommendLevel = new JLabel("권장레벨 : ");
		recommendLevel = new JLabel(controller.getMinRecommendLevel(selectedMapIndex) + " ~ " + controller.getMaxRecommendLevel(selectedMapIndex));
		lbl_apearMob = new JLabel("[ 등장 몬스터 ]");
		apearMob_1 = new JLabel("* " + controller.getApearMob(selectedMapIndex, 0));
		apearMob_2 = new JLabel("* " + controller.getApearMob(selectedMapIndex, 1));
		apearMob_3 = new JLabel("* " + controller.getApearMob(selectedMapIndex, 2));
		apearMob_4 = new JLabel("* " + controller.getApearMob(selectedMapIndex, 3));
		apearMob_5 = new JLabel("* " + controller.getApearMob(selectedMapIndex, 4));
		
		lbl_recommendLevel.setBounds(10, 10, 250, 16);
		recommendLevel.setBounds(70, 10, 250, 16);
		lbl_apearMob.setBounds(10, 30, 250, 16);
		apearMob_1.setBounds(10, 50, 250, 16);
		apearMob_2.setBounds(10, 70, 250, 16);
		apearMob_3.setBounds(10, 90, 250, 16);
		apearMob_4.setBounds(10, 110, 250, 16);
		apearMob_5.setBounds(10, 130, 250, 16);
		
		lbl_recommendLevel.setFont(font);
		recommendLevel.setFont(font);
		lbl_apearMob.setFont(font);
		apearMob_1.setFont(font);
		apearMob_2.setFont(font);
		apearMob_3.setFont(font);
		apearMob_4.setFont(font);
		apearMob_5.setFont(font);
	}
	
	

}
