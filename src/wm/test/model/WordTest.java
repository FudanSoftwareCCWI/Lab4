/**
 * Software Engineer lab4
 */
package wm.test.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import wm.model.Word;

/**
 * @author ArielQian
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WordTest {
	static Word word;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		word = new Word("a", "一个", false, false);
	}

	/**
	 * Test construction method.
	 * {@link wm.model.Word#Word(java.lang.String, java.lang.String, boolean, boolean)}
	 * .
	 */
	@Test
	public void testWord() {
		assertNotNull(word);
	}

	/**
	 * Test method for {@link wm.model.Word#isRecited()}.
	 */
	@Test
	public void testIsRecited() {
		assertEquals(false, word.isRecited());
	}

	/**
	 * Test method for {@link wm.model.Word#setRecited(boolean)}.
	 */
	@Test
	public void testSetRecited() {
		word.setRecited(true);
		assertEquals(true, word.isRecited());
	}

	/**
	 * Test method for {@link wm.model.Word#isCorrect()}.
	 */
	@Test
	public void testIsCorrect() {
		assertEquals(false, word.isCorrect());
	}

	/**
	 * Test method for {@link wm.model.Word#setCorrect(boolean)}.
	 */
	@Test
	public void testSetCorrect() {
		word.setCorrect(true);
		assertEquals(true, word.isCorrect());
	}

	/**
	 * Test method for {@link wm.model.Word#getKey()}.
	 */
	@Test
	public void testGetKey() {
		assertEquals("a", word.getKey());
	}

	/**
	 * Test method for {@link wm.model.Word#getMeaning()}.
	 */
	@Test
	public void testGetMeaning() {
		assertEquals("一个", word.getMeaning());
	}

}
