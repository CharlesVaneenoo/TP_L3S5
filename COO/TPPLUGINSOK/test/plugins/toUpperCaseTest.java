package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class toUpperCaseTest {

	@Test
	public void getLabelTest() {
		toUpperCase up1 = new toUpperCase();
		assertEquals("Transform your text in upper case",up1.getLabel());
	}

	@Test
	public void transformTest(){
		toUpperCase up1 = new toUpperCase();
		assertEquals("ABCDEF",up1.transform("abcDEF"));
		assertEquals("A1A2A3",up1.transform("a1a2a3"));
	}
}
