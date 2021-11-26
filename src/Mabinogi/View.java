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
		// �⺻ title bar ũ�� : 30px
		// �⺻ window border ũ�� : 8px
		setTitle("Mabinogi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(1000,768);
		// 640x360 ����+16  // ����+38
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
		
		if(where.equals("����")) {
			tempPanel = new PanelMain(controller); 
			contentPane.add(tempPanel);
		} else if(where.equals("����")) {
			tempPanel = new PanelInfo(controller);
			contentPane.add(tempPanel);
		} else if(where.equals("��ų")) {
			tempPanel = new PanelSkill(controller);
			contentPane.add(tempPanel);
		} else if(where.equals("�ʼ���")) {
			tempPanel = new PanelSelectMap(controller);
			contentPane.add(tempPanel);
		} /*else if(where.equals("����")) {
			tempPanel = new panelBattleMap(controller);
			contentPane.add(tempPanel);
		}*/
		tempPanel.updateUI();
	}
}
