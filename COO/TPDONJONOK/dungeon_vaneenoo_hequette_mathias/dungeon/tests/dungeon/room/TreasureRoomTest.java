package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Keys;
import dungeon.Loot;
import dungeon.Player;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;
import dungeon.room.TreasureRoom;

public class TreasureRoomTest {
	Loot loot=new Keys();
	Room room=new RoomIntersection();
	Room room2=new TreasureRoom(loot);
	
	
	Player player= new Player("player", 1);
	Dungeon dungeon=new Dungeon(room, player);
	
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		
		assertEquals(player.getNbKeys(),0);
		room2.interpretCmd("pick", dungeon, player);
		assertEquals(player.getNbKeys(),1);
	}

}
