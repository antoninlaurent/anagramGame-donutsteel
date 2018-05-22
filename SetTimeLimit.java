import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class SetTimeLimit
{
	public static void start()
	{
		JFrame frame = new JFrame("Set Time Limit");
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel timelabel = new JLabel("Enter New Time Limit in Seconds:"); //make instructions and text field
        JTextField timebox = new JTextField("", 10);

		JButton button1 = new JButton("Create Student Account"); //make button

		frame.getContentPane().add(timelabel); //add stuff to frame
        frame.getContentPane().add(timebox);
        frame.getContentPane().add(button1);

		ActionListener listener1 = new InputClickListener(timebox, frame); //add listener to button
		button1.addActionListener(listener1);

        frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
        frame.setVisible(true); //put frame on screen
	}
}
