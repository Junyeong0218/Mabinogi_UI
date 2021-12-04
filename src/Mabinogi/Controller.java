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
			view.moveToCoordinate("다음 방으로 이동합니다.");
		} else {
			view.refreshBattleMap("아직 적이 남아있습니다.");
			view.refreshBattleMap("적을 처치해야 다음 방으로 이동할 수 있습니다.");
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
		view.goTo("전투");
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
			view.refreshBattleMap("이미 죽은 몬스터입니다.");
			view.refreshBattleMap("다음 맵으로 이동해주세요. (미니맵 클릭)");
		} else {
			if(isOkToUse(skillIndex)) {
				// 스테미너 충분한지 판단
				user.loseStamina(skillIndex);
				if(skillIndex < 3) {
					// 기본 공격 = 0 / 스매시 = 1 / 파이널어택 = 2
					finalDamage = user.attackMob(temp_mob, skillIndex);
					if(skillIndex == 1) {
						view.refreshBattleMap("[ 스매시 ] 스킬 사용!");
						view.refreshBattleMap(getMobName() + "에게 " + finalDamage + " 의 데미지를 주었습니다.");
						completeAttack();
					} else if(skillIndex == 2) {
						view.refreshBattleMap("[ 파이널 어택 ] 스킬 사용!");
						view.refreshBattleMap(getMobName() + "에게 " + finalDamage + " 의 데미지를 2회 주었습니다.");
						completeAttack();
					} else {
						// 기본 공격
						view.refreshBattleMap(getMobName() + "에게 " + finalDamage + " 의 데미지를 주었습니다.");
						completeAttack();
					}
				} else if(skillIndex == 3) {
					tempEncounter = battleEncounter;
					isUsedDefence();
					view.refreshBattleMap("[ 디펜스 ] 스킬 사용!");
					view.refreshBattleMap("한 턴 간 방어력이 " + user.getRaisedDefence() + "만큼 증가합니다.");
					completeAttack();
				}
			} else {
				// 스테미너가 충분하지 않을 경우
				view.refreshBattleMap("스테미너가 충분하지 않습니다.");
			}
		}
	}
	
	public void completeAttack() {
		if(isDead(temp_mob)) {
			view.refreshBattleMap(0);
			view.refreshBattleMap(temp_mob.getName() + "을 쓰러뜨렸습니다.");
			if(isBoss()) {
				view.refreshBattleMap(user.earnExp(temp_mob.getExp(user.getLevel())) + " 의 경험치와 " + user.earnMoney(temp_mob.getMoney()) +" 의 골드를 획득했습니다.");
				if(user.isLevelUp(user.getLevel())) {
					user.levelup();
					view.refreshBattleMap("레벨이 " + user.getLevel() + "로 올랐습니다!");
				}
				user.setFullUserCondition();
				view.refreshBattleMap("던전 클리어!");
				view.refreshBattleMap("3초 후 던전 선택 화면으로 돌아갑니다.");
				System.out.println("3초 후 던전 선택 화면으로 돌아갑니다.");
				temp_mob = null;
				goToSelectMap();
			} else {
				view.refreshBattleMap(user.earnExp(temp_mob.getExp(user.getLevel())) + " 의 경험치와 " + user.earnMoney(temp_mob.getMoney()) +" 의 골드를 획득했습니다.");
				if(user.isLevelUp(user.getLevel())) {
					user.levelup();
					view.refreshBattleMap("레벨이 " + user.getLevel() + "로 올랐습니다!");
				}
				view.refreshBattleMap("다음 맵으로 이동해주세요. (미니맵 클릭)");
			}
		} else {
			attackToUser();
			battleEncounter++;
		}
	}
	
	public void attackToUser() {
		int finalDamage = temp_mob.attackUser(user, isUsedDefence); // 순수 데미지 - 방어력 = 입은 데미지 반환
		
		view.refreshBattleMap(getMobName() + "에게 " + finalDamage + " 의 데미지를 입었습니다.");
		
		if(isDead(user)) {
			user.loseExp(user.getLevel());
			view.refreshBattleMap(getMobName() + "에 의해 캐릭터가 사망했습니다.");
			view.refreshBattleMap("경험치가 감소합니다.");
			view.refreshBattleMap("3초 후 던전 선택 화면으로 돌아갑니다.");
			System.out.println("3초 후 던전 선택 화면으로 돌아갑니다.");
			user.setFullUserCondition();
			goToSelectMap();
		}
	}
}
