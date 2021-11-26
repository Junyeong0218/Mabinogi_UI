package Mabinogi;

import javax.swing.JPanel;

public class Controller {
	
	private Character user = null;
	private Character temp_user;
	
	private Map[] map = null;
	
	private Mob[] mob = null;
	private Mob temp_mob;
	
	private View view = null;
	
	private JPanel panelMain;
	private JPanel panelInfo;
	private JPanel panelInfoStatus;

	public Controller(Character user, Map[] map, Mob[] mob) {
		this.user = user;
		this.map = map;
		this.mob = mob;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void setUserName(String name) {
		user.setName(name);
	}
	
	public void createCharacter() {
		view.dialog_createCharater.setVisible(true);
	}
	
	public void goToMain() {
		view.goTo("����");
	}
	
	public void goToInfo() {
		view.goTo("����");
	}
	
	public void goToSkillInfo() {
		view.goTo("��ų");
	}
	
	public void goToSelectMap() {
		view.goTo("�ʼ���");
	}
	
	public void goToBattleMap() {
		view.goTo("����");
	}
	
	public int getSmashIndex() {
		return user.getSmashCurrentIndex();
	}
	
	public int getFinalHitIndex() {
		return user.getFinalHitCurrentIndex();
	}
	
	public int getDefenceIndex() {
		return user.getDefenceIndex();
	}
	
	public boolean judgeApEnough(int skillIndex) {
		return user.getAbilityPoint() > user.getSkillAp( skillIndex +1 ) -1;
	}
	
	public boolean isOktoRankUp(int skillIndex) {
		if(skillIndex > 31 && skillIndex < 48) {
			// ��ų�� defence �� ���
			if(skillIndex == 47) {
				// defence ��ų�� �ְ�ũ���� ��ũ�� �Ұ��� + dialog �����ϱ�
				return false;
			} else if(judgeApEnough(skillIndex)){
				// abilityPoint ����ϰ� defence ��ų�� ��ũ�� ������.
				return true;
			} else {
				// abilityPoint �� �����. + dialog �����ϱ�
				return false;
			}
		} else if(skillIndex > 15 && skillIndex < 32) {
			// ��ų�� finalHit �� ���
			if(skillIndex == 31) {
				// finalHit ��ų�� �ְ�ũ���� ��ũ�� �Ұ��� + dialog �����ϱ�
				return false;
			} else if(judgeApEnough(skillIndex)){
				// abilityPoint ����ϰ� finalHit ��ų�� ��ũ�� ������.
				return true;
			} else {
				// abilityPoint �� �����. + dialog �����ϱ�
				return false;
			}
		} else if(skillIndex > -1 && skillIndex < 16) {
			// ��ų�� smash �� ���
			if(skillIndex == 15) {
				// smash ��ų�� �ְ�ũ���� ��ũ�� �Ұ��� + dialog �����ϱ�
				return false;
			} else if(judgeApEnough(skillIndex)){
				// abilityPoint ����ϰ� smash ��ų�� ��ũ�� ������.
				return true;
			} else {
				// abilityPoint �� �����. + dialog �����ϱ�
				return false;
			}
		} else {
			// �μ��� ���� skillIndex �� ���� �������� �� + dialog �����ϱ�
			return false;
		}
	}
	
	public void skillRankUp(int skillIndex) {
		if(isOktoRankUp(skillIndex)) {
			user.loseAp(user.getSkillAp(skillIndex+1)); // Ap�Ҹ�
			user.skillRankUp(skillIndex); // SkillIndex++
		}
	}
	
	public String getSkillName(int skillIndex) {
		return user.getSkillName(skillIndex);
	}
	
	public String getSkillRank(int skillIndex) {
		return user.getSkillRank(skillIndex);
	}
	
	public String getSkillEx(int skillIndex) {
		return user.getSkillEx(skillIndex);
	}
	
	public String getUserName() {
		return user.getName();
	}
	
	public int getUserLevel() {
		return user.getLevel();
	}
	
	public int getUserHp() {
		return (int)user.getHp();
	}
	
	public int getUserFullHp() {
		return user.getFullHp();
	}
	
	public int getUserStamina() {
		return (int)user.getStamina();
	}
	
	public int getUserFullStamina() {
		return user.getFullStamina();
	}
	
	public int getUserExp() {
		return user.getExp();
	}
	
	public int getUserNeededExp() {
		return user.getNeededExp(getUserLevel());
	}
	
	public int getUserAp() {
		return user.getAbilityPoint();
	}
	
	public int getUserMoney() {
		return user.getMoney();
	}
	
	public double getUserStr() {
		return user.getStr();
	}
	
	public double getUserWill() {
		return user.getWill();
	}
	
	public int getUserMinDamage() {
		return user.getMinDamage(getUserStr());
	}
	
	public int getUserMaxDamage() {
		return user.getMaxDamage(getUserStr());
	}
	
	public int getUserDefence() {
		return user.getDefence(getUserStr());
	}
	
	public int getUserCritical() {
		return user.getCritical(getUserWill());
	}
	
}
