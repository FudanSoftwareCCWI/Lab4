/**
 * Software Engineer lab4
 */
package wm.model.dao;

import wm.model.Dictionaries;
import wm.model.Dictionary;

/**
 * Interface DictionaryDAO provides methods to visit a dictionary, including
 * select, update, insert and delete operations.
 * 
 * @author Ariel Qian
 * 
 */
public interface DictionaryDAO {
	/**
	 * 
	 * @return
	 */
	public Dictionaries selectAllDictionay();
	
	/**
	 * 
	 * @param dictionaries
	 * @return
	 */
	public boolean updateAllDictionary(Dictionaries dictionaries);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Dictionary selectDictionary(String name);
	
	/**
	 * 
	 * @param dictionary
	 * @return
	 */
	public boolean insertDictionary(Dictionary dictionary);
	
	/**
	 * 
	 * @param dictionary
	 * @return
	 */
	public boolean updateDictionary(Dictionary dictionary);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteDictionary(String name);
}
