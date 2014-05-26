package model;

import java.awt.Dimension;

import javax.swing.JFrame;

import config.InterfaceParam;

public class MainFrameModel extends JFrame implements InterfaceParam {
	
	public MainFrameModel() {
		super();
		Dimension fixedDimension = new Dimension(UNITLONGWIDTH+UNITSHORTWIDTH, NUM_ROW*UNITHEIGHT);
		this.setSize(fixedDimension);
		this.setResizable(false);
	}
	
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}
