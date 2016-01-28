package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.ButtonRoom;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class ButtonRoomTest {

	Room room=new RoomIntersection();
	Room room2=new ButtonRoom();
	Room room3=new RoomIntersection();
	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		room2.addAdjoiningRoom("west",room3);
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		room2.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		assertFalse(room2.getCanBeLeft());
		room2.interpretCmd("push", dungeon, player);
		assertTrue(room2.getCanBeLeft());
		room2.interpretCmd("west", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room3);
	}
}
