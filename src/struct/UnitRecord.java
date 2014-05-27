package struct;

public class UnitRecord {
	
	private String unitName;
	private int totalNum;
	private int recitedNum;
	private int correctNum;
	
	public UnitRecord(String name, int num){
		unitName = name;
		totalNum = num;
		recitedNum = 0;
		correctNum = 0;
	}

	public String getUnitName() {
		return unitName;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public int getRecitedNum() {
		return recitedNum;
	}

	public int getCorrectNum() {
		return correctNum;
	}
	
	public double getCorrectRate() {
		return correctNum/totalNum;
	}
}
