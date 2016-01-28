package dungeon.weapon;

import dungeon.Player;
/**
 * 
 * @author charlesvaneenoo
 * class Gun
 */
public class Gun extends Weapon{
	/**
	 * constructor of gun
	 */
	public Gun(){
		this.power = 100;
		this.description="a gun !";
	}

	/**
	 * class gun
	 */
	@Override
	public void pick(Player p) {
		p.setWeapon(new Gun());
		
	}



}
