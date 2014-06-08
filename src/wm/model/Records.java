package wm.model;

import java.util.List;

public class Records extends WMModel{
	/**
	 * Generated 
	 */
	private static final long serialVersionUID = -720321694165706292L;
	private Record allRecord;
	private List<Record> records;
	
	public Records(List<Record> records, Record allRecord){
		super();
		this.records = records;
		this.allRecord = allRecord;
	}
		
	public List<Record> getRecords() {
		return records;
	}


	public Record getSingleRecord(int index){
		return records.get(index);
	}
	
	public Record getSingleRecord(String name) {
		for(Record r: records){
			if(r.getName().equals(name)){
				return r;
			}				
		}
		return null;
	}
	
	public Record getAllRecord(){
		return allRecord;
	}
}
