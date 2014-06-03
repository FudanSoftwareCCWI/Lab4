/**
 * ArielQian
 * 2014年6月3日 上午11:16:20
 */
package wm.test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import wm.model.Dictionary;
import wm.model.Word;

/**
 * @author ArielQian
 *
 */
 
public class DictionaryTest {
	static Dictionary dictionary1;
	static Dictionary dictionary2;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		List<Word> words = new ArrayList<Word>();
		words.add(new Word("abandon", "抛弃，放弃", false, false));
		words.add(new Word("abandonment", "放弃", false, false));
		words.add(new Word("abbreviation", "缩写", false, false));
		words.add(new Word("abeyance", "缓办，终止", false, false));
		words.add(new Word("abide", "遵守", false, false));
		words.add(new Word("ability", "能力", false, false));
		words.add(new Word("able", "有能力的，能干的", false, false));
		words.add(new Word("abnormal", "反常的", false, false));
		words.add(new Word("aboard", "船（车）上", false, false));
		words.add(new Word("abolish", "废除，取消", false, false));
		
		dictionary1 = new Dictionary("test1", words);
		dictionary2 = new Dictionary("test2", words, 4);
	}

	/**
	 * Test method for {@link wm.model.Dictionary#Dictionary(java.lang.String, java.util.List)}.
	 */
	@Test
	public void testDictionaryStringListOfWord() {
		assertNotNull(dictionary1);
	}

	/**
	 * Test method for {@link wm.model.Dictionary#Dictionary(java.lang.String, java.util.List, int)}.
	 */
	@Test
	public void testDictionaryStringListOfWordInt() {
		assertNotNull(dictionary2);
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("test1", dictionary1.getName());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertEquals(10, dictionary1.getSize());
	}
	
	/**
	 * Test method for {@link wm.model.Dictionary#getPresentWord()}.
	 */
	@Test
	public void testGetPresentWord() {
		assertEquals(0, dictionary1.getPresentWord());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getMatchWords(java.lang.String)}.
	 */
	@Test
	public void testGetMatchWords() {
		
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getNextKey()}.
	 */
	@Test
	public void testGetNextKey() {
		assertEquals("abandonment", dictionary1.getNextKey());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getNextMeaning()}.
	 */
	@Test
	public void testGetNextMeaning() {
		assertEquals("能力", dictionary2.getNextKey());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#setWordRecited()}.
	 */
	@Test
	public void testSetWordRecited() {
		dictionary1.setWordRecited();
	}
	
	/**
	 * Test method for {@link wm.model.Dictionary#setWordCorrect(boolean)}.
	 */
	@Test
	public void testSetWordCorrect() {
	}
	
	/**
	 * Test method for {@link wm.model.Dictionary#setRecitedSize(int)}.
	 */
	@Test
	public void testSetRecitedSize() {
		
	}

	/**
	 * Test method for {@link wm.model.Dictionary#setStartWord(int)}.
	 */
	@Test
	public void testSetStartWord() {
	}

	/**
	 * Test method for {@link wm.model.Dictionary#calAvailableSize()}.
	 */
	@Test
	public void testCalAvailableSize() {
		dictionary2.setStartWord(4);
		assertEquals(6, dictionary2.calAvailableSize());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#produceRecord()}.
	 */
	@Test
	public void testProduceRecord() {
		
	}

	/**
	 * Test method for {@link wm.model.Dictionary#produceRecord(int, int)}.
	 */
	@Test
	public void testProduceRecordIntInt() {
		
	}

}
