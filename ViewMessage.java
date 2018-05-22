import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


public class ViewMessage
{
	public static void start()
	{
		JFrame frame = new JFrame("View Message"); //make a new frame
		frame.getContentPane().setLayout(new FlowLayout()); //set the layout
		JLabel titleText = new JLabel("View Message");	//put a title label
		JLabel bodyText = new JLabel(AnagramGame.acc.getMessage()); //get the message, put it in the label
		JButton button1 = new JButton("Return to Student Menu"); //go back button
				
		frame.getContentPane().add(titleText); //add stuff to frame
		frame.getContentPane().add(bodyText);
		frame.getContentPane().add(button1);

		button1.addActionListener(new FrameChangeClickListener(frame)); //add listener to button
	
		frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure this doesn't hang
		frame.setVisible(true); //put frame on screen
	}	
}