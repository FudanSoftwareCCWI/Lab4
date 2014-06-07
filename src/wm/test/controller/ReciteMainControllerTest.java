/**
 * Software Engineer lab4
 */
package wm.test.controller;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.SwitchDelegate;
import wm.controller.IReciteMainController;
import wm.controller.ReciteMainController;
import wm.model.IDictionaries;
import wm.view.IReciteMainView;

/**
 * @author Maggie He
 *
 */
public class ReciteMainControllerTest  extends MockObjectTestCase{
	protected static Mockery context;
	protected static SwitchDelegate delegate;
	protected static IReciteMainView view;
	protected static IDictionaries model;
	protected static IReciteMainController controller;
	
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
		view=context.mock(IReciteMainView.class);
		model=context.mock(IDictionaries.class);
		controller=new ReciteMainController(delegate, model);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#showDictionaryDetail(int)}.
	 */
	@Test
	public void testShowDictionaryDetail() {
		//Sequence sequence=context.sequence("");
		context.checking(new Expectations(){
			{
				
			}
		});
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#switchToStartSelect(int)}.
	 */
	@Test
	public void testSwitchToStartSelect() {
		context.checking(new Expectations(){
			{
				oneOf(delegate).getStartWordSelect(0);
			}
		});
		controller.switchToStartSelect(0);
	}

	/**
	 * Test method for {@link wm.controller.ReciteMainController#switchToHome()}.
	 */
	@Test
	public void testSwitchToHome() {
		context.checking(new Expectations(){
			{
				oneOf(delegate).getHome();
			}
		});
	}

}
