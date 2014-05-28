package controller;

import config.InterfaceParam;
import view.WMView;

public abstract class WMController implements InterfaceParam{
	
	protected RootDelegate rootDelegate;
	protected WMView view;

	public WMController(RootDelegate rootDelegate){
		this.rootDelegate = rootDelegate;
	}
	
	public WMView getView() {
		return view;
	}

	protected abstract void initListener();
	
}
