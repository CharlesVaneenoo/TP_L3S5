package dungeon;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.room.KeysRoom;
import dungeon.room.Room;

public class PlayerTest {
	
	Player player1 = new Player("Bob", 50);
	Monster monster = new Monster(50,10);
	
	

	@Test
	public void isDeadTest(){
		assertFalse(player1.isDeadPlayer());
		player1.setLife(0);
		assertTrue(player1.isDeadPlayer());
	}
	
	@Test
	public void KeyManipulationTest(){
		assertEquals(player1.getNbKeys(),0);
		player1.addKeys();
		assertFalse(player1.isEmptyKeys());
		assertEquals(player1.getNbKeys(),1);
		player1.removeKeys();
		assertTrue(player1.isEmptyKeys());
	}
	
	@Test
	public void PotionManipulationTest(){
		assertEquals(player1.getNbPotions(),0);
		player1.addPotions();
		assertFalse(player1.isEmptyPotions());
		assertEquals(player1.getNbPotions(),1);
		player1.removePotion();
		assertTrue(player1.isEmptyPotions());
	}
	
	@Test
	public void hitPlayerTest(){
		player1.hitPlayer(monster);
		assertEquals(monster.getLife(),40);
	}
	
	@Test
	public void usePotionTest(){
		assertEquals(player1.getLife(),50);
		player1.usePotion();
		assertEquals(player1.getLife(),50);
		player1.addPotions();
		player1.usePotion();
		assertEquals(player1.getLife(),100);
	}
	
	@Test
	public void useKeyTest(){
		Room room=new KeysRoom();
		Dungeon dungeon=new Dungeon(room, player1);
		assertFalse(dungeon.getCurrentRoom().getCanBeLeft());
		player1.addKeys();
		dungeon.interpretCommand("use key");
		assertTrue(dungeon.getCurrentRoom().getCanBeLeft());
		assertTrue(player1.isEmptyKeys());
	}

}
