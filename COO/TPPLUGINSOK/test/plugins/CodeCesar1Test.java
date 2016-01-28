package plugins;

import static org.junit.Assert.*;
import org.junit.Test;

public class CodeCesar1Test {

	@Test
	public void getDecalTest() {
		CodeCesar1 cesar = new CodeCesar1();
		assertEquals(1,cesar.getDecal());
	}
		
	@Test
	public void getLabelTest() {
		CodeCesar1 cesar = new CodeCesar1();
		assertEquals("Cesar's Code 1",cesar.getLabel());
	}
	
	/* bug sur transform
	@Test
	public void transformTest() {
		CodeCesar cesar = new CodeCesar(2);
		assertEquals("bcd",cesar.transform("abc"));
	}
	*/


}


