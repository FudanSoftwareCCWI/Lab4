/**
 * Software Engineer lab4
 */
package wm.model.dao;

import wm.model.Dictionaries;
import wm.model.Records;

/**
 * Do not need to implement yet.
 * 
 * Interface RecordDAO provides methods to visit a record, including select,
 * update, insert and delete operations.
 * 
 * @author Ariel Qian
 * 
 */
public interface RecordDAO {

	/**
	 * Read the record info by the dictionaries
	 * 
	 * @param dictionaries
	 * 			The dictionaries need to create a record
	 * @return	{@code Records}
	 */
	public Records selectAllRecord(Dictionaries dictionaries);

	/**
	 * Update the record info by the dictionaries
	 * 
	 * @param dictionaries
	 * 			The dictionaries need to update a record
	 */
	public void updateAllRecord(Dictionaries dictionaries);

	
	
}
