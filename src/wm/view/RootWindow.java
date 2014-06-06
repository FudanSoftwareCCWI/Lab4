/**
 * Software Engineer lab4
 */
package wm.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import wm.config.Constants;

/**
 * Class RootWindow manages a frame of the whole application. It have methods to
 * repaint its view.
 * 
 * @author Sidney Fan
 * 
 */
public class RootWindow extends JFrame {
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -4846877555809396935L;

	private int currentView;

	/**
	 * 
	 */
	public RootWindow() {
		// init size or something
		super();
		Dimension fixedDimension = new Dimension(Constants.GLOBAL_WIDTH,
				Constants.GLOBAL_HEIGHT+20);
		this.setSize(fixedDimension);
		this.setResizable(false);
	}
	
	/**
	 * 
	 */
	public void start() {
		this.setBackground(Constants.NORMALGREEN);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * 
	 * @param view
	 */
	public void showView(WMView view) {
		this.getContentPane().removeAll();
		this.getContentPane().add(view);
		this.repaint();
		this.validate();
		System.out.println("RootWindow: showview()");
	}

}
