package wm.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * 
 * @author Sidney Fan
 *
 */
public class WMBlock extends JPanel {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -1163413579217397402L;
	private int width;
	private int height;
	private Color localColor;
	private Color pressColor;
	private WMBlock thisWMBlock;

	public WMBlock(int width, int height, int row, int col) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.setBorder(null);
		this.setLayout(new GridLayout(row, col));
		thisWMBlock = this;
	}

	public void addLabel(String text, int size) {
		WMLabel label = new WMLabel(text, size);
		label.setSize(width, label.getHeight());
		this.add(label);
	}

	public void addLabel(WMLabel label) {
		label.setSize(width, label.getHeight());
		this.add(label);
	}

	public void setColor(Color localColor, Color pressColor) {
		this.localColor = localColor;
		this.pressColor = pressColor;
		thisWMBlock = this;
		this.setBackground(localColor);

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				thisWMBlock.setBackground(thisWMBlock.localColor);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				thisWMBlock.setBackground(thisWMBlock.pressColor);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.setColor(DARKGREEN);
//		g.fillPolygon(new int[] { 0, 10, 10, width, width, 10, 10 }, new int[] {
//				height / 2, height / 2 - 10, height, height, 0, 0,
//				height / 2 + 10 }, 7);
	}
	
}
