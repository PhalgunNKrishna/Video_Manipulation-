import java.util.*;

public class StoreTime {

    private ArrayList < ArrayList < String >> list;

    public StoreTime() {
        list = new ArrayList < ArrayList < String >> ();
    }

    public String RegularTime(int seconds) {
        int hour = 0;
        int min = 0;
        int sec = 0;
        if (seconds > 3599) {
            hour = seconds / 3600;
            seconds = seconds % (3600);
        } else {
            hour = 00;
            seconds = seconds;
        }
        if (seconds > 59) {
            min = seconds / 60;
            seconds = seconds % (60);
        } else {
            min = 00;
            seconds = seconds;
        }
        sec = seconds;
        String h = Integer.toString(hour);
        String m = Integer.toString(min);
        String s = Integer.toString(sec);
        String time = h + ":" + m + ":" + s;
        return time;
    }

    public ArrayList < Integer > Split(String str, String splt) {

        ArrayList < Integer > li = new ArrayList < > ();
        int i;
        int j = 0;
        int str_size = str.length();
        int li_size = li.size();

        for (i = 0; i < str_size;) {
            if (str.substring(i, i + 1).compareTo(splt) == 0) {
                li.add(Integer.parseInt(str.substring(j, i)));
                i += splt.length();
                j = i;
            } else {
                i += 1;
            }
        }
        li.add(Integer.parseInt(str.substring(j, i)));
        return li;
    }

    private int SecondConvert(int hour, int min, int sec) {
        int ret;
        ret = (hour * 3600 + min * 60 + sec);
        return ret;
    }

    public void Range(String li, String rangeVal) {

        // hast to be splitt.split() later 
        int rangeValInt = Integer.parseInt(rangeVal);
        ArrayList < String > ly = new ArrayList < > ();
        ArrayList < Integer > split_time = Split(li, ":");
        int temp = SecondConvert(split_time.get(0), split_time.get(1), split_time.get(2));
        // next line adds the times to the ArrayList<ArrayList<String>>
        // need a function to convert seconds to hour, min, sec)
        //list.get(i).add(RegularTime(temp + 30));
        //list.get(i).add(RegularTime(temp - 30));

        // INSTEAD OF HARD CODING 30, YOU'LL WANT TO USE RANGE INSTEAD
        ly.add(RegularTime(temp - rangeValInt));
        ly.add(RegularTime(temp + rangeValInt));

        ly.add(rangeVal);
        list.add(ly);
    }

    private int SecondConvert(int min, int sec) {
        int ret;
        ret = (min * 60 + sec);
        return ret;
    }

    public void addToArr(ArrayList < String > arr) {
        list.add(arr);
    }

    public ArrayList < ArrayList < String >> getArr() {
        return list;
    }

    public void printArr() {
        for (int counter = 0; counter < list.size(); counter++) {
            System.out.println(counter + " " + list.get(counter));
        }
    }

}
