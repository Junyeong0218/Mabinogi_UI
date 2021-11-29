package Mabinogi;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBattle extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelBattleChar;
	JPanel panelBattleMob;
	JPanel panelBattleMinimap;
	JPanel panelBattleLog;
	JPanel panelBattleControl;
	
	JLabel bg_selectedMap;
	
	ImageIcon bg_Alby = new ImageIcon(View.class.getResource("../Image/Background_Alby.png"));
	ImageIcon bg_Ciar = new ImageIcon(View.class.getResource("../Image/Background_Ciar.png"));
	ImageIcon bg_Rabbie = new ImageIcon(View.class.getResource("../Image/Background_Rabbie.png"));
	ImageIcon bg_Math = new ImageIcon(View.class.getResource("../Image/Background_Math.png"));
	ImageIcon bg_Barri = new ImageIcon(View.class.getResource("../Image/Background_Barri.png"));
	ImageIcon bg_Phiodh = new ImageIcon(View.class.getResource("../Image/Background_Phiodh.png"));
	ImageIcon selectedMap_icon;
	
	public PanelBattle(Controller controller, int selectedMapIndex, Font font, JPanel panelBattleLog, JPanel panelBattleControl) {
		
	setBounds(0, 0, 640, 360);
	setLayout(null);
	
	setBackground(selectedMapIndex);
	
	bg_selectedMap = new JLabel(selectedMap_icon);
	bg_selectedMap.setBounds(0, -20, 640, 360);
	
	panelBattleMinimap = new PanelBattleMinimap(controller, controller.getCurrent_X(), controller.getCurrent_Y());
	panelBattleChar = new PanelBattleChar(controller, font);
	panelBattleMob = new PanelBattleMob(controller, font);
	this.panelBattleLog = panelBattleLog;
	this.panelBattleControl = panelBattleControl;
	
	add(panelBattleChar);
	add(panelBattleMob);
	add(panelBattleMinimap);
	add(this.panelBattleLog);
	add(this.panelBattleControl);
	add(bg_selectedMap);
	
	setVisible(true);
	
	}
	
	public void setBackground(int selectedMapIndex) {
		switch(selectedMapIndex) {
		case 0:
			selectedMap_icon = bg_Alby;
			break;
		case 1:
			selectedMap_icon = bg_Ciar;
			break;
		case 2:
			selectedMap_icon = bg_Rabbie;
			break;
		case 3:
			selectedMap_icon = bg_Math;
			break;
		case 4:
			selectedMap_icon = bg_Barri;
			break;
		case 5:
			selectedMap_icon = bg_Phiodh;
			break;
		}
	}

}
