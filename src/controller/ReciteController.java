package controller;

import view.ReciteView;


public class ReciteController extends WMController {

	public ReciteController(RootDelegate rootDelegate) {
		super(rootDelegate);
		this.view = new ReciteView();
		initListener();
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
