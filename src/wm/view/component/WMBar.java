package wm.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import wm.config.Constants;
import wm.view.component.WMPie.Slice;

public class WMBar extends JPanel {

	private List<Integer> list;
	private int currentDicIndex;

	public WMBar() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(23);
		a.add(42);
		a.add(345);
		a.add(23);
		a.add(54);
		a.add(324);
		a.add(123);
		a.add(222);
		list = a;
		currentDicIndex = 0;
		createBar(a, 0);
	}

	public WMBar(List<Integer> list, int index) {
		createBar(list, index);
	}

	public void createBar(List<Integer> list, int currentDicIndex) {
		this.list = list;
		this.currentDicIndex = currentDicIndex;
		this.setOpaque(false);
		this.repaint();
	}

	public void paint(Graphics g) {
		drawBar((Graphics2D) g, list, currentDicIndex);
	}

	void drawBar(Graphics2D g, List<Integer> list, int curr) {
		super.paint(g);
		Rectangle rec = this.getBounds();
		int max = 0;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int x = it.next();
			max = Math.max(x, max);
		}

		double curRatio = 0.0D;
		int curPos = 0;
		int uintWidth = rec.width / list.size();
		int barWidth = (int) (uintWidth * 0.6);
		int padding = 15;
		int unitHeight = rec.height - padding;
		for (int i = 0; i < list.size(); i++) {
			g.setColor(Constants.NOTEALPHA);
			if(i==curr)
				g.setColor(Color.WHITE);
			curRatio = list.get(i) / (double) max;
			g.fillRect(curPos, (int) (unitHeight - curRatio * unitHeight)
					+ padding, barWidth, (int) (curRatio * unitHeight));
			g.drawString(String.valueOf(list.get(i)), curPos,
					(int) (unitHeight - curRatio * unitHeight) + padding - 5);
			curPos += uintWidth;
		}
	}

	// public static void main(String[] argv) {
	// JFrame frame = new JFrame();
	//
	// WMBar bar = new WMBar(new int[] { 367, 2000, 123, 453, 657 },
	// new String[] { "ajhg", "jhg", "sdfk", "poqwe", "mxcvn" });
	// bar.setBounds(0, 0, 200, 200);
	// frame.getContentPane().add(bar);
	//
	// frame.setSize(300, 200);
	// frame.setVisible(true);
	// }
}
