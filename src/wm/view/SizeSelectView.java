package wm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.view.component.WMLabel;

/**
 * Class SizeSelectView represents a scroll and the user can move it to select
 * the number of the word he want to recite
 * 
 * @author Sidney Fan
 * 
 */
public class SizeSelectView extends ReciteProcessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014427720952625543L;

	private JButton nextBtn;
	private WMLabel nextTip;
	private JSlider slider;

	private WMLabel left;
	private WMLabel right;
	private WMLabel pivot;
	private int leftValue;
	private int rightValue;
	private int pivotValue;

	public SizeSelectView(IReciteProcessController controller) {
		super(controller);
		addComponents();
		addListener();
	}

	protected void addComponents() {
		setTip(Constants.CHIN_SELECT_SZIE);

		nextBtn = new JButton(Constants.NEXTICON);
		nextTip = new WMLabel(Constants.CHIN_COMFIRM_TO_START,
				Constants.LABEL_TINY);
		nextBtn.setBorder(null);

		leftValue = 1;
		rightValue = controller.getAvailableSize();

		pivotValue = rightValue / 2;
		slider = new JSlider(leftValue, rightValue);
		slider = new JSlider(leftValue, rightValue, pivotValue);
		left = new WMLabel(String.valueOf(leftValue), Constants.LABEL_SMALL);
		right = new WMLabel(String.valueOf(rightValue), Constants.LABEL_SMALL);
		pivot = new WMLabel(String.valueOf(pivotValue), Constants.LABEL_SMALL);

		centerPanel.add(slider);
		centerPanel.add(nextBtn);
		centerPanel.add(nextTip);
		centerPanel.add(left);
		centerPanel.add(right);
		centerPanel.add(pivot);

		slider.setBounds(Constants.GLOBAL_WIDTH / 4, 2*Constants.UNITHEIGHT,
				Constants.GLOBAL_WIDTH / 2, Constants.UNITHEIGHT);
		left.setBounds(Constants.GLOBAL_WIDTH / 4 - 20,
				2 * Constants.UNITHEIGHT + 37, Constants.LABEL_SMALL,
				Constants.LABEL_SMALL);
		right.setBounds((int) (Constants.GLOBAL_WIDTH * 0.75),
				2 * Constants.UNITHEIGHT + 37, Constants.LABEL_NORMAL,
				Constants.LABEL_SMALL);
		setPivot(pivotValue);
		nextBtn.setBounds((Constants.GLOBAL_WIDTH - Constants.ICON_TINY) / 2, 3
				* Constants.UNITHEIGHT + PADDING, Constants.ICON_TINY,
				Constants.ICON_TINY);
		nextTip.setBounds(0, 3 * Constants.UNITHEIGHT + PADDING + 5,
				Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);

	}

	protected void addListener() {
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent evt) {
				setPivot(slider.getValue());
			}
		});

		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setReciteSize(slider.getValue());
//				controller.switchToReciteWord();
			}
		});
	}

	private void setPivot(int value) {
		int x = (int) (Constants.GLOBAL_WIDTH / 4 + (double) value
				/ (double) rightValue * Constants.GLOBAL_WIDTH / 2)
				- Constants.LABEL_SMALL;
		pivot.setText(String.valueOf(value));
		pivot.setBounds(x, 2 * Constants.UNITHEIGHT, Constants.LABEL_NORMAL,
				Constants.LABEL_SMALL);
	}

	/**
	 * 
	 * @param maxSize
	 */
	public void setAvaliableSizeText(int maxSize) {
		// TODO
	}

	public int getSelectedSize() {
		return pivotValue;
	}

}
