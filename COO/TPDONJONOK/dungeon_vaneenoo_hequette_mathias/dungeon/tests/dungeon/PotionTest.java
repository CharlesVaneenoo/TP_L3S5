package dungeon;

import static org.junit.Assert.*;

import org.junit.Test;

public class PotionTest {
	Player player1 = new Player("Bob", 50);
	Loot potion=new Potion();
	
	@Test
	public void pickTest() {
		assertTrue(player1.isEmptyPotions());
		potion.pick(player1);
		assertEquals(player1.getNbPotions(),1);

	}

}
