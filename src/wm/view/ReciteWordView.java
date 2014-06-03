package wm.view;

import wm.controller.IReciteProcessController;

/**
 * Class ReciteWordView present the chinese meaning of the word.
 * The user input the spelling into the input area and get the feedback,
 * then goto next word.
 * 
 * @author Sidney Fan
 * 
 */
public class ReciteWordView extends WMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5402598615372695937L;
	private IReciteProcessController controller;
	
	public ReciteWordView(IReciteProcessController controller) {
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
	
	/**
	 * 
	 * @param info
	 */
	public void setCorrectInfoText(String info){
		
	}
	
	/**
	 * 
	 * @param meaning
	 */
	public void setMeaningText(String meaning){
		
	}

}
