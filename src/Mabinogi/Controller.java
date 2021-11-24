package Mabinogi;

import javax.swing.JPanel;

public class Controller {
	
	Character user = null;
	Map[] map = null;
	Mob[] mob = null;
	Mob currentMonster;
	View view = null;
	JPanel panelMain;
	JPanel panelInfo;
	JPanel panelInfoStatus;

	public Controller(Character user, Map[] map, Mob[] mob) {
		this.user = user;
		this.map = map;
		this.mob = mob;
	}
	
	public void setView(View view, JPanel panelMain,JPanel panelInfo) {
		this.view = view;
		this.panelMain = panelMain;
		this.panelInfo = panelInfo;
	}
	
	/*public void setPanelInfoStatus(JPanel panelInfoStatus) {
		this.panelInfoStatus = panelInfoStatus;
	}*/
	
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
	
	public boolean isOktoRankUp() {
		if(user.getAbilityPoint() > user.skill[user.skillIndex+1].getAp()-1 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void skillRankUp() {
		if(isOktoRankUp()) {
			user.skillIndex++;
			user.loseAp(user.skill[user.skillIndex+1].getAp());
		}
	}
}
