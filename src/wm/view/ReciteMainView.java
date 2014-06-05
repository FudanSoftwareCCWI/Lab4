/**
 * Software Engineer lab4
 */
package wm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import wm.config.Constants;
import wm.controller.IReciteMainController;
import wm.view.component.*;

/**
 * Class ReciteMainView represents a recite main view, which shows a list of all
 * dictionaries and allows user to select one to recite. It is managed by a
 * recite main controller. It is the beginning view of the recite.
 * 
 * @author Sidney Fan
 * 
 */
public class ReciteMainView extends WMView {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -5827806794895012421L;
	private IReciteMainController controller;
	private JPanel dictionaryInfoPanel;
	private JPanel listPanel;
	private JScrollPane scrollPane;

	/* dictionary info */
	private WMLabel dictionaryNameLabel;
	private WMLabel totalNumLabel;
	private WMLabel dictSizeLabel;
	private WMLabel sizeRateLabel;
	private WMPie pie;
	private JPanel piePanel;
	private JButton quitBtn;
	private JButton homeBtn;
	private JButton nextBtn;
	/* dictionary list */
	private List<String> dictList;
	private int currentDictIndex;

	public ReciteMainView(IReciteMainController controller) {
		super();
		this.controller = controller;
		initComponents();
		initListener();
	}

	@Override
	protected void initComponents() {
		initUnitInfoPanel();
		initListPanel();
		updateView();
	}

	private void updateView() {
		// add left and right to view
		this.removeAll();
		this.setLayout(null);
		this.add(dictionaryInfoPanel);
		this.add(scrollPane);
		// set position and size
		dictionaryInfoPanel.setBounds(0, 0, Constants.UNITSHORTWIDTH,
				Constants.GLOBAL_HEIGHT);
		dictionaryInfoPanel.setOpaque(false);
		scrollPane.setBounds(Constants.UNITSHORTWIDTH, 0,
				Constants.UNITLONGWIDTH, Constants.GLOBAL_HEIGHT);
		scrollPane.setOpaque(false);
		scrollPane.getVerticalScrollBar().setUI(null);
		listPanel.setPreferredSize(new Dimension(scrollPane.getWidth() - 50,
				Constants.NUM_ROW * Constants.UNITHEIGHT));
		listPanel.revalidate();
	}

