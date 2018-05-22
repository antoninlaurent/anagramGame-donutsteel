import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class StartupMenu
{
	public static void start()
	{
		JFrame frame = new JFrame("Startup Menu"); //make a new frame
		frame.getContentPane().setLayout(new FlowLayout()); //set the layout
		JLabel titleText = new JLabel("Welcome to the Anagram Game"); //make a label and some buttons
		JButton button1 = new JButton("Create Parent Account");
		JButton button2 = new JButton("Parent Login");
		JButton button3 = new JButton("Student Login");
		
		frame.getContentPane().add(titleText); //add stuff to frame
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		
		button1.addActionListener(new FrameChangeClickListener(frame)); //add listeners to buttons
		button2.addActionListener(new FrameChangeClickListener(frame));
		button3.addActionListener(new FrameChangeClickListener(frame));
		
		frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
		frame.setVisible(true); //put the frame on screen
	}	
}