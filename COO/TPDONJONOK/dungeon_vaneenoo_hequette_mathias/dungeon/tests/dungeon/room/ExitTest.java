package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.Exit;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class ExitTest {
	Room room=new RoomIntersection();
	Room room2=new Exit();
	
	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		
		assertFalse(dungeon.gameIsFinished());
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		assertTrue(dungeon.gameIsFinished());
		assertTrue(dungeon.gameIsWon());

	}
}
