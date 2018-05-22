import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.WindowEvent; 
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Random;


public class GameClickListener implements ActionListener //this is the listener that runs during the actual game
{
	private JFrame frame;
	private JLabel fromLabel;
	private JTextField toField;
	private Timing time;
	private ArrayList<String> words;
	private String currWord = "";
	private String scrambWord = "";
	private Random rand;
	public GameClickListener(JLabel fr, JTextField to, JFrame f, Timing t)
	{
		time = t; //store inputs
		frame = f;
		fromLabel = fr;
		toField = to;
		Scanner in;
		rand = new Random(); //make a new random
		try
		{
			in = new Scanner(new File("words.txt")); //try to read the file
		} catch (Exception e)
		{
			System.out.println("words.txt not found."); //if it doesn't work, something is irreplacably wrong, so exit
			System.exit(0);
			in = new Scanner(System.in); //this never gets called, it's just so the compiler gets off my case
		}
		words = new ArrayList<String>(); //make a new arraylist
		for (int i = 0; i != 1000; i++) //iterate through the 1000 word list
		{
			words.add(in.nextLine().replace("    ",""));
		}
	}
	public void actionPerformed(ActionEvent event) //when button pressed
	{
		JButton button = (JButton) event.getSource(); //figure out what button was pressed
		String selectedOption = button.getText(); //figure out what button says
		if (selectedOption.equals("Start")) //the initial button name
		{
			button.setText("Submit"); //change what the button says
			time.interrupt(); //reset timer
		}
		else
		{
			if (toField.getText().equals(currWord)) //if you got the right answer
			{
				AnagramGame.acc.addScore(time.timer); //then get points
			}
			else
			{
				time.gameOpen = false; //tell the timer to kill the game
			}
			time.interrupt(); //reset timer

		}
		currWord = words.get(rand.nextInt(words.size())); //get a new random word from the list
		scrambWord = Anagram.scramble(currWord); //scramble that word
		fromLabel.setText(scrambWord); //set the fromtextlabel to the scrambled word
		//System.out.println(currWord); //for debug
	}
}