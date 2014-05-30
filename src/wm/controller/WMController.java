package wm.controller;

import wm.config.InterfaceParam;
import wm.view.WMView;

public abstract class WMController implements InterfaceParam{
	
	protected RootController rootDelegate;
	protected WMView view;

	public WMController(RootController rootDelegate){
		this.rootDelegate = rootDelegate;
	}
	
	public WMView getView() {
		return view;
	}

	protected abstract void initListener();
	
}
