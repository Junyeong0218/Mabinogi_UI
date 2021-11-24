package Mabinogi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTitle extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelTitle;
	JButton startButton;
	
	Controller controller;
	Dialog_CreateCharacter dialog;
	
	Image title_Background = new ImageIcon(View.class.getResource("../Image/MainTitle.png")).getImage();
	//Image currentBg = title_Background;
	
	public PanelTitle(Controller controller) {
		this.controller = controller;
		
		panelTitle = new JPanel();
		setLayout(null);
		
		startButton = new JButton("시작하기");
		startButton.setBounds(270, 240, 100, 40);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.createCharacter();
			}
		});
		
		add(startButton);
		
		panelTitle.setBounds(0, 0, 640, 360);
		panelTitle.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(title_Background, 0, -20, this);
	}
	
	
	
}
