package dungeon;
 /**
  * 
  * @author charlesvaneenoo
  * The class Potion
  */
public class Potion implements Loot{
	private String description;
	
	/**
	 * Constructor of potion
	 */
	public Potion(){
		this.description="a potion to heal yourself";
	}
	
	/**
	 * function pick, add a potion on the list of potion define in player.java
	 */
	public void pick(Player p) {
		p.addPotions();
	}

	/**
	 * function getDescription give to the users a description of a potion
	 */
	public String getDescription() {
		return description;
	}

	
}
