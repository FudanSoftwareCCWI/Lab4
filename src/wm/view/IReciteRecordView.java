package wm.view;

/**
 * Interface IReciteRecordView represents at the end of the recite. It will show a
 * table which contains the recite information.
 * 
 * @author Sidney Fan
 * 
 */
public interface IReciteRecordView {
	/**
	 * Set correct percentage text.
	 * @param precentage
	 */
	public void setCorrectPrecentageText(double percentage);

	/**
	 * Set correct count.
	 * @param currentCount
	 */
	public void setCorrectCountText(int currentCount);

	/**
	 * Set incorrect count text.
	 * @param incorrectCount
	 */
	public void setIncorrectCountText(int incorrectCount);

	/**
	 * Set name text.
	 * @param name
	 */
	public void setNameText(String name);

	/**
	 * Set recited size text.
	 * @param recitedSize
	 */
	public void setRecitedSizeText(int recitedSize);

	/**
	 * Show table panel.
	 */
	public void showTablePanel();
}
