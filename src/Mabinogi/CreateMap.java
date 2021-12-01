package Mabinogi;

import java.util.Random;

public class CreateMap {

	Random rand = new Random();
	
	private final int MINPATH = 4;
	private final int MAXPATH = 8;
	private final int PATH_MIN_X = 1;
	private final int PATH_MIN_Y = 1;
	private final int PATH_MAX_X = 3;
	private final int PATH_MAX_Y = 3;
	private final int DIR_INDEX = 4;
	
	private int start_x, start_y, boss_x, boss_y;
	private int selectedPath = 0;
	
	private int[] selected_x;
	private int[] selected_y;
	private int[] selected_dir;
	
	public CreateMap() {
		// ���۹� ��ǥ ���� ( 1~3, 1~3 )
		start_x = rand.nextInt(PATH_MAX_X)+1;
		start_y = rand.nextInt(PATH_MAX_Y)+1;
		
		while(selectedPath < 4) {
			// 4 ~ 8
			selectedPath = rand.nextInt(MAXPATH-MINPATH+1)+MINPATH;
			
			
			selected_x = new int[selectedPath];
			selected_y = new int[selectedPath];
			selected_dir = new int[selectedPath+1];
			
			// ���� ��ġ ����
			int current_x = start_x;
			int current_y = start_y;
			int j = 0;
			int i = 0;
			for(i = 0; i < selectedPath; i++) {
				boolean isFind;
				int rnd_dir;
				
				do {
					// do_while ���ǽ� �ʱ�ȭ
					isFind = true;
					// �������� 1~4 �����¿�
					rnd_dir = rand.nextInt(DIR_INDEX)+1;
					
					if(rnd_dir == 1) {
						if((current_y - 1 > PATH_MIN_Y - 1) && searchPastPath(rnd_dir, current_x, current_y)) {
							// ���� y��ǥ + 1 < �� �ִ�ũ�� + 1 -> �̵�����
							// �̹� ������ ��ǥ���� �˻� -> true -> �̵�����
							current_y--;
							selected_x[i] = current_x;
							selected_y[i] = current_y;
							selected_dir[i] = rnd_dir;
							isFind = false;
						}
					}
					else if(rnd_dir == 2) {
						if((current_y + 1 < PATH_MAX_Y + 1) && searchPastPath(rnd_dir, current_x, current_y)) {
							// ���� y��ǥ - 1 > �� �ּ�ũ�� - 1 -> �̵�����
							current_y++;
							selected_x[i] = current_x;
							selected_y[i] = current_y;
							selected_dir[i] = rnd_dir;
							isFind = false;
						}
					}
					else if(rnd_dir == 3) {
						if((current_x - 1 > PATH_MIN_X - 1) && searchPastPath(rnd_dir,current_x,current_y)) {
							// ���� x��ǥ - 1 > �� �ּ�ũ�� - 1 -> �̵�����
							current_x--;
							selected_x[i] = current_x;
							selected_y[i] = current_y;
							selected_dir[i] = rnd_dir;
							isFind = false;
						}
					}
					else if(rnd_dir == 4) {
						if((current_x + 1 < PATH_MAX_X + 1) && searchPastPath(rnd_dir,current_x,current_y)) {
							// ���� x��ǥ + 1 < �� �ּ�ũ�� + 1 -> �̵�����
							current_x++;
							selected_x[i] = current_x;
							selected_y[i] = current_y;
							selected_dir[i] = rnd_dir;
							isFind = false;
						}
					} 
					j++;
				}
				while(isFind && j < 99);
			}
			
			for(i = 0; i < selectedPath; i++) {
				if(selected_x[i] == 0) {
					boss_x = selected_x[i-1];
					boss_y = selected_y[i-1];
					selectedPath = i;
					break;
				} else {
					boss_x = selected_x[i];
					boss_y = selected_y[i];
				}
			}
		}
		
		System.out.println("start_x : " + start_x);
		System.out.println("start_y : " + start_y);
		System.out.println("boss_x : " + boss_x);
		System.out.println("boss_y : " + boss_y);
		for(int i = 0; i < selectedPath; i++) {
			System.out.println("---------------------------------");
			System.out.println("i : " + i);
			System.out.println("selected_x : " + selected_x[i] + " / selected_y : " + selected_y[i] + " / selected_dir : " + selected_dir[i]);
		}
	}
	
	public static void main(String[] args) {
		new CreateMap();
	}
	
	public int getStart_X() {
		return start_x;
	}
	
	public int getStart_Y() {
		return start_y;
	}
	
	public int getBoss_X() {
		return boss_x;
	}
	
	public int getBoss_Y() {
		return boss_y;
	}
	
	public int getSelectedPath() {
		return selectedPath;
	}
	
	public int[] getSelected_X() {
		return selected_x;
	}
	
	public int[] getSelected_Y() {
		return selected_y;
	}
	
	public int[] getSelected_Dir() {
		return selected_dir;
	}
	
	public boolean searchPastPath(int rnd_dir, int current_x, int current_y) {
		// ���⿡ ���� �̵����� ��ǥ�� �ӽ÷� �ű��
		switch(rnd_dir) {
		case 1:
			current_y--;
			break;
		case 2:
			current_y++;
			break;
		case 3:
			current_x--;
			break;
		case 4:
			current_x++;
			break;
		}
		
		// ���� ��ǥ �˻�
		if(current_x == start_x && current_y == start_y) {
			return false;
		}
		else {
			// ���� ��ǥ �˻�
			for(int i = 0; i < selectedPath; i++) {
				if(current_x == selected_x[i] && current_y == selected_y[i]) {
					return false;
				}
			}
			return true;
		}	
	}
}
