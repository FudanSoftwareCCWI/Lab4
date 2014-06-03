/**
 * 
 */
package wm.view.test;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IReciteProcessController;
import wm.view.StartSelectView;
import wm.view.StartWordDefineView;

/**
 * @author Sidney Fan
 * 
 */
public class StartWordDefineViewTest extends WMViewTestCase {

	StartWordDefineView view;
	IReciteProcessController controller;

	static ArrayList<String> result;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpFrame();
		result = new ArrayList<String>();
		result.add("abandon");
		result.add("abase");
		result.add("abash");
		result.add("abate");
		result.add("abbreviate");
		result.add("abdicate");
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
		context = new Mockery();
		controller = context.mock(IReciteProcessController.class);
		context.checking(new Expectations() {
			{
				allowing(controller).getAvailableWordList(
						with(any(String.class)));
				will(returnValue(result));
			}
		});
		view = new StartWordDefineView(controller);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(view);
		frame.repaint();
		frame.validate();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		while (true) {
		}
	}
}
