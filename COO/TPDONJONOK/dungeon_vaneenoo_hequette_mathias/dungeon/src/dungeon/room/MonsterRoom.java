package dungeon.room;

import java.util.HashMap;
import dungeon.Dungeon;
import dungeon.Monster;
import dungeon.Player;
/**
 * class Monster Room 
 */
public class MonsterRoom extends Room{
	private Monster monster1;
	//public Monster monster1= new Monster(100,100);
	//public Monster monster1= new Monster(1000,1000);
	
	/**
	 * constructor of MonsterRoom
	 * @param monster a monster for this room
	 */
	public MonsterRoom(Monster monster){
		this.monster1=monster;
		this.canBeLeft=false;
		this.adjoiningRooms=new HashMap<String,Room>();
		this.preview="a monster room";
		this.description="You are in a monster room";

	}
		
	/**
	 *  function interpretCmd when the player is in a MonsterRoom
	 */											
	public void interpretCmd(String s, Dungeon dungeon,Player player1){
		switch (s){
		// hit the fight begin
			case "hit": 
				// case monster is alive
				if (monster1.isDeadMonster()==false){ 
					player1.hitPlayer(monster1); 
					System.out.println("You hit the monster");
				}
				// case monster isn't alive
				if (monster1.isDeadMonster()==true){
						System.out.println("The monster is KO");
						this.setCanBeLeft(true);
				}
				else { 
						System.out.println("The monster isn't KO and he hits you");
						monster1.hitMonster(player1); 
						if(player1.isDeadPlayer()==true){
						this.preview="dead";
						}
				}
				break;
				//direction only if the monster is dead
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
			default:System.out.println("Try 'hit'");
		}

	}
}



