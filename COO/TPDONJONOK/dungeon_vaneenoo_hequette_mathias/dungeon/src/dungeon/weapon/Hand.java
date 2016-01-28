package dungeon.weapon;

import dungeon.Player;
/**
 * 
 * @author charlesvaneenoo
 * class Hand
 */
public class Hand extends Weapon {

	/**
	 * constructor of Hand
	 */
	public Hand(){
		this.power=10;
		this.description="your hands";
	}	
	
	/**
	 * class pick
	 */
	@Override
	public void pick(Player p) {
		p.setWeapon(new Hand());
		
	}


}
