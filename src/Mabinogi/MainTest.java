package Mabinogi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainTest {

	public static void main(String[] args) throws Throwable {
		
		Character user = new Character();
		Map[] map = new Map[6];
		Mob[] mob = new Mob[29];
		
		// ./MapData.txt 에서 맵 정보 불러오기
		loadMap(map);
		
		// ./MobData.txt 에서 몬스터 정보 불러오기
		loadMob(mob);
		
		Controller controller = new Controller(user, map, mob);
		
		View view = new View(controller);
		
		controller.setView(view, view.panelMain);
		
		view.showForm();
	}
	
	public static void loadMap(Map[] map) throws IOException
	{
		String path = "./MapData.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String temp = br.readLine();
		
		do
		{
			StringTokenizer stk = new StringTokenizer(temp);
			
			int i_temp = Integer.parseInt(stk.nextToken());
			String s_temp = stk.nextToken();
			
			map[i_temp] = new Map(s_temp);
			
			temp = br.readLine();
		}
		while(temp != null);
	}
	
	public static void loadMob(Mob[] mob) throws Throwable
	{
		String path = "./MobData.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String temp = br.readLine();
		temp = br.readLine();
		
		do
		{
			StringTokenizer stk = new StringTokenizer(temp,"\t");
			
			int i_temp_index = Integer.parseInt(stk.nextToken());
			String s_temp_1 = stk.nextToken();
			String s_temp_2 = stk.nextToken();
			int i_temp_1 = Integer.parseInt(stk.nextToken());
			int i_temp_2 = Integer.parseInt(stk.nextToken());
			int i_temp_3 = Integer.parseInt(stk.nextToken());
			int i_temp_4 = Integer.parseInt(stk.nextToken());
			int i_temp_5 = Integer.parseInt(stk.nextToken());
			int i_temp_6 = Integer.parseInt(stk.nextToken());
			int i_temp_7 = Integer.parseInt(stk.nextToken());
			int i_temp_8 = Integer.parseInt(stk.nextToken());
			int i_temp_9 = Integer.parseInt(stk.nextToken());
			
			mob[i_temp_index] = new Mob(s_temp_1, s_temp_2, i_temp_1, i_temp_2, i_temp_3, i_temp_4, i_temp_5, i_temp_6, i_temp_7, i_temp_8, i_temp_9);
			
			temp = br.readLine();
		}
		while(temp != null);
	}

}
