package Mabinogi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog_CreateCharacter extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtxt = new JTextField(15);
	JButton okBtn1 = new JButton("»Æ¿Œ");
	Controller controller;
	
	public Dialog_CreateCharacter(JFrame frame, String title, Controller controller)
	{
		super(frame, title);
		setLayout(new FlowLayout());
		add(jtxt);
		add(okBtn1);
		setBounds(583, 334, 200, 100);
		//1366 * 768
		
		okBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String name = jtxt.getText();
				controller.setUserName(name);
				setVisible(false);
			}
			
		});
	}
	
}
