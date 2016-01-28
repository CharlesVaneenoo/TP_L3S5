package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;
/**
 * 
 * @author charlesvaneenoo
 * Class CarpetRoom
 */
public class CarpetRoom extends Room{
	
	/**
	 * constructor of carpet room
	 */
	public CarpetRoom(){
	this.canBeLeft=true;
	this.adjoiningRooms=new HashMap<String,Room>();
	this.preview="a carpet room";
	this.description="You are in a carpet room, there is just a carpet on the floor";
	}

	/**
	 *  function interpretCmd for a CarpetRoom (secret exit)
	 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1) {
		switch (s){
		//direction
		case "carpet": if (this.adjoiningRooms.containsKey("carpet")){
			dungeon.setCurrentRoom(adjoiningRooms.get("carpet"));
			System.out.println("You pass below the carpet");}
		break;	
		default:System.out.println("try 'go carpet', 'look' or 'help'");
		}
	}

}
