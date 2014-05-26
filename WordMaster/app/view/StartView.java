package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import config.InterfaceParam;
import cmp.WMLabel;

public class StartView extends WMView {
	
	WMLabel logoLabel;
	WMLabel statisticLabel;
	WMLabel reciteLabel;
	WMLabel statisticNote;
	WMLabel reciteNote;
	JPanel statisticPanel;
	JPanel recitePanel;
	JPanel selectPanel;
	
	public StartView(){
		super();
		initComponents();
	}

	private void initComponents() {
		logoLabel = new WMLabel(APPNAME,LARGELABEL);
		statisticLabel = new WMLabel("统计",MIDDLELABEL);
		reciteLabel = new WMLabel("选词书",MIDDLELABEL);
		statisticNote = new WMLabel("包含每一个单元和整个词库的统计信息",SMALLLABEL);
		reciteNote = new WMLabel("点此进入单元的选择",SMALLLABEL);
		
		statisticNote.setForeground(new Color(128,180,96));
		reciteNote.setForeground(new Color(128,180,96));
		statisticNote.setVerticalAlignment(JLabel.TOP);
		reciteNote.setVerticalAlignment(JLabel.TOP);
		
		selectPanel = new JPanel();
		selectPanel.setLayout(new GridLayout(1, 2));
		selectPanel.setOpaque(false);
		statisticPanel = new JPanel();
		statisticPanel.setLayout(new GridLayout(2, 1));
		statisticPanel.setOpaque(false);
		recitePanel = new JPanel();
		recitePanel.setLayout(new GridLayout(2, 1));
		recitePanel.setOpaque(false);
		
		selectPanel.add(statisticPanel);
		selectPanel.add(recitePanel);
		
		statisticPanel.add(statisticLabel);
		statisticPanel.add(statisticNote);
		recitePanel.add(reciteLabel);
		recitePanel.add(reciteNote);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(logoLabel);
		this.add(selectPanel);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(75, 140, 0));
		g.fillRect(0, 0, InterfaceParam.WIDTH/2, InterfaceParam.HEIGHT);
		g.setColor(new Color(70, 130, 0));
		g.fillRect(InterfaceParam.WIDTH/2, 0, InterfaceParam.WIDTH/2, InterfaceParam.HEIGHT);
	}
	
}
