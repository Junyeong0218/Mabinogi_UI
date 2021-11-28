package Mabinogi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dialog_WrongName extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JLabel msg = new JLabel("잘못된 입력입니다.");
	private JButton okBtn = new JButton("확인");

	public Dialog_WrongName(JFrame frame, Controller controller, Font font) {
		super(frame, " ");
		setLayout(new BorderLayout());
		msg.setHorizontalAlignment(JLabel.CENTER);
		msg.setFont(font);
		okBtn.setFont(font);
		add(msg, BorderLayout.CENTER);
		add(okBtn,BorderLayout.SOUTH);
		setSize(250,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				controller.createCharacter();
			}
		});
		
	}
	
	

}
