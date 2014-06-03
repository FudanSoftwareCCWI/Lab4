package wm.view;

import wm.controller.IReciteProcessController;

/**
 * Class StartSelectView represents three ways to start recite,
 * the user can choose what he want and go to next step.
 * 
 * @author Sidney Fan
 * 
 */
public class StartSelectView extends WMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4531368146481645750L;
	private IReciteProcessController controller;
	
	public StartSelectView(IReciteProcessController controller) {
		super();
		this.controller = controller;
	}
	
	
	@Override
	protected void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initListener() {
		// TODO Auto-generated method stub
		
	}

}
