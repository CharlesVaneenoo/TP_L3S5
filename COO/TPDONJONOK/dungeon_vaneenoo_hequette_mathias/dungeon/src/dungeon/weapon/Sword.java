package dungeon.weapon;

import dungeon.Player;
/**
 * 
 * @author charlesvaneenoo
 * class Sword
 */
public class Sword extends Weapon {

	/**
	 * constructor of sword
	 */
	public Sword(){
		this.power=20;
		this.description="a nice sword";
	}

	/**
	 * class pick
	 */
	@Override
	public void pick(Player p) {
		p.setWeapon(new Sword());
		
	}

}
