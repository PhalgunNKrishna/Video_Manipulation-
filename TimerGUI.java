import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.time.*;

public class TimerGUI extends JFrame{
    // need to return something
    JButton submit = new JButton("Submit");
    StoreTime app = new StoreTime();

    public void TimeGUI() {
        
        GUI();
    }

    private void GUI() {
        JFrame frame = frame();
        
        JLabel enter, empty;

        enter = new JLabel();
        enter.setText("Enter Time:");
        enter.setBounds(10, 10, 100, 100);

        // empty
        empty = new JLabel();
        empty.setBounds(10, 110, 100, 100);

        frame.getContentPane().add(empty);
        frame.getContentPane().add(enter);

        textField(frame, submit, enter, empty);
        textField(frame, submit, enter, empty);


        submit.setBounds(10, 10, 100, 100);

        
        frame.getContentPane().add(submit);
        


        // JButton startButton = new JButton("Start");
        // JButton stopButton = new JButton("Stop");

        
        // frame.getContentPane().add(startButton, BorderLayout.WEST); // Adds Button to content pane of frame
        // frame.getContentPane().add(stopButton, BorderLayout.EAST); // Adds Button to content pane of frame
        frame.setVisible(true);
    }

    private JFrame frame() {
        JFrame frame = new JFrame("Video Manipulation");

        // set frame parameters
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        return frame;
    }
    
    public void textField(JFrame frame, JButton submit, JLabel enter, JLabel empty) {
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
                    System.out.println("Valid time string: " + timeStr);
                    enter.setText("");
                    empty.setText("Valid Time");

                    StringConcat cat = new StringConcat();
                    ArrayList<String> li = cat.Split(timeStr, ":");

                    
                    app.addToArr(li);
                    app.printArr();
                    
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

