package dungeon.room;

import java.util.HashMap;

import dungeon.Dungeon;
import dungeon.Loot;
import dungeon.Player;
/**
 * Class TreasureRoom
 */
public class TreasureRoom extends Room{
		private Loot loot;
		private boolean alreadyPicked;
	
		/**
		 * constructor of TreasureRoom
		 * @param l a loot 
		 */
		public TreasureRoom(Loot l){
			this.loot=l;
			this.alreadyPicked=false;
			this.canBeLeft=true;
			this.adjoiningRooms=new HashMap<String,Room>();
			this.preview="a treasure room";
			this.description="You are on a treasure room, there is something you should pick on the floor.";
		}
	
		/**
		 *  function interpretCmd allow to take a loot and to go in the next room
		 */
		public void interpretCmd(String s, Dungeon dungeon, Player player1) {
			switch (s){
			// pick a loot
			case "pick":if (!this.alreadyPicked){
							loot.pick(player1);
							this.alreadyPicked=true;
							System.out.println("you picked "+ loot.getDescription());
						}else{
							System.out.println("there is nothing else here.");
						}
			break;
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
			default:System.out.println("Try another order or 'pick'");
			}
			
		}

}
