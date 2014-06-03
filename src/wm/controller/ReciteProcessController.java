/**
 * 
 */
package wm.controller;

import java.util.List;

import wm.SwitchDelegate;
import wm.model.Dictionary;
import wm.model.Record;
import wm.view.ReciteRecordView;
import wm.view.ReciteWordView;
import wm.view.SizeSelectView;
import wm.view.StartSelectView;
import wm.view.StartWordDefineView;

/**
 * @author hewenqi
 *
 */
public class ReciteProcessController implements IReciteProcessController {
	SwitchDelegate delegate;
	StartSelectView startSelectView;
	StartWordDefineView startWordDefineView;
	SizeSelectView sizeSelectView;
	ReciteWordView reciteWordView;
	ReciteRecordView reciteRecordView;
	Dictionary model;
	
	
	
	public ReciteProcessController(SwitchDelegate delegate, Dictionary model) {
		super();
		this.delegate = delegate;
		this.model = model;
		this.startSelectView=new StartSelectView(this);
		this.startWordDefineView=new StartWordDefineView(this);
		this.sizeSelectView=new SizeSelectView(this);
		this.reciteWordView=new ReciteWordView(this);
		this.reciteRecordView=new ReciteRecordView(this);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#startByFirstWord()
	 */
	@Override
	public void startByFirstWord() {
		model.setStartWord(0);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#startByLastTime()
	 */
	@Override
	public void startByLastTime() {
		model.setStartWord(model.getPresentWord()+1);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#startByInput(java.lang.String)
	 */
	@Override
	public void startByInput(String key) {
		model.setStartWord(0);// TODO
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#getAvailableWordList(java.lang.String)
	 */
	@Override
	public void getAvailableWordList(String prefix) {
		List<String> words=model.getMatchWords(prefix);
		startWordDefineView.setWordListTextarea(words);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#getAvailableSize()
	 */
	@Override
	public int getAvailableSize() {
		return model.calAvailableSize();
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#setReciteSize(int)
	 */
	@Override
	public void setReciteSize(int size) {
		model.setRecitedSize(size);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#reciteNextWord()
	 */
	@Override
	public void reciteNextWord() {
		String meaning = model.getNextMeaning();
		reciteWordView.setMeaningText(meaning);	
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#checkCorrect()
	 */
	@Override
	public void checkCorrect(String input) {
		String key = model.getNextKey();
		if(key.equalsIgnoreCase(key)){
			reciteWordView.setCorrectInfoText("对");
		}else{
			reciteWordView.setCorrectInfoText("不对");
		}
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#getReciteRecord()
	 */
	@Override
	public Record getReciteRecord() {
		Record record=model.produceRecord(model.getStartWord(), model.getPresentWord());
		return record;
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#switchToStartWordDefine()
	 */
	@Override
	public void switchToStartWordDefine() {
		delegate.getStartWordDefine(model);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#switchToSizeSelect()
	 */
	@Override
	public void switchToSizeSelect() {
		
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#switchToReciteWord()
	 */
	@Override
	public void switchToReciteWord() {
		
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#switchToReciteRecord()
	 */
	@Override
	public void switchToReciteRecord() {
		delegate.getReciteRecord(model);
	}

	/** (non-Javadoc)
	 * @see wm.controller.IReciteProcessController#switchToHome()
	 */
	@Override
	public void switchToHome() {
		delegate.getHome();
	}

}