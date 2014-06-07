/**
 * Software Engineer lab4
 */
package wm.controller;

import wm.view.WMView;

/**
 * Interface WMController represents a concept of controllers.
 * 
 * @author Maggie He
 * 
 */
public interface WMController {
	
	/**
	 * Get controller's view.
	 * @return
	 */
	
	public WMView getView();
	/**
	 * Close window. Sometimes should store records.
	 */
	public void closeWindow();
}
