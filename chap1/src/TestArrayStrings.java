import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class TestArrayStrings {

	@Test
	public void testUnique() {
		fail("Not yet implemented");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSort() {
		String s = "bcad";
		char[] t = s.toCharArray();
		ArrayStrings.sort(t, 0, 4);
		assert(true);
		Assert.assertEquals("abcd", String.valueOf(t));
	}

	@Test
	public void testUniqueness() {
		fail("Not yet implemented");
	}

	@Test
	public void testRevert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDuplicate() {
		fail("Not yet implemented");
	}

}
