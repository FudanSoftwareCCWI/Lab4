/**
 * Software Engineer lab4
 */
package wm.test.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
import wm.model.Dictionaries;
import wm.model.Dictionary;
import wm.model.Word;
import wm.view.WMView;

/**
 * @author Maggie He
 *
 */
public class ReciteMainControllerTest {
	private Mockery context;
	private IReciteMainController controller;
	private SwitchDelegate delegate;
	private Dictionaries model; 
	private Dictionary d1;
	private Dictionary d2;
	
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
		context=new Mockery();
		delegate=context.mock(SwitchDelegate.class);
		d1=new Dictionary("d1", new ArrayList<Word>());
		d2=new Dictionary("d2", new ArrayList<Word>());
		List<Dictionary>list=new ArrayList<Dictionary>();
		list.add(d1);
		list.add(d2);
		model=new Dictionaries(list);
		controller=new ReciteMainController(delegate,model);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
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
		controller.switchToHome();
	}

	@Test
	public void testGetView(){
		WMView view=controller.getView();
		assertTrue(view!=null);
	}
}
