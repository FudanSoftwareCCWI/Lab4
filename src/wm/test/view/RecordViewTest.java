/**
 * Software Engineer lab4
 */
package wm.test.view;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.controller.IRecordController;
import wm.view.RecordView;

/**
 * 
 * @author SidneyFan
 *
 */
public class RecordViewTest extends WMViewTestCase {

	private static RecordView view;
	private static IRecordController controller;
	List<String> dictist;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpFrame();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dictist = new ArrayList<String>();
		dictist.add("Dictionary A");
		dictist.add("Dictionary B");
		dictist.add("Dictionary C");
		dictist.add("Dictionary D");
		dictist.add("Dictionary E");
		dictist.add("Dictionary F");
		dictist.add("Dictionary G");

		context = new Mockery();
		controller = context.mock(IRecordController.class);

		context.checking(new Expectations() {

			{
				allowing(controller).showRecordByPie(with(any(int.class)));
			}

		});
		view = new RecordView(controller);
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
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(23);
		a.add(42);
		a.add(345);
		a.add(23);
		a.add(54);
		a.add(324);
		a.add(123);
		a.add(222);
		
		view.setDictist(dictist);
		view.setSizeText(373);
		view.setReciteSizeText(56);
		view.setCorrectText(47);
		view.setWrongText(9);
		view.setCorrectPercentage(47.0 / 56.0);
		view.setPieCorrectIcon(47, 56);
		view.setPieRecitedIcon(56, 373);
		
		view.setBarCorrectIcon(a);
		view.setBarRecitedIcon(a);
		
		view.setHeadLineText("Statistic");

	}

}
