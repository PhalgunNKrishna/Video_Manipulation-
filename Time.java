public class Time {

    private int minute;
    private int second;
    private int milisecond;
    private int time_array[];

    // CONSTRUCTOR FUNCRTION:
    public Timer(int start_minute; int start_second) {
	minute = start_minute;
	second = start_second;
	time_array = new int[1];
	time_array[0] = SecondConvert(minute, second);
    }

    public int SecondConvert(min, sec) {
	int ret;
	ret = (min * 60 + sec);
	return ret;
    }
}

