package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteNumbersTest {

	@Test
	public void getLabelTest() {
		DeleteNumbers n1 = new DeleteNumbers();
		assertEquals("Delete the numbers of your text",n1.getLabel());
	}

	@Test /*bug*/
	public void transformTest(){
		DeleteNumbers n1 = new DeleteNumbers();
		//assertEquals("",n1.transform("123456"));
		//assertEquals("",n1.transform("123 456"));
		assertEquals("abcwxy",n1.transform("a7bc4wx0y"));
		//assertEquals("abcwxy",n1.transform("ab12cwxy34"));
	}
}
