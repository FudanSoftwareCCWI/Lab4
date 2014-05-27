package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import cmp.*;

public class UnitView extends WMView {

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

	public UnitView() {
		super();
		initComponents();
		initListener();
	}

	private void initComponents() {
		initUnitInfoPanel();
		initListPanel();
		// add left and right to view
		this.setLayout(null);
		scrollPane = new JScrollPane(listPanel);// TODO
		scrollPane.setBorder(null);
		this.add(unitInfoPanel);
		this.add(scrollPane);
		// set position and size
		unitInfoPanel.setBounds(0, 0, UNITSHORTWIDTH, GLOBAL_HEIGHT);
		unitInfoPanel.setOpaque(false);
		scrollPane.setBounds(UNITSHORTWIDTH, 0, UNITLONGWIDTH, GLOBAL_HEIGHT);
		scrollPane.setOpaque(false);
		listPanel.setPreferredSize(new Dimension(scrollPane.getWidth() - 50,
				NUM_ROW * UNITHEIGHT));
		listPanel.revalidate();
	}

	private void initUnitInfoPanel() {
		// init statistic panels
		unitInfoPanel = new JPanel();
		unitInfoPanel.setLayout(null);
		// 1
		unitNameLabel = new WMLabel("Unit  A", NORMALLABEL); // TODO
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1, 1));
		titlePanel.add(unitNameLabel);
		titlePanel.setOpaque(false);
		// 2
		WMLabel total = new WMLabel("单元单词总数", SMALLERLABEL);
		totalNumLabel = new WMLabel("237", SMALLERLABEL); // TODO
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new GridLayout(2, 1));
		totalPanel.add(total);
		totalPanel.add(totalNumLabel);
		totalNumLabel.setVerticalAlignment(JLabel.TOP);
		totalPanel.setOpaque(false);
		// 3
		WMLabel recite = new WMLabel("已背", SMALLERLABEL);
		WMLabel correct = new WMLabel("正确", SMALLERLABEL);
		WMLabel rate = new WMLabel("正确率", SMALLERLABEL);
		recitedNumLabel = new WMLabel("0", SMALLERLABEL);// TODO
		correctNumLabel = new WMLabel("0", SMALLERLABEL);// TODO
		recitedRateLabel = new WMLabel("0%", SMALLERLABEL);// TODO
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
		pieIcon = new JButton(PIEICON256);
		pieIcon.setBorder(null);
		JPanel piePanel = new JPanel();
		piePanel.setLayout(new GridLayout(1, 1));
		piePanel.add(pieIcon);
		piePanel.setOpaque(false);
		// 6
		quitIcon = new JButton(QUITICON);
		homeIcon = new JButton(HOMEICON);
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
		titlePanel.setBounds(0, 0, UNITSHORTWIDTH, UNITHEIGHT);
		totalPanel.setBounds(0, UNITHEIGHT, UNITSHORTWIDTH, UNITHEIGHT);
		infoPanel
				.setBounds(25, 2 * UNITHEIGHT, UNITSHORTWIDTH - 50, UNITHEIGHT);
		piePanel.setBounds(0, 3 * UNITHEIGHT, UNITSHORTWIDTH, 2 * UNITHEIGHT);
		iconPanel.setBounds(0, GLOBAL_HEIGHT - UNITHEIGHT, UNITSHORTWIDTH,
				UNITHEIGHT);
	}

	private void initListPanel() {
		// init list panel
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(NUM_ROW, 1));
		WMBlock tempBlock;
		for (int i = 0; i < NUM_ROW; i++) {
			tempBlock = new WMBlock(UNITLONGWIDTH, UNITHEIGHT, 1, 1);
			tempBlock.addLabel(String.format("Unit %s", (char) ('A' + i)),
					MIDDLELABEL); // TODO
			listPanel.add(tempBlock);
			if (i % 2 == 0) {
				tempBlock.setColor(NORMALGREEN, DARKGREEN);
			} else {
				tempBlock.setColor(LIGHTGREEN, DARKGREEN);
			}
		}
		// listPanel.setPreferredSize(new Dimension(UNITLONGWIDTH, 8 *
		// UNITHEIGHT));
	}

	private void initListener() {
		quitIcon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // TODO should fire quit
			}

		});

		homeIcon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("UnitView: Fire unitViewToHomeCommand");
				UnitView.this.firePropertyChange("unitViewToHomeCommand", null,
						null);
			}

		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(NORMALGREEN);
		g.fillRect(0, 0, UNITSHORTWIDTH, GLOBAL_HEIGHT);
		g.setColor(LIGHTGREEN);
		g.fillRect(UNITSHORTWIDTH, 0, UNITLONGWIDTH, GLOBAL_HEIGHT);
	}

}
