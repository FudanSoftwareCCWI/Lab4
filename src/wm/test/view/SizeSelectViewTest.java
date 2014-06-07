package wm.test.view;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IReciteProcessController;
import wm.view.SizeSelectView;

public class SizeSelectViewTest extends WMViewTestCase {

	SizeSelectView view;
	IReciteProcessController controller;
	int expected;

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
		expected = 100;
		context.checking(new Expectations() {
			{
				allowing(controller).getAvailableSize();
				will(returnValue(expected * 2));
			}
		});
		view = new SizeSelectView(controller);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(view);
		frame.repaint();
		frame.validate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_pivot_value() {
		int actual = view.getSelectedSize();
		assertEquals(expected, actual);
	}

}
