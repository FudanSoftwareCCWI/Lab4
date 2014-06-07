/**
 * Software Engineer lab4
 */
package wm.model;

/**
 * Interface IRecord provides the function to get the single record infomation.
 * 
 * @author ArielQian
 *
 */
public interface IRecord {

	/**
	 * Get the name of the dictionary.
	 * 
	 * @return The {@code name} of the dictionary
	 */
	public String getName();
	
	
	/**
	 * Get the total size of the dictionary.
	 * 
	 * @return {@code totalSize}, the number of words in the dictionary.
	 */
	public int getTotalSize();
	
	
	/**
	 * Get the recited size.
	 * 
	 * @return {@code recitedSize}, the number of words recited.
	 */
	public int getRecitedSize();
	
	
	/**
	 * Get the correct number of words recited.
	 * 
	 * @return The {@code correct} number of words recited
	 */
	public int getCorrect();
	
	
	/**
	 * Get the wrong number of words recited, obtained by subtract correct
	 * number from recitedSize.
	 * 
	 * @return The wrong number of words recited
	 */
	public int getWrong();
	
	
	/**
	 * Get the correct rate of words recited.
	 * 
	 * @return The correct rate of words recited
	 */
	public double getCorrectRate();
	
	
}
