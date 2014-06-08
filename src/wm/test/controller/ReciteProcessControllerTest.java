/**
 * Software Engineer lab4
 */
package wm.test.controller;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.SwitchDelegate;
import wm.controller.IReciteProcessController;
import wm.controller.ReciteProcessController;
import wm.model.Dictionary;
import wm.model.Word;

/**
 * @author Maggie He
 *
 */
public class ReciteProcessControllerTest {
	private Mockery context;
	private IReciteProcessController controller;
	private SwitchDelegate delegate;
	private Dictionary model;
	private Word w1;
	private Word w2;
	private Word w3;
	private Word w4;
	
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
		Class<ReciteProcessController>controllerClass=(Class<ReciteProcessController>) Class.forName("wm.controller.ReciteProcessController");
		Field f=controllerClass.getField("presentWord");
		f.setAccessible(true);
		f.get(controller);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#startByFirstWord()}.
	 */
	@Test
	public void testStartByFirstWord() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#startByLastTime()}.
	 */
	@Test
	public void testStartByLastTime() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#startByInput(java.lang.String)}.
	 */
	@Test
	public void testStartByInput() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#switchToStartWordDefine()}.
	 */
	@Test
	public void testSwitchToStartWordDefine() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#getAvailableWordList(java.lang.String)}.
	 */
	@Test
	public void testGetAvailableWordList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#getAvailableSize()}.
	 */
	@Test
	public void testGetAvailableSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#setReciteSize(int)}.
	 */
	@Test
	public void testSetReciteSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#checkCorrect(java.lang.String)}.
	 */
	@Test
	public void testCheckCorrect() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#switchToHome()}.
	 */
	@Test
	public void testSwitchToHome() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#getView()}.
	 */
	@Test
	public void testGetView() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteProcessController#closeWindow()}.
	 */
	@Test
	public void testCloseWindow() {
		fail("Not yet implemented");
	}

}
