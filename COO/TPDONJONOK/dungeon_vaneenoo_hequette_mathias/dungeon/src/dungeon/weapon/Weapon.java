package dungeon.weapon;

import dungeon.Loot;
import dungeon.Player;

public abstract class Weapon implements Loot{
	protected int power;
	protected String description;
	
	public int getPower() {
		return this.power;
	}
	
	@Override
	public abstract void pick(Player p);
	
	public String getDescription(){
		return this.description;
	}
}
