package Mabinogi;

import javax.swing.JPanel;

public class Controller {
	
	Character user = null;
	Map[] map = null;
	Mob[] mob = null;
	Mob currentMonster;
	View view = null;
	JPanel panelMain;

	public Controller(Character user, Map[] map, Mob[] mob) {
		this.user = user;
		this.map = map;
		this.mob = mob;
	}
	
	public void setView(View view, JPanel panelMain) {
		this.view = view;
		this.panelMain = panelMain;
	}
	
	public void setUserName(String name) {
		user.setName(name);
	}
	
	public void createCharacter() {
		view.dialog_createCharater.setVisible(true);
		view.goTo(panelMain);
	}
	
	public void goToInfo() {
		
	}
	
	public void goToSkillInfo() {
		
	}
	
	public void goToSelectMap() {
		
	}
	
	public void goToBattleMap() {
		
	}
}
