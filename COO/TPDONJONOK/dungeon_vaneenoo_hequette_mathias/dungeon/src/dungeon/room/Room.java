package dungeon.room;
import java.util.Map;
import dungeon.Dungeon;
import dungeon.Player;

/**
 * 
 */

/**
 * @author jeremy
 * Abstract class Room
 */
public abstract class Room {
	protected boolean canBeLeft;
	protected Map<String,Room> adjoiningRooms;
	protected String preview;
	protected String description;
	
	/* the function getDescription
	 * @return the description of a room
	 */
	public String getDescription(){
		return this.description;
	}
	
	/* the function getPreview
	 * @return the preview of a room
	 */
	public String getPreview(){
		return this.preview;
	}
	/**
	 * the function tell if a room can be left
	 * @return a boolean canBeLeft
	 */
	public boolean getCanBeLeft(){
		return this.canBeLeft;
	}
	
	/**
	 * the fonction can change if the room can be change or not 
	 * @param bool
	 */
	public void setCanBeLeft(boolean bool){
		this.canBeLeft=bool;
	}
	
	/**
	 *  abstract function interpretCmd
	 */
	public abstract void interpretCmd(String s,Dungeon dungeon, Player player1);

	/**
	 * this function permit to add a room on the hand of the current room
	 * @param dir the direction
	 * @param room the next room in the direction dir
	 */
	public void addAdjoiningRoom(String dir,Room room){
		this.adjoiningRooms.put(dir,room);
	}
	
	/**
	 * the function getAdjoiningRooms
	 * @return this room who is around the current room
	 */
	public Map<String,Room> getAdjoiningRooms(){
		return this.adjoiningRooms;
	}
}
