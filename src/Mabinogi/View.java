package Mabinogi;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Controller controller;
	
	JPanel panelTitle;
	JPanel panelMain;
	JPanel panelInfo;
	JPanel panelSkill;
	Dialog_CreateCharacter dialog_createCharater;
	
	Container contentPane;
	
	public View(Controller controller)
	{
		this.controller = controller;
		// window10 
		// 기본 title bar 크기 : 30px
		// 기본 window border 크기 : 8px
		setTitle("Mabinogi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(1000,768);
		// 640x360 가로+16  // 세로+38
		setSize(640, 360);
		
		contentPane= getContentPane();
		
		dialog_createCharater = new Dialog_CreateCharacter(this, controller);
		
		contentPane.add(new PanelTitle(controller));
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void showForm()
	{
		setVisible(true);
	}
	
	public void goTo(String where) {
		contentPane.removeAll();
		
		JPanel tempPanel = null;
		
		if(where.equals("메인")) {
			tempPanel = new PanelMain(controller); 
			contentPane.add(tempPanel);
		} else if(where.equals("정보")) {
			tempPanel = new PanelInfo(controller);
			contentPane.add(tempPanel);
		} else if(where.equals("스킬")) {
			tempPanel = new PanelSkill(controller);
			contentPane.add(tempPanel);
		} else if(where.equals("맵선택")) {
			tempPanel = new PanelSelectMap(controller);
			contentPane.add(tempPanel);
		} /*else if(where.equals("전투")) {
			tempPanel = new panelBattleMap(controller);
			contentPane.add(tempPanel);
		}*/
		tempPanel.updateUI();
	}
}
