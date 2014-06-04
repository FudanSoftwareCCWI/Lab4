/**
 * Software Engineer lab4
 */
package wm.model;

/**
 * Class Record represents a particular record in the recite process. It
 * provides users statistic information in the recite process, either of one
 * particular dictionary or all dictionaries.
 * 
 * @author Ariel Qian
 * 
 */
public class Record extends WMModel{
	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 6614689523828436387L;
	
	private String name;
	private int totalSize;
	private int recitedSize;
	private int correct;


	/**
	 * Create a recited record of a particular dictionary.
	 * 
	 * @param name
	 *            The name of the dictionary
	 * @param totalSize
	 *            The number of words in the dictionary
	 * @param recitedSize
	 *            The number of words recited
	 * @param correct
	 *            The correct number of words recited
	 */
	public Record(String name, int totalSize, int recitedSize, int correct) {
		super();
		this.name = name;
		this.totalSize = totalSize;
		this.recitedSize = recitedSize;
		this.correct = correct;
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
	 * Get the total size of the dictionary.
	 * 
	 * @return The number of words in the dictionary
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * Get the recited size.
	 * 
	 * @return The number of words recited
	 */
	public int getRecitedSize() {
		return recitedSize;
	}

	/**
	 * Get the correct number of words recited.
	 * 
	 * @return The correct number of words recited
	 */
	public int getCorrect() {
		return correct;
	}

	/**
	 * Get the wrong number of words recited, obtained by subtract correct
	 * number from recitedSize.
	 * 
	 * @return The wrong number of words recited
	 */
	public int getWrong() {
		return recitedSize - correct;
	}

	/**
	 * Get the correct rate of words recited.
	 * 
	 * @return The correct rate of words recited
	 */
	public double getCorrectRate() {
		return (double) correct / (double) recitedSize;
	}

}
