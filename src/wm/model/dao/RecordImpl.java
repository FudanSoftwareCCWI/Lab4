/**
 * Software Engineer lab4
 */
package wm.model.dao;

import java.util.ArrayList;
import java.util.List;

import wm.model.Dictionaries;
import wm.model.Record;

public class RecordImpl implements RecordDAO {
	private Record allRecord;
	private List<Record> singleRecord;
	
	public RecordImpl(Dictionaries dic){
		allRecord = dic.produceRecord();
		singleRecord = new ArrayList<Record>();
		for(int i = 0; i < dic.getDicNumber(); i++){
			singleRecord.add(dic.getDictionary(i).produceRecord());
		}
	}

	@Override
	public Record selectAllRecord() {	
		return allRecord;
	}

	@Override
	public Record selectRecordByName(String name) {
		for(Record r: singleRecord){
			if(r.getName().equals(name)){
				return r;
			}				
		}
		return null;
	}

	@Override
	public List<Record> selectAllRecordList() {		
		return singleRecord;
	}

	public Record selectRecordByIndex(int index) {
		return singleRecord.get(index);
	}


	
}
