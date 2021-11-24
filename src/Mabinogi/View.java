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
		
		
		/*buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		btn1 = new JButton("게임 시작");
		btn1.setBounds(270, 240, 100, 40);
		btn1.addActionListener(this);
		buttonPanel.add(btn1);
		add(buttonPanel);*/
		
		contentPane= getContentPane();
		panelTitle = new PanelTitle(controller);
		panelMain = new PanelMain(controller);
		panelInfo = new PanelInfo(controller);
		dialog_createCharater = new Dialog_CreateCharacter(this, controller);
		
		//contentPane.add(panelTitle);
		contentPane.add(panelInfo);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void showForm()
	{
		setVisible(true);
	}
	
	public void goTo(JPanel where) {
		contentPane.removeAll();
		contentPane.add(where);
		where.updateUI();
	}
}
