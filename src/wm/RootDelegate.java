/**
 * Software Engineer lab4
 */
package wm;

import java.util.List;

import wm.config.Configuration;
import wm.controller.IHomeController;
import wm.controller.IReciteMainController;
import wm.controller.IReciteProcessController;
import wm.controller.IRecordController;
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
	private IHomeController homeController;
	private IReciteMainController reciteMainController;
	private IReciteProcessController reciteProcessController;
	private IRecordController recordController;
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
		this.getHome();
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
	public void getStartWordSelect(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStartWordDefine(Dictionary model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSizeSelect(Dictionary model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReciteWord(Dictionary model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReciteRecord(Dictionary model) {
		// TODO Auto-generated method stub
		
	}

}
