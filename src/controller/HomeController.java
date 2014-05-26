package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import config.InterfaceParam;
import view.HomeView;

public class HomeController extends WMController{

	public HomeController(RootController rootController) {
		super(rootController);
		this.view = new HomeView();
		initListener();
	}

	@Override
	protected void initListener() {
		view.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("HomeController: receive "+evt.getPropertyName());
				if(evt.getPropertyName().equals("homeToStatisticViewCommand")){
					rootController.switchView(HOME_TO_STATISTIC);
				}else if(evt.getPropertyName().equals("homeToUnitViewCommand")){
					rootController.switchView(HOME_TO_UNIT);
				}
			}
		});

	}

}
