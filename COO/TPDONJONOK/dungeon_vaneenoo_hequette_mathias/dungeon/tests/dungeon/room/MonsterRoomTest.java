package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.Dungeon;
import dungeon.Monster;
import dungeon.Player;
import dungeon.room.MonsterRoom;
import dungeon.room.Room;
import dungeon.room.RoomIntersection;

public class MonsterRoomTest {

	Monster monster=new Monster(20,10);
	Room room=new RoomIntersection();
	Room room3=new RoomIntersection();
	Room room2=new MonsterRoom(monster);
	
	
	Player player= new Player("player", 20);
	Dungeon dungeon=new Dungeon(room, player);
	
	
	@Test
	public void InterpretCmdTest(){	
		room.addAdjoiningRoom("north",room2);
		room2.addAdjoiningRoom("north",room3);

		assertEquals(dungeon.getCurrentRoom(),room);
		room.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room2);
		assertFalse(room2.getCanBeLeft());
		
		room2.interpretCmd("hit", dungeon, player);
		assertEquals(monster.getLife(),10);
		assertEquals(player.getLife(),10);
		room2.interpretCmd("hit", dungeon, player);
		assertTrue(monster.isDeadMonster());
		assertEquals(player.getLife(),10);
		assertTrue(room2.getCanBeLeft());

		room2.interpretCmd("north", dungeon, player);
		assertEquals(dungeon.getCurrentRoom(),room3);

	}

}
