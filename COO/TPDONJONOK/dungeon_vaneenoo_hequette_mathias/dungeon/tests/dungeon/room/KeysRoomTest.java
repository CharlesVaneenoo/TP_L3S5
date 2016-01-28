package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.KeysRoom;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class KeysRoomTest {
	
	Room room=new KeysRoom();
	Room room2=new RoomIntersection();
	
	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("west",room2);
		
		assertEquals(dungeon.getCurrentRoom(),room);
		dungeon.interpretCommand("go west");
		assertEquals(dungeon.getCurrentRoom(),room);
		player.addKeys();
		assertFalse(player.isEmptyKeys());
		room.interpretCmd("west", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
	}

}
