package wm.controller;

import wm.view.ReciteView;


public class ReciteController extends WMController {

	public ReciteController(RootController rootDelegate) {
		super(rootDelegate);
		this.view = new ReciteView();
		initListener();
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
