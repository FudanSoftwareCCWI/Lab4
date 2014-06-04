/**
 * Software Engineer lab4
 */
package wm.controller;

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
	public void getAvailableSize();

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
	public void checkCorrect();

	/**
	 * 
	 */
	public void getReciteRecord();

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
