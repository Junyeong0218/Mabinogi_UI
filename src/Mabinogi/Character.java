package Mabinogi;

import java.util.Random;

public class Character {

	private String name;
	private int level, abilityPoint, rebirth, exp, money, hp, stamina, fullHp, fullStamina; // 레벨 1~50, 어빌++, 환생횟수0
	
	private double d_str, d_will;
	
	private int[] neededExp = new int[50];
	
	// 체력 레벨업, 환생 계수
	private final int HP_LEVELUP = 15;
	private final double HP_REBIRTH = 0.1;
	// 스테미나 레벨업, 환생 계수
	private final int STAMINA_LEVELUP = 5;
	private final double STAMINA_REBIRTH = 0.05;
	// 힘 레벨업, 환생 계수
	private final double STR_LEVELUP = 7.5;
	private final double STR_REBIRTH = 0.2;
	// 의지 레벨업, 환생 계수
	private final double WILL_LEVELUP = 0.5;
	private final double WILL_REBIRTH = 0.05;
	// 전투력 계산 상수
	private final double MAX_DAMAGE_DIV = 2.5;
	private final double MIN_DAMAGE_DIV = 3;
	private final double DEFENCE_DIV = 5;
	private final double CRITICAL_DIV = 5;
	
	private Skill[] skill = null;
	private int smashIndex, finalHitIndex, defenceIndex;
	
	public Character(Skill[] skill)
	{
		//this.name = "테스트용";
		this.level = 1;
		this.abilityPoint = 100;
		this.rebirth = 0;
		this.exp = 0;
		this.money = 0;
		
		this.hp = 100 + HP_LEVELUP;
		this.stamina = 100 + STAMINA_LEVELUP;
		this.d_str = 45 + STR_LEVELUP;
		this.d_will = 25 + WILL_LEVELUP;
		
		this.fullHp = hp;
		this.fullStamina = stamina;
		
		this.skill = skill;
		this.smashIndex = 0;
		this.finalHitIndex = 16;
		this.defenceIndex = 32;
		
		setNeededExp();
	}
	
	public void setNeededExp()
	{
		neededExp[0] = 400;
		neededExp[1] = 700;		
		neededExp[2] = 1000;		
		neededExp[3] = 1300;		
		neededExp[4] = 1600;		
		neededExp[5] = 1800;		
		neededExp[6] = 2000;		
		neededExp[7] = 2200;		
		neededExp[8] = 2400;		
		neededExp[9] = 2600;		
		neededExp[10] = 2800;		
		neededExp[11] = 3000;		
		neededExp[12] = 3300;		
		neededExp[13] = 3600;		
		neededExp[14] = 3900;		
		neededExp[15] = 4300;		
		neededExp[16] = 4700;		
		neededExp[17] = 5100;		
		neededExp[18] = 5600;		
		neededExp[19] = 6200;		
		neededExp[20] = 6800;		
		neededExp[21] = 7600;		
		neededExp[22] = 8400;		
		neededExp[23] = 9300;		
		neededExp[24] = 10300;		
		neededExp[25] = 11300;		
		neededExp[26] = 12500;		
		neededExp[27] = 13800;		
		neededExp[28] = 15300;		
		neededExp[29] = 16800;		
		neededExp[30] = 18500;		
		neededExp[31] = 20300;		
		neededExp[32] = 22200;		
		neededExp[33] = 24300;		
		neededExp[34] = 26600;		
		neededExp[35] = 29000;		
		neededExp[36] = 31600;		
		neededExp[37] = 34400;		
		neededExp[38] = 37300;		
		neededExp[39] = 40400;		
		neededExp[40] = 43700;		
		neededExp[41] = 47200;		
		neededExp[42] = 50900;		
		neededExp[43] = 54800;		
		neededExp[44] = 59000;		
		neededExp[45] = 63300;		
		neededExp[46] = 67900;		
		neededExp[47] = 72700;		
		neededExp[48] = 77700;		
		neededExp[49] = 83000;		
	}
	
	public void getSelectedSkillIndex() {
		
	}
	
	public int getSmashCurrentIndex() {
		return smashIndex;
	}
	
	public int getFinalHitCurrentIndex() {
		return finalHitIndex;
	}
	
	public int getDefenceIndex() {
		return defenceIndex;
	}
	
	public String getSkillName(int skillIndex) {
		return skill[skillIndex].getName();
	}
	
	public String getSkillRank(int skillIndex) {
		return skill[skillIndex].getRank();
	}
	
	public String getSkillEx(int skillIndex) {
		return skill[skillIndex].getExplanation();
	}
	
	public int getSkillAp(int skillIndex) {
		return skill[skillIndex].getAp();
	}
	
	public int getSkillStamina(int skillIndex) {
		int stamina = 0;
		
		if(skillIndex == 1) {
			stamina = skill[smashIndex].getStamina();
		} else if(skillIndex == 2) {
			stamina = skill[finalHitIndex].getStamina();
		}else if(skillIndex == 3) {
			stamina = skill[defenceIndex].getStamina();
		}
		
		return stamina;
	}
	
