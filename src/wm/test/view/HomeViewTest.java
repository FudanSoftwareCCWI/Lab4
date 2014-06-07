package wm.test.view;

import java.awt.event.MouseEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IHomeController;
import wm.view.HomeView;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.States;

/**
 * <b>HomeViewTest</b>
 * <pre> public class <b>HomeViewTest</b> extends {@link WMViewTestCase} </pre>
 * <blockquote>
 * <p>Tests if mouse click in HomeView invoke corresponding controller. Uses JMock.</p>
 * </blockquote>
 * @author Sidney Fan
 *
 */

public class HomeViewTest extends WMViewTestCase{

	private static HomeView homeView;
	private static IHomeController controller;

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
		controller = context.mock(IHomeController.class);
		homeView = new HomeView(controller);
		final States viewState = context.states("view").startsAs("showing");
		
		context.checking(new Expectations() {
			
			{
				oneOf(controller).switchToRecite();
				when(viewState.is("showing"));
				then(viewState.is("disappear"));
			}
			
		});
		frame.getContentPane().removeAll();
		frame.getContentPane().add(homeView);
		frame.repaint();
		frame.validate();
	}
	
	@After
	public void tearDown() throws Exception {
		controller = null;
		homeView = null;
		context = null;
	}

	@Test
	public void click_and_disappear() {
		homeView.getRecitePanel().getMouseListeners()[0]
				.mouseClicked(new MouseEvent(homeView.getRecitePanel(),
						MouseEvent.MOUSE_CLICKED, 0,
						MouseEvent.BUTTON1_DOWN_MASK, 1, 1, 1, false));
		context.assertIsSatisfied();
	}
	
}
