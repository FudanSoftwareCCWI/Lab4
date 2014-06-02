package wm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.view.component.WMLabel;

/**
 * Class StartSelectView represents three ways to start recite, the user can
 * choose what he want and go to next step.
 * 
 * @author Sidney Fan
 * 
 */
public class StartSelectView extends WMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4531368146481645750L;

	private IReciteProcessController controller;

	/* Components */
	/* Panel */
	private JPanel navPanel;
	private JPanel selectPanel;
	/* Button */
	private JButton quitBtn;
	private JButton homeBtn;
	private SelectButton startByFirstBtn;
	private SelectButton startByLastBtn;
	private SelectButton startByCustomBtn;

	/* Label */
	private WMLabel headLine;

	/**
	 * <b>StartSelectView</b>
	 * 
	 * <pre>
	 * <code>public StartSelectView(IReciteProcessController controller)</code>
	 * </pre>
	 * 
	 * <blockquote>
	 * <p>
	 * Constructor of home view.
	 * </p>
	 * 
	 * @param controller
	 *            -controller of home view
	 * 
	 */
	public StartSelectView(IReciteProcessController controller) {
		super();
		this.controller = controller;
		initComponents();
		initListener();
	}

	@Override
	protected void initComponents() {
		// Global
		navPanel = new JPanel();
		selectPanel = new JPanel();
		this.setLayout(null);
		this.add(navPanel);
		this.add(selectPanel);
		navPanel.setBounds(0, 0, Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);
		selectPanel.setBounds(0, Constants.UNITHEIGHT, Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_HEIGHT - Constants.UNITHEIGHT);
		navPanel.setOpaque(false);
		selectPanel.setOpaque(false);
		// navigator
		homeBtn = new JButton(Constants.HOMEICON);
		quitBtn = new JButton(Constants.QUITICON);
		homeBtn.setBorder(null);
		quitBtn.setBorder(null);
		headLine = new WMLabel("Dictionary", Constants.NORMALLABEL);
		navPanel.setLayout(null);
		navPanel.add(homeBtn);
		navPanel.add(quitBtn);
		navPanel.add(headLine);
		homeBtn.setBounds(0, 0, Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		quitBtn.setBounds(Constants.GLOBAL_WIDTH - Constants.UNITHEIGHT, 0,
				Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		headLine.setBounds(Constants.UNITHEIGHT, 0, Constants.GLOBAL_WIDTH - 2
				* Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		// selector
		selectPanel.setLayout(null);
		startByFirstBtn = new SelectButton(Constants.CHIN_STAETBYFIRST);
		startByLastBtn = new SelectButton(Constants.CHIN_STARTBYLAST);
		startByCustomBtn = new SelectButton(Constants.CHIN_STARTBYCUSTOM);
		WMLabel selectTip = new WMLabel(Constants.CHIN_SELECTSTARTMETHOD,
				Constants.SMALLERLABEL);
		selectPanel.add(selectTip);
		selectPanel.add(startByFirstBtn);
		selectPanel.add(startByLastBtn);
		selectPanel.add(startByCustomBtn);
		int padding = 50;
		selectTip.setBounds(0, padding, Constants.GLOBAL_WIDTH,
				Constants.UNITHEIGHT);
		startByFirstBtn.setBounds(padding, Constants.UNITHEIGHT + padding,
				Constants.ICON_MIDDLE, Constants.ICON_MIDDLE);
		startByLastBtn.setBounds(
				(Constants.GLOBAL_WIDTH - Constants.ICON_MIDDLE) / 2,
				Constants.UNITHEIGHT + padding, Constants.ICON_MIDDLE,
				Constants.ICON_MIDDLE);
		startByCustomBtn.setBounds(Constants.GLOBAL_WIDTH
				- Constants.ICON_MIDDLE - padding, Constants.UNITHEIGHT
				+ padding, Constants.ICON_MIDDLE, Constants.ICON_MIDDLE);

	}

	@Override
	protected void initListener() {
		quitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // TODO should fire quit
			}

		});

		homeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.switchToHome();
			}

		});
		startByFirstBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.startByFirstWord();
			}

		});
		startByLastBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.startByLastTime();
			}

		});
		startByCustomBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.switchToStartWordDefine();
			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Constants.LIGHTGREEN);
		g.fillRect(0, 0, Constants.GLOBAL_WIDTH, Constants.GLOBAL_HEIGHT);
		g.setColor(Constants.NORMALGREEN);
		g.fillRect(0, 0, Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);
	}

	public class SelectButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7507522887537228688L;
		private String text;

		public SelectButton(String text) {
			super(text);
			this.text = text;
			this.setBorder(null);
			this.setFont(new Font(Constants.LABELFONT, Font.PLAIN,
					Constants.SMALLERLABEL));
			this.setForeground(Constants.NORMALGREEN);
		}

		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Constants.NORMALGREEN);
			g.fillArc(0, 0, Constants.ICON_MIDDLE, Constants.ICON_MIDDLE, 0,
					360);
			g.setColor(Color.WHITE);
			g.fillArc(Constants.ICON_BORDER, Constants.ICON_BORDER,
					Constants.ICON_MIDDLE - 2 * Constants.ICON_BORDER,
					Constants.ICON_MIDDLE - 2 * Constants.ICON_BORDER, 0, 360);
			super.paintComponent(g);
		}
	}

	public JButton getQuitBtn() {
		return quitBtn;
	}

	public JButton getHomeBtn() {
		return homeBtn;
	}

	public SelectButton getStartByFirstBtn() {
		return startByFirstBtn;
	}

	public SelectButton getStartByLastBtn() {
		return startByLastBtn;
	}

	public SelectButton getStartByCustomBtn() {
		return startByCustomBtn;
	}
	
	
}
