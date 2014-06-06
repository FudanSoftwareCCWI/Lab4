/**
 * Software Engineer lab4
 */
package wm.view;

import wm.controller.IRecordController;

/**
 * Class RecordView represents a record view and is managed by a record view
 * controller. It provides different methods to show the recite record.
 * 
 * @author Sidney Fan
 * 
 */
public class RecordView extends WMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2917311740345650657L;
	IRecordController controller;
	
	public RecordView(IRecordController controller) {
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
	 * @param size
	 */
	public void setSizeText(int size){
		
	}
	
	/**
	 * 
	 * @param recitedSize
	 */
	public void setReciteSizeText(int recitedSize){
		
	}
	
	/**
	 * 
	 * @param correct
	 */
	public void setCorrectText(int correct){
		
	}
	
	/**
	 * 
	 * @param percentage
	 */
	public void setCorrectPercentage(double percentage){
		
	}
	
	/**
	 * 
	 * @param wrong
	 */
	public void setWrongText(int wrong){
		
	}
	
	/**
	 * 
	 * @param correct
	 * @param size
	 */
	public void setPieCorrectIcon(int correct, int size){
		
	}
	
	/**
	 * 
	 * @param recited
	 * @param size
	 */
	public void setPieRecitedIcon(int recited, int size){
		
	}
	
	/**
	 * 
	 * @param correct
	 * @param size
	 */
	public void setBarCorrectIcon(int correct, int size){
		
	}
	
	/**
	 * 
	 * @param recited
	 * @param size
	 */
	public void setBarRecitedIcon(int recited, int size){
		
	}

}
