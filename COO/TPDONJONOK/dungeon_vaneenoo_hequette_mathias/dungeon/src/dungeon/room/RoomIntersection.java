/**
 * 
 */
package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;

/**
 * @author jeremy
 *
 */
public class RoomIntersection extends Room{
	/**
	 * constructor of RoomIntersection
	 */
	public RoomIntersection(){
		this.canBeLeft=true;
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="a room";
		this.description="You are on an intersection, there is nothing suspicious here.";
	}
	
	/**
	 *  function interpretCmd permit to direct the player through the room
	 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1){
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
