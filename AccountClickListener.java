import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.WindowEvent; 


public class AccountClickListener implements ActionListener
{
	private JFrame frame;
	private JTextField username;
	private JTextField password;
	public AccountClickListener(JTextField u, JTextField p, JFrame f)
	{
		username = u; //store the username box to read
		password = p; //store the password box to read
		frame = f; //store the frame to close
	}
	public void actionPerformed(ActionEvent event)
	{
		JButton button = (JButton) event.getSource(); //get the button that was pressed
		String selectedOption = button.getText(); //get the text of the button
		String usernameS = username.getText(); //get the text from the boxes
		String passwordS = password.getText(); 
		if (selectedOption.equals("Create New Parent Account")) //if the button says this
		{
			AnagramGame.acc = Account.createParent(usernameS, passwordS); //create a parent account
			ParentMenu.start(); //open the next frame
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //close the current frame
		}
		else if (selectedOption.equals("Login to Parent Account")) //if the button says this
		{
			if (Account.parentLogin(usernameS, passwordS)) //check if the login is correct
			{
				ParentMenu.start(); //open the next frame
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //close current frame
			}
			else
			{
				System.out.println("account not found"); //for debug
			}
		}
		else if (selectedOption.equals("Create Student Account")) //if the button says this
		{
			AnagramGame.acc.createStudent(usernameS, passwordS); //create a student account in the parent account
			ParentMenu.start(); //open the next frame, it's parentMenu because you can only make a student account from parentmenu
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //close current window
		}
		else //login to student account
		{
			if (Account.studentLogin(usernameS, passwordS)) //if the login is correct
			{
				StudentMenu.start(); //open next frame
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //close current frame
			}
			else
			{
				System.out.println("account not found"); //for debug
			}
		}
	}
}