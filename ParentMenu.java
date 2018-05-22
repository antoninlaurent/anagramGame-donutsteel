import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class ParentMenu
{
	public static void start()
	{
		JFrame frame = new JFrame("Parent Menu"); //make frame
		frame.getContentPane().setLayout(new FlowLayout()); //set layout
		JLabel titleText = new JLabel("Parent Menu"); //put a title label
		JButton button1 = new JButton("Create Student Account"); //make some buttons
		JButton button2 = new JButton("Set Time Limit");
		JButton button3 = new JButton("View Scores");
		JButton button4 = new JButton("Leave Message");
		JButton button5 = new JButton("Log Out");
		
		
		frame.getContentPane().add(titleText); //put stuff on frame
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(button4);
		frame.getContentPane().add(button5);
		

		button1.addActionListener(new FrameChangeClickListener(frame)); //add listeners to buttons
		button2.addActionListener(new FrameChangeClickListener(frame));
		button3.addActionListener(new FrameChangeClickListener(frame));
		button4.addActionListener(new FrameChangeClickListener(frame));
		button5.addActionListener(new FrameChangeClickListener(frame));
	
		frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
		frame.setVisible(true); //put frame on screen
	}	
}