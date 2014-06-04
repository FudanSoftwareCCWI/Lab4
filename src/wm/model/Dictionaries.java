/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Class Dictionaries represents all available dictionaries. It provides
 * users methods to get a particular dictionary and fetch total recite
 * record.
 * 
 * @author Ariel Qian
 *
 */
public class Dictionaries extends Observable{
	
	private List<Dictionary> dictionaries;
	
	public Dictionaries(List<Dictionary> dictionaries) {
		super();
		this.dictionaries = dictionaries;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Dictionary getDictionary(int index){
		return dictionaries.get(index);
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Dictionary getDictionary(String name){
		Dictionary dictionary=null;
		for(Dictionary dic: dictionaries){
			if(dic.getName().equals(name)){
				dictionary = dic;
				break;
			}
		}
		return dictionary;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getDictionaryNames(){
		List<String> names = new ArrayList<String>();
		for(Dictionary dic: dictionaries){
			names.add(dic.getName());
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTotalSize(){
		return dictionaries.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public Record produceRecord(){
		String name = "All Record";
		int totalSize = 0;
		int recitedSize = 0;
		int correctSize = 0;
		Record singleRecord = null;
		for(Dictionary dic: dictionaries){
			totalSize+=dic.getSize();
			singleRecord = dic.produceRecord();
			recitedSize += singleRecord.getRecitedSize();
			correctSize += singleRecord.getCorrect();
		}
		return new Record(name, totalSize, recitedSize, correctSize);
	}
}
