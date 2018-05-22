import java.util.Random;

public class Anagram
{
	private static Random rand;
	public static String scramble(String input) //scramble the input string
	{
		rand = new Random(); //make new random
		String output = input;
		while(output.equals(input)){ //if the output = input, try again
			char[] inputArray = input.toCharArray(); //turn input into chararray
			char[] outputArray = new char[inputArray.length]; //prepare output as chararray
			for(char c : inputArray) //iterate through all characters in input
			{
				int index = rand.nextInt(outputArray.length); //pick a random character
				while (outputArray[index] != '\u0000') //while the character selected is empty
				{
					index = rand.nextInt(outputArray.length); //pick another random character
				}
				outputArray[index] = c; //since the character is empty, put that character there
			}
			output = String.valueOf(outputArray); //turn the array back into a string
		}
		return output; //then return it
	}
}