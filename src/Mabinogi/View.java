package Mabinogi;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class View extends JFrame implements ActionListener {

	private Image title_Background = new ImageIcon(View.class.getResource("../image/MainTitle.png")).getImage();
	private Image main_Background = new ImageIcon(View.class.getResource("../Image/Main.png")).getImage();
	private Image currentBg = title_Background;
	private JButton btn1;
	
	Controller controller;
	
	Dialog_CreateCharacter dialog_createCharater;
	
	public View()
	{
		super("Mabinogi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,360);
		setResizable(false);
		setLocationRelativeTo(null);
		
		initialize();
	}
	
	public void initialize()
	{
		JPanel buttonPanel = new JPanel();
		btn1 = new JButton("게임 시작");
		btn1.setBounds(270, 240, 100, 40);
		buttonPanel.setLayout(null);
		
		btn1.addActionListener(this);
		
		buttonPanel.add(btn1);
		
		this.add(buttonPanel);
	}
	
	public void setController(Controller controller)
	{
		this.controller = controller;
		dialog_createCharater = new Dialog_CreateCharacter(this, "닉네임을 입력해주세요.", controller);
	}

	public void paint(Graphics g)
	{
		g.drawImage(currentBg, 0, 0, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialog_createCharater.setVisible(true);
		if(currentBg == title_Background)
		{
			currentBg = main_Background;
		}
		
		repaint();
		
		
		
		btn1.setEnabled(false);
	}
	
	public void showForm()
	{
		setVisible(true);
	}
}
