package wm.controller;

import java.util.ArrayList;
import java.util.List;

import wm.SwitchDelegate;
import wm.model.Record;
import wm.model.dao.RecordImpl;
import wm.view.RecordView;

public class RecordController implements IRecordController {
	SwitchDelegate delegate;
	RecordView view;
	RecordImpl model;
	
	public RecordController(SwitchDelegate delegate, RecordImpl model) {
		super();
		this.delegate = delegate;
		this.model = model;
		this.view = new RecordView(this);
		view.showTablePanel();
		this.showDictList();
		this.showRecordByTable(0);
	}

	@Override
	public void showRecordByPie(int index) {
		Record record=model.selectRecordByIndex(index);
		view.setSizeText(record.getTotalSize());
		view.setReciteSizeText(record.getRecitedSize());
		view.setCorrectText(record.getCorrect());
		view.setWrongText(record.getWrong());
		view.setCorrectPercentage(record.getCorrectRate());
		view.setPieRecitedIcon(record.getRecitedSize(), record.getTotalSize());
		view.setPieCorrectIcon(record.getCorrect(), record.getRecitedSize());
		view.showPiePanel();
	}

	@Override
	public void showRecordByPie() {
		Record record = model.selectAllRecord();
		view.setPieRecitedIcon(record.getRecitedSize(), record.getTotalSize());
		view.setPieCorrectIcon(record.getRecitedSize(), record.getTotalSize());
		view.showPiePanel();
	}

	@Override
	public void showRecordByBar() {
		List<Record> records=model.selectAllRecordList();
		List<Integer> recited=new ArrayList<Integer>();
		List<Integer> correct=new ArrayList<Integer>();
		for(Record record:records){
			recited.add(record.getRecitedSize());
			correct.add((int)(record.getCorrectRate()*100));
		}
		view.setBarRecitedIcon(recited);
		view.setBarCorrectIcon(correct);
		view.showBarPanel();
	}
	
	@Override
	public void showRecordByBar(int index) {
		Record dictrecord=model.selectRecordByIndex(index);
		List<Record> records=model.selectAllRecordList();
		List<Integer> recited=new ArrayList<Integer>();
		List<Integer> correct=new ArrayList<Integer>();
		for(Record record:records){
			recited.add(record.getRecitedSize());
			correct.add((int)(record.getCorrectRate()*100));
		}
		view.setSizeText(dictrecord.getTotalSize());
		view.setReciteSizeText(dictrecord.getRecitedSize());
		view.setCorrectText(dictrecord.getCorrect());
		view.setWrongText(dictrecord.getWrong());
		view.setCorrectPercentage(dictrecord.getCorrectRate());
		view.setBarRecitedIcon(recited);
		view.setBarCorrectIcon(correct);
		view.showBarPanel();
	}

	@Override
	public void showRecordByTable(int index) {
		System.out.println(index);
		Record record=model.selectRecordByIndex(index);
		view.setSizeText(record.getTotalSize());
		view.setReciteSizeText(record.getRecitedSize());
		view.setCorrectText(record.getCorrect());
		view.setWrongText(record.getWrong());
		view.setCorrectPercentage(record.getCorrectRate());
		view.showTablePanel();
	}

	@Override
	public void showDictList() {
		List<Record>records=model.selectAllRecordList();
		List<String>names=new ArrayList<String>();
		for(Record record:records){
			names.add(record.getName());
		}
		view.setDictist(names);
	}
	
	@Override
	public void switchToHome() {
		delegate.getHome();
	}

	public RecordView getView() {
		return view;
	}

	
}
