/**
 * Software Engineer lab4
 */
package wm.model;

import java.util.List;

/**
 * Interface IDictionary provides the functions to get the word and word
 * infomation in the dictionary. Also the functions return the record of the
 * dictionary. 
 * 
 * @author ArielQian
 * 
 */
public interface IDictionary {

	/**
	 * Get the name of the dictionary.
	 * 
	 * @return The name of the dictionary
	 */
	public String getName();

	/**
	 * Get the size of the dictionary.
	 * 
	 * @return The size of the dictionary
	 */
	public int getSize();

	/**
	 * Get a list of words in the dictionary that has a particular prefix.
	 * 
	 * @param prefix
	 *            The particular prefix
	 * @return A list of words with this prefix
	 */
	public List<String> getMatchWords(String prefix);

	/**
	 * Get the presentWord.
	 * 
	 * @return {@code precentWord}
	 */
	public int getPresentWord();

	/**
	 * Get the english expression of the word according to index
	 * 
	 * @param index
	 *            The index of the word
	 * @return {@code String} The english expression
	 */
	public String getKey(int index);

	/**
	 * Get the chinese expression of the word according to index
	 * 
	 * @param index
	 *            The index of the word
	 * @return {@code String} The chinese expression
	 */
	public String getMeaning(int index);

	/**
	 * Get the word's if recited by the index.
	 * 
	 * @param index
	 *            The index of the word
	 * @return The {@code recited} of the word
	 */
	public boolean getWordRecited(int index);

	/**
	 * Get the word's if correct by the index.
	 * 
	 * @param index
	 *            The index of the word
	 * @return The {@code correct} of the word
	 */
	public boolean getWordCorrect(int index);

	/**
	 * Get the word if recited and correct. This function is used to record the
	 * info.
	 * 
	 * @param index
	 *            The index of the word
	 * @return A String: {@code recited} + "\t" + {@code correct}
	 */
	public String getWordEntry(int index);

	/**
	 * Get the word index according to the word's key.
	 * 
	 * @param key
	 *            The english expression of the word.
	 * @return {@code int} The index of the word.
	 */
	public int getWordIndex(String key);

	/**
	 * Set the index of the present word. Must be called when setStartWord() is
	 * called.
	 * 
	 * @param index
	 *            The index of the present word
	 */
	public void setPresentWord(int index);

	/**
	 * Set the present word is already recited
	 * 
	 */
	public void setWordRecited(int index);

	/**
	 * Set the present word is correct or not. If the word is already correct,
	 * do not modify it.
	 * 
	 * @param index
	 *            the index of the word
	 * @param correct
	 *            a boolean show if the word is correct
	 */
	public void setWordCorrect(int index, boolean correct);

	/**
	 * Calculate the available size in the dictionary
	 * 
	 * @param start
	 *            The start word in the recitation
	 * @return {@code int} The available size.
	 */
	public int calAvailableSize(int start);

	/**
	 * Produce a record for the whole dictionary.
	 * 
	 * @return A record
	 */
	public Record produceRecord();

	/**
	 * Produce a record with start and end(included).
	 * 
	 * @param start
	 *            The start index
	 * @param end
	 *            The end index
	 * @return A record
	 */
	public Record produceRecord(int start, int end);

}
