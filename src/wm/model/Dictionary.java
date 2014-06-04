/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Class Dictionary represents a particular dictionary in the recite process. It
 * provides users several methods to manage a recite process and fetch current
 * recite record.
 * 
 * @author Ariel Qian
 * 
 */
public class Dictionary extends Observable {

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
		return name;
	}

	/**
	 * Get the size of the dictionary.
	 * 
	 * @return The size of the dictionary
	 */
	public int getSize() {
		return words.size();
	}

	/**
	 * Get a list of words in the dictionary that has a particular prefix.
	 * 
	 * @param prefix
	 *            The particular prefix
	 * @return A list of words with this prefix
	 */
	public List<String> getMatchWords(String prefix) {
		List<String> match = new ArrayList<String>();
		for (Word w : words) {
			if (w.getKey().startsWith(prefix))
				match.add(w.getKey());
		}
		return match;
	}

	/**
	 * 
	 */
	public int getPresentWord() {
		return presentWord;
	}

	/**
	 * Get the next English key.
	 * 
	 * @return The next English key
	 */
	public String getNextKey() {
		Word word = words.get(presentWord);
		return word.getKey();
	}

	/**
	 * Get the next Chinese meaning.
	 * 
	 * @return The Chinese meaning
	 */
	public String getNextMeaning() {
		Word word = words.get(presentWord);
		return word.getMeaning();
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public boolean getWordRecited(int index){
		return words.get(index).isRecited();
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public boolean getWordCorrect(int index){
		return words.get(index).isCorrect();
	}
	
	public String getWordEntry(int index){
		boolean recited = this.getWordRecited(index);
		boolean correct = this.getWordCorrect(index);
		String c = "";
		String r = "";
		if (recited)
			r = "1";
		else
			r = "0";

		if (correct)
			c = "1";
		else
			c = "0";
		return r+"\t"+c;
	}

	/**
	 * Set the recitedSize.
	 * 
	 * @param size
	 *            The recitedSize
	 */
	public void setRecitedSize(int size) {
		recitedSize = size;
	}

	/**
	 * Set the index of the start word.
	 * 
	 * @param index
	 *            The index of the start word
	 */
	public void setStartWord(int index) {
		startWord = index;
	}

	/**
	 * Set the index of the start word.
	 * 
	 * @param key
	 *            The key of the start word
	 */
	public void setStartWord(String key) {
		int index = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getKey().equals(key)) {
				index = i;
				break;
			}
		}
		startWord = index;
	}

	/**
	 * Set the index of the present word. Must be called when setStartWord() is
	 * called.
	 * 
	 * @param index
	 *            The index of the present word
	 */
	public void setPresentWord(int index) {
		presentWord = index;
	}

	/**
	 * 
	 */
	public void setWordRecited() {
		words.get(presentWord).setRecited(true);
	}

	/**
	 * 
	 */
	public void setWordCorrect(boolean correct) {
		words.get(presentWord).setCorrect(correct);
	}

	/**
	 * Calculate the available size when start word is set. Must be called after
	 * the start word is set.
	 * 
	 * @return The available size with a particular start
	 */
	public int calAvailableSize() {
		return words.size() - startWord;
	}

	/**
	 * Produce a record for the whole dictionary.
	 * 
	 * @return A record
	 */
	public Record produceRecord() {
		String recordName = name;
		int totalSize = words.size();
		int recitedSize = 0;
		int correctSize = 0;
		for (Word w : words) {
			if (w.isRecited())
				recitedSize++;
			if (w.isCorrect())
				correctSize++;
		}
		return new Record(name, totalSize, recitedSize, correctSize);
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
		String recordName = name;
		int totalSize = end - start + 1;
		int recitedSize = 0;
		int correctSize = 0;
		Word w = null;
		for (int i = start; i <= end; i++) {
			w = words.get(i);
			if (w.isRecited())
				recitedSize++;
			if (w.isCorrect())
				correctSize++;
		}
		return new Record(recordName, totalSize, recitedSize, correctSize);
	}

}
