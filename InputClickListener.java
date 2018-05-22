import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.WindowEvent; 


public class InputClickListener implements ActionListener //this listener takes a field and frame, and saves info to current account
{
	private JTextField input;
	private JFrame frame;
	public InputClickListener(JTextField t, JFrame f) //constructor
	{
		input = t;
		frame = f;
	}
	public void actionPerformed(ActionEvent event) //when button pressed
	{
		String inputS = input.getText(); //get text
		JButton button = (JButton) event.getSource(); //get button
		String selectedOption = button.getText(); //figure out which button was pressed
		if (selectedOption.equals("Save Message")) //if the button says save message
		{
			AnagramGame.acc.setMessage(inputS); //save the input to message
		}
		else //save time limit
		{
			AnagramGame.acc.setTimeLimit(Integer.parseInt(inputS)); //save the input to timelimit after reading it as an int
		}
		ParentMenu.start(); //open the parent menu, since that's how you get there
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //close current frame
	}
}