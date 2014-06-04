/**
 * Software Engineer lab4
 */
package wm.view;

import wm.controller.IReciteProcessController;

/**
 * Abstract Class ReciteProcessView represents a recite process view, which shows the recite process. Any views of each step for the recite process should extends this view. It is managed by a recite process view
 * controller.
 * 
 * @author Sidney Fan
 * 
 */
public abstract class ReciteProcessView extends WMView {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -5105958811645184995L;

	protected IReciteProcessController controller;
<<<<<<< HEAD
=======
	/* Button */
	protected JButton quitBtn;
	protected JButton homeBtn;
	/* Label */
	protected WMLabel headLine;
	protected WMLabel tipLabel;
	/* Panel */
	protected JPanel navPanel;
	protected JPanel centerPanel;
	/* Padding */
	static int PADDING = 50;

	public ReciteProcessView(IReciteProcessController controller) {
		super();
		this.controller = controller;
		initComponents();
		initListener();
	}

	@Override
	protected void initComponents() {
		// Global
		navPanel = new JPanel();
		centerPanel = new JPanel();
		this.setLayout(null);
		this.add(navPanel);
		this.add(centerPanel);
		navPanel.setBounds(0, 0, Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);
		centerPanel.setBounds(0, Constants.UNITHEIGHT, Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_HEIGHT - Constants.UNITHEIGHT);
		navPanel.setOpaque(false);
		centerPanel.setOpaque(false);
		// navigator
		homeBtn = new JButton(Constants.HOMEICON);
		quitBtn = new JButton(Constants.QUITICON);
		homeBtn.setBorder(null);
		quitBtn.setBorder(null);
		headLine = new WMLabel("Dictionary", Constants.LABEL_NORMAL);
		navPanel.setLayout(null);
		navPanel.add(homeBtn);
		navPanel.add(quitBtn);
		navPanel.add(headLine);
		homeBtn.setBounds(0, 0, Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		quitBtn.setBounds(Constants.GLOBAL_WIDTH - Constants.UNITHEIGHT, 0,
				Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		headLine.setBounds(Constants.UNITHEIGHT, 0, Constants.GLOBAL_WIDTH - 2
				* Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		// center
		centerPanel.setLayout(null);
		tipLabel = new WMLabel("", Constants.LABEL_SMALL);
		centerPanel.add(tipLabel);
		tipLabel.setBounds(0, PADDING/2, Constants.GLOBAL_WIDTH,
				Constants.UNITHEIGHT);
	}

	/**
	 * Sets the top head line of recite process view.
	 * @param text
	 */
	protected void setHeadLineText(String text){
		headLine.setText(text);
	}
	
	protected String getHeadLineText(){
		return headLine.getText();
	}
	
	protected void setTip(String text){
		tipLabel.setText(text);
	}
	
	protected void hideTip(){
		centerPanel.remove(tipLabel);
	}
	
	@Override
	protected void initListener() {
		quitBtn.addActionListener(new ActionListener() {
>>>>>>> SidneyFan

	public ReciteProcessView(IReciteProcessController controller){
		this.controller=controller;
	}
}
