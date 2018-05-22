import java.util.Date;
import java.text.SimpleDateFormat;
public class Score
{
	public static SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy HH:mm:ss a"); //make a date formatter
	private Date date; //make a date
	private int points; //make a points int
	public Score(Date d, int p)
	{
		date = d; //store inputs
		points = p;
	}
	public static Score parse(String str)
	{
		String[] parts = str.split("-"); //string input is Date-Int
		Date parsedDate;
		try{
			parsedDate = formatter.parse(parts[0]); //try to read the date in the string
		}
		catch (Exception e)
		{
			parsedDate = new Date(); //otherwise just use today's date
		}
		return new Score(parsedDate, Integer.parseInt(parts[1])); //make a new score object and return it
	}
	public String toString()
	{
		String str = formatter.format(date) + "-" + points; //translate the score object into a string
		return str;
	}
	public int points()
	{
		return points; //return the points
	}
	
}