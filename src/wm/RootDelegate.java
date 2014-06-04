/**
 * Software Engineer lab4
 */
package wm;

import wm.config.Configuration;
import wm.controller.WMController;
import wm.model.Dictionaries;
import wm.model.Dictionary;
import wm.view.RootWindow;

/**
 * Class RootDelegate manages the whole application. It implements
 * SwitchDelegate to switch controllers.
 * 
 * @author Maggie He
 * 
 */
public class RootDelegate implements SwitchDelegate {
	private RootWindow rootWindow;
	private WMController currentController;
	private Dictionaries preLoadModel;
	private Configuration conf;

	/**
	 * 
	 */
	public RootDelegate() {
		super();
		this.rootWindow = new RootWindow();
		this.conf = new Configuration();
		this.preLoadModel = preload();
	}

	/**
	 * 
	 * @return
	 */
	private Dictionaries preload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getHome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReciteMain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStartWordSelect(int dictionaryIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStartWordDefine(int dictionaryIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSizeSelect(int dictionaryIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReciteWord(int dictionaryIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReciteRecord(int dictionaryIndex) {
		// TODO Auto-generated method stub
		
	}

}
