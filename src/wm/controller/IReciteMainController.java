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
	 */
	public void switchToStartSelect();

	/**
	 * 
	 */
	public void switchToHome();
}
