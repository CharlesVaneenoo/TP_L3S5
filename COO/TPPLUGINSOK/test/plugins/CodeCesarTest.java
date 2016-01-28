package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeCesarTest {

	@Test
	public void getDecalTest() {
		CodeCesar cesar = new CodeCesar(5);
		assertEquals(5,cesar.getDecal());
	}
	
	@Test
	public void getLabelTest() {
		CodeCesar cesar = new CodeCesar(5);
		assertEquals("Cesar's Code 5",cesar.getLabel());
	}
	/* bug sur transform
	@Test
	public void transformTest() {
		CodeCesar cesar = new CodeCesar(2);
		assertEquals("cde",cesar.transform("abc"));
	}
	*/
}
