import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.WindowEvent; 


public class FrameChangeClickListener implements ActionListener //this listener is for frames that go to other frames
{
	private JFrame frame;
	public FrameChangeClickListener(JFrame f)
	{
		frame = f;
	}
	public void actionPerformed(ActionEvent event)
	{
		JButton button = (JButton) event.getSource(); //figure out what the button says
		String selectedOption = button.getText();
		if (selectedOption.equals("Create Parent Account")) //then go to parentcreateaccount
		{
			ParentCreateAccount.start();
		}
		else if (selectedOption.equals("Parent Login")) //then go to parentlogin
		{
			ParentLogin.start();
		}
		else if (selectedOption.equals("Student Login")) //then go to studentlogin
		{
			StudentLogin.start();
		}
		else if (selectedOption.equals("Create Student Account")) //then go to createstudentaccount
		{
			CreateStudentAccount.start();
		}
		else if (selectedOption.equals("Set Time Limit")) //set time limit
		{
			SetTimeLimit.start();
		}
		else if (selectedOption.equals("View Scores")) //then go to viewscores
		{
			ViewScores.start();
		}
		else if (selectedOption.equals("Leave Message"))//then go to leavemessage
		{
			LeaveMessage.start();
		}
		else if (selectedOption.equals("Log Out"))//then go to startupmenu
		{
			StartupMenu.start();
		}
		else if (selectedOption.equals("Play Game")) //then go to the game
		{
			GamePlay.start();
		}
		else if (selectedOption.equals("View Message")) //then go to view message
		{
			ViewMessage.start();
		}
		else if (selectedOption.equals("Return to Parent Menu")) //then go to parent menu
		{
			ParentMenu.start();
		}
		else if (selectedOption.equals("Return to Student Menu")) //then go to student menu
		{
			StudentMenu.start();
		}
		else //for debug
		{
			System.out.println("invalid button");
		}
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //kill the current frame
	}
}