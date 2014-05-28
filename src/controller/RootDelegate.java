package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import config.InterfaceParam;
import view.HomeView;
import view.RootWindow;
import view.WMView;

public class RootDelegate implements InterfaceParam {
	/* Root window */
	private RootWindow rootWindow;
	/* Controllers */
	private HomeController homeController;
	private UnitController unitController;
	private StatisticController statisticController;
	private WMController currentController;

	public RootDelegate() {
		super();
		rootWindow = new RootWindow();
	}

	public void init() {
		// TODO read config file
		// InterfaceParameter

		// Listener
		initListener();
	}

	public void start() {
		try {
			showHomeView();
			// start application
			rootWindow.start();
		} catch (Exception e) {
			// Exit with exception
		}
	}

	private void initListener() {
		rootWindow.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				RootDelegate.this.parseRootEvent(evt);
			}
		});

	}

	protected void parseRootEvent(PropertyChangeEvent evt) {
		// event from root window
	}

	public void switchView(int type) {
		System.out.print("RootController: switchView() receive ");
		switch (type) {
		case HOME_TO_STATISTIC:
			System.out.print("HOME_TO_STATISTIC");
			showStatisticView();
			break;
		case HOME_TO_UNIT:
			System.out.print("HOME_TO_UNIT");
			showUnitView();
			break;
		case UNIT_TO_HOME:
			System.out.print("UNIT_TO_HOME");
			showHomeView();
		default:

		}
		System.out.println();
	}

	private void showHomeView() {
		if (homeController == null)
			homeController = new HomeController(this);
		currentController = homeController;
		rootWindow.showView(homeController.getView());
	}

	private void showUnitView() {
		if (unitController == null)
			unitController = new UnitController(this);
		currentController = unitController;
		rootWindow.showView(unitController.getView());
	}

	private void showStatisticView() {
		if (statisticController == null)
			statisticController = new StatisticController(this);
		currentController = statisticController;
		rootWindow.showView(statisticController.getView());
	}

}
