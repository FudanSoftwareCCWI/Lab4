package wm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.view.component.WMLabel;

/**
 * Class ReciteWordView present the chinese meaning of the word. The user input
 * the spelling into the input area and get the feedback, then goto next word.
 * 
 * @author Sidney Fan
 * 
 */
public class ReciteWordView extends ReciteProcessView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5402598615372695937L;
	private IReciteProcessController controller;
	private WMLabel paraphrase;
	private WMLabel resultHint;
	private JTextField inputField;

	public ReciteWordView(IReciteProcessController controller) {
		super(controller);
		addComponents();
		addListener();
	}

	protected void addComponents() {
		setHeadLineText(Constants.CHIN_RECITING);
		hideTip();

		paraphrase = new WMLabel("n. 释义", Constants.LABEL_MIDDLE);
		inputField = new JTextField();
		resultHint = new WMLabel("结果", Constants.LABEL_SMALL);

		inputField.setBackground(new Color(0, 0, 0, 0));
		inputField.setForeground(Color.WHITE);
		inputField.setBorder(new LineBorder(Color.WHITE, 2));
		inputField.setFont(new Font(Constants.LABEL_FONT, Font.PLAIN,
				Constants.LABEL_MIDDLE));
		inputField.setHorizontalAlignment(JTextField.CENTER);
		resultHint.setVisible(false);

		centerPanel.add(paraphrase);
		centerPanel.add(inputField);
		centerPanel.add(resultHint);

		paraphrase.setBounds(0, PADDING, Constants.GLOBAL_WIDTH,
				Constants.UNITHEIGHT);
		inputField.setBounds(Constants.GLOBAL_WIDTH / 2
				- (int) (Constants.UNITHEIGHT * 1.5), Constants.UNITHEIGHT
				+ PADDING, 3 * Constants.UNITHEIGHT, Constants.LABEL_LARGE);
		resultHint.setBounds(0, 3 * Constants.UNITHEIGHT,
				Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);

	}

	protected void addListener() {
		inputField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent evt) {
				if(evt.getKeyChar() == KeyEvent.VK_ENTER){
					inputField.setEditable(false);
					controller.checkCorrect(inputField.getText());
					
				}
			}
		});
	}

	/**
	 * Set the result info text and set visible.
	 * @param info
	 */
	public void setCorrectInfoText(String info) {
		resultHint.setText(info);
		resultHint.setVisible(true);
	}

	/**
	 * Set the paraphrase Chinese meaning. Simultaneously hide the correct info text.
	 * @param meaning
	 */
	public void setMeaningText(String meaning) {
		paraphrase.setText(meaning);
		resultHint.setVisible(false);
	}
	
	/**
	 * Empty the input field.
	 */
	public void emptyInputField(){
		inputField.setText("");
		inputField.setEditable(true);
	}

}
