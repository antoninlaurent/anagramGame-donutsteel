import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class StudentMenu
{
	public static void start()
	{
		JFrame frame = new JFrame("Student Menu"); //open a frame
		frame.getContentPane().setLayout(new FlowLayout()); //set layout
		JLabel titleText = new JLabel("Student Menu"); //make a title label
		JButton button1 = new JButton("Play Game"); //make buttons
		JButton button3 = new JButton("View Scores");
		JButton button4 = new JButton("View Message");
		JButton button5 = new JButton("Log Out");
		
		
		frame.getContentPane().add(titleText); //add stuff to screen
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(button4);
		frame.getContentPane().add(button5);
		

		button1.addActionListener(new FrameChangeClickListener(frame)); //add listeners to buttons
		button3.addActionListener(new FrameChangeClickListener(frame));
		button4.addActionListener(new FrameChangeClickListener(frame));
		button5.addActionListener(new FrameChangeClickListener(frame));
	
		frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure frame doesn't hang
		frame.setVisible(true); //put frame on screen
	}	
}