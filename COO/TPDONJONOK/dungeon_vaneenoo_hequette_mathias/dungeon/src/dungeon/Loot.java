package dungeon;

/**
 * interface loot 
 */
public interface Loot {
	/**
	 * function pick
	 * @param p a player 
	 */
	public void pick(Player p);
	
	/**
	 * function getDescription
	 * @return the description of the class 
	 */
	public String getDescription();
}
