package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import cmp.*;
import config.InterfaceParam;

public class UnitView extends WMView {

	JPanel statisticPanel;
	JPanel listPanel;
	
	public UnitView() {
		super();
		initComponents();
	}

	private void initComponents() {
		initStatisticPanel();
		initListPanel();

		this.setLayout(null);
		this.add(statisticPanel);
		this.add(listPanel);
	}

	private void initListPanel() {
		// init list panel
		listPanel = new JPanel();
		listPanel.setLocation(UNITSHORTWIDTH, 0);
		listPanel.setSize(UNITLONGWIDTH, InterfaceParam.HEIGHT);
		listPanel.setOpaque(false);
		
		listPanel.setLayout(new GridLayout(NUM_ROW,1));
		for (int i = 0; i < NUM_ROW-1; i++) {
			WMBlock titleBlock = new WMBlock(UNITSHORTWIDTH,UNITHEIGHT,1,1);
			titleBlock.addLabel(String.format("Unit %s", (char)('A'+i)),MIDDLELABEL);
			listPanel.add(titleBlock);
			if(i%2==0){
				titleBlock.setBackground(LIGHTGREEN);
			}else{
				titleBlock.setBackground(NORMALGREEN);
			}
		}
		// plus
		WMBlock titleBlock = new WMBlock(UNITSHORTWIDTH,UNITHEIGHT,2,1);
		titleBlock.addLabel("+",MIDDLELABEL);
		titleBlock.setBackground(DARKGREEN);
		listPanel.add(titleBlock);
	}

	private void initStatisticPanel() {
		// init statistic panels
		statisticPanel = new JPanel();
		statisticPanel.setLocation(0, 0);
		statisticPanel.setSize(UNITSHORTWIDTH, InterfaceParam.HEIGHT);
		statisticPanel.setOpaque(false);
		
		statisticPanel.setLayout(new GridLayout(NUM_ROW,1));
		
		WMBlock titleBlock = new WMBlock(UNITSHORTWIDTH,UNITHEIGHT,1,1);
		titleBlock.addLabel("Unit A",MIDDLELABEL);
		titleBlock.setBackground(DARKGREEN);
		statisticPanel.add(titleBlock);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(75, 140, 0));
		g.fillRect(0, 0, UNITSHORTWIDTH, InterfaceParam.HEIGHT);
		g.setColor(new Color(70, 130, 0));
		g.fillRect(UNITSHORTWIDTH, 0, UNITLONGWIDTH, InterfaceParam.HEIGHT);
	}
}
