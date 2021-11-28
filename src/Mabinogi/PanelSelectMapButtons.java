package Mabinogi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSelectMapButtons extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JPanel panelSelectMapButtons;
	
	private JButton dungeon_alby;
	private JButton dungeon_ciar;
	private JButton dungeon_rabbie;
	private JButton dungeon_math;
	private JButton dungeon_barri;
	private JButton dungeon_phiodh;
	
	ImageIcon alby_icon = new ImageIcon(View.class.getResource("../Image/button_Dungeon_Alby.png"));
	ImageIcon ciar_icon = new ImageIcon(View.class.getResource("../Image/button_Dungeon_Ciar.png"));
	ImageIcon rabbie_icon = new ImageIcon(View.class.getResource("../Image/button_Dungeon_Rabbie.png"));
	ImageIcon math_icon = new ImageIcon(View.class.getResource("../Image/button_Dungeon_Math.png"));
	ImageIcon barri_icon = new ImageIcon(View.class.getResource("../Image/button_Dungeon_Barri.png"));
	ImageIcon phiodh_icon = new ImageIcon(View.class.getResource("../Image/button_Dungeon_Phiodh.png"));
	
	public PanelSelectMapButtons(Controller controller, int selectedMapIndex) {
		
		panelSelectMapButtons = new JPanel();
		setBounds(10, 7, 200, 300);
		setLayout(null);
		setOpaque(false);
		
		dungeon_alby = new JButton(alby_icon);
		dungeon_ciar = new JButton(ciar_icon);
		dungeon_rabbie = new JButton(rabbie_icon);
		dungeon_math = new JButton(math_icon);
		dungeon_barri = new JButton(barri_icon);
		dungeon_phiodh = new JButton(phiodh_icon);
		
		setButtons(selectedMapIndex);
		
		dungeon_alby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectMap(0);
			}
		});
		
		dungeon_ciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectMap(1);
			}
		});
		
		dungeon_rabbie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectMap(2);
			}
		});
		
		dungeon_math.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectMap(3);
			}
		});
		
		dungeon_barri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectMap(4);
			}
		});
		
		dungeon_phiodh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.selectMap(5);
			}
		});
		
		add(dungeon_alby);
		add(dungeon_ciar);
		add(dungeon_rabbie);
		add(dungeon_math);
		add(dungeon_barri);
		add(dungeon_phiodh);
		
		setVisible(true);
	}
	
	public void setButtons(int selectedMapIndex) {
		dungeon_alby.setBorderPainted(false);
		dungeon_alby.setContentAreaFilled(false);
		dungeon_alby.setBounds(0, 0, 200, 45);
		
		dungeon_ciar.setBorderPainted(false);
		dungeon_ciar.setContentAreaFilled(false);
		dungeon_ciar.setBounds(0, 51, 200, 45);
		
		dungeon_rabbie.setBorderPainted(false);
		dungeon_rabbie.setContentAreaFilled(false);
		dungeon_rabbie.setBounds(0, 102, 200, 45);
		
		dungeon_math.setBorderPainted(false);
		dungeon_math.setContentAreaFilled(false);
		dungeon_math.setBounds(0, 153, 200, 45);
		
		dungeon_barri.setBorderPainted(false);
		dungeon_barri.setContentAreaFilled(false);
		dungeon_barri.setBounds(0, 204, 200, 45);
		
		dungeon_phiodh.setBorderPainted(false);
		dungeon_phiodh.setContentAreaFilled(false);
		dungeon_phiodh.setBounds(0, 255, 200, 45);
		
		dungeon_alby.setEnabled(true);
		dungeon_ciar.setEnabled(true);
		dungeon_rabbie.setEnabled(true);
		dungeon_math.setEnabled(true);
		dungeon_barri.setEnabled(true);
		dungeon_phiodh.setEnabled(true);
		
		switch(selectedMapIndex){
		case 0:
			dungeon_alby.setEnabled(false);
			break;
		case 1:
			dungeon_ciar.setEnabled(false);
			break;
		case 2:
			dungeon_rabbie.setEnabled(false);
			break;
		case 3:
			dungeon_math.setEnabled(false);
			break;
		case 4:
			dungeon_barri.setEnabled(false);
			break;
		case 5:
			dungeon_phiodh.setEnabled(false);
			break;
		}
	}
	
	

}
