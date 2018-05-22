import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class GamePlay
{
	public static JFrame frame;
	public static JLabel timerLabel;
	public static void start()
	{
		frame = new JFrame("Play Game"); //make frame
        frame.getContentPane().setLayout(new FlowLayout()); //set layout

        JLabel fromlabel = new JLabel("From Word: "); //instructions and empty label to be set
        JLabel frombox = new JLabel("");

        JLabel tolabel = new JLabel("To Word:"); //instructions and text field
        JTextField tobox = new JTextField("", 10);

		JButton button1 = new JButton("Start"); //button that starts game
		
		timerLabel = new JLabel(""); //label to be changed for timelimit
		
		frame.getContentPane().add(fromlabel); //add stuff to frame
        frame.getContentPane().add(frombox);
        frame.getContentPane().add(tolabel);
        frame.getContentPane().add(tobox);
        frame.getContentPane().add(button1);
		frame.getContentPane().add(timerLabel);
				
		Timing timing = new Timing(); //make a new timing object and start it
		timing.start();

		ActionListener listener1 = new GameClickListener(frombox, tobox, frame, timing); //make listener, feed all necessary info
		button1.addActionListener(listener1);

        frame.pack();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //make sure game doesn't hang
        frame.setVisible(true); //put frame on screen

	}
}