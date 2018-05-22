import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class StudentLogin
{
	public static void start()
	{
		JFrame frame = new JFrame("Student Login"); //make new frame
        frame.getContentPane().setLayout(new FlowLayout()); //set the layout

        JLabel usernamelabel = new JLabel("Enter Username:"); //put label and textfield for username and password
        JTextField usernamebox = new JTextField("", 10);

        JLabel passwordlabel = new JLabel("Enter Password:");
        JTextField passwordbox = new JTextField("", 10);

		JButton button1 = new JButton("Login to Student Account"); //put a button
		button1.setSize(300, 90);

		frame.getContentPane().add(usernamelabel); //add stuff to frame
        frame.getContentPane().add(usernamebox);
        frame.getContentPane().add(passwordlabel);
        frame.getContentPane().add(passwordbox);
        frame.getContentPane().add(button1);

		ActionListener listener1 = new AccountClickListener(usernamebox, passwordbox, frame); //add listener to button
		button1.addActionListener(listener1);

        frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
        frame.setVisible(true); //put frame on screen
	}
}
