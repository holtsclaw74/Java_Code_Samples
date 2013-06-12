
import java.util.Scanner;
public class HighLowbb
{
  public static void main(String args[])
	{
		String response;
		int thisNumber,lastNumber,tempNumber, counter;
		Scanner input = new Scanner(System.in);
		System.out.printf("Please think of a number between\n");
		System.out.printf("one and one hundred. I'll guess\n");
		System.out.printf("your number. You tell me if I'm\n");
		System.out.printf("too high, too low or correct.\n");
		thisNumber = 50;
		tempNumber = 50;
		lastNumber = 0;
		System.out.printf("I guess: %s\n", thisNumber);
		System.out.printf("too (h)igh, too (l)ow, or (c)orrect?\n");
		response = input.nextLine();
		while(!(response.equals("h")) && !(response.equals("l")) && !(response.equals("c")))
		{
			System.out.printf("Sorry, I didn't understand you...\n");
			System.out.printf("I guess: %s\n", thisNumber);
			System.out.printf("too (h)igh, too (l)ow, or (c)orrect?\n");
			response = input.nextLine();
		} 
		counter = 1;
		if(response.equals("h"))
			lastNumber = 0;
		if(response.equals("l"))
			lastNumber = 100;
		
		
		while(!(response.equals("c")))
		{
			if(response.equals("h"))
			{
				
				tempNumber = thisNumber;
				if(Math.abs((thisNumber - lastNumber)/2) >= 1)
					thisNumber = thisNumber - Math.abs((thisNumber - lastNumber)/2);
				else
					thisNumber = thisNumber - 1;
				lastNumber = tempNumber;
				
			}

			if(response.equals("l"))
			{
				tempNumber = thisNumber;
				if(Math.abs((thisNumber - lastNumber)/2) >= 1)
					thisNumber = thisNumber + Math.abs((thisNumber - lastNumber)/2);
				else
					thisNumber = thisNumber + 1;
				lastNumber = tempNumber;
				
			}
			counter = counter + 1;
			System.out.printf("I guess: %s\n", thisNumber);
			System.out.printf("too (h)igh, too (l)ow, or (c)orrect?\n");
			response = input.nextLine();
			while(!(response.equals("h")) && !(response.equals("l")) && !(response.equals("c")))
			{
				System.out.printf("Sorry, I didn't understand you...\n");
				System.out.printf("I guess: %s\n", thisNumber);
				System.out.printf("too (h)igh, too (l)ow, or (c)orrect?\n");
				response = input.nextLine();
			} 

		}
		System.out.printf("I got it! It took %d turns\n",counter);
	}

}

