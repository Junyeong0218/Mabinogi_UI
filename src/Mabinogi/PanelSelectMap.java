package Mabinogi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSelectMap extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelSelectMap;
	JPanel panelSelectMapButtons;
	JPanel panelSelectMapInfo;
	
	JLabel bg_selectedMap;
	
	JButton backToMain;
	JButton goToSelectedDungeon;
	
	ImageIcon backTo_icon = new ImageIcon(View.class.getResource("../Image/button_backTo_small.png"));
	ImageIcon goTo_selectedDungeon_icon = new ImageIcon(View.class.getResource("../Image/button_goTo_SelectedDungeon.png"));
	ImageIcon bg_Alby = new ImageIcon(View.class.getResource("../Image/Background_Alby.png"));
	ImageIcon bg_Ciar = new ImageIcon(View.class.getResource("../Image/Background_Ciar.png"));
	ImageIcon bg_Rabbie = new ImageIcon(View.class.getResource("../Image/Background_Rabbie.png"));
	ImageIcon bg_Math = new ImageIcon(View.class.getResource("../Image/Background_Math.png"));
	ImageIcon bg_Barri = new ImageIcon(View.class.getResource("../Image/Background_Barri.png"));
	ImageIcon bg_Phiodh = new ImageIcon(View.class.getResource("../Image/Background_Phiodh.png"));
	ImageIcon selectedMap_icon;
	
	public PanelSelectMap(Controller controller, int selectedMapIndex, Font font) {
		
		panelSelectMap = new JPanel();
		setBounds(0, 0, 640, 360);
		setLayout(null);
		setOpaque(false);
		
		setBackground(selectedMapIndex);
		
		bg_selectedMap = new JLabel(selectedMap_icon);
		bg_selectedMap.setBounds(0, -20, 640, 360);
		
		panelSelectMapButtons = new PanelSelectMapButtons(controller, selectedMapIndex);
		panelSelectMapInfo = new PanelSelectMapInfo(controller, selectedMapIndex, font);
		
		backToMain = new JButton(backTo_icon);
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToMain();
			}
		});
		
		goToSelectedDungeon = new JButton(goTo_selectedDungeon_icon);
		goToSelectedDungeon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToBattle(selectedMapIndex);
			}
		});
		
		setButtons();
		
		add(panelSelectMapButtons);
		add(panelSelectMapInfo);
		add(backToMain);
		add(goToSelectedDungeon);
		add(bg_selectedMap);
		
		setVisible(true);
		
	}
	
	public void setButtons() {
		// 615, 312
		goToSelectedDungeon.setBounds(415, 216, 200, 45);
		goToSelectedDungeon.setBorderPainted(false);
		goToSelectedDungeon.setContentAreaFilled(false);
		
		backToMain.setBounds(415, 267, 200, 45);
		backToMain.setBorderPainted(false);
		backToMain.setContentAreaFilled(false);
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
