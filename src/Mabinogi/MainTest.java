package Mabinogi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MainTest {

	public static void main(String[] args) throws Throwable {
		
		Map[] map = new Map[6];
		Mob[] mob = new Mob[29];
		Skill[] skill = new Skill[48];
		
		// ./MapData.txt 에서 맵 정보 불러오기
		loadMap(map);
		
		// ./MobData.txt 에서 몬스터 정보 불러오기
		loadMob(mob);
		
		// ./Skill.txt 에서 스킬 정보 불러오기
		loadSkill(skill);
		
		Character user = new Character(skill);
		
		Controller controller = new Controller(user, map, mob);
		
		View view = new View(controller);
		
		controller.setView(view);
		
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
	
	public static void loadSkill(Skill[] skill) throws Throwable
	{
		String path = "./Skill.txt";
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String temp = br.readLine();
		temp = br.readLine();
		
		do
		{
			StringTokenizer stk = new StringTokenizer(temp,"\t");
			
			String s_temp_ex;
			
			int i_temp_index = Integer.parseInt(stk.nextToken());
			String s_temp_1 = stk.nextToken();
			String s_temp_2 = stk.nextToken();
			int i_temp_ap = Integer.parseInt(stk.nextToken());
			double d_temp_damage = Double.parseDouble(stk.nextToken());
			
			if(i_temp_index > 31) {
				// defence 스킬
				s_temp_ex = "방어력을 (" + (int)(d_temp_damage*100) + "%) 만큼 1턴 증가시킨다.";
			} else if(i_temp_index > 15) {
				// finalHit 스킬
				s_temp_ex = "적에게 (" + (int)(d_temp_damage*100) + "%) 의 데미지를 2회 입힌다.";
			} else {
				// smash 스킬
				s_temp_ex = "적에게 큰 데미지 (" + (int)(d_temp_damage*100) + "%) 를 줄 수 있다";
			}
			
			skill[i_temp_index] = new Skill(s_temp_1, s_temp_2, i_temp_ap, d_temp_damage, s_temp_ex);
			
			temp = br.readLine();
		}
		while(temp != null);
	}

}
