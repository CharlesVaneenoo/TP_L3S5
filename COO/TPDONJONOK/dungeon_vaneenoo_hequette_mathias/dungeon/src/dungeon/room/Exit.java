package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;
/**
 * class Exit
 */
public class Exit extends Room {
	/**
	 * constructor of exit 
	 */
	public Exit(){
		this.canBeLeft=true;
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="exit";
		this.description="You are on an exit";
	}
	
	/**
	 *  function interpretCmd for an exit 
	 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1){
	System.out.println("You win");	
	}
	
	}
