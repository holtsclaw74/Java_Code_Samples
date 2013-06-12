import java.util.Random;
import java.util.Scanner;

public class Cryptograph_bb {

  static Scanner input = new Scanner(System.in);
  static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static String key = "UBWKOVGAPRFJLCQHZENSXDMYTI";
  static int count;
  static Character character;
  static String value;
  static int j;
  private static boolean there = false;
  
  
  public static void main(String[] args) {
    boolean keepGoing = true;
    while(keepGoing){

      String response = menu();

        if (response.equals("1")){
          System.out.println("Please enter unencrypted phrase");
          String plain = input.nextLine();
          plain = plain.toUpperCase();
          
          System.out.println(Encrypt(plain));

        } else if (response.equals("2")){
          System.out.println("Please enter encrypted phrase");
          String code = input.nextLine();
          code = code.toUpperCase();
          System.out.println(Decrypt(code));

        } else if (response.equals("0")){
          System.out.println("Goodbye!");
          keepGoing = false;

        } else if (response.equals("3")){
            changeKey(key);
            System.out.println("The key has been changed\n");
          }
        else {
          System.out.println("Sorry. I didn't understand");
        } // end if
      } // end while
   } // end main 
  
  
private static void changeKey(String oldKey) {
  char[] keyPlace = new char[oldKey.length()];
	Random randomNumbers = new Random();
	key="";
	
	for(int count = 0;count< oldKey.length(); count++)
	{
		keyPlace[count]= oldKey.charAt(count);
	}
	for(int first = 0;first< oldKey.length(); first++)
	{
		int second = randomNumbers.nextInt(oldKey.length());
		char temp = keyPlace[first];
		keyPlace[first]=keyPlace[second];
		keyPlace[second]=temp;
		
	}
	for(int count=0;count<oldKey.length();count++)
	{
		key=key+keyPlace[count];
	}
	//System.out.println(oldKey);
	//System.out.println(key);
}
public static String Encrypt(String phrase)
	{
	  	String encryptPhrase="";
	  	
		for(count=0 ; count <= phrase.length()-1; count++)
		{
			
			there = false;
			for(j=0; j <= alpha.length()-1; j++)
			{
				
				if(phrase.charAt(count) == alpha.charAt(j))
				{
					
					there = true;
					
					character = key.charAt(j);
					
					value = character.toString();
					
					
					encryptPhrase=encryptPhrase+value;
				}
			}
			if(!(there))
			{
				
				encryptPhrase=encryptPhrase+"#";
			}
		}
		
		
		return encryptPhrase;
	}

  public static String Decrypt(String phrase)
	{
		String decryptPhrase="";
		
		for(count=0; count <= phrase.length()-1; count++)
		{
			there=false;
			for(j=0; j <= key.length()-1; j++)
			{
				if(phrase.charAt(count) == key.charAt(j))
				{
					there = true;
					character = alpha.charAt(j);
					value = character.toString();
					decryptPhrase= decryptPhrase+value;
				}
			}
			if(!(there))
			{
				decryptPhrase= decryptPhrase+" ";
			}
		}
		return decryptPhrase;
		
	}
	public static String menu()
	{
		
		System.out.println("Select an option \n");
		System.out.println("0) Quit \n");
		System.out.println("1) Encrypt a phrase \n");
		System.out.println("2) Decrypt a phrase \n");
		System.out.println("3) Generate a new key \n");		
		return input.nextLine();
	}
} // end Cryptograph
