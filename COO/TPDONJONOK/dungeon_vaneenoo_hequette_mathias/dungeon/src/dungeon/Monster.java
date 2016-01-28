package dungeon;
/**
 * 
 * @author charlesvaneenoo
 * The class Monster
 */
public class Monster {
	
	public int life;
	public int strength;

	/**
	 * the constructor Monster
	 * @param life : the Monster's life 
	 * @param strength : the Monster's strength
	 */
	public Monster(int life, int strength){
		this.life=life;
		this.strength=strength;
	}
	
	/**
	 * the function getLife give the Monster's life
	 * @return an int : the Monster's life
	 */
	public int getLife(){
		return this.life;
	}
	/**
	 * the function setLife permit to change the life
	 * @param newLife : the new life
	 */
	public void setLife(int newLife){
		this.life=newLife;
	}
	
	/**
	 * the function hitMonster allow the monster to hit a player
	 * @param player : the player hit by the monster
	 */
	public void hitMonster(Player player){
		player.setLife(player.getLife()-this.strength);
	}
	
	/**
	 * the function isDeadMonster check if the monster is dead or not
	 * @return a boolean
	 */
	public boolean isDeadMonster(){
		if (this.life >0){ 
		return false;
		}
		else return true;		
	}
	
}
