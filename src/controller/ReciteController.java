package controller;

import view.ReciteView;


public class ReciteController extends WMController {

	public ReciteController(RootController rootController) {
		super(rootController);
		this.view = new ReciteView();
		initListener();
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
