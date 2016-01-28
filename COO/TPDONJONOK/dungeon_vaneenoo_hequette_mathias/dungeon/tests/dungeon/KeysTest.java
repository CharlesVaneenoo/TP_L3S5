package dungeon;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeysTest {
	Player player1 = new Player("Bob", 50);
	Loot key=new Keys();
	
	@Test
	public void pickTest() {
		assertTrue(player1.isEmptyKeys());
		key.pick(player1);
		assertEquals(player1.getNbKeys(),1);

	}
}
