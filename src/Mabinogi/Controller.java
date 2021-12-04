package Mabinogi;

import java.util.Random;

public class Controller {
	
	private Character user = null;
	
	private Map[] map = null;
	
	private Mob[] mob = null;
	private Mob temp_mob;
	
	private View view = null;
	
	private int selectedPath;
	private int start_x;
	private int start_y;
	private int boss_x;
	private int boss_y;
	private int[] selected_x;
	private int[] selected_y;
	private int[] selected_dir;
	private int current_x;
	private int current_y;
	private int current_path;
	
	private int selectedMapIndex;
	private int battleEncounter;
	private int tempEncounter;
	private boolean isUsedDefence = false;

	public Controller(Character user, Map[] map, Mob[] mob) {
		this.user = user;
		this.map = map;
		this.mob = mob;
		temp_mob = new Mob();
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void setUserName(String name) {
		user.setName(name);
	}
	
	public int getSelectedPath() {
		return selectedPath; 
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
	
	public int[] getSelected_X() {
		return selected_x; 
	}
	
	public int[] getSelected_Y() {
		return selected_y; 
	}
	
	public int[] getSelected_Dir() {
		return selected_dir; 
	}
	
	public int getCurrent_X() {
		return current_x;
	}
	
	public int getCurrent_Y() {
		return current_y;
	}
	
	public int getCurrentPath() {
		return current_path;
	}
	
	public String getApearMob(int selectedMapIndex, int mobIndex) {
		int i;
		for(i = 0; i < mob.length; i++) {
			if(mob[i].getMap().equals(map[selectedMapIndex].getMapName())) {
				break;
			}
		}
		return mob[i+mobIndex].getName();
	}
	
	public int getMinRecommendLevel(int selectedMapIndex) {
		int i;
		for(i = 0; i < mob.length; i++) {
			if(mob[i].getMap().equals(map[selectedMapIndex].getMapName())) {
				break;
			}
		}
		return mob[i].getLevel();
	}
	
	public int getMaxRecommendLevel(int selectedMapIndex) {
		int i;
		for(i = 0; i < mob.length; i++) {
			if(mob[i].getMap().equals(map[selectedMapIndex].getMapName())) {
				break;
			}
		}
		return mob[i+4].getLevel();
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
	
	public int getSkillAp(int skillIndex) {
		return user.getSkillAp(skillIndex);
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
		return user.getDefence(getUserStr(), isUsedDefence);
	}
	
	public int getUserCritical() {
		return user.getCritical(getUserWill());
	}
	
	public String getMobName() {
		return temp_mob.getName();
	}
	
	public int getMobLevel() {
		return temp_mob.getLevel();
	}
	
	public int getMobHp() {
		return temp_mob.getHp();
	}
	
	public int getMobFullHp() {
		return temp_mob.getFullHp();
	}
	
	public int getMobMinDamage() {
		return temp_mob.getMinDamage();
	}
	
	public int getMobMaxDamage() {
		return temp_mob.getMaxDamage();
	}
	
	public int getMobDefence() {
		return temp_mob.getDefence();
	}
	
	public int getMobCritical() {
		return temp_mob.getCritical();
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
			goToSkillInfo();
		}
	}
	
	public boolean isNext(int x, int y) {
		int temp_cur_x = current_x;
		int temp_cur_y = current_y;
		switch(selected_dir[current_path+1]) {
		case 1:
			temp_cur_y--;
			break;
		case 2:
			temp_cur_y++;
			break;
		case 3:
			temp_cur_x--;
			break;
		case 4:
			temp_cur_x++;
			break;
		}
		return x == temp_cur_x && y == temp_cur_y;
	}
	
	public boolean isBoss() {
		return current_x == boss_x && current_y == boss_y;
	}
	
	public void moveTo() {
		if(isDead(temp_mob)) {
			current_path++;
			current_x = selected_x[current_path];
			current_y = selected_y[current_path];
			selectMob(selectedMapIndex);
			view.moveToCoordinate("���� ������ �̵��մϴ�.");
		} else {
			view.refreshBattleMap("���� ���� �����ֽ��ϴ�.");
			view.refreshBattleMap("���� óġ�ؾ� ���� ������ �̵��� �� �ֽ��ϴ�.");
		}
	}
	
	public void toggleBattleControl(int controlIndex) {
		if(controlIndex == 0) {
			view.refreshBattleMap(1);
		} else {
			view.refreshBattleMap(0);
		}
	}
	
	public void selectMap(int selectedMapIndex) {
		view.SelectMap(selectedMapIndex);
	}
	
	public void selectMob(int selectedMapIndex) {
		if(isBoss()) {
			temp_mob.setName(mob[selectedMapIndex * 5 + 4].getName());
			temp_mob.setMap(mob[selectedMapIndex * 5 + 4].getMap());
			temp_mob.setLevel(mob[selectedMapIndex * 5 + 4].getLevel());
			temp_mob.setHp(mob[selectedMapIndex * 5 + 4].getHp());
			temp_mob.setFullHp(mob[selectedMapIndex * 5 + 4].getFullHp());
			temp_mob.setMinDamage(mob[selectedMapIndex * 5 + 4].getMinDamage());
			temp_mob.setMaxDamage(mob[selectedMapIndex * 5 + 4].getMaxDamage());
			temp_mob.setCritical(mob[selectedMapIndex * 5 + 4].getCritical());
			temp_mob.setDefence(mob[selectedMapIndex * 5 + 4].getDefence());
			temp_mob.setExp(mob[selectedMapIndex * 5 + 4].getExp());
			temp_mob.setMinMoney(mob[selectedMapIndex * 5 + 4].getMinMoney());
			temp_mob.setMaxMoney(mob[selectedMapIndex * 5 + 4].getMaxMoney());
		} else {
			Random rand = new Random();
			int rnd = rand.nextInt(4);
			temp_mob.setName(mob[selectedMapIndex * 5 + rnd].getName());
			temp_mob.setMap(mob[selectedMapIndex * 5 + rnd].getMap());
			temp_mob.setLevel(mob[selectedMapIndex * 5 + rnd].getLevel());
			temp_mob.setHp(mob[selectedMapIndex * 5 + rnd].getHp());
			temp_mob.setFullHp(mob[selectedMapIndex * 5 + rnd].getFullHp());
			temp_mob.setMinDamage(mob[selectedMapIndex * 5 + rnd].getMinDamage());
			temp_mob.setMaxDamage(mob[selectedMapIndex * 5 + rnd].getMaxDamage());
			temp_mob.setCritical(mob[selectedMapIndex * 5 + rnd].getCritical());
			temp_mob.setDefence(mob[selectedMapIndex * 5 + rnd].getDefence());
			temp_mob.setExp(mob[selectedMapIndex * 5 + rnd].getExp());
			temp_mob.setMinMoney(mob[selectedMapIndex * 5 + rnd].getMinMoney());
			temp_mob.setMaxMoney(mob[selectedMapIndex * 5 + rnd].getMaxMoney());
		}
		battleEncounter = 0;
		tempEncounter = 0;
		isUsedDefence = false;
	}
	
	public void createCharacter() {
		view.dialog_createCharater.setVisible(true);
	}
	
	public void inputWrongName() {
		view.dialog_wrongName.setVisible(true);
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
	
	public void goToBattle(int selectedMapIndex) {
		this.selectedMapIndex = selectedMapIndex;
		CreateMap createMap = new CreateMap();
		selectedPath = createMap.getSelectedPath();
		start_x = createMap.getStart_X();
		start_y = createMap.getStart_Y();
		boss_x = createMap.getBoss_X();
		boss_y = createMap.getBoss_Y();
		selected_x = createMap.getSelected_X();
		selected_y = createMap.getSelected_Y();
		selected_dir = createMap.getSelected_Dir();
		current_x = start_x;
		current_y = start_y;
		current_path = -1;
		selectMob(selectedMapIndex);
		view.goTo("����");
	}
	
	public boolean isDead(Mob mob) {
		return getMobHp() < 1;
	}
	
	public boolean isDead(Character user) {
		return user.getHp() < 1;
	}
	
	public void isUsedDefence() {
		if(tempEncounter == battleEncounter) {
			isUsedDefence = true;
		} else {
			isUsedDefence = false;
		}
	}
	
	public boolean isOkToUse(int skillIndex) {
		return user.getStamina() > user.getSkillStamina(skillIndex)-1;
	}
	
	public void attackToMob(int skillIndex) {
		int finalDamage;
		isUsedDefence();
		if(isDead(temp_mob)) {
			view.refreshBattleMap("�̹� ���� �����Դϴ�.");
			view.refreshBattleMap("���� ������ �̵����ּ���. (�̴ϸ� Ŭ��)");
		} else {
			if(isOkToUse(skillIndex)) {
				// ���׹̳� ������� �Ǵ�
				user.loseStamina(skillIndex);
				if(skillIndex < 3) {
					// �⺻ ���� = 0 / ���Ž� = 1 / ���̳ξ��� = 2
					finalDamage = user.attackMob(temp_mob, skillIndex);
					if(skillIndex == 1) {
						view.refreshBattleMap("[ ���Ž� ] ��ų ���!");
						view.refreshBattleMap(getMobName() + "���� " + finalDamage + " �� �������� �־����ϴ�.");
						completeAttack();
					} else if(skillIndex == 2) {
						view.refreshBattleMap("[ ���̳� ���� ] ��ų ���!");
						view.refreshBattleMap(getMobName() + "���� " + finalDamage + " �� �������� 2ȸ �־����ϴ�.");
						completeAttack();
					} else {
						// �⺻ ����
						view.refreshBattleMap(getMobName() + "���� " + finalDamage + " �� �������� �־����ϴ�.");
						completeAttack();
					}
				} else if(skillIndex == 3) {
					tempEncounter = battleEncounter;
					isUsedDefence();
					view.refreshBattleMap("[ ���潺 ] ��ų ���!");
					view.refreshBattleMap("�� �� �� ������ " + user.getRaisedDefence() + "��ŭ �����մϴ�.");
					completeAttack();
				}
			} else {
				// ���׹̳ʰ� ������� ���� ���
				view.refreshBattleMap("���׹̳ʰ� ������� �ʽ��ϴ�.");
			}
		}
	}
	
	public void completeAttack() {
		if(isDead(temp_mob)) {
			view.refreshBattleMap(0);
			view.refreshBattleMap(temp_mob.getName() + "�� �����߷Ƚ��ϴ�.");
			if(isBoss()) {
				view.refreshBattleMap(user.earnExp(temp_mob.getExp(user.getLevel())) + " �� ����ġ�� " + user.earnMoney(temp_mob.getMoney()) +" �� ��带 ȹ���߽��ϴ�.");
				if(user.isLevelUp(user.getLevel())) {
					user.levelup();
					view.refreshBattleMap("������ " + user.getLevel() + "�� �ö����ϴ�!");
				}
				user.setFullUserCondition();
				view.refreshBattleMap("���� Ŭ����!");
				view.refreshBattleMap("3�� �� ���� ���� ȭ������ ���ư��ϴ�.");
				System.out.println("3�� �� ���� ���� ȭ������ ���ư��ϴ�.");
				temp_mob = null;
				goToSelectMap();
			} else {
				view.refreshBattleMap(user.earnExp(temp_mob.getExp(user.getLevel())) + " �� ����ġ�� " + user.earnMoney(temp_mob.getMoney()) +" �� ��带 ȹ���߽��ϴ�.");
				if(user.isLevelUp(user.getLevel())) {
					user.levelup();
					view.refreshBattleMap("������ " + user.getLevel() + "�� �ö����ϴ�!");
				}
				view.refreshBattleMap("���� ������ �̵����ּ���. (�̴ϸ� Ŭ��)");
			}
		} else {
			attackToUser();
			battleEncounter++;
		}
	}
	
	public void attackToUser() {
		int finalDamage = temp_mob.attackUser(user, isUsedDefence); // ���� ������ - ���� = ���� ������ ��ȯ
		
		view.refreshBattleMap(getMobName() + "���� " + finalDamage + " �� �������� �Ծ����ϴ�.");
		
		if(isDead(user)) {
			user.loseExp(user.getLevel());
			view.refreshBattleMap(getMobName() + "�� ���� ĳ���Ͱ� ����߽��ϴ�.");
			view.refreshBattleMap("����ġ�� �����մϴ�.");
			view.refreshBattleMap("3�� �� ���� ���� ȭ������ ���ư��ϴ�.");
			System.out.println("3�� �� ���� ���� ȭ������ ���ư��ϴ�.");
			user.setFullUserCondition();
			goToSelectMap();
		}
	}
}
