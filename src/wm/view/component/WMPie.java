package wm.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import wm.config.Constants;

public class WMPie extends JPanel {
	
	class Slice {
		double value;
		Color color;

		public Slice(double value, Color color) {
			this.value = value;
			this.color = color;
		}
	}

	Slice[] slices;

	public WMPie() {
		createPie(new int[]{50,300});
	}
	
	public WMPie(int[] nums) {
		createPie(nums);
	}

	public void createPie(int[] nums){
		slices = new Slice[nums.length];
		slices[0] = new Slice(nums[0], Color.WHITE);
		for (int i = 1; i < nums.length; i++) {
			slices[i] = new Slice(nums[i], Constants.NOTEALPHA);
		}
		this.repaint();
	}
	
	public void paint(Graphics g) {
		drawPie((Graphics2D) g, slices);
	}

	void drawPie(Graphics2D g, Slice[] slices) {
		double total = 0.0D;
		for (int i = 0; i < slices.length; i++) {
			total += slices[i].value;
		}
		double curValue = 0.0D;
		int startAngle = 0;
		for (int i = 0; i < slices.length; i++) {
			startAngle = (int) ((curValue / total) * 360);
			int arcAngle = (int) ((slices[i].value / total) * 360);
			g.setColor(slices[i].color);
			if (i == slices.length - 1)
				arcAngle = 360 - startAngle;
			g.fillArc(0, 0,Constants.ICON_MIDDLE, Constants.ICON_MIDDLE, startAngle,
					arcAngle);
			curValue += slices[i].value;
		}
	}

//	public static void main(String[] argv) {
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(new WMPie(new int[]{367,2000}));
//		frame.setSize(300, 200);
//		frame.setVisible(true);
//	}
}