	private void initUnitInfoPanel() {
		// init statistic panels
		dictionaryInfoPanel = new JPanel();
		dictionaryInfoPanel.setLayout(null);

		// 1 row
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1, 1));
		titlePanel.add(new WMLabel("Word Master", Constants.LABEL_NORMAL));
		titlePanel.setOpaque(false);

		// 2 row
		dictionaryNameLabel = new WMLabel("词库 ~", Constants.LABEL_MIDDLE);
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new GridLayout(1, 1));
		totalPanel.add(dictionaryNameLabel);
		totalPanel.setOpaque(false);

		// 3 row
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(2, 3));
		WMLabel recite = new WMLabel("单词总量", Constants.LABEL_SMALL);
		WMLabel correct = new WMLabel("单词量", Constants.LABEL_SMALL);
		WMLabel rate = new WMLabel("词量比例", Constants.LABEL_SMALL);
		totalNumLabel = new WMLabel("~", Constants.LABEL_SMALL);
		dictSizeLabel = new WMLabel("~", Constants.LABEL_SMALL);
		sizeRateLabel = new WMLabel("~", Constants.LABEL_SMALL);
		totalNumLabel.setVerticalAlignment(JLabel.TOP);
		dictSizeLabel.setVerticalAlignment(JLabel.TOP);
		sizeRateLabel.setVerticalAlignment(JLabel.TOP);
		infoPanel.add(recite);
		infoPanel.add(correct);
		infoPanel.add(rate);
		infoPanel.add(totalNumLabel);
		infoPanel.add(dictSizeLabel);
		infoPanel.add(sizeRateLabel);
		infoPanel.setOpaque(false);

		// 4-5
		pie = new WMPie();
		pie.setBounds((Constants.UNITSHORTWIDTH - Constants.ICON_MIDDLE) / 2,
				0, Constants.ICON_MIDDLE + 1, Constants.ICON_MIDDLE);
		piePanel = new JPanel();
		piePanel.setLayout(null);
		piePanel.setOpaque(false);
		piePanel.add(pie);

		// 6
		quitBtn = new JButton(Constants.QUITICON);
		homeBtn = new JButton(Constants.HOMEICON);
		nextBtn = new JButton(Constants.NEXTICON);
		quitBtn.setBorder(null);
		homeBtn.setBorder(null);
		nextBtn.setBorder(null);
		JPanel iconPanel = new JPanel();
		iconPanel.setOpaque(false);
		iconPanel.setLayout(new GridLayout(1, 3));
		iconPanel.add(homeBtn);
		iconPanel.add(nextBtn);
		iconPanel.add(quitBtn);

		// add all and set position
		dictionaryInfoPanel.add(titlePanel);
		dictionaryInfoPanel.add(totalPanel);
		dictionaryInfoPanel.add(infoPanel);
		dictionaryInfoPanel.add(piePanel);
		dictionaryInfoPanel.add(iconPanel);
		titlePanel.setBounds(0, 0, Constants.UNITSHORTWIDTH,
				Constants.UNITHEIGHT);
		totalPanel.setBounds(0, Constants.UNITHEIGHT, Constants.UNITSHORTWIDTH,
				Constants.UNITHEIGHT);
		infoPanel.setBounds(25, 2 * Constants.UNITHEIGHT,
				Constants.UNITSHORTWIDTH - 50, Constants.UNITHEIGHT);
		piePanel.setBounds(0, 3 * Constants.UNITHEIGHT,
				Constants.UNITSHORTWIDTH, 2 * Constants.UNITHEIGHT);
		iconPanel.setBounds(0, Constants.GLOBAL_HEIGHT - Constants.UNITHEIGHT,
				Constants.UNITSHORTWIDTH, Constants.UNITHEIGHT);
	}

	private void initListPanel() {
		listPanel = new JPanel();
		scrollPane = new JScrollPane(listPanel);
		scrollPane.setBorder(null);
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
				// System.out.println("UnitView: Fire dictionaryViewToHomeCommand");
				// ReciteMainView.this.firePropertyChange("dictionaryViewToHomeCommand",
				// null, null);
				controller.switchToHome();
			}

		});

		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.switchToStartSelect(currentDictIndex);
			}
		});
	}

	private void setListBlockListener() {
		for (final Component block : listPanel.getComponents()) {
			block.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					setCurrentBlock((WMBlock) block);
					controller.showDictionaryDetail(currentDictIndex);
				}
			});
		}
	}

	/**
	 * <b>setListPanelContent</b>
	 * 
	 * <pre>
	 * <code>public void <b>setListPanelContent</b>(List&lt;<em>String</em>&gt; nameList)</code>
	 * </pre>
	 * 
	 * <blockquote> Set the content of the dictionary list panel. <br>
	 * <br>
	 * 
	 * @param nameList
	 *            -The name list of all dictionaries, such as "Dictionary A" or
	 *            "Dictionary B". </blockquote>
	 */
	public void setListPanelContent(List<String> nameList) {
		dictList = nameList;
		listPanel.removeAll();
		listPanel.setLayout(new GridLayout(nameList.size(), 1));
		WMBlock tempBlock;
		String tempname;
		Iterator<String> it = dictList.iterator();
		int i = 0;
		while (it.hasNext()) {
			tempname = it.next();
			tempBlock = new WMBlock(Constants.UNITLONGWIDTH,
					Constants.UNITHEIGHT, 1, 1);
			tempBlock.addLabel(tempname, Constants.LABEL_MIDDLE);
			listPanel.add(tempBlock);
			if (i % 2 == 0) {
				tempBlock.setColor(Constants.NORMALGREEN, Constants.DARKGREEN);
			} else {
				tempBlock.setColor(Constants.LIGHTGREEN, Constants.DARKGREEN);
			}
			i++;
		}
		// set new blocks listener
		setListBlockListener();
	}

	/**
	 * Set the text of the name label the name of the selected dictionary.
	 * 
	 * @param name
	 *            The name of the dictionary
	 */
	public void setNameLabelText(String name) {
		dictionaryNameLabel.setText(name);
		dictionaryNameLabel.revalidate();
	}

	/**
	 * Set the pie icon according the size of the selected dictionary and total
	 * size of all dictionaries.
	 * 
	 * @param size
	 *            The size of the selected dictionary
	 * @param totalSize
	 *            The total size of all dictionaries
	 */
	public void setPieIcon(int size, int totalSize) {
		dictSizeLabel.setText(String.valueOf(size));
		totalNumLabel.setText(String.valueOf(totalSize));

		int rate = (int) (((double) size / (double) totalSize) * 100);
		sizeRateLabel.setText(String.format("%d%%", rate));
		pie.createPie(new int[] { size, totalSize - size });
		piePanel.repaint();
	}

	/**
	 * Set the text of the size label.
	 * 
	 * @param size
	 *            The size of the selected dictionary
	 */
	public void setSizeLabelText(int size) {
		dictSizeLabel.setText(String.valueOf(size));
	}

	/**
	 * Set the text of the total size label.
	 * 
	 * @param size
	 *            The total size of all dictionaries
	 */
	public void setTotalSizeLabelText(int totalSize) {
		totalNumLabel.setText(String.valueOf(totalSize));
	}

	/**
	 * Returns current clicked dictionary's index. Should be called when switch
	 * to recite process view.
	 * 
	 * @return currentDictIndex
	 */
	public int getCurrentDictIndex() {
		return currentDictIndex;
	}

	/**
	 * Set the current dictionary. This method will paint the current index
	 * block simultaneously.
	 * 
	 * @param currentDictIndex
	 */
	public void setCurrentDictIndex(int currentDictIndex) {
		setCurrentBlock((WMBlock) (listPanel.getComponents()[currentDictIndex]));
	}

	private void setCurrentBlock(WMBlock clickedBlock) {
		Component[] siblings = listPanel.getComponents();
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
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Constants.DARKGREEN);
		g.fillRect(0, 0, Constants.UNITSHORTWIDTH, Constants.GLOBAL_HEIGHT);
		g.setColor(Constants.LIGHTGREEN);
		g.fillRect(Constants.UNITSHORTWIDTH, 0, Constants.UNITLONGWIDTH,
				Constants.GLOBAL_HEIGHT);
	}
}
