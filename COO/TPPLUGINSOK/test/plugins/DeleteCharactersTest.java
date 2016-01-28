package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteCharactersTest {

	@Test
	public void getLabelTest() {
		DeleteCharacters c1 = new DeleteCharacters();
		assertEquals("Delete characters in your text",c1.getLabel());
	}

	@Test /*bug*/
	public void transformTest(){
		DeleteCharacters c1 = new DeleteCharacters();
		assertEquals("",c1.transform("abcwxy"));
		assertEquals("",c1.transform("abc  wxy"));
		assertEquals("012",c1.transform("abcwx012y"));
		assertEquals("1234",c1.transform("ab12cwxy34"));
	}
}
