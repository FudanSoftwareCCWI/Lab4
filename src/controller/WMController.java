package controller;

import config.InterfaceParam;
import view.WMView;

public abstract class WMController implements InterfaceParam{
	
	protected RootController rootController;
	protected WMView view;

	public WMController(RootController rootController){
		this.rootController = rootController;
	}
	
	public WMView getView() {
		return view;
	}

	protected abstract void initListener();
	
}
