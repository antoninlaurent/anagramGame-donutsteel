import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewScores
{
	public static void start()
	{
		JFrame frame = new JFrame("View Scores"); //make a new frame
		frame.getContentPane().setLayout(new FlowLayout()); //set the layout
		JLabel titleText = new JLabel("View Scores"); //put some text to explain
		ArrayList<Score> scores = AnagramGame.acc.getScores(); //get all the scores
		String scoreString = "<html>"; //define the string as html code
		for (Score i: scores) //iterate through all the scores
		{
			scoreString = scoreString + i.toString() + "<br>"; //add to string, and use html line ending
		}
		JLabel bodyText = new JLabel(scoreString); //put that string into a label
		JButton button1 = new JButton("Log Out"); //add a log out button
				
		frame.getContentPane().add(titleText); //put the stuff into the frame
		frame.getContentPane().add(bodyText);
		frame.getContentPane().add(button1);

		button1.addActionListener(new FrameChangeClickListener(frame)); //put a listener on button
	
		frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
		frame.setVisible(true); //put frame on screen
	}	
}