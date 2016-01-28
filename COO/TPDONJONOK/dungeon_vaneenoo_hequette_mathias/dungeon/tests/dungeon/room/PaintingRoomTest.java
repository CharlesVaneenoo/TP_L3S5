package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.PaintingRoom;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class PaintingRoomTest {
	Room room=new RoomIntersection();
	Room room2=new PaintingRoom();
	Room room3=new RoomIntersection();

	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		room2.addAdjoiningRoom("painting",room3);		
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		room2.interpretCmd("painting", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room3);
	}

}
