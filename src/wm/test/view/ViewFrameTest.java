package wm.test.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import wm.config.Constants;
import wm.controller.*;
import wm.view.*;

public class ViewFrameTest {
	
	static JFrame frame;
	private static WMView view;
	private static IReciteMainController controller;
	
	public static void main(String args[]){
		frame = new JFrame();
		Dimension fixedDimension = new Dimension(Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_HEIGHT+20);
		frame.setSize(fixedDimension);
		frame.setResizable(false);
		frame.setBackground(Constants.NORMALGREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		view = new ReciteMainView(controller);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(view);
		frame.repaint();
		frame.validate();
		
	}
	
}
