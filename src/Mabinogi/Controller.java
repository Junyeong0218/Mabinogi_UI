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
		view.goTo("메인");
	}
	
	public void goToInfo() {
		view.goTo("정보");
	}
	
	public void goToSkillInfo() {
		view.goTo("스킬");
	}
	
	public void goToSelectMap() {
		view.goTo("맵선택");
	}
	
	public void goToBattleMap() {
		view.goTo("전투");
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
			// 스킬이 defence 인 경우
			if(skillIndex == 47) {
				// defence 스킬이 최고랭크여서 랭크업 불가능 + dialog 구현하기
				return false;
			} else if(judgeApEnough(skillIndex)){
				// abilityPoint 충분하고 defence 스킬이 랭크업 가능함.
				return true;
			} else {
				// abilityPoint 가 불충분. + dialog 구현하기
				return false;
			}
		} else if(skillIndex > 15 && skillIndex < 32) {
			// 스킬이 finalHit 인 경우
			if(skillIndex == 31) {
				// finalHit 스킬이 최고랭크여서 랭크업 불가능 + dialog 구현하기
				return false;
			} else if(judgeApEnough(skillIndex)){
				// abilityPoint 충분하고 finalHit 스킬이 랭크업 가능함.
				return true;
			} else {
				// abilityPoint 가 불충분. + dialog 구현하기
				return false;
			}
		} else if(skillIndex > -1 && skillIndex < 16) {
			// 스킬이 smash 인 경우
			if(skillIndex == 15) {
				// smash 스킬이 최고랭크여서 랭크업 불가능 + dialog 구현하기
				return false;
			} else if(judgeApEnough(skillIndex)){
				// abilityPoint 충분하고 smash 스킬이 랭크업 가능합.
				return true;
			} else {
				// abilityPoint 가 불충분. + dialog 구현하기
				return false;
			}
		} else {
			// 인수로 받은 skillIndex 의 값이 범위밖의 값 + dialog 구현하기
			return false;
		}
	}
	
	public void skillRankUp(int skillIndex) {
		if(isOktoRankUp(skillIndex)) {
			user.loseAp(user.getSkillAp(skillIndex+1)); // Ap소모
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
