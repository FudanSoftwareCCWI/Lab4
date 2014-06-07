/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.List;

/**
 * Class Records represents the record of the whole dictionary and the List of
 * each dictionary.It can get a single record by the index or name. And it also
 * can get the record of whole dictionary or the list of the record.
 * It implements the {@link IRecords} interface.
 * 
 * @author ArielQian
 * 
 */
public class Records extends WMModel implements IRecords{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -434440532466459449L;
	
	private Record allRecord;
	private List<Record> records;

	public Records(List<Record> records, Record allRecord) {
		super();
		this.records = records;
		this.allRecord = allRecord;
	}


	@Override
	public List<Record> getRecords() {
		return records;
	}


	@Override
	public Record getSingleRecord(int index) {
		return records.get(index);
	}


	@Override
	public Record getSingleRecord(String name) {
		for (Record r : records) {
			if (r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}


	@Override
	public Record getAllRecord() {
		return allRecord;
	}
}
