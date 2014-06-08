/**
 * Software Engineer lab4
 */
package wm.model;

/**
 * Class Word represents a word. It has an English key and Chinese meaning. Some
 * statistic information is also included in class Word, such as recited and
 * correctness. It provides get and set methods to manage the word. record.
 * 
 * @author Ariel Qian
 * 
 */
public class Word {
	private String key;
	private String meaning;
	private boolean recited;
	private boolean correct;

	/**
	 * The constructor. It needs 4 parameters, including key, meaning, if the
	 * word is recited and if the word is correctly answered.
	 * 
	 * @param key
	 *            The english expression of the word
	 * @param meaning
	 *            The chinese meaning of the word
	 * @param recited
	 *            If the word is recited, it will be {@code true}, else it will
	 *            be {@code false}
	 * @param correct
	 *            If the user answer the meaning correct, it will be
	 *            {@code true}, else it will be {@code false};
	 */
	public Word(String key, String meaning, boolean recited, boolean correct) {
		super();
		this.key = key;
		this.meaning = meaning;
		this.recited = recited;
		this.correct = correct;
	}

	/**
	 * The get function of {@code recited}.
	 * 
	 * @return {@code recited}
	 */
	public boolean isRecited() {
		return recited;
	}

	/**
	 * The set function of {@code recited}.
	 * 
	 * @param recited
	 */
	public void setRecited(boolean recited) {
		this.recited = recited;
	}

	/**
	 * The get function of {@code correct}.
	 * 
	 * @return {@code correct}
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * The set function of {@code correct}.
	 * 
	 * @param correct
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * The get function of {@code key}.
	 * 
	 * @return {@code key}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * The get function of {@code meaning}.
	 * 
	 * @return {@code meaning}
	 */
	public String getMeaning() {
		return meaning;
	}

	public String toString(){
		String c = "";
		String r = "";
		String prefix = key.substring(0,1).toLowerCase();
		if (recited)
			r = "1";
		else
			r = "0";

		if (correct)
			c = "1";
		else
			c = "0";
		return prefix + "\t" + r + "\t" + c;
	}
}
