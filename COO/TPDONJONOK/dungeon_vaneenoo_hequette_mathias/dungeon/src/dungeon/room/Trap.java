package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;
/**
 * class Trap
 */
public class Trap extends Room{
	
	/**
	 * constructor of class Trap
	 */
	public Trap(){
		this.canBeLeft=false;
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="trapped";
		this.description="You are on a trap, you can't move.";
	}
	
	/**
	 *  function interpretCmd tell to player he is on a trap, and the game is over
	 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1){
		System.out.println("You ran into a trap and died");
	
	}

}
