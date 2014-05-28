package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import config.InterfaceParam;
import view.HomeView;

public class HomeController extends WMController{

	public HomeController(RootDelegate rootDelegate) {
		super(rootDelegate);
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
					rootDelegate.switchView(HOME_TO_STATISTIC);
				}else if(evt.getPropertyName().equals("homeToUnitViewCommand")){
					rootDelegate.switchView(HOME_TO_UNIT);
				}
			}
		});

	}
	
	public HomeView getView(){
		((HomeView)view).refreshHome();
		return ((HomeView)view);
	}

}
