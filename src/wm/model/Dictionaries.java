/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Class Dictionaries represents all available dictionaries. It provides users
 * methods to get a particular dictionary and fetch total recite record.
 * 
 * @author Ariel Qian
 * 
 */
public class Dictionaries extends Observable {

	private List<Dictionary> dictionaries;

	public Dictionaries(List<Dictionary> dictionaries) {
		super();
		this.dictionaries = dictionaries;
	}

	/**
	 * Get the dictionary by the index
	 * 
	 * @param index
	 *            The index of the dictionary
	 * @return {@code dictionary}
	 */
	public Dictionary getDictionary(int index) {
		return dictionaries.get(index);
	}

	/**
	 * Get the dictionary by the name
	 * 
	 * @param name
	 *            The name of the dictionary
	 * @return {@code dictionary}
	 */
	public Dictionary getDictionary(String name) {
		for (Dictionary dic : dictionaries) {
			if (dic.getName().equals(name)) {
				return dic;
			}
		}
		return null;
	}

	/**
	 * Get all dictionaries' name
	 * 
	 * @return a {@code List<String>} of the dictionaries' name
	 */
	public List<String> getDictionaryNames() {
		List<String> names = new ArrayList<String>();
		for (Dictionary dic : dictionaries) {
			names.add(dic.getName());
		}
		return names;
	}

	/**
	 * Get the number of the dictionaries
	 * 
	 * @return {@code int}
	 */
	public int getDicNumber() {
		return dictionaries.size();
	}
	
	/**
	 * Get the total size of the dictionaries
	 * 
	 * @return {@code int}
	 */
	public int getTotalSize(){
		int totalSize = 0;
		for(Dictionary dic: dictionaries){
			totalSize += dic.getSize();
		}
		return totalSize;
	}

	/**
	 * Get a Record of all dictionaries.
	 * 
	 * @return {@code Record}
	 */
	public Record produceRecord() {
		String name = "All Record";
		int totalSize = 0;
		int recitedSize = 0;
		int correctSize = 0;
		Record singleRecord = null;
		for (Dictionary dic : dictionaries) {
			totalSize += dic.getSize();
			singleRecord = dic.produceRecord();
			recitedSize += singleRecord.getRecitedSize();
			correctSize += singleRecord.getCorrect();
		}
		return new Record(name, totalSize, recitedSize, correctSize);
	}
}
