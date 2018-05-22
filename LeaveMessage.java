import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class LeaveMessage
{
	public static void start()
	{
		JFrame frame = new JFrame("Leave Message"); //make frame
        frame.getContentPane().setLayout(new FlowLayout()); //set layout

        JLabel msglabel = new JLabel("Enter Message for your Student:"); //make instructions and textfield
        JTextField msgbox = new JTextField(AnagramGame.acc.getMessage(), 10);

		JButton button1 = new JButton("Save Message"); //make button

		frame.getContentPane().add(msglabel); //add stuff to frame
        frame.getContentPane().add(msgbox);
        frame.getContentPane().add(button1);

		ActionListener listener1 = new InputClickListener(msgbox, frame); //add listener to button
		button1.addActionListener(listener1);

        frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
        frame.setVisible(true); //put frame on screen
	}
}
