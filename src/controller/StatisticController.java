package controller;

import view.StatisticView;

public class StatisticController extends WMController {

	public StatisticController(RootController rootController) {
		super(rootController);
		this.view = new StatisticView();
		initListener();
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
