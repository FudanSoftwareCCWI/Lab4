/**
 * Software Engineer lab4
 */
package wm.model.dao;

import wm.model.Record;

/**
 * Interface RecordDAO provides methods to visit a record, including select,
 * update, insert and delete operations.
 * 
 * @author Ariel Qian
 * 
 */
public interface RecordDAO {

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Record selectRecord(String name);

	/**
	 * 
	 * @param record
	 * @return
	 */
	public boolean insertRecord(Record record);

	/**
	 * 
	 * @param record
	 * @return
	 */
	public boolean updateRecord(Record record);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteRecord(String name);
}
