package wm.view;

import wm.controller.IReciteProcessController;


/**
 * Class SizeSelectView represents a scroll and the user can move it to select 
 * the number of the word he want to recite
 * 
 * @author Sidney Fan
 * 
 */
public class SizeSelectView extends WMView{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014427720952625543L;
	private IReciteProcessController controller;
	
	public SizeSelectView(IReciteProcessController controller) {
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
	 * @param maxSize
	 */
	public void setAvaliableSizeText(int maxSize){
		
	}
}
