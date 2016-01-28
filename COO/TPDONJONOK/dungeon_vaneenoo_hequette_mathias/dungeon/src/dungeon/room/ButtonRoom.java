package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Player;
/**
 * this is the class ButtonRoom
 *
 */
public class ButtonRoom extends Room{

	/**
	 * the constructor of ButtonRoom
	 */
	public ButtonRoom(){
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="a button room";
		this.description="You are in a room, there is a button to push";
		this.canBeLeft=false;
	}
	
	/**
	 *  function interpretCmd
	 */
	public void interpretCmd(String s, Dungeon dungeon, Player player1) {
		switch (s){
			//push the button for unlock the exit of the room
			case "push": if (this.canBeLeft== false){
					this.canBeLeft=true;
					System.out.println("You push the button, something happened");
				}
				else{
					System.out.println("The button is already push");
				}
			break;
			//direction only if button is pushed
			case "north": if (this.adjoiningRooms.containsKey("north")&&(this.canBeLeft)){
					dungeon.setCurrentRoom(adjoiningRooms.get("north"));
					System.out.println("You move to north");
					}
				else { if (this.canBeLeft== false){
							System.out.println("Try push!");}
					  else{
						  	System.out.println("They are no room in this side, try another direction !");}
				}
			break;
			case "east": if (this.adjoiningRooms.containsKey("east")&&(this.canBeLeft)){
					dungeon.setCurrentRoom(adjoiningRooms.get("east"));
					System.out.println("You move to east");
				}
				else {
					 if (this.canBeLeft== false){
							System.out.println("Try push!");}
					  else{
						  	System.out.println("They are no room in this side, try another direction !");}
				}
			break;	
			case "south": if (this.adjoiningRooms.containsKey("south")&&(this.canBeLeft)){
					dungeon.setCurrentRoom(adjoiningRooms.get("south"));
					System.out.println("You move to south");
				}
				else {
					 if (this.canBeLeft== false){
							System.out.println("Try push!");}
					  else{
						  	System.out.println("They are no room in this side, try another direction !");}
				}
			break;	
			case "west": if (this.adjoiningRooms.containsKey("west")&&(this.canBeLeft)){
					dungeon.setCurrentRoom(adjoiningRooms.get("west"));
					System.out.println("You move to west");
				}
				else {
					 if (this.canBeLeft== false){
							System.out.println("Try 'push'!");}
					  else{
						  	System.out.println("They are no room in this side, try another direction !");}
				}
			break;	
			default:System.out.println("Try 'push' or a direction");
	}

		}

	}

