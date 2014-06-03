/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.List;

/**
 * Class Dictionary represents a particular dictionary in the recite process. It
 * provides users several methods to manage a recite process and fetch current
 * recite record.
 * 
 * @author Ariel Qian
 * 
 */
public class Dictionary extends WMModel{
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -3393449066800517704L;
	private String name;
	private List<Word> words;
	private int presentWord;
	private int startWord;
	private int recitedSize;

	/**
	 * Create a dictionary with name, words and default presentWord.
	 * 
	 * @param name
	 *            The name of the dictionary
	 * @param words
	 *            The words of the dictionary
	 */
	public Dictionary(String name, List<Word> words) {
		this(name, words, 0);
	}

	/**
	 * Create a dictionary with name, words and presentWord.
	 * 
	 * @param name
	 *            The name of the dictionary
	 * @param words
	 *            The words of the dictionary
	 * @param presentWord
	 *            The index of the present word
	 */
	public Dictionary(String name, List<Word> words, int presentWord) {
		super();
		this.name = name;
		this.words = words;
		this.presentWord = presentWord;
	}

	/**
	 * Get the name of the dictionary.
	 * 
	 * @return The name of the dictionary
	 */
	public String getName() {
		return null;
	}

	/**
	 * Get the size of the dictionary.
	 * 
	 * @return The size of the dictionary
	 */
	public int getSize() {
		return 0;
	}

	/**
	 * Get a list of words in the dictionary that has a particular prefix.
	 * 
	 * @param prefix
	 *            The particular prefix
	 * @return A list of words with this prefix
	 */
	public List<String> getMatchWords(String prefix) {
		return null;
	}

	public int getPresentWord() {
		return this.presentWord;
	}
	
	/**
	 * Get the next English key.
	 * 
	 * @return The next English key
	 */
	public String getNextKey() {
		return null;
	}

	/**
	 * Get the next Chinese meaning.
	 * 
	 * @return The Chinese meaning
	 */
	public String getNextMeaning() {
		return null;
	}

	/**
	 * Set the recitedSize.
	 * 
	 * @param size
	 *            The recitedSize
	 */
	public void setRecitedSize(int size) {

	}

	/**
	 * Set the index of the start word.
	 * 
	 * @param index
	 *            The index of the start word
	 */
	public void setStartWord(int index) {

	}

	/**
	 * Set the index of the present word. Must be called when setStartWord() is
	 * called.
	 * 
	 * @param index
	 *            The index of the present word
	 */
	private void setPresentWord(int index) {

	}

	/**
	 * Calculate the available size when start word is set. Must be called after
	 * the start word is set.
	 * 
	 * @return The available size with a particular start
	 */
	public int calAvailableSize() {
		return 0;
	}

	/**
	 * Produce a record for the whole dictionary.
	 * 
	 * @return A record
	 */
	public Record produceRecord() {
		return produceRecord(0, getSize() - 1);
	}

	/**
	 * Produce a record with start and end(included).
	 * 
	 * @param start
	 *            The start index
	 * @param end
	 *            The end index
	 * @return A record
	 */
	public Record produceRecord(int start, int end) {
		return null;
	}

	public int getStartWord() {
		return this.startWord;
	}



}
