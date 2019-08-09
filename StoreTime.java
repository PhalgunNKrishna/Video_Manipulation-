import java.util.*; 

public class StoreTime {

    private ArrayList<ArrayList<String>> list;

    // CONSTRUCTOR FUNCTION:
    public StoreTime () {
        list = new ArrayList<ArrayList<String>>();
    }


    // public StoreTime(int start_hour, int start_minute, int start_second) {
    //     this.minute = start_minute;
    //     this.second = start_second;
    //     this.hour = start_hour;
    //     this.list = new ArrayList<Integer>();
    // }

    private int SecondConvert(int min, int sec) {
        int ret;
        ret = (min * 60 + sec);
        return ret;
    }

    public void addToArr(ArrayList<String> arr) {
        list.add(arr);
    }

    public void printArr() {
        for (int counter = 0; counter < list.size(); counter++) { 		      
            System.out.println(counter + " " + list.get(counter)); 		
        }  
    }

}

