package wm.controller;

import wm.view.StatisticView;

public class StatisticController extends WMController {

	public StatisticController(RootController rootDelegate) {
		super(rootDelegate);
		this.view = new StatisticView();
		initListener();
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
