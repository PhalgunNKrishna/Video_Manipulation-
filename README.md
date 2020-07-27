# Video_Manipulation-  

By Phalgun Krishna and Charles Arellano   

A side project that can split video files at a desired time stamp and concatenate multiple video files together. This project includes a GUI for users to easily input their desired videos and time stamps. Created by Phalgun Krishna and Charles Arellano

## Instructions to Run Project
In order to run our project, simply compile the .java files in the Video Manipulation- directory using the command:

```c
javac <file name>.java
```

An example would then be:

```c
javac SetRange.java
```

Be sure to compile the java files without dependencies before the files with dependencies. Therefore, Main.java should be compiled last and TimerGUI.java should be compiled immediately before Main.java. After all the .class files have been made, run:

```c
java Main
```
A GUI will appear in which you will select a video file from your computer and will then be prompted to enter a time stamp and a range. If one were to input a time stamp of 00:01:30 with a range of 10 seconds, the resulting video will be the original video from 00:01:20 to 00:01:40. Thus, the resulting video spans the time <Time Stamp> - <Range> to <Time Stamp> + Range

A "SampleVideoOutput directory" will then appear containing your split video file. You will then have the option to merge video files of your choice in the GUI prompt.

To remove the .class files simply type in the Video Manipulation directory shell:

```c
rm *.class
```
### Overview of Our Project
As this was Phalgun's introduction to Java, Phalgun focused on the simpler aspects of this project by researching potential tools to split and concatenate video files as well as writing the StringConcat.java and SetRange.java files. After he found the ffmpeg command line tool used on lines 140 through 147 in TimerGUI.java, Phalgun wrote the aforementioned files with little difficulty. 

Because Charles held more experience in programming and Java than Phalgun, Charles focused his efforts on the more complex TimerGUI.java file.




