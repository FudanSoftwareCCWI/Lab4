/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import model.UnitRecord;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

import com.sun.tools.javac.code.Attribute.Array;
/**
 * @author apple
 *
 */
@RunWith(Parameterized.class)

public class UnitRecordTest {

	private UnitRecord record;
	private String name;
	private int num;
	
	public UnitRecordTest(Object agrs[]){
		
	}
	
	@Parameters
	public static List<Integer[]> data(){
		return Arrays.asList(new Integer[][]{
				{1,1,1},{2,2,2},{3,3,3}
		});
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		record =  new UnitRecord(name, num);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			double result = record.getCorrectRate();
			assertEquals(0, result,0.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
