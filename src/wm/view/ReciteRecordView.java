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
	protected WMLabel dictRecitedLabel;
	protected WMLabel dictCorrectLabel;
	protected WMLabel dictWrongLabel;
	protected WMLabel dictRateLabel;
	protected WMLabel dictNameValue;
	protected int dictRecitedValue;
	protected int dictCorrectValue;
	protected int dictWrongValue;
	protected int dictRateValue;
	/* Panel */
	protected JPanel bottomNav;
	protected JPanel tablePanel;
	protected JPanel infoPanel;
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
		initInfoPanel();
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

	private void initInfoPanel() {
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(4, 1));
		infoPanel.setOpaque(false);

		dictRecitedLabel = new WMLabel(Constants.CHIN_RECITED,
				Constants.LABEL_TINY);
		dictCorrectLabel = new WMLabel(Constants.CHIN_CORRECT,
				Constants.LABEL_TINY);
		dictWrongLabel = new WMLabel(Constants.CHIN_WRONG, Constants.LABEL_TINY);
		dictRateLabel = new WMLabel(Constants.CHIN_RATE, Constants.LABEL_TINY);

		infoPanel.add(dictRecitedLabel);
		infoPanel.add(dictCorrectLabel);
		infoPanel.add(dictWrongLabel);
		infoPanel.add(dictRateLabel);
		infoPanel.setBounds(0, Constants.UNITHEIGHT - PADDING / 2, 2
				* Constants.UNITHEIGHT + PADDING, Constants.GLOBAL_HEIGHT - 2
				* Constants.UNITHEIGHT - 2 * PADDING);

		centerPanel.add(infoPanel);
		
	}

	private void initIconPanel() {
		iconPanel = new JPanel();
		iconPanel.setBounds(2 * Constants.UNITHEIGHT + PADDING,
				Constants.UNITHEIGHT, 2 * Constants.ICON_MIDDLE + PADDING,
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
		names.add(Constants.CHIN_RECITED);
		names.add(Constants.CHIN_CORRECT);
		names.add(Constants.CHIN_WRONG);
		names.add(Constants.CHIN_RATE);
		values.add(dictRecitedValue);
		values.add(dictCorrectValue);
		values.add(dictWrongValue);
		values.add(dictRateValue);

		tableIcon = new WMTable(values, names);
		tableIcon.setBounds(0, PADDING, 2 * Constants.ICON_MIDDLE + PADDING,
				Constants.ICON_MIDDLE / 2);

		tablePanel.setLayout(null);
		tablePanel.setOpaque(false);
		tablePanel.add(tableIcon);
		

		tablePanel.setBounds(0, 0, 2 * Constants.ICON_MIDDLE + PADDING,
				Constants.ICON_MIDDLE + PADDING);
		iconPanel.add(tablePanel);
	}


	/**
	 * 
	 * @param precentage
	 */
	public void setCorrectPrecentageText(double percentage) {
		dictRateValue = (int) (percentage * 100);
		dictRateLabel.setText("");
		dictRateLabel.setLayout(new GridLayout(2, 1));
		dictRateLabel
				.add(new WMLabel(Constants.CHIN_RATE, Constants.LABEL_TINY));
		dictRateLabel.add(new WMLabel(String.valueOf((int) (percentage * 100))
				+ "%", Constants.LABEL_TINY));
	}

	/**
	 * 
	 * @param currentCount
	 */
	public void setCorrectCountText(int currentCount) {
		dictCorrectValue = currentCount;
		dictCorrectLabel.setText("");
		dictCorrectLabel.setLayout(new GridLayout(2, 1));
		dictCorrectLabel.add(new WMLabel(Constants.CHIN_CORRECT,
				Constants.LABEL_TINY));
		dictCorrectLabel.add(new WMLabel(String.valueOf(currentCount),
				Constants.LABEL_TINY));
	}

	/**
	 * 
	 * @param incorrectCount
	 */
	public void setIncorrectCountText(int incorrectCount) {
		dictWrongValue = incorrectCount;
		dictWrongLabel.setText("");
		dictWrongLabel.setLayout(new GridLayout(2, 1));
		dictWrongLabel.add(new WMLabel(Constants.CHIN_TOTAL,
				Constants.LABEL_TINY));
		dictWrongLabel.add(new WMLabel(String.valueOf(incorrectCount),
				Constants.LABEL_TINY));
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
		dictRecitedLabel.setText("");
		dictRecitedLabel.setLayout(new GridLayout(2, 1));
		dictRecitedLabel.add(new WMLabel(Constants.CHIN_RECITED,
				Constants.LABEL_TINY));
		dictRecitedLabel.add(new WMLabel(String.valueOf(recitedSize),
				Constants.LABEL_TINY));
	}
	
	public void showTablePanel() {
		// default
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		names.add(Constants.CHIN_TOTAL);
		names.add(Constants.CHIN_RECITED);
		names.add(Constants.CHIN_CORRECT);
		names.add(Constants.CHIN_WRONG);
		names.add(Constants.CHIN_RATE);
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
