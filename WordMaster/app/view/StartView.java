package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import config.InterfaceParam;
import cmp.WMLabel;

public class StartView extends WMView {

	WMLabel logoLabel;
	WMLabel statisticLabel;
	WMLabel reciteLabel;
	WMLabel statisticNote;
	WMLabel reciteNote;

	JPanel selectPanel;
	JPanel statisticPanel;
	JPanel recitePanel;

	public StartView() {
		super();
		initComponents();
		initListener();
	}

	private void initListener() {

		statisticPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
	}

	private void initComponents() {
		// init labels
		logoLabel = new WMLabel(APPNAME, LARGELABEL);
		statisticLabel = new WMLabel("统计", MIDDLELABEL);
		reciteLabel = new WMLabel("选词书", MIDDLELABEL);
		statisticNote = new WMLabel("包含每一个单元和整个词库的统计信息", SMALLLABEL);
		reciteNote = new WMLabel("点此进入单元的选择", SMALLLABEL);
		// set note color and alignment
		statisticNote.setForeground(NORMALGREEN.brighter());
		reciteNote.setForeground(NORMALGREEN.brighter());
//		statisticNote.setVerticalAlignment(JLabel.TOP);
		reciteNote.setVerticalAlignment(JLabel.TOP);
		// select panel
		selectPanel = new JPanel();
		selectPanel.setLayout(new GridLayout(1, 2));
		selectPanel.setOpaque(false);
		// left
		statisticPanel = new JPanel();
		statisticPanel.setLayout(new GridLayout(3, 1));
		statisticPanel.setOpaque(false);
		// right
		recitePanel = new JPanel();
		recitePanel.setLayout(new GridLayout(2, 1));
		recitePanel.setOpaque(false);
		// add left & right to select
		selectPanel.add(statisticPanel);
		selectPanel.add(recitePanel);
		// left add static 
		statisticPanel.add(statisticLabel);
		statisticPanel.add(statisticNote);
		// right add recite 
		recitePanel.add(reciteLabel);
		recitePanel.add(reciteNote);
		// add all to frame
		this.setLayout(null);
		this.add(logoLabel);
		logoLabel.setBounds(0, 20, InterfaceParam.WIDTH, InterfaceParam.HEIGHT/2);
		this.add(selectPanel);
		selectPanel.setBounds(0, InterfaceParam.HEIGHT/2, InterfaceParam.WIDTH, InterfaceParam.HEIGHT/2);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(NORMALGREEN);
		g.fillRect(0, 0, InterfaceParam.WIDTH / 2, InterfaceParam.HEIGHT);
		g.setColor(DARKGREEN);
		g.fillRect(InterfaceParam.WIDTH / 2, 0, InterfaceParam.WIDTH / 2,
				InterfaceParam.HEIGHT);
		g.fillPolygon(new int[] { 0, 0, InterfaceParam.WIDTH / 8 }, new int[] {
				0, InterfaceParam.WIDTH / 8, 0 }, 3);
		g.setColor(NORMALGREEN);
		g.fillPolygon(new int[] { InterfaceParam.WIDTH, InterfaceParam.WIDTH,
				InterfaceParam.WIDTH - InterfaceParam.WIDTH / 8 }, new int[] {
				InterfaceParam.HEIGHT,
				InterfaceParam.HEIGHT - InterfaceParam.WIDTH / 8,
				InterfaceParam.HEIGHT }, 3);
	}

}
