package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeCesar13Test {

		@Test
		public void getDecalTest() {
			CodeCesar13 cesar = new CodeCesar13();
			assertEquals(13,cesar.getDecal());
		}
			
		@Test
		public void getLabelTest() {
			CodeCesar13 cesar = new CodeCesar13();
			assertEquals("Cesar's Code 13",cesar.getLabel());
		}
		
		/* bug sur transform
		@Test
		public void transformTest() {
			CodeCesar cesar = new CodeCesar(2);
			assertEquals("bcd",cesar.transform("abc"));
		}
		*/

}
