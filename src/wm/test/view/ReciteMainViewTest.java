package wm.test.view;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IReciteMainController;
import wm.view.ReciteMainView;

public class ReciteMainViewTest extends WMViewTestCase {

	private static ReciteMainView reciteMainView;
	private static IReciteMainController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpFrame();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	public static List<String> getNameList() {
		ArrayList<String> r = new ArrayList<String>();
		for (int i = 0; i < 26; i++) {
			r.add(String.format("Dictionary %c", (char) ('A' + i)));
		}
		return r;
	}

	@Before
	public void setUp() throws Exception {
		context = new Mockery();
		controller = context.mock(IReciteMainController.class);
		reciteMainView = new ReciteMainView((IReciteMainController) controller);
		reciteMainView.setListPanelContent(getNameList());

		frame.getContentPane().removeAll();
		frame.getContentPane().add(reciteMainView);
		frame.repaint();
		frame.validate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		reciteMainView.setCurrentDictIndex(0);
		reciteMainView.setNameLabelText("词库A");
		reciteMainView.setPieIcon(237,2000);
	}

	@Test
	public void test_setCurrentDictIndex() {
		int expect = 2;
		reciteMainView.setCurrentDictIndex(expect);
		int actual = reciteMainView.getCurrentDictIndex();
		Assert.assertEquals(expect, actual);
	}
	
}
