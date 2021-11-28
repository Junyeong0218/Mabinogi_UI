package Mabinogi;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Controller controller;
	
	JPanel panelTitle;
	
	JPanel tempPanel;
	
	Dialog_CreateCharacter dialog_createCharater;
	Dialog_WrongName dialog_wrongName;
	//������ TTF
	Font font = new Font("KBIZ�Ѹ������ B", Font.PLAIN, 12);
	
	int selectedMapIndex;
	
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
		
		dialog_createCharater = new Dialog_CreateCharacter(this, controller, font);
		dialog_wrongName = new Dialog_WrongName(this, controller, font);
		
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
		
		tempPanel = null;
		
		if(where.equals("����")) {
			tempPanel = new PanelMain(controller);
			contentPane.add(tempPanel);
		}
		else if(where.equals("����")) {
			tempPanel = new PanelInfo(controller, font);
			contentPane.add(tempPanel);
		}
		else if(where.equals("��ų")) {
			tempPanel = new PanelSkill(controller, font);
			contentPane.add(tempPanel);
		}
		else if(where.equals("�ʼ���")) {
			tempPanel = new PanelSelectMap(controller, 0, font);
			contentPane.add(tempPanel);
		} else if(where.equals("����")) {
			tempPanel = new PanelBattle(controller, selectedMapIndex, font, "");
			contentPane.add(tempPanel);
		}
		tempPanel.updateUI();
	}
	
	public void SelectMap(int selectedMapIndex) {
		contentPane.removeAll();
		tempPanel = new PanelSelectMap(controller, selectedMapIndex, font);
		this.selectedMapIndex = selectedMapIndex; 
		contentPane.add(tempPanel);
		tempPanel.updateUI();
	}
	
	public void moveToCoordinate() {
		contentPane.removeAll();
		tempPanel = new PanelBattle(controller, selectedMapIndex, font, "");
		
		contentPane.add(tempPanel);
		tempPanel.updateUI();
	}
}
