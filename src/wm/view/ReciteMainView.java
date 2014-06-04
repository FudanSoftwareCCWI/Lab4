/**
 * Software Engineer lab4
 */
package wm.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JPanel unitInfoPanel;
	private JPanel listPanel;
	private JScrollPane scrollPane;

	// unit info
	private WMLabel unitNameLabel;
	private WMLabel totalNumLabel;
	private WMLabel recitedNumLabel;
	private WMLabel correctNumLabel;
	private WMLabel recitedRateLabel;
	private JButton pieIcon;// TODO
	private JButton quitIcon;
	private JButton homeIcon;

	public ReciteMainView(IReciteMainController controller) {
		super();
		this.controller = controller;
	}

	@Override
	protected void initComponents() {
		initUnitInfoPanel();
		initListPanel();
		// add left and right to view
		this.setLayout(null);
		scrollPane = new JScrollPane(listPanel);// TODO
		scrollPane.setBorder(null);
		this.add(unitInfoPanel);
		this.add(scrollPane);
		// set position and size
		unitInfoPanel.setBounds(0, 0, Constants.UNITSHORTWIDTH,
				Constants.GLOBAL_HEIGHT);
		unitInfoPanel.setOpaque(false);
		scrollPane.setBounds(Constants.UNITSHORTWIDTH, 0,
				Constants.UNITLONGWIDTH, Constants.GLOBAL_HEIGHT);
		scrollPane.setOpaque(false);
		listPanel.setPreferredSize(new Dimension(scrollPane.getWidth() - 50,
				Constants.NUM_ROW * Constants.UNITHEIGHT));
		listPanel.revalidate();
	}

	private void initUnitInfoPanel() {
		// init statistic panels
		unitInfoPanel = new JPanel();
		unitInfoPanel.setLayout(null);
		// 1
		unitNameLabel = new WMLabel("Unit  A", Constants.NORMALLABEL); // TODO
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1, 1));
		titlePanel.add(unitNameLabel);
		titlePanel.setOpaque(false);
		// 2
		WMLabel total = new WMLabel("单元单词总数", Constants.SMALLERLABEL);
		totalNumLabel = new WMLabel("237", Constants.SMALLERLABEL); // TODO
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new GridLayout(2, 1));
		totalPanel.add(total);
		totalPanel.add(totalNumLabel);
		totalNumLabel.setVerticalAlignment(JLabel.TOP);
		totalPanel.setOpaque(false);
		// 3
		WMLabel recite = new WMLabel("已背", Constants.SMALLERLABEL);
		WMLabel correct = new WMLabel("正确", Constants.SMALLERLABEL);
		WMLabel rate = new WMLabel("正确率", Constants.SMALLERLABEL);
		recitedNumLabel = new WMLabel("0", Constants.SMALLERLABEL);// TODO
		correctNumLabel = new WMLabel("0", Constants.SMALLERLABEL);// TODO
		recitedRateLabel = new WMLabel("0%", Constants.SMALLERLABEL);// TODO
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(2, 3));
		infoPanel.add(recite);
		infoPanel.add(correct);
		infoPanel.add(rate);
		infoPanel.add(recitedNumLabel);
		infoPanel.add(correctNumLabel);
		infoPanel.add(recitedRateLabel);
		recitedNumLabel.setVerticalAlignment(JLabel.TOP);
		correctNumLabel.setVerticalAlignment(JLabel.TOP);
		recitedRateLabel.setVerticalAlignment(JLabel.TOP);
		infoPanel.setOpaque(false);
		// 4-5
		pieIcon = new JButton(Constants.PIEICON256);
		pieIcon.setBorder(null);
		JPanel piePanel = new JPanel();
		piePanel.setLayout(new GridLayout(1, 1));
		piePanel.add(pieIcon);
		piePanel.setOpaque(false);
		// 6
		quitIcon = new JButton(Constants.QUITICON);
		homeIcon = new JButton(Constants.HOMEICON);
		quitIcon.setBorder(null);
		homeIcon.setBorder(null);
		JPanel iconPanel = new JPanel();
		iconPanel.setOpaque(false);
		iconPanel.setLayout(new GridLayout(1, 2));
		iconPanel.add(homeIcon);
		iconPanel.add(quitIcon);
		// add all and set position
		unitInfoPanel.add(titlePanel);
		unitInfoPanel.add(totalPanel);
		unitInfoPanel.add(infoPanel);
		unitInfoPanel.add(piePanel);
		unitInfoPanel.add(iconPanel);
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
		// init list panel
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(Constants.NUM_ROW, 1));
		WMBlock tempBlock;
		for (int i = 0; i < Constants.NUM_ROW; i++) {
			tempBlock = new WMBlock(Constants.UNITLONGWIDTH,
					Constants.UNITHEIGHT, 1, 1);
			tempBlock.addLabel(String.format("Unit %s", (char) ('A' + i)),
					Constants.MIDDLELABEL); // TODO
			listPanel.add(tempBlock);
			if (i % 2 == 0) {
				tempBlock.setColor(Constants.NORMALGREEN, Constants.DARKGREEN);
			} else {
				tempBlock.setColor(Constants.LIGHTGREEN, Constants.DARKGREEN);
			}
		}
		// listPanel.setPreferredSize(new Dimension(UNITLONGWIDTH, 8 *
		// UNITHEIGHT));
	}

	@Override
	protected void initListener() {
		quitIcon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // TODO should fire quit
			}

		});

		homeIcon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
<<<<<<< HEAD
				System.out.println("UnitView: Fire unitViewToHomeCommand");
				ReciteMainView.this.firePropertyChange("unitViewToHomeCommand",
						null, null);
			}

		});
=======
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
>>>>>>> origin/version2.1
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Constants.NORMALGREEN);
		g.fillRect(0, 0, Constants.UNITSHORTWIDTH, Constants.GLOBAL_HEIGHT);
		g.setColor(Constants.LIGHTGREEN);
		g.fillRect(Constants.UNITSHORTWIDTH, 0, Constants.UNITLONGWIDTH,
				Constants.GLOBAL_HEIGHT);
	}

	/**
	 * Set the content of the dictionary list panel.
	 * 
	 * @param nameList
	 *            The name list of all dictionaries
	 */
	public void setListPanelContent(List<String> nameList) {

	}

	/**
	 * Set the text of the name label the name of the selected dictionary.
	 * 
	 * @param name
	 *            The name of the dictionary
	 */
	public void setNameLabelText(String name) {

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
<<<<<<< HEAD

=======
		dictSizeLabel.setText(String.valueOf(size));
		totalNumLabel.setText(String.valueOf(totalSize));

		int rate = (int) (((double) size / (double) totalSize) * 100);
		sizeRateLabel.setText(String.format("%d%%", rate));
		pie.createPie(new int[] { size, totalSize - size });
>>>>>>> origin/version2.1
	}

	/**
	 * Set the text of the size label.
	 * 
	 * @param size
	 *            The size of the selected dictionary
	 */
	public void setSizeLabelText(int size) {

	}

	/**
	 * Set the text of the total size label.
	 * 
	 * @param size
	 *            The total size of all dictionaries
	 */
	public void setTotalSizeLabelText(int totalSize) {

	}
}
