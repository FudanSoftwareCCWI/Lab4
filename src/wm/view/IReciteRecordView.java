package wm.view;

/**
 * Interface IReciteRecordView represents at the end of the recite. It will show
 * a table which contains the recite information.
 * 
 * @author Sidney Fan
 * 
 */
public interface IReciteRecordView {
	/**
	 * Set correct percentage 
	 * @param precentage
	 */
	public void setCorrectPrecentageText(double percentage);

	/**
	 * Set correct count 
	 * @param currentCount
	 */
	public void setCorrectCountText(int currentCount);

	/**
	 * Set incorrect count 
	 * @param incorrectCount
	 */
	public void setIncorrectCountText(int incorrectCount);

	/**
	 * Set name text
	 * @param name
	 */
	public void setNameText(String name);

	/**
	 * Set recited size
	 * @param recitedSize
	 */
	public void setRecitedSizeText(int recitedSize);

	/**
	 * Show the table panel
	 */
	public void showTablePanel();
}
