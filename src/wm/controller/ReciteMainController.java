package wm.controller;

import wm.SwitchDelegate;
import wm.model.Dictionaries;
import wm.view.ReciteMainView;
import wm.view.WMView;

public class ReciteMainController implements IReciteMainController {
	SwitchDelegate delegate;
	ReciteMainView view;
	Dictionaries model;
	
	public ReciteMainController(SwitchDelegate delegate) {
		super();
		this.delegate = delegate;
		this.view = new ReciteMainView(this);
		this.showDictionaryDetail(0);
		view.setListPanelContent(model.getDictionaryNames());
	}

	@Override
	public void showDictionaryDetail(int index) {
		int size=model.getDictionary(index).getSize();
		int totalSize=model.getTotalSize();
		view.setSizeLabelText(size);
		view.setTotalSizeLabelText(totalSize);
		view.setPieIcon(size, totalSize);
	}

	@Override
	public void switchToStartSelect(int index) {
		delegate.getStartWordSelect(index);
	}

	@Override
	public void switchToHome() {
		delegate.getHome();
	}

	@Override
	public WMView getView() {
		return view;
	}

	
}
