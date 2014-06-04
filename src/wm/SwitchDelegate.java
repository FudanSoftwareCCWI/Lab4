/**
 * Software Engineer lab4
 */
package wm;


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
	 * @param model
	 */
	public void getStartWordSelect(int dictionaryIndex);

	/**
	 * 
	 * @param model
	 */
	public void getStartWordDefine(int dictionaryIndex);

	/**
	 * 
	 * @param model
	 */
	public void getSizeSelect(int dictionaryIndex);

	/**
	 * 
	 * @param model
	 */
	public void getReciteWord(int dictionaryIndex);

	/**
	 * 
	 * @param model
	 */
	public void getReciteRecord(int dictionaryIndex);

	/**
	 * 
	 */
	public void getRecord();
}
