/**
 * 
 */
package wm.test.controller;

import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.SwitchDelegate;
import wm.controller.ReciteMainController;
import wm.model.Dictionaries;
import wm.view.ReciteMainView;

/**
 * @author hewenqi
 *
 */
public class ReciteMainControllerTest {
	private static Mockery context;
	private static SwitchDelegate delegate;
	private static ReciteMainView view;
	private static Dictionaries model;
	private static ReciteMainController controller;
	
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
		context= new Mockery();
		delegate=context.mock(SwitchDelegate.class);
		view=context.mock(ReciteMainView.class);
		model=context.mock(Dictionaries.class);
		controller=new ReciteMainController(delegate, model);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#ReciteMainController(wm.SwitchDelegate, wm.model.Dictionaries)}.
	 */
	@Test
	public void testReciteMainController() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#showDictionaryDetail(int)}.
	 */
	@Test
	public void testShowDictionaryDetail() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#switchToStartSelect(int)}.
	 */
	@Test
	public void testSwitchToStartSelect() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#switchToHome()}.
	 */
	@Test
	public void testSwitchToHome() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#getView()}.
	 */
	@Test
	public void testGetView() {
		fail("Not yet implemented");
	}

}
