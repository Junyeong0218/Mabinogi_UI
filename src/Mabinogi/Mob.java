package Mabinogi;

import java.util.Random;

public class Mob {

	String name, map;
	int level, hp, minDamage, maxDamage, critical, defence, exp, minMoney, maxMoney;
	
	public Mob(String name, String map, int level, int hp, int minDamage, int maxDamage, int critical, int defence, int exp, int minMoney, int maxMoney)
	{
		this.name = name;
		this.map = map;
		this.level = level;
		this.hp = hp;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.critical = critical;
		this.defence = defence;
		this.exp = exp;
		this.minMoney = minMoney;
		this.maxMoney = maxMoney;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public int getCritical() {
		return critical;
	}

	public int getDefence() {
		return defence;
	}

	public int getExp(int level)
	{
		if(level - this.level > 9)
		{
			return (int)(exp * 0.5); 
		}
		else
		{
			return exp;
		}
	}
	
	public int getMoney()
	{
		Random rand = new Random();
		int temp = rand.nextInt(101); // 0 ~ 100 까지 난수 발생
		
		return this.minMoney + ( this.maxMoney - this.minMoney ) * temp / 100;
	}	
	
	public void attackUser(Character character)
	{
		boolean isCritical = isCritical();
		int selectedDamage;
		
		Random rand = new Random();
		int temp = rand.nextInt(101); // 0 ~ 100 까지 난수
		
		if( isCritical )
		{
			selectedDamage = ( minDamage + (maxDamage - minDamage) * temp / 100 ) * 2;
		}
		else
		{
			selectedDamage = minDamage + (maxDamage - minDamage) * temp / 100;
		}
		
		character.attacked(selectedDamage);
	}
	
	public void attacked(int damage)
	{
		this.hp -= ( damage - this.defence );
	}
	
	public boolean isDead()
	{
		if(this.hp < 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isCritical()
	{
		Random rand = new Random();
		int temp = rand.nextInt(100) + 1;
		
		if( temp <= getCritical() )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void showInfo()
	{
		System.out.println("== " + name + " ==");
		System.out.println("등장맵 : " + map);
		System.out.println("레벨 : " + level);
		System.out.println("hp : " + hp);
		System.out.println("최소 공격력 : " + minDamage);
		System.out.println("최대 공격력 : " + maxDamage);
		System.out.println("크리티컬 확률 : " + critical);
		System.out.println("방어력 : " + defence);
		System.out.println("경험치 : " + exp);
		System.out.println("최소 골드 : " + minMoney);
		System.out.println("최대 골드 : " + maxMoney);
		System.out.println("========================================");
	}
	
	

}
