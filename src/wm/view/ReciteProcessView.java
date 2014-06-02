/**
 * Software Engineer lab4
 */
package wm.view;

import wm.controller.IReciteProcessController;

/**
 * Abstract Class ReciteProcessView represents a recite process view, which
 * shows the recite process. Any views of each step for the recite process
 * should extends this view. It is managed by a recite process view controller.
 * 
 * @author Sidney Fan
 * 
 */
public abstract class ReciteProcessView extends WMView {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -5105958811645184995L;

	protected IReciteProcessController controller;

	public ReciteProcessView(IReciteProcessController controller) {
		this.controller = controller;
	}
}
