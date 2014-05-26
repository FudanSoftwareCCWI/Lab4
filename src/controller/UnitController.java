package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import view.HomeView;
import view.UnitView;

public class UnitController extends WMController{
	
	public UnitController(RootController rootController) {
		super(rootController);
		this.view = new UnitView();
		initListener();
	}

	@Override
	protected void initListener() {
		this.view.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("unitViewToHomeCommand")){
					UnitController.this.rootController.switchView(UNIT_TO_HOME);
				}
				
			}
		});
	}
}
