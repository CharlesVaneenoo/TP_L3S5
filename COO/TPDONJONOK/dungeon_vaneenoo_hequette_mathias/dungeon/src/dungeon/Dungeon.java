package dungeon;

import java.util.Map.Entry;
import java.util.Scanner;

import dungeon.room.Room;

/**
 * The class Dungeon
 */
public class Dungeon {
	private Player player;
	protected Room currentRoom;
	protected Room previousRoom;
	protected boolean gameIsFinished = false;
	protected final Scanner scanner = new Scanner(System.in);
  
 /**
  * The Constructor Dungeon
  * @param start : the begin room
  * @param player : the player who plays in the dungeon
  */
	
  public Dungeon(Room start, Player player){	
	  this.currentRoom=start;
	  this.player = player;
	  this.previousRoom=null;
  }
  
  /**
   * The function getCurrentRoom
   * @return The current room
   */
  public Room getCurrentRoom() {
    return currentRoom;
}
  
  /**
   * The function setCurrentRoom allow to change the Current room in the game
   * @param newroom : the new room
   */
  public void setCurrentRoom(Room newroom){
	  this.previousRoom=this.currentRoom;
	  this.currentRoom = newroom;
  }

  /**
   * The function printPossibleDirections prints the different directions possible
   */
	public void printPossibleDirections(){
		for(Entry<String, Room> entry : this.currentRoom.getAdjoiningRooms().entrySet()){
			String direction=entry.getKey();
			Room room = entry.getValue();
			System.out.println("There is "+room.getPreview()+ " on the "+ direction);
		}
	}
	
	
/**
 * 	The function interpretCommand
 * @param command : allow users to move and interact with the game 
 */
  public void interpretCommand(String command) {	  
    switch (command) {
    // direction
    case "go north": 
    	if(currentRoom.getCanBeLeft()){
    	currentRoom.interpretCmd("north",this, player);}
    	else {System.out.println("it's blocked");}
    	break;
    case "go east": 
    	if(currentRoom.getCanBeLeft()){
    	currentRoom.interpretCmd("east",this, player);}
    	else {System.out.println("it's blocked");}
    	break;
    case "go south":
    	if(currentRoom.getCanBeLeft()){
    	currentRoom.interpretCmd("south",this, player);}
    	else {System.out.println("it's blocked");}
    	break;
    case "go west":
    	if(currentRoom.getCanBeLeft()){
    	currentRoom.interpretCmd("west",this, player);}
    	else {System.out.println("it's blocked");}
    	break;
    //action
    case "look": System.out.println(currentRoom.getDescription());
    							printPossibleDirections();
    	break;
    case "hit": currentRoom.interpretCmd("hit",this, player);
    	break;
    case "push": currentRoom.interpretCmd("push",this, player);
	break;
    case "help": System.out.println("Possible actions:\ngo [direction or back or painting or carpet]\nhit\nlook\nstat\nuse potion\nuse key\npush\npick");
    	break;
    case "pick": currentRoom.interpretCmd("pick",this, player);
		break;
    case "go carpet": currentRoom.interpretCmd("carpet",this, player);
   	break;
    case "go painting": currentRoom.interpretCmd("painting",this, player);
   	break;
    case "stat": System.out.println("Player: "+player.getName()+"\nLife: "+player.getLife()+"\nWeapon: "+player.getWeapon().getDescription()+"\nStrength: "+player.getWeapon().getPower()+"\nPotions :"+player.getNbPotions()+"\nKeys: "+player.getNbKeys()+"\n");
    break;
    case "go back":if (this.previousRoom != null){
    				this.setCurrentRoom(this.previousRoom);
    				}else System.out.println("you can't go back");
    break;
    case "use potion":player.usePotion();
    break;
    case "use key":player.useKey(this);
    break;
    default:
      System.out.println("I don’t know what you mean");
    }
}
  
 /**
  * The function start permit to begin the game dungeon and it looks if the game is done or not
  */
  public void start() {
    do {
      System.out.println("You are in " + getCurrentRoom().getPreview());
      System.out.println("What do you want to do?");
      System.out.print("> ");
      // Read a command from the user (stdin)
      String line = scanner.nextLine();
      interpretCommand(line);
} while (!gameIsFinished());
System.out.println("You are " + getCurrentRoom().getPreview());
    if (gameIsWon()) {
      System.out.println("You win!");
    } else {
      System.out.println("You loose!");
    }
}
  
  
  /**
   * the function gameIsFinished
   * @return a boolean : if the game is finished or not
   */
  public boolean gameIsFinished() {
	    return gameIsLost() || gameIsWon();
	}
  
  /**
   * the function gameIsLost
   * @return a boolean : if the game is lost
   */
  public boolean gameIsLost() {
    return (currentRoom.getPreview().equals("in end of game"))||(currentRoom.getPreview().equals("dead"))||(currentRoom.getPreview().equals("trapped"));
}
  
  /**
   * function goToNextDungeon allow to access  to next level
   * @param nextdungeon
   */
  public void goToNextDungeon(Dungeon nextdungeon){
	  if (gameIsWon()){
		  System.out.print("Good job you go to the next level\n -----------------------------\n");
		  nextdungeon.start();
  }
  }
  
  /**
   * the function GameIsWon
   * @return a boolean : if the game is won
   */
  public boolean gameIsWon() {
    return currentRoom.getPreview().equals("exit");
} }
