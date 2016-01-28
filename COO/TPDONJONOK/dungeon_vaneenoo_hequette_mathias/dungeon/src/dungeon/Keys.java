package dungeon;

/**
 * 
 * @author charlesvaneenoo
 * class Keys
 */
public class Keys implements Loot{
	private String description;
	
	/**
	 * constructor of keys
	 */
	public Keys(){
		this.description="a key";
	}
	
	/**
	 * function pick add a keys to the list of keys
	 * @param p a player 
	 */
	public void pick(Player p) {
		p.addKeys();
	}
	
	/**
	 * function getDescription
	 * @return the description of the class key
	 */
	public String getDescription() {
		return description;
	}
}
