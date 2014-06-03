package wm.view;

import java.util.List;

import wm.controller.IReciteProcessController;


/**
 * Class StartWordDefineView appears when the user want to start
 * by the input word, the user can input the word he want to start
 * with and go to next stop. 
 * 
 * @author Sidney Fan
 * 
 */
public class StartWordDefineView extends WMView {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3052539781672180377L;
	private IReciteProcessController controller;
	
	public StartWordDefineView(IReciteProcessController controller) {
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
	 * @param word
	 */
	public void setWordListTextarea(List word){
		
	}

}
