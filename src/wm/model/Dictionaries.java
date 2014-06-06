/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.List;

/**
 * Class Dictionaries represents all available dictionaries. It provides
 * users methods to get a particular dictionary and fetch total recite
 * record.
 * 
 * @author Ariel Qian
 *
 */
public class Dictionaries extends WMModel{
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -6972941627269796672L;
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
		return null;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Dictionary getDictionary(String name){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getDictionaryNames(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getTotalSize(){
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public Record produceRecord(){
		return null;
	}
}
