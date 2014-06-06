package wm.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.view.component.WMBar;
import wm.view.component.WMButton;
import wm.view.component.WMLabel;
import wm.view.component.WMListBox;
import wm.view.component.WMPie;
import wm.view.component.WMTable;

/**
 * Class ReciteRecordView represents at the end of the recite. It will show a
 * table which contains the recite information.
 * 
 * @author Sidney Fan
 * 
 */
public class ReciteRecordView extends ReciteProcessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7420407063090542202L;
	/* Label */
	protected WMLabel dictNameLabel;
	protected WMLabel dictNameValue;
	protected int dictRecitedValue;
	protected int dictCorrectValue;
	protected int dictWrongValue;
	protected int dictRateValue;
	/* Panel */
	protected JPanel bottomNav;
	protected JPanel tablePanel;
	protected JPanel iconPanel;
	/* Icons */
	private WMTable tableIcon;

	public ReciteRecordView(IReciteProcessController controller) {
		super(controller);
		addComponents();
	}

	protected void addComponents() {
		// initialize different components
		initDictNamePanel();
		initIconPanel();
	}

	private void initDictNamePanel() {
		dictNameLabel = new WMLabel(Constants.CHIN_DICTNAME,
				Constants.LABEL_TINY);
		dictNameValue = new WMLabel("Dictionary", Constants.LABEL_TINY);
		dictNameLabel.setBounds(0, 0, Constants.GLOBAL_WIDTH, PADDING);
		dictNameValue.setBounds(0, PADDING, Constants.GLOBAL_WIDTH, PADDING);
		centerPanel.add(dictNameLabel);
		centerPanel.add(dictNameValue);
	}

	private void initIconPanel() {
		iconPanel = new JPanel();
		iconPanel.setBounds(Constants.GLOBAL_WIDTH / 2 - Constants.ICON_MIDDLE,
				Constants.UNITHEIGHT, 2 * Constants.ICON_MIDDLE,
				Constants.ICON_MIDDLE + PADDING);
		iconPanel.setLayout(null);
		iconPanel.setOpaque(false);

		centerPanel.add(iconPanel);
		initTablePanel();
	}

	private void initTablePanel() {
		tablePanel = new JPanel();
		// default
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		names.add(Constants.CHIN_SELECTED);
		names.add(Constants.CHIN_CORRECT);
		names.add(Constants.CHIN_WRONG);
		names.add(Constants.CHIN_RATE+"(%)");
		values.add(dictRecitedValue);
		values.add(dictCorrectValue);
		values.add(dictWrongValue);
		values.add(dictRateValue);

		tableIcon = new WMTable(values, names);
		tableIcon.setBounds(0, PADDING, 2 * Constants.ICON_MIDDLE,
				Constants.ICON_MIDDLE / 2);

		tablePanel.setLayout(null);
		tablePanel.setOpaque(false);
		tablePanel.add(tableIcon);

		tablePanel.setBounds(0, 0, 2 * Constants.ICON_MIDDLE,
				Constants.ICON_MIDDLE + PADDING);
		iconPanel.add(tablePanel);
	}

	/**
	 * 
	 * @param precentage
	 */
	public void setCorrectPrecentageText(double percentage) {
		dictRateValue = (int) (percentage * 100);
	}

	/**
	 * 
	 * @param currentCount
	 */
	public void setCorrectCountText(int currentCount) {
		dictCorrectValue = currentCount;
	}

	/**
	 * 
	 * @param incorrectCount
	 */
	public void setIncorrectCountText(int incorrectCount) {
		dictWrongValue = incorrectCount;
	}

	/**
	 * 
	 * @param name
	 */
	public void setNameText(String name) {
		dictNameValue.setText(name);
	}

	/**
	 * 
	 * @param recitedSize
	 */
	public void setRecitedSizeText(int recitedSize) {
		dictRecitedValue = recitedSize;
	}

	public void showTablePanel() {
		// default
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		names.add(Constants.CHIN_SELECTED);
		names.add(Constants.CHIN_CORRECT);
		names.add(Constants.CHIN_WRONG);
		names.add(Constants.CHIN_RATE+"(%)");
		values.add(dictRecitedValue);
		values.add(dictCorrectValue);
		values.add(dictWrongValue);
		values.add(dictRateValue);

		iconPanel.removeAll();
		tableIcon.createTable(values, names);
		iconPanel.add(tablePanel);
		iconPanel.repaint();
	}
}
