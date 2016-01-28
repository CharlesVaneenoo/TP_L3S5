package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;
import dungeon.room.Trap;

public class TrapTest {

	Room room=new RoomIntersection();
	Room roomTrap=new Trap();
	
	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	@Test
	public void getCanBeLeftTest(){
		assertFalse(roomTrap.getCanBeLeft());
	}

	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",roomTrap);
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertTrue(dungeon.gameIsLost());
	}

}
