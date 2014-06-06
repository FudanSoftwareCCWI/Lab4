/**
 * Software Engineer lab4
 */
package wm.test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import wm.model.Dictionaries;
import wm.model.Dictionary;
import wm.model.dao.DictionaryImpl;

/**
 * @author ArielQian
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DictionaryImplTest {
	static Dictionaries dic;
	static DictionaryImpl reader;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reader = new DictionaryImpl();
		dic = reader.selectAllDictionay("dictionary.txt");
	}

	/**
	 * Test method for {@link wm.model.dao.DictionaryImpl#selectAllDictionay(java.lang.String)}.
	 */
	@Test
	public void testSelectAllDictionay() {
		Dictionary dictionary = dic.getDictionary(0);
		assertEquals(26, dic.getDicNumber());
		assertEquals("abandon", dictionary.getKey(0));
		dictionary.setWordRecited();
		dictionary.setWordCorrect(true);
	}

	/**
	 * Test method for {@link wm.model.dao.DictionaryImpl#updateAllDictionary(wm.model.Dictionaries)}.
	 */
	@Test
	public void testUpdateAllDictionary() {
		reader.updateAllDictionary(dic);
		dic = reader.selectAllDictionay("dictionary.txt");
		Dictionary dictionary = dic.getDictionary(0);
		assertEquals(true, dictionary.getWordCorrect(0));
		assertEquals(true, dictionary.getWordRecited(0));
	}

}
