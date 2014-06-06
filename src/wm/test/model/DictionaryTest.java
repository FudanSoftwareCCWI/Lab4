/**
 * Software Engineer lab4
 */
package wm.test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import wm.model.Dictionary;
import wm.model.Record;
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
		assertEquals(4, dictionary2.getPresentWord());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getMatchWords(java.lang.String)}.
	 */
	@Test
	public void testGetMatchWords() {
		String match="aba";
		List<String> result = dictionary1.getMatchWords(match);
		assertEquals(2, result.size());
		assertEquals("abandon", result.get(0));
		assertEquals("abandonment", result.get(1));
	
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getNextKey()}.
	 */
	@Test
	public void testGetNextKey() {
		assertEquals("abandon", dictionary1.getNextKey());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#getNextMeaning()}.
	 */
	@Test
	public void testGetNextMeaning() {
		assertEquals("遵守", dictionary2.getNextMeaning());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#calAvailableSize()}.
	 */
	@Test
	public void testCalAvailableSize() {
		dictionary2.setStartWord("abide");
		assertEquals(6, dictionary2.calAvailableSize());
	}

	/**
	 * Test method for {@link wm.model.Dictionary#produceRecord()}.
	 */
	@Test
	public void testProduceRecord() {
		dictionary1.setPresentWord(5);
		dictionary1.setWordRecited();
		dictionary1.setWordCorrect(true);
		Record record = dictionary1.produceRecord();
		assertEquals(1, record.getRecitedSize());
		assertEquals(0, record.getWrong());
		assertEquals(10, record.getTotalSize());
		
	}

	/**
	 * Test method for {@link wm.model.Dictionary#produceRecord(int, int)}.
	 */
	@Test
	public void testProduceRecordIntInt() {
		dictionary1.setPresentWord(5);
		dictionary1.setWordRecited();
		dictionary1.setWordCorrect(true);
		Record record = dictionary1.produceRecord(2, 5);
		assertEquals(1, record.getRecitedSize());
		assertEquals(0, record.getWrong());
		assertEquals(4, record.getTotalSize());
	}

}
