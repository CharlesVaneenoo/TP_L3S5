package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;

/**
 * 
 * @author charlesvaneenoo
 * class KeysRoom
 */
public class KeysRoom extends Room {
	
	
	/**
	 * constructor of KeysRoom
	 */
	public KeysRoom(){
		this.canBeLeft=false;
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="a locked room";
		this.description="You are on a locked room, you should open the door!";
	}
	
/**
 * the function interpretCmd works only if the player have a key with him else the access is refused
 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1) {
		switch (s){
		//direction
		case "north": if (this.adjoiningRooms.containsKey("north")){
			dungeon.setCurrentRoom(adjoiningRooms.get("north"));
			System.out.println("You move to north");
			}
		else {
			System.out.println("They are no room in this side, try another direction !");}
		break;
		case "east": if (this.adjoiningRooms.containsKey("east")){
			dungeon.setCurrentRoom(adjoiningRooms.get("east"));
			System.out.println("You move to east");
		}
		else {
			System.out.println("They are no room in this side, try another direction !");}
		break;	
		case "south": if (this.adjoiningRooms.containsKey("south")){
			dungeon.setCurrentRoom(adjoiningRooms.get("south"));
			System.out.println("You move to south");
		}
		else {
			System.out.println("They are no room in this side, try another direction !");}
		break;	
		case "west": if (this.adjoiningRooms.containsKey("west")){
			dungeon.setCurrentRoom(adjoiningRooms.get("west"));
			System.out.println("You move to west");
		}
		else {
			System.out.println("They are no room in this side, try another direction !");}
		break;	
		default:System.out.println("Try another direction");
		}
	
	}

		
		
}



