package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class RoomIntersectionTest {

	Room room=new RoomIntersection();
	Room room2=new RoomIntersection();
	
	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	@Test
	public void getCanBeLeftTest(){
		assertTrue(room.getCanBeLeft());
	}

	@Test
	public void addAdjoiningRoomsTest(){
		room.addAdjoiningRoom("north",room2);
		assertTrue(room.getAdjoiningRooms().containsKey("north"));
		assertFalse(room.getAdjoiningRooms().containsKey("west"));
	}
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		room2.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);

	}
	
	
	
}
