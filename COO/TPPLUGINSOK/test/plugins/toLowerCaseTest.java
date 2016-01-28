package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class toLowerCaseTest {

	@Test
	public void getLabelTest() {
		toLowerCase low1 = new toLowerCase();
		assertEquals("Transform your text in lower case",low1.getLabel());
	}

	@Test
	public void transformTest(){
		toLowerCase low1 = new toLowerCase();
		assertEquals("abcdef",low1.transform("abcDEF"));
		assertEquals("a1a2a3",low1.transform("A1A2A3"));
	}

}
