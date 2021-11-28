package Mabinogi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog_CreateCharacter extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtxt = new JTextField(15);
	private JButton okBtn = new JButton("확인");
	
	public Dialog_CreateCharacter(JFrame frame, Controller controller, Font font)
	{
		super(frame, "닉네임을 입력해주세요.");
		setLayout(new BorderLayout());
		jtxt.setHorizontalAlignment(JLabel.CENTER);
		okBtn.setFont(font);
		add(jtxt, BorderLayout.CENTER);
		add(okBtn, BorderLayout.SOUTH);
		setSize(250, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(jtxt.getText() == null || jtxt.getText().equals("")) {
					controller.inputWrongName();
				} else {
					String name = jtxt.getText();
					controller.setUserName(name);
					setVisible(false);
					controller.goToMain();
				}
				
			}
			
		});
	}
	
}
