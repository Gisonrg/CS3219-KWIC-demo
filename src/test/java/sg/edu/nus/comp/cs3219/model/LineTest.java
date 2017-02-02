package sg.edu.nus.comp.cs3219.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LineTest {
	@Test
	public void testLineGetWord() {
		Line line = new Line("The Day after Tomorrow");
		assertEquals("The", line.getWord(0));
		assertEquals("Tomorrow", line.getWord(3));
	}

	@Test
	public void testLineSetWord() {
		Line line = new Line("The Day after Tomorrow");
		line.setWord(0, "the");
		assertEquals("the", line.getWord(0));
	}

	@Test
	public void testLineGetBeforeAfterIndex() {
		Line line = new Line("The Day after Tomorrow");

		List<String> expectedBefore = Arrays.asList(new String[] { "The", "Day" });
		List<String> expectedAfter = Arrays.asList(new String[] { "after", "Tomorrow" });

		assertEquals(expectedBefore, line.getWordsFromStartToIndex(2));
		assertEquals(expectedAfter, line.getWordsFromIndexToEnd(2));
	}

	@Test
	public void testLineGetBeforeAfterIndex_empty() {
		Line line = new Line("");
		assertTrue(line.getWordsFromStartToIndex(0).isEmpty());
		assertTrue(line.getWordsFromIndexToEnd(0).isEmpty());
	}

	@Test
	public void testLineGetBeforeIndex_singleWord() {
		Line line = new Line("Man");

		List<String> expected = Arrays.asList(new String[] { "Man" });

		assertTrue(line.getWordsFromStartToIndex(0).isEmpty());
		assertEquals(expected, line.getWordsFromIndexToEnd(0));

		assertEquals(expected, line.getWordsFromStartToIndex(1));
		assertTrue(line.getWordsFromIndexToEnd(1).isEmpty());
	}

	@Test
	public void testLineGetBeforeAfterIndex_trimSpaces() {
		Line line = new Line("      Man      ");

		List<String> expected = Arrays.asList(new String[] { "Man" });

		assertTrue(line.getWordsFromStartToIndex(0).isEmpty());
		assertEquals(expected, line.getWordsFromIndexToEnd(0));

		assertEquals(expected, line.getWordsFromStartToIndex(1));
		assertTrue(line.getWordsFromIndexToEnd(1).isEmpty());
	}


}
