package dungeon;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonsterTest {
	
	Monster monster1 = new Monster(10,10);
	Player player1 = new Player("Pierre",50);
	@Test
	public void hitMonsterTest() {
		monster1.hitMonster(player1);
		assertEquals(player1.getLife(),40);
	}
	
	@Test
	public void isDeadMonster(){
		player1.hitPlayer(monster1);
		assertTrue(monster1.isDeadMonster());
	}

}
