/**
 * Software Engineer lab4
 */
package wm.controller;

import wm.model.Record;

/**
 * Interface IReciteProcessController provides methods to manage a
 * recite process.
 * 
 * @author Maggie He
 * 
 */
public interface IReciteProcessController extends WMController {
	/**
	 * 
	 */
	public void startByFirstWord();

	/**
	 * 
	 */
	public void startByLastTime();

	/**
	 * 
	 * @param key
	 */
	public void startByInput(String key);

	/**
	 * 
	 * @param prefix
	 */
	public void getAvailableWordList(String prefix);

	/**
	 * 
	 */
	public int getAvailableSize();

	/**
	 * 
	 * @param size
	 */
	public void setReciteSize(int size);

	/**
	 * 
	 */
	public void reciteNextWord();

	/**
	 * 
	 */
	public void checkCorrect(String input);

	/**
	 * 
	 */
	public Record getReciteRecord();

	/**
	 * 
	 */
	public void switchToStartWordDefine();

	/**
	 * 
	 */
	public void switchToSizeSelect();

	/**
	 * 
	 */
	public void switchToReciteWord();

	/**
	 * 
	 */
	public void switchToReciteRecord();

	/**
	 * 
	 */
	public void switchToHome();
}
