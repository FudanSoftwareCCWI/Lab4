/**
 * Software Engineer lab4
 */
package wm;

import wm.model.Dictionary;


/**
 * Interface SwitchDelegate manages the switches between different controllers.
 * 
 * @author Maggie He
 * 
 */
public interface SwitchDelegate {
	/**
	 * 
	 */
	public void getHome();

	/**
	 * 
	 */
	public void getReciteMain();

	/**
	 * 
	 * @param index
	 */
	public void getStartWordSelect(int index);

	/**
	 * 
	 * @param model
	 */
	public void getStartWordDefine(Dictionary model);

	/**
	 * 
	 * @param model
	 */
	public void getSizeSelect(Dictionary model);

	/**
	 * 
	 * @param model
	 */
	public void getReciteWord(Dictionary model);

	/**
	 * 
	 * @param model
	 */
	public void getReciteRecord(Dictionary model);

	/**
	 * 
	 */
	public void getRecord();
}
