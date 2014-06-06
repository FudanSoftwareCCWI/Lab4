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
	 * Get the presentWord.
	 * 
	 * @return {@code precentWord}
	 */
	public int getPresentWord() {
		return presentWord;
	}

	public String getKey(int index){
		return words.get(index).getKey();
	}
	
	public String getMeaning(int index){
		return words.get(index).getMeaning();
	}
	
	/**
	 * Get the word's if recited by the index.
	 * 
	 * @param index
	 *            The index of the word
	 * @return The {@code recited} of the word
	 */
	public boolean getWordRecited(int index) {
		return words.get(index).isRecited();
	}

	/**
	 * Get the word's if correct by the index.
	 * 
	 * @param index
	 *            The index of the word
	 * @return The {@code correct} of the word
	 */
	public boolean getWordCorrect(int index) {
		return words.get(index).isCorrect();
	}

	/**
	 * Get the word if recited and correct. This function is used to record the
	 * info.
	 * 
	 * @param index
	 *            The index of the word
	 * @return A String: {@code recited} + "\t" + {@code correct}
	 */
	public String getWordEntry(int index) {
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
		return r + "\t" + c;
	}
	
	public int getWordIndex(String key) {
		int index = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getKey().equals(key)) {
				index = i;
				break;
			}
		}
		return index;
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
	 * Set the present word is already recited
	 * 
	 */
	public void setWordRecited() {
		words.get(presentWord).setRecited(true);
	}

	/**
	 * Set the present word is already recited
	 * 
	 */
	public void setWordRecited(int index) {
		words.get(index).setRecited(true);
	}
	
	/**
	 * Set the present word is correct or not. If the word is already correct, do not modify it.
	 * 
	 * @param correct
	 * 			a boolean show if the word is correct 
	 */
	public void setWordCorrect(boolean correct) {
		boolean isCorrect=words.get(presentWord).isCorrect();
		if(!isCorrect)
			words.get(presentWord).setCorrect(correct);
	}
	
	public void setWordCorrect(int index,boolean correct) {
		boolean isCorrect=words.get(index).isCorrect();
		if(!isCorrect)
			words.get(index).setCorrect(correct);
	}
	
	public int calAvailableSize(int start) {
		return words.size() - start;
	}

	/**
	 * Produce a record for the whole dictionary.
	 * 
	 * @return A record
	 */
	public Record produceRecord() {
		return produceRecord(0,getSize()-1);
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
