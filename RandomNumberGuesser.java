//package A2_NumberGuessGame;

/**
 * Name:		David Rodriguez
 * Instructor:	Grigoriy Grinberg
 * Description:	Random Number Guessing Game
 * Due:			06/27/2021
 * 
 * Pledge: I, David Rodriguez, pledge that I have completed this
 * programming assignment independently.
 * All work provided here is of my own.
 * 
 */

import java.util.Scanner;

/**
 * Class:
 * Random Number Guessing Game
 * 
 * A random number is generater using the RNG(Random Number Generator) class.
 * The user inputs their guesses until they find the correct number.
 * 
 * @author David Rodriguez
 *
 */
public class RandomNumberGuesser {

	public static void main(String[] args) {
		//Variables used
		Scanner scan = new Scanner(System.in);
		String answer = "";		//used to get user's answer of form "yes" or "no"
		int number;				//used to store the correct answer
		int guess;				//used to store user's guess
		int low = 1;			//updated lowest guess
		int high = 100;			//updated highest guess
		boolean inRange;		//stores boolean returned by RNG.inputValidate();
		
		
		//Prints program header
		printHeader();
		
		//Prompt the user if they're ready
		//Looped to check valid input
		do {
			System.out.println("Are you ready?( yes or no )");
			answer = scan.next();
		}while(!isValid(answer));
		
		//-----------  Game Play Loop  --------------\\
		//Play Game while answer is yes
		while(answer.equalsIgnoreCase("yes")){ 
			
			System.out.println("\n\t****---NEW GAME---****");
			
			//Reset variables Guess count and ask for first guess
			RNG.resetCount();
			number = RNG.rand();
			low =1;
			high = 100;
			
			System.out.println("Enter your first guess:");
			guess = scan.nextInt();
			
			// If guess is incorrect, loop until correct
			while(guess!=number) {
				
				inRange = RNG.inputValidation(guess, low, high);
				
				System.out.println("Your guess count is: "+RNG.getCount());
				
				if(!inRange) {
					System.out.printf("Enter next guess between %s and %s\n",low,high);
					guess=scan.nextInt();
				}
				else {
					if(guess > number) {
						System.out.println("Your Guess is too high!");
						high = guess;
						
					}else if(guess < number) {
						System.out.println("Your guess is too low!");
						low = guess;
					}
					
					System.out.printf("Enter next guess between %s and %s\n",low,high);
					guess=scan.nextInt();
					
				}
				
			}//end while guess incorrect
			
			System.out.println("\n\t***Correct! You have won!***\n");
			//Prompt to play again
			do {
				System.out.print("Play again?( yes or no )");
				answer = scan.next();
			}while(!isValid(answer));
			
			
		}// end play loop
		
		//display winning output
		System.out.println("\nThanks for playing! Game exiting...");
		
		//close scanner resource
		scan.close();
		
	}
	
	/**
	 * Prints application header
	 */
	static void printHeader() {
		System.out.println("******************************************");
		System.out.println("**          Guess The Number!           **");
		System.out.println("**          by David Rodriguez          **");
		System.out.println("******************************************\n");
		
		System.out.println("You must guess a number between 1 and 100.\n");
	}

	/**
	 * Checks user input for "yes" or "no". Returns boolean.
	 * @param answer String for user input
	 * @return	True if user inputs "yes"/"no", false otherwise.
	 */
	static boolean isValid(String answer) {
		return (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) ;
	}
	
	
}
