/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.List;

/**
 * Interface IRecords provides functions to get the all record of the dictionary
 * and the single record of any dictionary.
 * 
 * @author ArielQian
 * 
 */
public interface IRecords {

	/**
	 * The get function of the {@code List<Record>}
	 * 
	 * @return {@code List<Record>} The list of the record.
	 */
	public List<Record> getRecords();

	/**
	 * Get the single record by the index.
	 * 
	 * @param index
	 *            the index of the record
	 * @return The {@code record}
	 */
	public Record getSingleRecord(int index);

	/**
	 * Get the single record by the record name.
	 * 
	 * @param name
	 *            the name of the record
	 * @return The {@code record}
	 */
	public Record getSingleRecord(String name);

	/**
	 * Get the record of the whole dictionaries
	 * 
	 * @return The {@code record}
	 */
	public Record getAllRecord();
}
