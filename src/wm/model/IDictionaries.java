/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.List;

/**
 * The Interface IDictionaries privides the functions to get the specific dictionary.
 * Also include the get function of the total dictionary size and dictionary's number.
 * And provide the function produce the record.
 * 
 * @author ArielQian
 *
 */
public interface IDictionaries {

	/**
	 * Get the dictionary by the index
	 * 
	 * @param index
	 *            The index of the dictionary
	 * @return {@code dictionary}
	 */
	public Dictionary getDictionary(int index);
	
	
	/**
	 * Get the dictionary by the name
	 * 
	 * @param name
	 *            The name of the dictionary
	 * @return {@code dictionary}
	 */
	public Dictionary getDictionary(String name);
	
	
	/**
	 * Get all dictionaries' name
	 * 
	 * @return a {@code List<String>} of the dictionaries' name
	 */
	public List<String> getDictionaryNames();
	
	
	/**
	 * Get the number of the dictionaries
	 * 
	 * @return {@code int}
	 */
	public int getDicNumber();
	
	
	/**
	 * Get the total size of the dictionaries
	 * 
	 * @return {@code int}
	 */
	public int getTotalSize();
	
	
	/**
	 * Get a Record of all dictionaries.
	 * 
	 * @return {@code Record}
	 */
	public Record produceRecord();
}
