/**
 * Software Engineer lab4
 */
package wm.controller;

/**
 * Interface IRecordController provides methods to manage records.
 * 
 * @author Maggie He
 * 
 */
public interface IRecordController extends WMController {
	
	/**
	 * Show dictionary list.
	 */
	public void showDictList();
	/**
	 * 
	 * @param index
	 */
	public void showRecordByPie(int index);
	
	/**
	 * Show all dictionaries record.
	 */
	public void showRecordByPie();
	
	/**
	 * Show all dictionaries record.
	 */
	public void showRecordByBar();
	
	/**
	 * Show all dictionaries record.
	 * @param index
	 */
	void showRecordByBar(int index);
	
	/**
	 * Show record by table.
	 * @param index
	 */
	public void showRecordByTable(int index);
	
	/**
	 * Switch to home.
	 */
	public void switchToHome();
	
}
