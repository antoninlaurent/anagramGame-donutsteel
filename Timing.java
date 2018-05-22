import java.awt.event.WindowEvent; 
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class Timing extends Thread { //do some multithreading
	public int timer = AnagramGame.acc.getTimeLimit(); //count time
	public boolean gameOpen = true; //public bool that can be changed to prevent hanging

	@Override
	public void run() {
		
	while (gameOpen) //loop that can be closed externally
	{
		try{
			TimeUnit.SECONDS.sleep(1); //wait a sec
		} catch (Exception e)
		{
			timer = AnagramGame.acc.getTimeLimit(); //if interrupt is called, reset the timer
		}
		timer = timer - 1; //decrease time remaining
		GamePlay.timerLabel.setText("Time Remaining: " + timer); //print time remaining to the label
		if (timer < 0) //exit when time runs out
		{
			gameOpen = false;
		}
	}
	GamePlay.frame.dispatchEvent(new WindowEvent(GamePlay.frame, WindowEvent.WINDOW_CLOSING)); //when loop ends, close frame
	ViewScores.start();	//when loop ends, open the viewscocres
	}
}