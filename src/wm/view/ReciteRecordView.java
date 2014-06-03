package wm.view;

import wm.controller.IReciteProcessController;

/**
 * Class ReciteRecordView represents at the end of the recite.
 * It will show a table which contains the recite information.
 * 
 * @author Sidney Fan
 * 
 */
public class ReciteRecordView extends WMView{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7420407063090542202L;
	private IReciteProcessController controller;
	
	public ReciteRecordView(IReciteProcessController controller) {
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
	 * @param precentage
	 */
	public void setCorrectPrecentageText(double precentage){
		
	}
	
	/**
	 * 
	 * @param currentCount
	 */
	public void setCorrectCountText(int currentCount){
		
	}

	/**
	 * 
	 * @param incorrectCount
	 */
	public void setIncorrectCountText(int incorrectCount){
		
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setNameText(String name){
		
	}
	
	/**
	 * 
	 * @param recitedSize
	 */
	public void setRecitedSizeText(int recitedSize){
		
	}
}
