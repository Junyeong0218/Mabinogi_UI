package Mabinogi;

import java.util.Random;

public class Mob {

	private String name, map;
	private int level, hp, fullHp, minDamage, maxDamage, critical, defence, exp, minMoney, maxMoney;
	
	public Mob(String name, String map, int level, int hp, int minDamage, int maxDamage, int critical, int defence, int exp, int minMoney, int maxMoney)
	{
		this.name = name;
		this.map = map;
		this.level = level;
		this.hp = hp;
		this.fullHp = hp;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.critical = critical;
		this.defence = defence;
		this.exp = exp;
		this.minMoney = minMoney;
		this.maxMoney = maxMoney;
	}

	public int getFullHp() {
		return fullHp;
	}

	public String getMap() {
		return map;
	}

	public int getHp() {
		return hp;
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

	public int getExp(int userlevel)
	{
		if(userlevel - this.level > 9)
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
		int temp = rand.nextInt(101); // 0 ~ 100 ���� ���� �߻�
		
		return this.minMoney + ( this.maxMoney - this.minMoney ) * temp / 100;
	}	
	
	public int attackUser(Character user, boolean isUsed)
	{
		int selectedDamage;
		
		Random rand = new Random();
		int temp = rand.nextInt(101); // 0 ~ 100 ���� ����
		
		if( isCritical() )
		{
			selectedDamage = ( minDamage + (maxDamage - minDamage) * temp / 100 ) * 2;
		}
		else
		{
			selectedDamage = minDamage + (maxDamage - minDamage) * temp / 100;
		}
		
		int finalDamage = user.attacked(selectedDamage, isUsed);
		
		return finalDamage;
	}
	
	public int attacked(int damage, int skillIndex)
	{
		int finalDamage = damage - defence;
		
		if(skillIndex == 2) {
			hp -= finalDamage * 2;
		} else {
			hp -= finalDamage;
		}
		
		if(hp < 0) {
			hp = 0;
		}
		
		return finalDamage;
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
		System.out.println("����� : " + map);
		System.out.println("���� : " + level);
		System.out.println("hp : " + hp);
		System.out.println("�ּ� ���ݷ� : " + minDamage);
		System.out.println("�ִ� ���ݷ� : " + maxDamage);
		System.out.println("ũ��Ƽ�� Ȯ�� : " + critical);
		System.out.println("���� : " + defence);
		System.out.println("����ġ : " + exp);
		System.out.println("�ּ� ��� : " + minMoney);
		System.out.println("�ִ� ��� : " + maxMoney);
		System.out.println("========================================");
	}
	
	

}
