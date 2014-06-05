package wm.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import wm.config.Constants;

public class WMTable extends JPanel {

	private List<Integer> list;
	private List<String> name;

	public WMTable(List<Integer> list, List<String> name) {
		super();
		createTable(list, name);
	}

	public void createTable(List<Integer> list, List<String> name) {
		this.list = list;
		this.name = name;
		this.setOpaque(false);
		this.repaint();
	}

	public void paint(Graphics g) {
		drawTable((Graphics2D) g, list, name);
	}

	void drawTable(Graphics2D g, List<Integer> list, List<String> name) {

		Rectangle rec = this.getBounds();
//		g.setColor(Constants.DARKGREEN);
//		g.fillRect(0, 0, rec.width, rec.height / 2);
//		g.setColor(Constants.NOTEALPHA);
//		g.fillRect(0, rec.height / 2, rec.width, rec.height / 2);
		
		g.setColor(Color.WHITE);
		g.drawLine(0, 0, rec.width, 0);
		g.drawLine(0, rec.height/2, rec.width, rec.height/2);
		g.drawLine(0, rec.height-1, rec.width, rec.height-1);
		int size = Math.max(list.size(), name.size());
		int unitWidth = rec.width / size;
		Iterator<Integer> il = list.iterator();
		Iterator<String> in = name.iterator();
		int value;
		String text;
		int currPos = 20;
		while (in.hasNext() && il.hasNext()) {
			text = in.next();
			value = il.next();
			g.drawString(text, currPos, rec.height / 3);
			g.drawString(String.valueOf(value), currPos+10, rec.height / 4 * 3);
			currPos += unitWidth;
		}

		super.paint(g);
	}

	public static void main(String[] argv) {
		JFrame frame = new JFrame();

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		names.add(Constants.CHIN_TOTAL);
		names.add(Constants.CHIN_RECITED);
		names.add(Constants.CHIN_CORRECT);
		names.add(Constants.CHIN_WRONG);
		names.add(Constants.CHIN_RATE);
		values.add(323);
		values.add(122);
		values.add(110);
		values.add(12);
		values.add(86);

		WMTable bar = new WMTable(values, names);
		bar.setBounds(0, 0, 200, 200);
		frame.getContentPane().add(bar);

		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}
