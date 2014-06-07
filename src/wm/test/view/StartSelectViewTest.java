/**
 * Software Engineer lab4
 */
package wm.test.view;

import java.awt.event.MouseEvent;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IReciteProcessController;
import wm.view.StartSelectView;

/**
 * 
 * @author SidneyFan
 *
 */
public class StartSelectViewTest extends WMViewTestCase {

	StartSelectView view;
	IReciteProcessController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpFrame();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		context = new Mockery();
		controller = context.mock(IReciteProcessController.class);
		context.checking(new Expectations() {
			{
				oneOf(controller).switchToStartWordDefine();
			}
		});
		view = new StartSelectView(controller);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(view);
		frame.repaint();
		frame.validate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		view.getStartByCustomBtn().getMouseListeners()[0]
				.mouseClicked(new MouseEvent(view.getStartByCustomBtn(), MouseEvent.MOUSE_CLICKED,
						0, MouseEvent.BUTTON1_DOWN_MASK, 1, 1, 1, false));
		context.assertIsSatisfied();
	}

}
