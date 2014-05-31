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

	
	public Word(String key, String meaning, boolean recited, boolean correct) {
		super();
		this.key = key;
		this.meaning = meaning;
		this.recited = recited;
		this.correct = correct;
	}

	public boolean isRecited() {
		return recited;
	}

	public void setRecited(boolean recited) {
		this.recited = recited;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getKey() {
		return key;
	}

	public String getMeaning() {
		return meaning;
	}

}
