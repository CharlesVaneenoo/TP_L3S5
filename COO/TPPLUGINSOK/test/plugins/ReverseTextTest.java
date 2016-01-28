package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseTextTest {

	@Test
	public void getLabelTest() {
		ReverseText t1 = new ReverseText();
		assertEquals("Reverse text",t1.getLabel());
	}

	@Test
	public void transformTest(){
		ReverseText t1 = new ReverseText();
		assertEquals("edcba",t1.transform("abcde"));
		assertEquals("654321",t1.transform("123456"));
	}

}
