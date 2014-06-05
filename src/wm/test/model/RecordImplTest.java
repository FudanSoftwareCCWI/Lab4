/**
 * Software Engineer lab4
 */
package wm.test.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.model.Dictionaries;
import wm.model.Record;
import wm.model.dao.DictionaryImpl;
import wm.model.dao.RecordImpl;

/**
 * 
 * @author ArielQian
 * 
 */
public class RecordImplTest {
	static RecordImpl recordHolder;
	static Dictionaries dic;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		recordHolder = new RecordImpl();
		DictionaryImpl reader = new DictionaryImpl();
		dic = reader.selectAllDictionay("dictionary.txt");
	}

	/**
	 * Test method for {@link wm.model.dao.RecordImpl#RecordImpl()}.
	 */
	@Test
	public void testRecordImpl() {
		assertNotNull(recordHolder);
	}

	/**
	 * Test method for {@link wm.model.dao.RecordImpl#selectAllRecord()}.
	 */
	@Test
	public void testSelectAllRecord() {
		assertEquals(dic.produceRecord().toString(), recordHolder
				.selectAllRecord().toString());
	}

	/**
	 * Test method for
	 * {@link wm.model.dao.RecordImpl#selectRecordByName(java.lang.String)}.
	 */
	@Test
	public void testSelectRecordByName() {
		assertEquals(dic.getDictionary(0).produceRecord().toString(),
				recordHolder.selectRecordByName("Dictionary A").toString());
	}

	/**
	 * Test method for {@link wm.model.dao.RecordImpl#selectAllRecordList()}.
	 */
	@Test
	public void testSelectAllRecordList() {
		List<Record> allRecord = recordHolder.selectAllRecordList();
		assertEquals(26, allRecord.size());
		for (int i = 0; i < 26; i++) {
			assertEquals(dic.getDictionary(i).produceRecord().toString(),
					allRecord.get(i).toString());
		}
	}
}
