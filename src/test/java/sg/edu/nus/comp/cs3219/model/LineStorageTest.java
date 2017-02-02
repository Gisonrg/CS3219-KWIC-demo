package sg.edu.nus.comp.cs3219.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LineStorageTest {
	LineStorage storage = new LineStorage();

	@Before
	public void setUp() {
		storage = new LineStorage();
	}

	@Test
	public void testAddLines() {
		storage.addLine("The Day after Tomorrow");
		storage.addLine("Fast and Furious");
		storage.addLine("Man of Steel");

		assertEquals(3, storage.size());
	}

	@Test
	public void testLastIndex() {
		storage.addLine("The Day after Tomorrow");
		assertEquals(0, storage.getLastIndex());
		storage.addLine("Fast and Furious");
		assertEquals(1, storage.getLastIndex());
		storage.addLine("Man of Steel");
		assertEquals(2, storage.getLastIndex());
	}

	@Test
	public void testDelete() {
		storage.addLine("The Day after Tomorrow");
		storage.addLine("Fast and Furious");
		storage.addLine("Man of Steel");
		assertEquals(3, storage.size());

		storage.delete(1);
		assertEquals("Man", storage.get(1).getWord(0));
		assertEquals(2, storage.size());
	}
}
