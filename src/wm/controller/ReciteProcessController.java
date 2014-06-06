/**
 * 
 */
package wm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import wm.SwitchDelegate;
import wm.model.Dictionary;
import wm.model.Record;
import wm.view.ReciteRecordView;
import wm.view.ReciteWordView;
import wm.view.SizeSelectView;
import wm.view.StartSelectView;
import wm.view.StartWordDefineView;
import wm.view.WMView;

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
	WMView currentView;
	Dictionary model;
	Timer timer;

	// recite word control
	private int startWord;
	private int presentWord;
	private int reciteSize;

	public ReciteProcessController(SwitchDelegate delegate, Dictionary model) {
		super();
		this.delegate = delegate;
		this.model = model;
		this.startSelectView = new StartSelectView(this);
		this.currentView = startSelectView;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#startByFirstWord()
	 */
	@Override
	public void startByFirstWord() {
		this.startWord=0;
		this.presentWord=this.startWord-1;
		this.switchToSizeSelect();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#startByLastTime()
	 */
	@Override
	public void startByLastTime() {
		this.startWord=model.getPresentWord()+1;
		this.presentWord=this.startWord-1;
		this.switchToSizeSelect();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#startByInput(java.lang.String)
	 */
	@Override
	public void startByInput(String key) {
		this.startWord=model.getWordIndex(key);
		this.presentWord=this.startWord-1;
		this.switchToSizeSelect();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToStartWordDefine()
	 */
	@Override
	public void switchToStartWordDefine() {
		startWordDefineView=new StartWordDefineView(this);
		this.currentView = startWordDefineView;
		delegate.getStartWordDefine();
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToSizeSelect()
	 */
	private void switchToSizeSelect() {
		sizeSelectView=new SizeSelectView(this);
		this.currentView = sizeSelectView;
		delegate.getSizeSelect();
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#getAvailableWordList(java.lang.String)
	 */
	@Override
	public List<String> getAvailableWordList(String prefix) {//TODO
		List<String> words = model.getMatchWords(prefix);
		return words;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#getAvailableSize()
	 */
	@Override
	public int getAvailableSize() {//TODO
		return model.calAvailableSize(startWord);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#setReciteSize(int)
	 */
	@Override
	public void setReciteSize(int size) {
		this.reciteSize = size;
		this.switchToReciteWord();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#checkCorrect()
	 */
	@Override
	public void checkCorrect(String input) {
		String key = model.getKey(presentWord);
		if (key.equalsIgnoreCase(input)) {
			model.setWordRecited(this.presentWord);
			model.setWordCorrect(this.presentWord,true);
			reciteWordView.setCorrectInfoText("对");
		} else {
			model.setWordRecited(this.presentWord);
			model.setWordCorrect(this.presentWord,false);
			reciteWordView.setCorrectInfoText("不对");
		}
		//wait for one minute to recite next word
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reciteNextWord();
				timer.stop();
			}

		});
		timer.start();
	}

	private void reciteNextWord() {
		if (this.presentWord-this.startWord+1 == reciteSize) {// check whether meets the reciteSize 
			this.switchToReciteRecord();
		} else {// else
			presentWord++;
			model.setPresentWord(presentWord);
			reciteWordView.setMeaningText(model.getMeaning(presentWord));
			reciteWordView.emptyInputField();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToReciteWord()
	 */
	private void switchToReciteWord() {
		reciteWordView = new ReciteWordView(this);
		this.currentView = reciteWordView;
		this.reciteNextWord();
		delegate.getReciteRecord();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToReciteRecord()
	 */
	private void switchToReciteRecord() {
		reciteRecordView=new ReciteRecordView(this);
		this.currentView = reciteRecordView;
		Record record=model.produceRecord(this.startWord,this.presentWord);
		reciteRecordView.setNameText(model.getName());
		reciteRecordView.setRecitedSizeText(this.reciteSize);
		reciteRecordView.setCorrectCountText(record.getCorrect());
		reciteRecordView.setIncorrectCountText(record.getWrong());
		reciteRecordView.setCorrectPrecentageText(record.getCorrectRate());
		reciteRecordView.showTablePanel();
		delegate.getReciteRecord();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToHome()
	 */
	@Override
	public void switchToHome() {
		delegate.getHome();
	}

	@Override
	public WMView getView() {
		return currentView;
	}

}
