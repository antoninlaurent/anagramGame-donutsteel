import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
public class Account
{
	private String parentName;
	private String parentPass;
	private String studentName;
	private String studentPass;
	private int timeLimit;
	private String message;
	private ArrayList<Score> scores = new ArrayList<Score>();
	private int lineNumber;
	
	public static ArrayList<Account> accountList = new ArrayList<Account>();
	public Account(String accountString)
	{
		String[] parts = accountString.split("!"); //split input string into parts and save those parts
		parentName = parts[0]; //String
		parentPass = parts[1]; 
		studentName = parts[2];
		studentPass = parts[3];//String
		timeLimit = Integer.parseInt(parts[4]); //int
		message = parts[5];
		scores.add(Score.parse(parts[6])); //score
		scores.add(Score.parse(parts[7]));
		scores.add(Score.parse(parts[8]));
		scores.add(Score.parse(parts[9]));
		scores.add(Score.parse(parts[10]));
		scores.add(Score.parse(parts[11]));
		scores.add(Score.parse(parts[12]));
		scores.add(Score.parse(parts[13]));
		scores.add(Score.parse(parts[14]));
		scores.add(Score.parse(parts[15])); //score
	}
	public static Account createParent(String username, String password){
		Date now = new Date(); //get a date object to make a bunch of scores with
		Score blankScore = new Score(now, 0); //make a score to fill out a default string
		String no = blankScore.toString(); //make the score into an input string
		String initialString = username + "!" + password + "!default!default!60!no message!" + no + "!" + no + "!" + no + "!" + no + "!" + no + "!" + no + "!" + no + "!" + no + "!" + no + "!" + no; //default string
		Account acc = new Account(initialString); //make a new account object
		accountList.add(acc); //add it to the list of accounts
		Account.save(); //save the account
		return acc; //return the account
	}
	public void createStudent(String username, String password)
	{
		studentName = username; //change the username to the one provided
		studentPass = password; //change the password to the one provided
		Account.save(); //save the account
	}
	public String toString()
	{
		String returnString = String.join("!", parentName, parentPass, studentName, studentPass, Integer.toString(timeLimit), message, scores.get(0).toString(), scores.get(1).toString(), scores.get(2).toString(), scores.get(3).toString(), scores.get(4).toString(), scores.get(5).toString(), scores.get(6).toString(), scores.get(7).toString(), scores.get(8).toString(), scores.get(9).toString());
		return returnString; //turn the account into a string
	}
	public static void loadAll() //should be run at beginning
	{
		Scanner in;
		try
		{
			in = new Scanner(new File("accounts.txt")); //read the file
		} catch (Exception e)
		{
			System.out.println("accounts.txt not found.");
			System.exit(0); //if the file isn't there, something is probably wrong
			in = new Scanner(System.in); //this never gets called, it's just so the compiler gets off my case
		}
		String nextLine;
		try
		{
			nextLine = in.nextLine();	
		} catch (Exception e) //if accounts.txt is empty, then there's no need to iterate through it
		{
			nextLine = "";
		}
		int lineN = 1;
		while(!nextLine.equals("")) //keep reading until you get blanks
		{
			accountList.add(new Account(nextLine, lineN)); //add the accounts in file to the list of accounts
			nextLine = in.nextLine(); //look at the next line
		}
	}
	public static void save()
	{
		PrintWriter out;
		try{
			out = new PrintWriter("accounts.txt", "UTF-8");//write to file
			for (int i = 0; i != accountList.size(); i++)
			{
				out.println(accountList.get(i).toString()); //write all the accounts to the file
			}
			out.println(""); //put a newline at the end to make sure nextLine() doesn't give exception
			out.close(); //close the file
		}
		catch (Exception e)
		{
			System.out.println(e); //for debug
		}
	}
	public String getParentName()//self explanatory
	{
		return parentName;
	}
	public String getParentPass()//self explanatory
	{
		return parentPass;
	}
	public String getStudentName()//self explanatory
	{
		return studentName;
	}
	public String getStudentPass()//self explanatory
	{
		return studentPass;
	}
	public void setTimeLimit(int x)//self explanatory
	{
		timeLimit = x;
		this.save();//make sure to save changes
	}
	public int getTimeLimit()//self explanatory
	{
		return timeLimit;
	}
	public void setMessage(String x)//self explanatory
	{
		message = x;
		this.save();//save changes
	}
	public String getMessage()//self explanatory
	{
		return message;
	}
	public ArrayList<Score> getScores()//self explanatory
	{
		return scores;
	}
	public void addScore(int newScore)
	{
		Date now = new Date(); //get the time right now
		for(int i = 0; i != 10; i++) //iterate through all current scores
		{
			if (newScore > scores.get(i).points()) //if the new score is bigger than the current score
			{
				scores.add(i, new Score(now, newScore)); //then replace it and shift everything down
				i = 9; //then don't look at any of the other scores
			}
		}
		try{
			scores.remove(10); //if there's something left at the end, take it off
		}catch (Exception e)
		{
			assert true; //does nothing
		}
		this.save(); //save progress
	}
	public static boolean parentLogin(String username, String password)
	{
		for (Account testAcc: accountList) //iterate over all account
		{
			if (username.equals(testAcc.getParentName())) //if account has same username
			{
				if (password.equals(testAcc.getParentPass())) //if account has same password
				{
					AnagramGame.acc = testAcc; //set the current account to that account
					return true; //then exit with true
				}
			}
		}
		return false; //if no account works, then login failed
	}
	public static boolean studentLogin(String username, String password)
	{
		for (Account testAcc: accountList) //iterate over all account
		{
			if (username.equals(testAcc.getStudentName())) //if account has same username
			{
				if (password.equals(testAcc.getStudentPass())) //if account has same password
				{
					AnagramGame.acc = testAcc; //set current account to that account
					return true; //then exit with true
				}
			}
		}
		return false; //if no account works, then login failed
	}
}