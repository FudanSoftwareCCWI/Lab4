package cmp;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class WMBlock extends JPanel {
	
	private int width;
	private int height;
	
	public WMBlock(int width, int height, int row, int col){
		this.width = width;
		this.height = height;
		this.setSize(width, height);
//		this.setOpaque(false);
		this.setLayout(new GridLayout(row, col));
	}
	
	public void addLabel(String text, int size){
		WMLabel label = new WMLabel(text, size);
		label.setSize(width, label.getHeight());
		this.add(label);
		
	}
	
}
