import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class TimerGUI {

    public void TimeGUI() {
        GUI();
    }

    private void GUI() {
        JFrame frame = new JFrame("Video Manipulation");

        // Initialize variables
        JTextField textfield1;
        JLabel enter, empty;

        // set frame parameters
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        // init label
        enter = new JLabel();
        enter.setText("Enter Time:");
        enter.setBounds(10,10,100,100);
        
        // empty
        empty = new JLabel();
        empty.setBounds(10,110,100,100);

        // init text field
        textfield1 = new JTextField("Text field 1", 5);

        JButton submit = new JButton("Submit");
        submit.setBounds(10, 10, 100, 100);
        // JButton startButton = new JButton("Start");
        // JButton stopButton = new JButton("Stop");
        

        


        frame.getContentPane().add(empty);
        frame.getContentPane().add(textfield1);
        frame.getContentPane().add(enter);
        frame.getContentPane().add(submit);
        // frame.getContentPane().add(startButton, BorderLayout.WEST); // Adds Button to content pane of frame
        // frame.getContentPane().add(stopButton, BorderLayout.EAST); // Adds Button to content pane of frame
        
        frame.setVisible(true);
    }

}