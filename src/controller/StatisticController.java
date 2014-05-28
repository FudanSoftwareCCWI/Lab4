package controller;

import view.StatisticView;

public class StatisticController extends WMController {

	public StatisticController(RootDelegate rootDelegate) {
		super(rootDelegate);
		this.view = new StatisticView();
		initListener();
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
