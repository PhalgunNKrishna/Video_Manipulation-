public class SetRange {
	private int[] Range;

	public int[] Range(int minute, int second) {
		Range = new int[2];
		Range[0] = minute;
		Range[1] = second;
		
		return Range;
	}
}