	public void skillRankUp(int skillIndex) {
		if(skillIndex > 31) {
			defenceIndex++;
		}
		else if(skillIndex > 15) {
			finalHitIndex++;
		}
		else if(skillIndex > -1) {
			smashIndex++;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getAbilityPoint()
	{
		return abilityPoint;
	}
	
	public int getRebirth()
	{
		return rebirth;
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public int getStamina()
	{
		return stamina;
	}
	
	public double getStr()
	{
		return d_str;
	}
	
	public double getWill()
	{
		return d_will;
	}
	
	public int getFullHp()
	{
		return fullHp;
	}
	
	public int getFullStamina()
	{
		return fullStamina;
	}
	
	public int getMaxDamage(double d_str)
	{
		return (int)(d_str / MAX_DAMAGE_DIV);
	}
	
	public int getMinDamage(double d_str)
	{
		return (int)(d_str / MIN_DAMAGE_DIV);
	}
	
	public int getRaisedDefence() {
		return (int)((d_str / DEFENCE_DIV) * skill[defenceIndex].getDamage());
	}
	
	public int getDefence(double d_str, boolean isUsed)
	{
		if(isUsed) {
			return (int)((d_str / DEFENCE_DIV) + (d_str / DEFENCE_DIV) * skill[defenceIndex].getDamage());
		} else {
			return (int)(d_str / DEFENCE_DIV);
		}
	}
	
	public int getCritical(double d_will)
	{
		return (int)(d_will / CRITICAL_DIV);
	}
	
	public int getNeededExp(int level)
	{
		return neededExp[level-1];
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int earnExp(int exp)
	{
		this.exp += exp;
		
		return exp;
	}
	
	public void loseStamina(int skillIndex) {
		if(skillIndex == 1) {
			stamina -= skill[smashIndex].getStamina();
		} else if(skillIndex == 2) {
			stamina -= skill[finalHitIndex].getStamina();
		} else if(skillIndex == 3) {
			stamina -= skill[defenceIndex].getStamina();
		} 
	}
	
	public void loseExp(int level) {
		exp -= neededExp[level] * 0.05;
		if(exp < 0) {
			exp = 0;
		}
	}
	
	public int earnMoney(int money)
	{
		this.money += money;
		
		return money;
	}
	
	public void loseAp(int ap) {
		this.abilityPoint -= ap;
	}
	
	public void setFullUserCondition() {
		hp = fullHp;
		stamina = fullStamina;
	}
	
	public void levelup()
	{
		this.exp -= getNeededExp(this.level);
		this.level++;
		this.abilityPoint++;
		
		// Hp = 100 + 업당 15 * (1 + 0.1 * 환생횟수)
		hp = fullHp;
		hp += HP_LEVELUP * (1 + HP_REBIRTH * rebirth);
		fullHp = hp;
		
		// Stamina = 100 + 업당 5 * (1 + 0.05 * 환생횟수)
		stamina = fullStamina;
		stamina += STAMINA_LEVELUP * (1 + STAMINA_REBIRTH * rebirth);
		fullStamina = stamina;
		
		// str = 45 + 업당 7.5 * (1 + 0.2 * 환생횟수) // 환생 1회당 증가랑 20%증가 // 최종스텟 = 420(0환생시)
		d_str += STR_LEVELUP + (1 + STR_REBIRTH * rebirth);
		
		// will =  25 + 업당 2.5 * (1 + 0.05 * 환생횟수) // 환생 1회당 증가량 5% 증가 // 최종스텟 = 150(0환생시)
		d_will += WILL_LEVELUP + (1 + WILL_REBIRTH * rebirth);
	}
	
	public boolean isLevelUp(int level)
	{
		if( getExp() > getNeededExp(level) - 1 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int attackMob(Mob mob, int skillIndex)
	{
		int maxDamage = getMaxDamage(d_str);
		int minDamage = getMinDamage(d_str);
		int selectedDamage;
		double skillDamage = 1;
		
		if(skillIndex == 0) {
			skillDamage = 1;
		} else if(skillIndex == 1) {
			skillDamage = skill[smashIndex].getDamage();
		} else if(skillIndex == 2) {
			skillDamage = skill[finalHitIndex].getDamage();
		}
		
		Random rand = new Random();
		int temp = rand.nextInt(101); // 0 ~ 100 까지 난수
		
		// 크리티컬 발동시 데미지 2배 적용
		if( isCritical() )
		{
			selectedDamage = (int)(( minDamage + (maxDamage - minDamage) * temp / 100 ) * skillDamage * 2);
		}
		else
		{
			selectedDamage = (int)((minDamage + (maxDamage - minDamage) * temp / 100) * skillDamage);
		}
		
		int finalDamage = mob.attacked(selectedDamage, skillIndex);
		
		return finalDamage;
	}
	
	public int attacked(int damage, boolean isUsed)
	{
		int defence = getDefence(d_str, isUsed);
		
		int finalDamage = damage - defence;
		
		hp -= (finalDamage);
		
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
		
		if( temp <= (int)getCritical(this.d_will) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
}
