package wm.controller;

import java.util.ArrayList;

import wm.SwitchDelegate;
import wm.model.Dictionaries;
import wm.model.Record;
import wm.view.RecordView;

public class RecordController implements IRecordController {
	SwitchDelegate delegate;
	RecordView view;
	Dictionaries model;
	
	public RecordController(SwitchDelegate delegate, Dictionaries model) {
		super();
		this.delegate = delegate;
		this.model = model;
		this.view = new RecordView(this);
	}

	@Override
	public void showRecordByPie(int index) {
		Record record=model.getDictionary(index).produceRecord();
		view.setPieRecitedIcon(record.getRecitedSize(), record.getTotalSize());
		view.setPieCorrectIcon(record.getCorrect(), record.getRecitedSize());
	}

	@Override
	public void showRecordByPie() {
		Record record = model.produceRecord();
		view.setPieRecitedIcon(record.getRecitedSize(), record.getTotalSize());
		view.setPieCorrectIcon(record.getRecitedSize(), record.getTotalSize());
	}

	@Override
	public void showRecordByBar(int index) {
		//TODO
		Record record=model.getDictionary(index).produceRecord();
		view.setBarRecitedIcon(new ArrayList<Integer>());
		view.setBarCorrectIcon(new ArrayList<Integer>());
	}

	@Override
	public void showRecordByBar() {
		//TODO
		Record record=model.produceRecord();
		view.setBarRecitedIcon(new ArrayList<Integer>());
		view.setBarCorrectIcon(new ArrayList<Integer>());
	}

	@Override
	public void showRecordByTable(int index) {
		Record record=model.getDictionary(index).produceRecord();
		view.setSizeText(record.getTotalSize());
		view.setReciteSizeText(record.getRecitedSize());
		view.setCorrectText(record.getCorrect());
		view.setWrongText(record.getWrong());
		view.setCorrectPercentage(record.getCorrectRate());
	}

	@Override
	public void showDictList() {
		
	}
	
	@Override
	public void switchToHome() {
		delegate.getHome();
	}

	public RecordView getView() {
		return view;
	}

	
}
