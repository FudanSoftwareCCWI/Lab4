package wm.view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import wm.view.component.WMLabel;

public class HomeView extends WMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 113232243106457859L;

	HomeView thisView;
	
	WMLabel logoLabel;
	WMLabel statisticLabel;
	WMLabel reciteLabel;
	WMLabel statisticNote;
	WMLabel reciteNote;

	JPanel selectPanel;
	JPanel statisticPanel;
	JPanel recitePanel;

	JButton quitIcon; // should be extracted

	public HomeView() {
		super();
		thisView = this;
		initComponents();
		initListener();
	}

	private void initComponents() {
		// init labels
		logoLabel = new WMLabel(APPNAME, LARGELABEL);
		statisticLabel = new WMLabel("统计", MIDDLELABEL);
		reciteLabel = new WMLabel("选词书", MIDDLELABEL);
		statisticNote = new WMLabel("包含每一个单元和整个词库的统计信息", SMALLLABEL);
		reciteNote = new WMLabel("点此进入单元的选择", SMALLLABEL);
		quitIcon = new JButton(QUITICON);

		// set note color and alignment
		statisticNote.setForeground(NOTEALPHA);
		reciteNote.setForeground(NOTEALPHA);
		statisticLabel.setVerticalAlignment(JLabel.BOTTOM);
		reciteLabel.setVerticalAlignment(JLabel.BOTTOM);
		quitIcon.setBorder(null);

		// select panel
		selectPanel = new JPanel();
		selectPanel.setLayout(null);
		selectPanel.setOpaque(false);
		// left
		statisticPanel = new JPanel();
		statisticPanel.setLayout(new GridLayout(2, 1));
		statisticPanel.setOpaque(false);
		// right
		recitePanel = new JPanel();
		recitePanel.setLayout(new GridLayout(2, 1));
		recitePanel.setOpaque(false);

		// add left & right to select
		selectPanel.add(statisticPanel);
		statisticPanel.setBounds(0, 0, GLOBAL_WIDTH / 2, GLOBAL_HEIGHT / 3);
		selectPanel.add(recitePanel);
		recitePanel.setBounds(GLOBAL_WIDTH / 2, 0, GLOBAL_WIDTH / 2,
				GLOBAL_HEIGHT / 3);

		// left add static
		statisticPanel.add(statisticLabel);
		statisticPanel.add(statisticNote);

		// right add recite
		recitePanel.add(reciteLabel);
		recitePanel.add(reciteNote);

		// add all to frame
		this.setLayout(null);
		this.add(logoLabel);
		logoLabel.setBounds(0, 20, GLOBAL_WIDTH, GLOBAL_HEIGHT / 2);
		this.add(selectPanel);
		selectPanel.setBounds(0, GLOBAL_HEIGHT / 2, GLOBAL_WIDTH,
				GLOBAL_HEIGHT / 2);
		this.add(quitIcon);
		quitIcon.setBounds(GLOBAL_WIDTH - ICON_SMALL - 10, 10, ICON_SMALL,
				ICON_SMALL);
	}

	private void initListener() {
		
		// Mouse Listener
		statisticPanel.addMouseListener(new MouseListener() {
			boolean pressed = false;
			boolean in = false;

			@Override
			public void mouseEntered(MouseEvent e) {
				statisticPanel.setOpaque(true);
				statisticPanel.setBackground(DARKGREEN);
				in = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!pressed) {
					statisticPanel.setOpaque(false);
					statisticPanel.setBackground(LIGHTGREEN);
				}
				in = false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				statisticPanel.setOpaque(true);
				statisticPanel.setBackground(DARKGREEN);
				pressed = false;
				// fire property changed
				System.out.println("HomeView: Fire homeToStatisticViewCommand");
				thisView.firePropertyChange("homeToStatisticViewCommand", null, null);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				statisticPanel.setOpaque(true);
				statisticPanel.setBackground(DARKGREEN.darker());
				pressed = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				statisticPanel.setOpaque(true);
				if (!in) {
					statisticPanel.setBackground(LIGHTGREEN);
				} else {
					statisticPanel.setBackground(DARKGREEN);
				}
				pressed = false;
			}
		});

		recitePanel.addMouseListener(new MouseListener() {
			boolean pressed = false;
			boolean in = false;
			
			@Override
			public void mouseEntered(MouseEvent e) {
				recitePanel.setOpaque(true);
				recitePanel.setBackground(DARKGREEN);
				in = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!pressed) {
				recitePanel.setOpaque(false);
				recitePanel.setBackground(NORMALGREEN);
				}
				in = false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				recitePanel.setOpaque(true);
				recitePanel.setBackground(DARKGREEN);
				pressed = false;
				// fire property changed
				System.out.println("HomeView: Fire homeToUnitViewCommand");
				thisView.firePropertyChange("homeToUnitViewCommand", null, null);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				recitePanel.setOpaque(true);
				recitePanel.setBackground(DARKGREEN.darker());
				pressed = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				recitePanel.setOpaque(true);
				if (!in) {
					recitePanel.setBackground(NORMALGREEN);
				} else {
					recitePanel.setBackground(DARKGREEN);
				}
				pressed = false;
			}
		});

		quitIcon.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // TODO should fire quit
			}
			
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(LIGHTGREEN);
		g.fillRect(0, 0, GLOBAL_WIDTH / 2, GLOBAL_HEIGHT);
		g.setColor(NORMALGREEN);
		g.fillRect(GLOBAL_WIDTH / 2, 0, GLOBAL_WIDTH / 2, GLOBAL_HEIGHT);
		g.fillPolygon(new int[] { 0, 0, GLOBAL_WIDTH / 8 }, new int[] { 0,
				GLOBAL_WIDTH / 8, 0 }, 3);
		g.setColor(LIGHTGREEN);
		g.fillPolygon(new int[] { GLOBAL_WIDTH, GLOBAL_WIDTH,
				GLOBAL_WIDTH - GLOBAL_WIDTH / 8 }, new int[] { GLOBAL_HEIGHT,
				GLOBAL_HEIGHT - GLOBAL_WIDTH / 8, GLOBAL_HEIGHT }, 3);
	}

	public void refreshHome(){
		statisticPanel.setBackground(LIGHTGREEN);
		recitePanel.setBackground(NORMALGREEN);
	}
	
}
