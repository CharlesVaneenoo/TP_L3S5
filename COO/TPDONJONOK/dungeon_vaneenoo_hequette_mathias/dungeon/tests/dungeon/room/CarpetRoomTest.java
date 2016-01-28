package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.CarpetRoom;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class CarpetRoomTest {

	Room room=new RoomIntersection();
	Room room2=new CarpetRoom();
	Room room3=new RoomIntersection();

	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		room2.addAdjoiningRoom("carpet",room3);		
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		room2.interpretCmd("carpet", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room3);
	}
}
