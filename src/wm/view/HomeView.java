/**
 * Software Engineer lab4
 */
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

import wm.config.Constants;
import wm.controller.IHomeController;
import wm.view.component.WMLabel;

/**
 * Class HomeView represents a home view and is managed by a home view
 * controller. It is the beginning view of the application.
 * 
 * @author Sidney Fan
 * 
 */
public class HomeView extends WMView {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 113232243106457859L;

	IHomeController controller;
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

	public HomeView(IHomeController controller) {
		super();
		this.controller=controller;
		thisView = this;
	}

	@Override
	protected void initComponents() {
		// init labels
		logoLabel = new WMLabel(Constants.APPNAME, Constants.LARGELABEL);
		statisticLabel = new WMLabel("统计", Constants.MIDDLELABEL);
		reciteLabel = new WMLabel("选词书", Constants.MIDDLELABEL);
		statisticNote = new WMLabel("包含每一个单元和整个词库的统计信息", Constants.SMALLLABEL);
		reciteNote = new WMLabel("点此进入单元的选择", Constants.SMALLLABEL);
		quitIcon = new JButton(Constants.QUITICON);

		// set note color and alignment
		statisticNote.setForeground(Constants.NOTEALPHA);
		reciteNote.setForeground(Constants.NOTEALPHA);
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
		statisticPanel.setBounds(0, 0, Constants.GLOBAL_WIDTH / 2,
				Constants.GLOBAL_HEIGHT / 3);
		selectPanel.add(recitePanel);
		recitePanel.setBounds(Constants.GLOBAL_WIDTH / 2, 0,
				Constants.GLOBAL_WIDTH / 2, Constants.GLOBAL_HEIGHT / 3);

		// left add static
		statisticPanel.add(statisticLabel);
		statisticPanel.add(statisticNote);

		// right add recite
		recitePanel.add(reciteLabel);
		recitePanel.add(reciteNote);

		// add all to frame
		this.setLayout(null);
		this.add(logoLabel);
		logoLabel.setBounds(0, 20, Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_HEIGHT / 2);
		this.add(selectPanel);
		selectPanel.setBounds(0, Constants.GLOBAL_HEIGHT / 2,
				Constants.GLOBAL_WIDTH, Constants.GLOBAL_HEIGHT / 2);
		this.add(quitIcon);
		quitIcon.setBounds(Constants.GLOBAL_WIDTH - Constants.ICON_SMALL - 10,
				10, Constants.ICON_SMALL, Constants.ICON_SMALL);
	}

	@Override
	protected void initListener() {

		// Mouse Listener
		statisticPanel.addMouseListener(new MouseListener() {
			boolean pressed = false;
			boolean in = false;

			@Override
			public void mouseEntered(MouseEvent e) {
				statisticPanel.setOpaque(true);
				statisticPanel.setBackground(Constants.DARKGREEN);
				in = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!pressed) {
					statisticPanel.setOpaque(false);
					statisticPanel.setBackground(Constants.LIGHTGREEN);
				}
				in = false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				statisticPanel.setOpaque(true);
				statisticPanel.setBackground(Constants.DARKGREEN);
				pressed = false;
				// fire property changed
				System.out.println("HomeView: Fire homeToStatisticViewCommand");
				thisView.firePropertyChange("homeToStatisticViewCommand", null,
						null);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				statisticPanel.setOpaque(true);
				statisticPanel.setBackground(Constants.DARKGREEN.darker());
				pressed = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				statisticPanel.setOpaque(true);
				if (!in) {
					statisticPanel.setBackground(Constants.LIGHTGREEN);
				} else {
					statisticPanel.setBackground(Constants.DARKGREEN);
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
				recitePanel.setBackground(Constants.DARKGREEN);
				in = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!pressed) {
					recitePanel.setOpaque(false);
					recitePanel.setBackground(Constants.NORMALGREEN);
				}
				in = false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				recitePanel.setOpaque(true);
				recitePanel.setBackground(Constants.DARKGREEN);
				pressed = false;
				// fire property changed
				System.out.println("HomeView: Fire homeToUnitViewCommand");
				thisView.firePropertyChange("homeToUnitViewCommand", null, null);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				recitePanel.setOpaque(true);
				recitePanel.setBackground(Constants.DARKGREEN.darker());
				pressed = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				recitePanel.setOpaque(true);
				if (!in) {
					recitePanel.setBackground(Constants.NORMALGREEN);
				} else {
					recitePanel.setBackground(Constants.DARKGREEN);
				}
				pressed = false;
			}
		});

		quitIcon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // TODO should fire quit
			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Constants.LIGHTGREEN);
		g.fillRect(0, 0, Constants.GLOBAL_WIDTH / 2, Constants.GLOBAL_HEIGHT);
		g.setColor(Constants.NORMALGREEN);
		g.fillRect(Constants.GLOBAL_WIDTH / 2, 0, Constants.GLOBAL_WIDTH / 2,
				Constants.GLOBAL_HEIGHT);
		g.fillPolygon(new int[] { 0, 0, Constants.GLOBAL_WIDTH / 8 },
				new int[] { 0, Constants.GLOBAL_WIDTH / 8, 0 }, 3);
		g.setColor(Constants.LIGHTGREEN);
		g.fillPolygon(new int[] { Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_WIDTH - Constants.GLOBAL_WIDTH / 8 },
				new int[] { Constants.GLOBAL_HEIGHT,
						Constants.GLOBAL_HEIGHT - Constants.GLOBAL_WIDTH / 8,
						Constants.GLOBAL_HEIGHT }, 3);
	}

	/**
	 * 
	 */
	public void refreshHome() {
		statisticPanel.setBackground(Constants.LIGHTGREEN);
		recitePanel.setBackground(Constants.NORMALGREEN);
	}

}
