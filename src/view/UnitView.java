package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import cmp.*;
import config.InterfaceParam;

public class UnitView extends WMView {

	JPanel statisticPanel;
	JPanel listPanel;
	
	JButton quitIcon;
	JButton homeIcon;
	
	public UnitView() {
		super();
		initComponents();
		initListener();
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
		listPanel.setSize(UNITLONGWIDTH, GLOBAL_HEIGHT);
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
		WMBlock titleBlock = new WMBlock(UNITSHORTWIDTH,UNITHEIGHT,1,1);
		titleBlock.addLabel("+",MIDDLELABEL);
		titleBlock.setBackground(DARKGREEN);
		listPanel.add(titleBlock);
	}

	private void initStatisticPanel() {
		// init statistic panels
		statisticPanel = new JPanel();
		statisticPanel.setBounds(0, 0,UNITSHORTWIDTH, GLOBAL_HEIGHT);
		statisticPanel.setOpaque(false);
		statisticPanel.setLayout(null);
		
		quitIcon = new JButton(QUITICON);
		homeIcon = new JButton(HOMEICON);
		quitIcon.setBorder(null);
		homeIcon.setBorder(null);
		
		JPanel iconPanel = new JPanel();
		iconPanel.setOpaque(false);
		iconPanel.setLayout(new GridLayout(1,2));
		iconPanel.add(homeIcon);
		iconPanel.add(quitIcon);
		
		WMBlock titleBlock = new WMBlock(UNITSHORTWIDTH,UNITHEIGHT,1,1);
		titleBlock.addLabel("Unit A",MIDDLELABEL);
		titleBlock.setBackground(DARKGREEN);
		statisticPanel.add(titleBlock);
		titleBlock.setBounds(0,0,UNITSHORTWIDTH,UNITHEIGHT);
		statisticPanel.add(iconPanel);
		iconPanel.setBounds(0, GLOBAL_HEIGHT-UNITHEIGHT, UNITSHORTWIDTH, UNITHEIGHT);
	}

	private void initListener() {
		quitIcon.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // TODO should fire quit
			}
			
		});
		
		homeIcon.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("UnitView: Fire unitViewToHomeCommand");
				UnitView.this.firePropertyChange("unitViewToHomeCommand", null, null);
			}
			
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(75, 140, 0));
		g.fillRect(0, 0, UNITSHORTWIDTH, GLOBAL_HEIGHT);
		g.setColor(new Color(70, 130, 0));
		g.fillRect(UNITSHORTWIDTH, 0, UNITLONGWIDTH, GLOBAL_HEIGHT);
	}
	
	
}
