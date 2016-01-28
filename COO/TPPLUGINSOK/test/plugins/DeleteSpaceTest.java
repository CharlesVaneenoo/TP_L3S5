package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteSpaceTest {

	@Test
	public void getLabelTest() {
		DeleteSpace sp1 = new DeleteSpace();
		assertEquals("Delete the space in your text",sp1.getLabel());
	}

	@Test /*bug*/
	public void transformTest(){
		DeleteSpace sp1 = new DeleteSpace();
		assertEquals("",sp1.transform("abcwxy"));
		assertEquals("abcwxy",sp1.transform("abc  wxy"));
		assertEquals("abc",sp1.transform("a b c"));
	}
}
