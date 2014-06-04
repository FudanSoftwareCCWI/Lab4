/**
 * Software Engineer lab4
 */
package wm;

import wm.config.Configuration;
import wm.controller.HomeController;
import wm.controller.IHomeController;
import wm.controller.IReciteMainController;
import wm.controller.IReciteProcessController;
import wm.controller.IRecordController;
import wm.controller.ReciteMainController;
import wm.controller.ReciteProcessController;
import wm.controller.RecordController;
import wm.controller.WMController;
import wm.model.Dictionaries;
import wm.model.Dictionary;
import wm.model.dao.DictionaryDAO;
import wm.model.dao.DictionaryImpl;
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

	public RootDelegate() {
		super();
		this.rootWindow = new RootWindow();
		this.conf = new Configuration();
		this.preLoadModel = preload();
	}

	public void start(){
		rootWindow.start();
		this.getHome();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private Dictionaries preload() {
		DictionaryDAO dictionaryDAO=new DictionaryImpl();
		return dictionaryDAO.selectAllDictionay();
	}

	@Override
	public void getHome() {
		if(homeController==null){
			homeController=new HomeController(this);
		}
		currentController=homeController;
		rootWindow.showView(currentController.getView());
	}

	@Override
	public void getReciteMain() {
		if(reciteMainController==null){
			reciteMainController=new ReciteMainController(this);
		}
		currentController=reciteMainController;
		rootWindow.showView(currentController.getView());
	}

	@Override
	public void getRecord() {
		if(recordController==null){
			recordController=new RecordController(this, preLoadModel);
		}
		currentController=recordController;
		rootWindow.showView(currentController.getView());
	}

	@Override
<<<<<<< HEAD
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
		
=======
	public void getStartWordSelect(int index) {
		if(reciteProcessController==null){
			reciteProcessController=new ReciteProcessController(this, preLoadModel.getDictionary(index));
		}
		currentController=reciteProcessController;
		rootWindow.showView(currentController.getView());
	}

	@Override
	public void getStartWordDefine(Dictionary model) {
		rootWindow.showView(currentController.getView());
	}

	@Override
	public void getSizeSelect(Dictionary model) {
		rootWindow.showView(currentController.getView());
	}

	@Override
	public void getReciteWord(Dictionary model) {
		rootWindow.showView(currentController.getView());
	}

	@Override
	public void getReciteRecord(Dictionary model) {
		rootWindow.showView(currentController.getView());
>>>>>>> FETCH_HEAD
	}


}
