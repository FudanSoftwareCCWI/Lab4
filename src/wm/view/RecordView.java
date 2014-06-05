/**
 * Software Engineer lab4
 */
package wm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import wm.config.Constants;
import wm.controller.IReciteProcessController;
import wm.controller.IRecordController;
import wm.view.component.WMBar;
import wm.view.component.WMBlock;
import wm.view.component.WMButton;
import wm.view.component.WMLabel;
import wm.view.component.WMPie;
import wm.view.component.WMTable;

/**
 * Class RecordView represents a record view and is managed by a record view
 * controller. It provides different methods to show the recite record.
 * 
 * @author Sidney Fan
 * 
 */
public class RecordView extends WMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2917311740345650657L;
	protected IRecordController controller;
	/* Button */
	protected JButton quitBtn;
	protected JButton homeBtn;
	protected WMButton tableBlock;
	protected WMButton pieBlock;
	protected WMButton barBlock;
	/* Label */
	protected WMLabel headLine;
	protected WMLabel dictNameLabel;
	protected WMLabel dictSizeLabel;
	protected WMLabel dictRecitedLabel;
	protected WMLabel dictCorrectLabel;
	protected WMLabel dictWrongLabel;
	protected WMLabel dictRateLabel;
	protected int dictSizeValue;
	protected int dictRecitedValue;
	protected int dictCorrectValue;
	protected int dictWrongValue;
	protected int dictRateValue;
	/* Panel */
	protected JPanel navPanel;
	protected JPanel centerPanel;
	protected JPanel bottomNav;
	protected JPanel tablePanel;
	protected JPanel piePanel;
	protected JPanel barPanel;
	protected JPanel infoPanel;
	protected JPanel iconPanel;
	/* Padding */
	static int PADDING = 50;
	/* Combobox */
	protected WMListBox listBox;
	/* Status */
	private int currentBtnIndex;
	private static int INTABLE = 1;
	private static int INPIE = 2;
	private static int INBAR = 3;
	private int currentDicIndex;
	/* Dictionary list */
	private List<String> dictist;
	/* Icons */
	private WMTable tableIcon;
	private WMPie pieCorrectIcon;
	private WMPie pieRecitedIcon;
	private WMBar barCorrectIcon;
	private WMBar barRecitedIcon;

	/**
	 * Constructor of RecordView.<br>
	 * Invoke sequence<br>
	 * <blockquote> After Instantiate, invoke following first:<br>
	 * <ul>
	 * <li>setDictist(List<String> dictist): set dictionary list</li>
	 * <li>setSizeText</li>
	 * <li>setReciteSizeText</li>
	 * <li>setCorrectText</li>
	 * <li>setCorrectPercentage</li>
	 * <li>setWrongText</li>
	 * </ul>
	 * After above, for specified condition (default show table panel), invoke
	 * following functions:
	 * <ul>
	 * <li>showTablePanel</li>
	 * <li>showPiePanel</li>
	 * <li>showBarPanel</li>
	 * </ul>
	 * 
	 * </blockquote>
	 * 
	 * @param controller
	 */
	public RecordView(IRecordController controller) {
		super();
		this.controller = controller;
		initComponents();
		initListener();
		// default
		// showTablePanel();
	}

	/**
	 * Set dictionary list.
	 * 
	 * @param dictist
	 */
	public void setDictist(List<String> dictist) {
		this.dictist = dictist;
		listBox.setText(0);
	}

	/**
	 * Set dictionary total size.
	 * 
	 * @param size
	 */
	public void setSizeText(int size) {
		dictSizeValue = size;
		dictSizeLabel.setText("");
		dictSizeLabel.setLayout(new GridLayout(2, 1));
		dictSizeLabel.add(new WMLabel(Constants.CHIN_TOTAL,
				Constants.LABEL_TINY));
		dictSizeLabel.add(new WMLabel(String.valueOf(size),
				Constants.LABEL_TINY));
	}

	/**
	 * Set recited size.
	 * 
	 * @param recitedSize
	 */
	public void setReciteSizeText(int recitedSize) {
		dictRecitedValue = recitedSize;
		dictRecitedLabel.setText("");
		dictRecitedLabel.setLayout(new GridLayout(2, 1));
		dictRecitedLabel.add(new WMLabel(Constants.CHIN_RECITED,
				Constants.LABEL_TINY));
		dictRecitedLabel.add(new WMLabel(String.valueOf(recitedSize),
				Constants.LABEL_TINY));
	}

	/**
	 * Set correct size.
	 * 
	 * @param correct
	 */
	public void setCorrectText(int correct) {
		dictCorrectValue = correct;
		dictCorrectLabel.setText("");
		dictCorrectLabel.setLayout(new GridLayout(2, 1));
		dictCorrectLabel.add(new WMLabel(Constants.CHIN_CORRECT,
				Constants.LABEL_TINY));
		dictCorrectLabel.add(new WMLabel(String.valueOf(correct),
				Constants.LABEL_TINY));
	}

	/**
	 * Set correct percentage.
	 * 
	 * @param percentage
	 */
	public void setCorrectPercentage(double percentage) {
		dictRateValue = (int) (percentage * 100);
		dictRateLabel.setText("");
		dictRateLabel.setLayout(new GridLayout(2, 1));
		dictRateLabel
				.add(new WMLabel(Constants.CHIN_RATE, Constants.LABEL_TINY));
		dictRateLabel.add(new WMLabel(String.valueOf((int) (percentage * 100))
				+ "%", Constants.LABEL_TINY));
	}

	/**
	 * Set wrong size.
	 * 
	 * @param wrong
	 */
	public void setWrongText(int wrong) {
		dictWrongValue = wrong;
		dictWrongLabel.setText("");
		dictWrongLabel.setLayout(new GridLayout(2, 1));
		dictWrongLabel.add(new WMLabel(Constants.CHIN_TOTAL,
				Constants.LABEL_TINY));
		dictWrongLabel.add(new WMLabel(String.valueOf(wrong),
				Constants.LABEL_TINY));
	}

	/**
	 * Set correct pie icon data.
	 * 
	 * @param correct
	 * @param size
	 *            -recited size
	 */
	public void setPieCorrectIcon(int correct, int size) {
		pieCorrectIcon.createPie(new int[] { correct, size - correct });
	}

	/**
	 * Set recited pie icon data.
	 * 
	 * @param recited
	 * @param size
	 *            -total size
	 */
	public void setPieRecitedIcon(int recited, int size) {
		pieRecitedIcon.createPie(new int[] { recited, size - recited });
		pieRecitedIcon.repaint();
	}

	/**
	 * Set correct bar data.
	 * 
	 * @param list
	 *            -List of integers of percentage, e.g. {86,72,...}
	 */
	public void setBarCorrectIcon(List<Integer> list) {
		barCorrectIcon.createBar(list, currentDicIndex);
		barCorrectIcon.repaint();
	}

	/**
	 * Set recietd bar data.
	 * 
	 * @param list
	 *            -List of integers of percentage, e.g. {86,72,...}
	 */
	public void setBarRecitedIcon(List<Integer> list) {
		barRecitedIcon.createBar(list, currentDicIndex);
		barRecitedIcon.repaint();
	}

	/**
	 * Set head line text.
	 * 
	 * @param text
	 */
	public void setHeadLineText(String text) {
		headLine.setText(text);
	}

	/**
	 * Get the head line text.
	 * 
	 * @return head line string text.
	 */
	public String getHeadLineText() {
		return headLine.getText();
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
		headLine = new WMLabel("Statisics", Constants.LABEL_NORMAL);
		navPanel.setLayout(null);
		navPanel.add(homeBtn);
		navPanel.add(quitBtn);
		navPanel.add(headLine);
		homeBtn.setBounds(0, 0, Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		quitBtn.setBounds(Constants.GLOBAL_WIDTH - Constants.UNITHEIGHT, 0,
				Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		headLine.setBounds(Constants.UNITHEIGHT, 0, Constants.GLOBAL_WIDTH - 2
				* Constants.UNITHEIGHT, Constants.UNITHEIGHT);
		addCenterPanel();
	}

	private void addCenterPanel() {
		centerPanel.setLayout(null);
		// initialize different components
		initDictNamePanel();
		initInfoPanel();
		initTablePanel();
		initIconPanel();

	}

	private void initDictNamePanel() {
		listBox = new WMListBox(Constants.UNITHEIGHT, Constants.LABEL_SMALL + 5);
		dictNameLabel = new WMLabel(Constants.CHIN_DICTNAME,
				Constants.LABEL_TINY);
		dictNameLabel.setBounds(0, 0, Constants.GLOBAL_WIDTH, PADDING);
		listBox.setBounds((Constants.GLOBAL_WIDTH - Constants.UNITHEIGHT) / 2,
				PADDING, Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);
		centerPanel.add(dictNameLabel);
		centerPanel.add(listBox);
	}

	private void initInfoPanel() {
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(5, 1));
		infoPanel.setOpaque(false);

		dictSizeLabel = new WMLabel(Constants.CHIN_TOTAL, Constants.LABEL_TINY);
		dictRecitedLabel = new WMLabel(Constants.CHIN_RECITED,
				Constants.LABEL_TINY);
		dictCorrectLabel = new WMLabel(Constants.CHIN_CORRECT,
				Constants.LABEL_TINY);
		dictWrongLabel = new WMLabel(Constants.CHIN_WRONG, Constants.LABEL_TINY);
		dictRateLabel = new WMLabel(Constants.CHIN_RATE, Constants.LABEL_TINY);

		infoPanel.add(dictSizeLabel);
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

		initPiePanel();
		initBarPanel();
		initBottomNav();
	}

	private void initTablePanel() {
		tablePanel = new JPanel();
		// default
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		names.add(Constants.CHIN_TOTAL);
		names.add(Constants.CHIN_RECITED);
		names.add(Constants.CHIN_CORRECT);
		names.add(Constants.CHIN_WRONG);
		names.add(Constants.CHIN_RATE);
		values.add(dictSizeValue);
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
	}

	private void initPiePanel() {
		piePanel = new JPanel();
		pieCorrectIcon = new WMPie();
		pieRecitedIcon = new WMPie();
		WMLabel corrLabel = new WMLabel(Constants.CHIN_CORRECT_WRONG_RATIO,
				Constants.LABEL_TINY);
		WMLabel reciLabel = new WMLabel(Constants.CHIN_RECITE_PIE,
				Constants.LABEL_TINY);

		piePanel.setLayout(null);
		piePanel.setOpaque(false);

		pieCorrectIcon.setBounds(0, 0, Constants.ICON_MIDDLE,
				Constants.ICON_MIDDLE);
		pieRecitedIcon.setBounds(Constants.ICON_MIDDLE + PADDING, 0,
				Constants.ICON_MIDDLE, Constants.ICON_MIDDLE);
		corrLabel.setBounds(0, Constants.ICON_MIDDLE + 10,
				Constants.ICON_MIDDLE, Constants.LABEL_SMALL);
		reciLabel.setBounds(Constants.ICON_MIDDLE + PADDING,
				Constants.ICON_MIDDLE + 10, Constants.ICON_MIDDLE,
				Constants.LABEL_SMALL);

		piePanel.add(pieCorrectIcon);
		piePanel.add(pieRecitedIcon);
		piePanel.add(corrLabel);
		piePanel.add(reciLabel);

		piePanel.setBounds(0, 0, 2 * Constants.ICON_MIDDLE + PADDING,
				Constants.ICON_MIDDLE + PADDING);
	}

	private void initBarPanel() {
		barPanel = new JPanel();
		barCorrectIcon = new WMBar();
		barRecitedIcon = new WMBar();

		barPanel.setLayout(null);
		barPanel.setOpaque(false);

		barCorrectIcon.setBounds(0, 0, 2 * Constants.ICON_MIDDLE,
				Constants.UNITHEIGHT);
		barRecitedIcon.setBounds(0, Constants.UNITHEIGHT + PADDING,
				2 * Constants.ICON_MIDDLE, Constants.UNITHEIGHT);

		barPanel.add(barCorrectIcon);
		barPanel.add(barRecitedIcon);

		barPanel.setBounds(0, 0, 2 * Constants.ICON_MIDDLE + PADDING,
				Constants.ICON_MIDDLE + PADDING);
	}

	private void initBottomNav() {
		currentBtnIndex = 0;
		bottomNav = new JPanel();
		tableBlock = new WMButton(Constants.TABLEICON96);
		pieBlock = new WMButton(Constants.PIEICON96);
		barBlock = new WMButton(Constants.BARICON96);
		tableBlock.setBorder(null);
		pieBlock.setBorder(null);
		barBlock.setBorder(null);
		tableBlock.setColor(Constants.NORMALGREEN, Constants.DARKGREEN);
		pieBlock.setColor(Constants.NORMALGREEN, Constants.DARKGREEN);
		barBlock.setColor(Constants.NORMALGREEN, Constants.DARKGREEN);
		tableBlock.setOpaque(true);
		pieBlock.setOpaque(true);
		barBlock.setOpaque(true);

		centerPanel.add(tableBlock);
		centerPanel.add(pieBlock);
		centerPanel.add(barBlock);

		tableBlock.setBounds(0, Constants.GLOBAL_HEIGHT - 2
				* Constants.UNITHEIGHT, Constants.GLOBAL_WIDTH / 3,
				Constants.UNITHEIGHT);
		pieBlock.setBounds(Constants.GLOBAL_WIDTH / 3, Constants.GLOBAL_HEIGHT
				- 2 * Constants.UNITHEIGHT, Constants.GLOBAL_WIDTH / 3 + 1,
				Constants.UNITHEIGHT);
		barBlock.setBounds(Constants.GLOBAL_WIDTH * 2 / 3,
				Constants.GLOBAL_HEIGHT - 2 * Constants.UNITHEIGHT,
				Constants.GLOBAL_WIDTH / 3, Constants.UNITHEIGHT);
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

		tableBlock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setCurrentBlock(tableBlock);
				currentBtnIndex = INTABLE;
				// showTablePanel(); // TODO should be remove after publish
			}
		});

		pieBlock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setCurrentBlock(pieBlock);
				currentBtnIndex = INPIE;
				// showPiePanel(); // TODO should be remove after publish
			}
		});

		barBlock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setCurrentBlock(barBlock);
				currentBtnIndex = INBAR;
				// showBarPanel(); // TODO should be remove after publish
			}
		});

	}

	private void setCurrentBlock(WMButton clickedbtn) {
		tableBlock.release();
		tableBlock.paintLocal();
		pieBlock.release();
		pieBlock.paintLocal();
		barBlock.release();
		barBlock.paintLocal();
		clickedbtn.paintPress();
		clickedbtn.fix();
		// inform controller TODO should remove comment
		// if (currentBtnIndex == INTABLE) {
		// controller.showRecordByTable(currentDicIndex);
		// } else if (currentBtnIndex == INPIE) {
		// controller.showRecordByPie(currentDicIndex);
		// } else if (currentBtnIndex == INBAR) {
		// controller.showRecordByBar(currentDicIndex);
		// }

	}

	public void showTablePanel() {
		iconPanel.removeAll();
		iconPanel.add(tablePanel);
		iconPanel.repaint();

		// TODO
		controller.showRecordByPie(currentDicIndex);
		listBox.setText(currentDicIndex);
	}

	public void showPiePanel() {
		iconPanel.removeAll();
		iconPanel.add(piePanel);
		iconPanel.repaint();

		// TODO
		controller.showRecordByPie(currentDicIndex);
		listBox.setText(currentDicIndex);
	}

	public void showBarPanel() {
		iconPanel.removeAll();
		iconPanel.add(barPanel);
		iconPanel.repaint();

		// TODO
		controller.showRecordByPie(currentDicIndex);
		listBox.setText(currentDicIndex);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Constants.LIGHTGREEN);
		g.fillRect(0, 0, Constants.GLOBAL_WIDTH, Constants.GLOBAL_HEIGHT);
		g.setColor(Constants.NORMALGREEN);
		g.fillRect(0, 0, Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);
		g.fillRect(0, Constants.GLOBAL_HEIGHT - Constants.UNITHEIGHT,
				Constants.GLOBAL_WIDTH, Constants.UNITHEIGHT);
	}

	protected class WMListBox extends JComponent {

		JTextField field;
		JScrollPane scrollPane;
		JPanel comboBox;

		int width;
		int height;
		int currentDictIndex;
		boolean isComboShow;

		WMListBox(int width, int height) {
			this.width = width;
			this.height = height;
			this.isComboShow = false;

			initWMComboBox();
			initComboListener();
		}

		private void initWMComboBox() {
			field = new JTextField();
			comboBox = new JPanel();
			scrollPane = new JScrollPane(comboBox);

			field.setBorder(new MatteBorder(1, 0, 1, 0, Color.WHITE));
			scrollPane.setBorder(null);
			scrollPane.getVerticalScrollBar().setUI(null);
			field.setFont(new Font(Constants.LABEL_FONT, Font.PLAIN,
					Constants.LABEL_TINY));
			field.setForeground(Color.WHITE);
			field.setBackground(new Color(0, 0, 0, 0));
			field.setEditable(false);

			this.setLayout(null);
			this.add(field);
			this.add(scrollPane);
			field.setBounds(0, 0, width, height);
			scrollPane.setBounds(0, height + 5, width, 2 * height);
			hideComboBox();
		}

		public String getPrefix() {
			return field.getText();
		}

		private void initComboListener() {
			field.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (isComboShow) {
						hideComboBox();
					} else {
						setComboBox();
					}
				}
			});
		}

		public void setComboBox() {
			comboBox.removeAll();
			comboBox.setLayout(new GridLayout(dictist.size(), 1));
			if (dictist.size() == 0)
				return;
			WMBlock tempBlock;
			String tempname;
			Iterator<String> it = dictist.iterator();
			while (it.hasNext()) {
				tempname = it.next();
				tempBlock = new WMBlock(width, 20, 1, 1);
				tempBlock.addLeftLabel(tempname, Constants.LABEL_TINY);
				tempBlock.setColor(Constants.LIGHTGREEN, Constants.NOTEALPHA);
				comboBox.add(tempBlock);
			}
			comboBox.setPreferredSize(new Dimension(scrollPane.getWidth() - 50,
					dictist.size() * (Constants.LABEL_SMALL + 3)));
			setListBlockListener();
			showComboBox();
		}

		public void showComboBox() {
			isComboShow = true;
			scrollPane.setVisible(true);
		}

		public void hideComboBox() {
			isComboShow = false;
			scrollPane.setVisible(false);
		}

		private void setListBlockListener() {
			for (final Component block : comboBox.getComponents()) {
				block.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						setCurrentBlock((WMBlock) block);
						field.setText(dictist.get(currentDictIndex));
					}
				});
			}
		}

		private void setCurrentBlock(WMBlock clickedBlock) {
			Component[] siblings = comboBox.getComponents();
			int i = 0;
			for (Component block : siblings) {
				if (clickedBlock.equals((WMBlock) block)) {
					this.currentDictIndex = i;
					continue;
				}
				((WMBlock) block).release();
				((WMBlock) block).paintLocal();
				i++;
			}
			clickedBlock.paintPress();
			clickedBlock.fix();
			hideComboBox();
		}

		protected JTextField getField() {
			return field;
		}

		protected void setText(String text) {
			field.setText(text);
		}

		protected void setText(int index) {
			if (index < 0) {
				field.setText("Empty");
			} else
				field.setText(dictist.get(index));

		}

	}

}
