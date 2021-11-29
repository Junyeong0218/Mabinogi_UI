package Mabinogi;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelBattleLog extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel log1 = new JLabel("");
	JLabel log2 = new JLabel("");
	JLabel log3 = new JLabel("");
	JLabel log4 = new JLabel("");
	JLabel log5 = new JLabel("");
	JLabel log6 = new JLabel("");
	JLabel log7 = new JLabel("");
	JLabel log8 = new JLabel("");
	JLabel log9 = new JLabel("");
	JLabel log10 = new JLabel("");
	
	Font font;
	
	public PanelBattleLog(Controller controller, Font font, String battleLog) {
		
		this.font = font;
		
		setBounds(6, 136, 473, 180);
		setLayout(new GridLayout(10, 1));
		setBackground(new Color(255, 255, 255, 150));
		setFont(font);
		setBorder(new TitledBorder( new LineBorder(new Color(0, 0, 0)), "전투로그", 4, 0, font));
		
		setFont();
		
		setLabelText(battleLog);
		
		add(log1);
		add(log2);
		add(log3);
		add(log4);
		add(log5);
		add(log6);
		add(log7);
		add(log8);
		add(log9);
		add(log10);
		
		setVisible(true);
	}
	
	public void setLabelText(String battleLog) {
		log1.setText(log2.getText());
		log2.setText(log3.getText());
		log3.setText(log4.getText());
		log4.setText(log5.getText());
		log5.setText(log6.getText());
		log6.setText(log7.getText());
		log7.setText(log8.getText());
		log8.setText(log9.getText());
		log9.setText(log10.getText());
		log10.setText(battleLog);
	}
	
	public void setFont() {
		log1.setFont(font);
		log2.setFont(font);
		log3.setFont(font);
		log4.setFont(font);
		log5.setFont(font);
		log6.setFont(font);
		log7.setFont(font);
		log8.setFont(font);
		log9.setFont(font);
		log10.setFont(font);
	}

}
