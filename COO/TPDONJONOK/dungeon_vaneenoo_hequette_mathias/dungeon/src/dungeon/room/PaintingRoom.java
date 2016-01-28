package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;
/**
 * @author charlesvaneenoo
 * class PaintingRoom
 */
public class PaintingRoom extends Room {
	/**
	 * constructor PaintingRoom
	 */
	public PaintingRoom(){
		this.canBeLeft=true;
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="a painting room";
		this.description="You are in a painting room, there is just a painting on the wall";
	}
	
	/**
	 *  function interpretCmd permit to go through the painting (secret exit)
	 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1) {
		switch (s){
		case "painting": if (this.adjoiningRooms.containsKey("painting")){
				dungeon.setCurrentRoom(adjoiningRooms.get("painting"));
				System.out.println("You get through the painting");}
		break;
		default:System.out.println("try 'go painting','look' or 'help'");
		}
	}

}
