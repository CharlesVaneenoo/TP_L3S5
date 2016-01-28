package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteVowelsTest {

	@Test
	public void getLabelTest() {
		DeleteVowels v1 = new DeleteVowels();
		assertEquals("Delete voyel(s) in your text",v1.getLabel());
	}

	@Test /*bug*/
	public void transformTest(){
		DeleteVowels v1 = new DeleteVowels();
		assertEquals("bcd",v1.transform("abcde"));
		assertEquals("",v1.transform("aaaaaiiiiii"));
	}
}
