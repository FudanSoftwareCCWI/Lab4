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
	private int selectedSize;
	private int count;

	public ReciteProcessController(SwitchDelegate delegate, Dictionary model) {
		super();
		this.delegate = delegate;
		this.model = model;
		this.startSelectView = new StartSelectView(this);
		this.startWordDefineView = new StartWordDefineView(this);
		this.sizeSelectView = new SizeSelectView(this);
		this.reciteWordView = new ReciteWordView(this);
		this.reciteRecordView = new ReciteRecordView(this);
		this.currentView = startSelectView;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#startByFirstWord()
	 */
	@Override
	public void startByFirstWord() {
		model.setStartWord(0);
		model.setPresentWord(0);
		this.switchToSizeSelect();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#startByLastTime()
	 */
	@Override
	public void startByLastTime() {
		model.setStartWord(model.getPresentWord() + 1);
		model.setPresentWord(model.getPresentWord() + 1);
		this.switchToSizeSelect();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#startByInput(java.lang.String)
	 */
	@Override
	public void startByInput(String key) {
		int index=model.setStartWord(key);
		model.setPresentWord(index);
		System.out.println(key);
		this.switchToSizeSelect();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#getAvailableWordList(java.lang.String)
	 */
	@Override
	public List<String> getAvailableWordList(String prefix) {
		List<String> words = model.getMatchWords(prefix);
		// startWordDefineView.setWordListTextarea(words);
		return words;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#getAvailableSize()
	 */
	@Override
	public int getAvailableSize() {
		return model.calAvailableSize();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#setReciteSize(int)
	 */
	@Override
	public void setReciteSize(int size) {
		this.selectedSize = size;
		this.count = 0;
		model.setRecitedSize(size);
		this.switchToReciteWord();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#reciteNextWord()
	 */
	@Override
	public void reciteNextWord() {
		String meaning = model.getNextMeaning();
		reciteWordView.setMeaningText(meaning);
		reciteWordView.emptyInputField();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#checkCorrect()
	 */
	@Override
	public void checkCorrect(String input) {
		String key = model.getNextKey();
		if (key.equalsIgnoreCase(input)) {
			model.setWordRecited();
			model.setWordCorrect(true);
			reciteWordView.setCorrectInfoText("对");
		} else {
			model.setWordRecited();
			model.setWordCorrect(false);
			reciteWordView.setCorrectInfoText("不对");
		}
		count++;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkNext();
				timer.stop();
			}

		});
		timer.start();
	}

	private void checkNext() {
		// check recited size
		if (count == selectedSize) {// if equal
			this.switchToReciteRecord();// then to record view
		} else {// else
			model.setPresentWord(model.getPresentWord() + 1);
			reciteNextWord();// to next
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#getReciteRecord()
	 */
	@Override
	public Record getReciteRecord() {
		Record record = model.produceRecord(model.getStartWord(),
				model.getPresentWord());
		return record;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToStartWordDefine()
	 */
	@Override
	public void switchToStartWordDefine() {
		this.currentView = startWordDefineView;
		delegate.getStartWordDefine(model);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToSizeSelect()
	 */
	@Override
	public void switchToSizeSelect() {
		this.currentView = sizeSelectView;
		delegate.getSizeSelect(model);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToReciteWord()
	 */
	@Override
	public void switchToReciteWord() {
		this.currentView = reciteWordView;
		reciteWordView.emptyInputField();
		reciteWordView.setMeaningText(model.getNextMeaning());
		delegate.getReciteRecord(model);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToReciteRecord()
	 */
	@Override
	public void switchToReciteRecord() {// TODO
		this.currentView = reciteRecordView;
		Record record=model.produceRecord(model.getStartWord(), model.getPresentWord());
		reciteRecordView.setNameText(model.getName());
		reciteRecordView.setRecitedSizeText(this.selectedSize);
		reciteRecordView.setCorrectCountText(record.getCorrect());
		reciteRecordView.setIncorrectCountText(record.getWrong());
		reciteRecordView.setCorrectPrecentageText(record.getCorrectRate());
		
		System.out.println("From controller");
		System.out.println(record.getCorrect());
		System.out.println(record.getWrong());
		System.out.println(record.getCorrectRate());
		System.out.println(record.getTotalSize());
		reciteRecordView.showTablePanel();
		delegate.getReciteRecord(model);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see wm.controller.IReciteProcessController#switchToHome()
	 */
	@Override
	public void switchToHome() {
		this.currentView = startSelectView;
		delegate.getHome();
	}

	@Override
	public WMView getView() {
		return currentView;
	}

}
