/**
 * Software Engineer lab4
 */
package wm.controller;

/**
 * Interface IReciteMainController provides methods to manage a recite main
 * view.
 * 
 * @author Maggie He
 * 
 */
public interface IReciteMainController extends WMController {
	/**
	 * 
	 * @param index
	 */
	public void showDictionaryDetail(int index);

	/**
	 * 
	 * @param index
	 */
	public void switchToStartSelect(int index);

	/**
	 * 
	 */
	public void switchToHome();
}
