package wm.view.test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import wm.config.Constants;
import wm.controller.IHomeController;
import wm.view.HomeView;

import org.jmock.*;
import org.jmock.api.Action;
import org.jmock.api.Expectation;
import org.jmock.api.Invocation;
import org.jmock.syntax.MethodClause;

public class HomeViewTest {

	private static JFrame frame;
	private static HomeView homeView;
	
	private static Mockery context;
	
	private static IHomeController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		frame = new JFrame();
		Dimension fixedDimension = new Dimension(Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_HEIGHT);
		frame.setSize(fixedDimension);
		frame.setResizable(false);
		frame.setBackground(Constants.NORMALGREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		context = new Mockery();
		
		controller = context.mock(IHomeController.class);
		homeView = new HomeView((IHomeController) controller);
		final States view = context.states("view").startsAs("showing");
		
		context.checking(new Expectations() {
			
			{
				oneOf(controller).switchToRecite();
				when(view.is("showing"));
				then(view.is("disappear"));
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
