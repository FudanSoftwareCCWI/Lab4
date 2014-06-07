/**
 * Software Engineer lab4
 */
package wm.model.dao;

import java.io.IOException;

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
	 * Get the dictionaries by the filename.
	 * 
	 * @return {@code Dictionaries}
	 * @throws IOException 
	 */
	public Dictionaries selectAllDictionay(String filename);
	
	/**
	 * Update the dictionaries info into the file.
	 * 
	 * @param {@code dictionaries}
	 * @return {@code boolean}
	 */
	public boolean updateAllDictionary(Dictionaries dictionaries);
	
	/**
	 * Update dictionary info by the dictionary name
	 * 
	 * @param name
	 * 			the name of the dictionary
	 * @return {@code Dictionary}
	 */
	public Dictionary selectDictionary(String name);
	
	/**
	 * 
	 * @param dictionary
	 * @return
	 */
	public boolean insertDictionary(Dictionary dictionary);
	
	/**
	 * Update the dictionary info.
	 * 
	 * @param dictionary
	 * 			The dictionary to be updated
	 * @return {@code boolean}
	 */
	public boolean updateDictionary(Dictionary dictionary);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteDictionary(String name);
}
