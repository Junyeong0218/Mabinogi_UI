package Mabinogi;

public class Controller {
	
	Character user = null;
	Map[] map = null;
	Mob[] mob = null;
	Mob currentMonster;
	View view = null;

	public Controller(Character user, Map[] map, Mob[] mob, View view)
	{
		this.user = user;
		this.map = map;
		this.mob = mob;
		this.view = view;
		this.view.setController(this);
	}
	
	public void setUserName(String name)
	{
		user.setName(name);
	}
}
