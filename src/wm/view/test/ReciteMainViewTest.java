package wm.view.test;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mockery;
import org.jmock.States;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IHomeController;
import wm.controller.IReciteMainController;
import wm.view.HomeView;
import wm.view.ReciteMainView;

public class ReciteMainViewTest extends WMViewTestCase{

	private static ReciteMainView reciteMainView;
	private static IReciteMainController controller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpFrame();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	public static List<String> getNameList(){
		ArrayList<String> r = new ArrayList<String>();
		for (int i = 0; i < 26; i++) {
			r.add(String.format("Dictionary %c", (char)('A'+i)));
		}
		return r;
	}
	
	@Before
	public void setUp() throws Exception {
		context = new Mockery();
		controller = context.mock(IReciteMainController.class);
		reciteMainView = new ReciteMainView((IReciteMainController) controller);
		
		reciteMainView.setListPanelContent(getNameList());

		final States viewState = context.states("view").startsAs("showing");
		
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
		while(true);
	}

}
