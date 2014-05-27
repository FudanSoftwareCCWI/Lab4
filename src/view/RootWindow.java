package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import config.InterfaceParam;

public class RootWindow extends JFrame implements InterfaceParam{
	WMView homeView;
	WMView statisticView;
	WMView unitView;
	WMView reciteView;
	
	WMView currentView;

	public void start(){
		this.setBackground(NORMALGREEN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public RootWindow() {
		// init size or something
		super();
		Dimension fixedDimension = new Dimension(GLOBAL_WIDTH, GLOBAL_HEIGHT);
		this.setSize(fixedDimension);
		this.setResizable(false);
	}
	
	public void showView(WMView view) {
		this.getContentPane().removeAll();
		this.getContentPane().add(view);
		this.repaint();
		this.validate();
		System.out.println("RootWindow: showview()");
	}
	
}
