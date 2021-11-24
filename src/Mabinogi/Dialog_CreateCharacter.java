package Mabinogi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog_CreateCharacter extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextField jtxt = new JTextField(15);
	JButton okBtn1 = new JButton("확인");
	Controller controller;
	
	public Dialog_CreateCharacter(JFrame frame, Controller controller)
	{
		super(frame, "닉네임을 입력해주세요.");
		setLayout(new FlowLayout());
		add(jtxt);
		add(okBtn1);
		setSize(250, 100);
		setLocationRelativeTo(null);
		
		okBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				controller.setUserName(jtxt.getText());
				setVisible(false);
			}
			
		});
	}
	
}
