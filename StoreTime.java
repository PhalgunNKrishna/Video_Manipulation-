import java.util.*; 

public class StoreTime {

    private int minute;
    private int second;
    private int milisecond;
    private List<Integer> list;

    // CONSTRUCTOR FUNCRTION:
    public StoreTime(int start_minute, int start_second) {
        this.minute = start_minute;
        this.second = start_second;
        this.list = new ArrayList<Integer>();
    }

    private int SecondConvert(int min, int sec) {
        int ret;
        ret = (min * 60 + sec);
        return ret;
    }

    public void 
}

