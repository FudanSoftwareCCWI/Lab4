/**
 * Software Engineer lab4
 */
package wm.view;

import javax.swing.JPanel;

import wm.config.Constants;

/**
 * Abstract Class WMView represents a view of the application. Any other views
 * of the application should extend this view.
 * 
 * @author Sidney Fan
 * 
 */
public abstract class WMView extends JPanel {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 16020516862728212L;

	public WMView() {
		this.setBackground(Constants.NORMALGREEN);
//		this.initComponents();
//		this.initListener();
	}

	/**
	 * 
	 */
	protected abstract void initComponents();

	/**
	 * 
	 */
	protected abstract void initListener();
}
