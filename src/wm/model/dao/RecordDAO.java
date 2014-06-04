/**
 * Software Engineer lab4
 */
package wm.model.dao;

import java.util.List;

import wm.model.Record;

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
	 * 
	 * @param name
	 * @return
	 */
	public Record selectAllRecord();

	/**
	 * 
	 * @param record
	 * @return
	 */
	public Record selectRecordByName(String name);

	/**
	 * 
	 * @param record
	 * @return
	 */
	public List<Record> selectAllRecordList();

	
}
