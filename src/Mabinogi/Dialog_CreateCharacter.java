package Mabinogi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog_CreateCharacter extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextField jtxt = new JTextField(15);
	JButton okBtn = new JButton("Ȯ��");
	Controller controller;
	
	public Dialog_CreateCharacter(JFrame frame, Controller controller)
	{
		super(frame, "�г����� �Է����ּ���.");
		setLayout(new FlowLayout());
		add(jtxt);
		add(okBtn);
		setSize(250, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String name = jtxt.getText();
				controller.setUserName(name);
				setVisible(false);
				controller.goToMain();
			}
			
		});
	}
	
}
