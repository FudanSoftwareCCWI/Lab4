package wm.controller;

import wm.SwitchDelegate;
import wm.view.HomeView;

public class HomeController implements IHomeController {
	SwitchDelegate delegate;
	HomeView view;
	
	
	
	public HomeController(SwitchDelegate delegate) {
		super();
		this.delegate=delegate;
		this.view = new HomeView(this);
	}

	@Override
	public void switchToRecite() {
		delegate.getReciteMain();
	}

	@Override
	public void switchToRecord() {
		delegate.getRecord();
	}

}
