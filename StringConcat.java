import java.io.*;
import java.util.*;

public class StringConcat {
    public static ArrayList<String> Split(String str, String splt) {

	ArrayList<String> li = new ArrayList<>();
	int i;
	int j = 0;
	int str_size = str.length();
	int li_size = li.size();

	for (i = 0; i < str_size;) {
	    if (str.substring(i,i+1).compareTo(splt) == 0) {
		li.add(str.substring(j,i));
		i += splt.length();
		j = i;
	    } else {
		i += 1;
	    }
	} li.add (str.substring(j, i));
	System.out.println(li);
	return li;
    }

    public static void main(String args[]) {
	ArrayList<String> li = new ArrayList<>();
	li = Split(args[0], ":");
    }
}


// MAKE THE RETURN TYPES AN ARRAY


