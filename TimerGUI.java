import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;

public class TimerGUI extends JFrame {
    JButton submit = new JButton("Submit");
    StoreTime app = new StoreTime();
    JFrame frame = frame();
    JButton process = new JButton("Process");
    JButton merge = new JButton("Merge");

    public void TimeGUI() {
        GUI();
    }

    // let the user select the file from a file selector
    private File fileChooser() {

        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
        fc.setDialogTitle("Select a video file");
        fc.setAcceptAllFileFilterUsed(false);
        File selectedFile;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Video Files", "flv", "wmv", "mov", "mp4");
        fc.addChoosableFileFilter(filter);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile;
        }
        return null;

    }

    // deals with the frame, buttons, and back-end functionality
    private void GUI() {
        JLabel enterTime, empty, enterRange;
        File fN = fileChooser();
        // let user pick from a drop down box which returns seconds as a integer
        // convert 
        JTextField range;
        enterRange = new JLabel();
        enterRange.setText("Enter Time Range in Seconds (SS):");
        enterRange.setBounds(10, 10, 10, 100);
        range = new JTextField("Range", 5);
        frame.getContentPane().add(enterRange);
        frame.getContentPane().add(range);

        enterTime = new JLabel();
        enterTime.setText("Enter Time (HH:MM:SS):");
        enterTime.setBounds(10, 10, 10, 100);
        
        // empty
        empty = new JLabel();
        empty.setBounds(10, 110, 100, 100);

        frame.getContentPane().add(empty);
        frame.getContentPane().add(enterTime);
        textField(submit, enterTime, empty, range, fN);

        submit.setBounds(10, 10, 100, 100);
        frame.getContentPane().add(submit);
        frame.setVisible(true);
    }

    // creates the window frame
    private JFrame frame() {
        frame = new JFrame("Video Manipulation");

        // set frame parameters
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 200);

        return frame;
    }

    // creates all the buttons and textfields
    public void textField(JButton submit, JLabel enter, JLabel empty, JTextField range, File fN) {
        // Initialize variables
        JTextField textfield1;

        // init text field
        textfield1 = new JTextField("Text field 1", 5);
        frame.getContentPane().add(textfield1);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String timeStr = textfield1.getText();
                    LocalTime.parse(timeStr);
                    enter.setText("");
                    empty.setText("Valid Time");
                    app.Range(timeStr, range.getText());
                    ArrayList < ArrayList < String >> list = app.getArr();
                    app.printArr();
                    process.setBounds(10, 10, 100, 100);
                    frame.getContentPane().add(process);
                    String fileName = fN.getName();

                    process.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {

                            // peform for loop in here for the size of the arraylists
                            int listSize = list.size();
                            String fileNameTrim = fileName.substring(0, fileName.lastIndexOf('.'));

                            String PATH = fileNameTrim+"Output";
                            File directory = new File(PATH);

                            if (!directory.exists()) {
                                directory.mkdir();
                            } else {
                                System.out.println("MADE");
                            }

                            System.out.println("\nRUNNING:");
                            try {
                                
                                merge.setBounds(10, 10, 100, 100);
                                frame.getContentPane().add(merge);
                                frame.setVisible(true);
                                System.out.println("MADE BUTTON");
                                for (int i = 0; i < listSize; i++) {
                                    String startTime = list.get(i).get(0);
                                    String lengthTime = list.get(i).get(2);
                                    int length = Integer.parseInt(lengthTime) * 2;
                                    String lengthTimeCal = Integer.toString(length);
                                    System.out.println("START " + startTime + " LENGTH " + lengthTimeCal);
                                    System.out.println("**********");
                                    String command = "ffmpeg -y -ss " +
                                        startTime + " -i " +
                                        fileName + " -to " +
                                        lengthTimeCal +
                                        " -c copy "+ fileNameTrim + "Output/" +
                                        fileNameTrim + "_" + i +
                                        ".mp4";
                                    Runtime.getRuntime().exec(command);
                                    System.out.println(command);
                                }

                                /* 1. Read in all the files from "Output" directory
                                    * All the files in the "Output" directory are video files that have
                                    * already been split.
                                    *
                                    * 2. Do java writeToFile to make a textfile in "Output" directory 
                                    * that lists video files you want to merge
                                    *
                                    * 3. Do the jpeg command that "merge" into one file
                                    *
                                    * 4. Put that file in "Output" directory
                                    */
                                merge.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent arg0) {
                                        try {
                                            FileWriter fw = new FileWriter("list.txt");
                                            String PATH1 = fileNameTrim+"Output/";
                                            File dir = new File(PATH1);
                                            File[] directoryListing = dir.listFiles();
                                            String file = "file '";
                                            String NewLine = "'\n";
                                            if (directoryListing != null) {
                                                for (File child: directoryListing) {
                                                    System.out.println(child);
                                                    String ch = child.toString();

                                                    // expand on? this is for windows
                                                    ch = ch.replace('\\' , '/');


                                                    for (int i = 0; i < file.length(); i++) {
                                                        fw.write(file.charAt(i));
                                                    }
                                                    for (int i = 0; i < ch.length(); i++) {
                                                        fw.write(ch.charAt(i));
                                                    }
                                                    for (int i = 0; i < NewLine.length(); i++) {
                                                        fw.write(NewLine.charAt(i));
                                                    }
                                                }
                                            }
                                            fw.close();

                                            String mergeCommand = "ffmpeg -y -f concat -i list.txt"
                                            + " -c copy " + fileNameTrim + "Output/" +
                                            fileNameTrim + "_merge.mp4";

                                            Runtime.getRuntime().exec(mergeCommand);
                                            System.out.println(mergeCommand);

                                        } catch (IOException e) {
                                            System.out.println("Merge didn't work");
                                            e.printStackTrace();
                                        }
                                    }
                                });

                            } catch (Exception e) {
                                System.out.println("Didn't work");
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (DateTimeParseException | NullPointerException e) {
                    String timeStr = textfield1.getText();
                    System.out.println("Invalid time string: " + timeStr);
                    enter.setText("");
                    empty.setText("Invalid Time");
                }
            }
        });

    }

}