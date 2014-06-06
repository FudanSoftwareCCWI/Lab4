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
		DictionaryImpl reader = new DictionaryImpl();
		dic = reader.selectAllDictionay("dictionary.txt");
		recordHolder = new RecordImpl();
	}

	/**
	 * Test method for {@link wm.model.dao.RecordImpl#RecordImpl()}.
	 */
	@Test
	public void testRecordImpl() {
		assertNotNull(recordHolder);
	}

	
}
