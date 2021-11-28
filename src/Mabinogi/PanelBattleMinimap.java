package Mabinogi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelBattleMinimap extends JPanel {
	
	private static final long serialVersionUID = 1L;

	JButton[][] map = new JButton[3][3];
	
	JLabel current_user;
	
	ImageIcon user = new ImageIcon(View.class.getResource("../Image/Minimap_User.png"));
	ImageIcon start = new ImageIcon(View.class.getResource("../Image/Minimap_Start.png"));
	ImageIcon boss = new ImageIcon(View.class.getResource("../Image/Minimap_boss.png"));
	ImageIcon disable = new ImageIcon(View.class.getResource("../Image/Minimap_disable.png"));
	ImageIcon left = new ImageIcon(View.class.getResource("../Image/Minimap_left.png"));
	ImageIcon right = new ImageIcon(View.class.getResource("../Image/Minimap_right.png"));
	ImageIcon down = new ImageIcon(View.class.getResource("../Image/Minimap_down.png"));
	ImageIcon up = new ImageIcon(View.class.getResource("../Image/Minimap_up.png"));
	
	int selectedPath;
	
	public PanelBattleMinimap(Controller controller, int current_x, int current_y) {
		
		//setBounds(527, 7, 120, 120);
		setBounds(494, 6, 122, 122);
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		// 모든 칸 disable 로 초기화
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				map[i][j] = new JButton(disable);
			}
		}
		
		// 1~3행 행별로 반복 (Y)
		for(int i = 0; i < 3; i++) {
			// 모든 생성된 path 검사
			for(int j = 0; j < controller.getSelectedPath()-1; j++) {
				// 각 칸의 x값이 각 행과 같다면
				if(controller.getSelected_X()[j] == i+1) {
					// dir 에 따라 방향이미지로 버튼 생성
					switch(controller.getSelected_Dir()[j+1]) {
					case 1:
						map[controller.getSelected_Y()[j]-1][i] = new JButton(up);
						map[controller.getSelected_Y()[j]-1][i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.moveTo();
							}
						});
						break;
					case 2:
						map[controller.getSelected_Y()[j]-1][i] = new JButton(down);
						map[controller.getSelected_Y()[j]-1][i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.moveTo();
							}
						});
						break;
					case 3:
						map[controller.getSelected_Y()[j]-1][i] = new JButton(left);
						map[controller.getSelected_Y()[j]-1][i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.moveTo();
							}
						});
						break;
					case 4:
						map[controller.getSelected_Y()[j]-1][i] = new JButton(right);
						map[controller.getSelected_Y()[j]-1][i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								controller.moveTo();
							}
						});
						break;
					}
				}
			}
			// 시작 좌표 생성
			if(controller.getStart_X() == i+1) {
				map[controller.getStart_Y()-1][i] = new JButton(start);
				map[controller.getStart_Y()-1][i].setDisabledIcon(start);
			}
			// 보스 좌표 생성
			if(controller.getBoss_X() == i+1) {
				map[controller.getBoss_Y()-1][i] = new JButton(boss);
				map[controller.getBoss_Y()-1][i].setDisabledIcon(boss);
				if(controller.getCurrent_X() == controller.getBoss_X() && controller.getCurrent_Y() == controller.getBoss_Y()) {
					map[controller.getBoss_Y()-1][i].setEnabled(false);
				}
				map[controller.getBoss_Y()-1][i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.moveTo();
					}
				});
			}
		}
		
		// 현재 유저 위치 출력
		current_user = new JLabel(user);
		current_user.setBounds(8 + 45 * (current_x-1), 8 + 45 * (current_y-1), 16, 16);
		add(current_user);
		
		// 다음 진행 방향 제외 비활성화 + 위치 및 크기 설정 + 패널에 추가 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!controller.isNext(j+1, i+1)) {
					map[i][j].setEnabled(false);
				}
				map[i][j].setBounds(45*j+1, 45*i+1, 30, 30);
				add(map[i][j]);
			}
		}
		
		System.out.println(controller.getCurrent_X());
		System.out.println(controller.getCurrent_Y());
		System.out.println(controller.getCurrentPath());
		System.out.println("------");
		
		setVisible(true);
	}
	
}
