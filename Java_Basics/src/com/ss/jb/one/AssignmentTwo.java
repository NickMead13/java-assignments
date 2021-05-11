/**
 * 
 */
package com.ss.jb.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author NickM
 *
 */
public class AssignmentTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AssignmentTwo assignment = new AssignmentTwo();
		assignment.run();
	}
	
	int generatedNum;
	
	public AssignmentTwo() {
		generateNumber();
	}
	
	/**
	 * Runs until the user has guess 5 times incorrectly or guesses within 10 of the generated number
	 */
	public void run() {
		System.out.println(generatedNum);
		int result = 0;
		boolean success = false;
		for (int i = 0; i < 5 && !success; i++) {
			result = attemptGuess();
			switch (result) {
			case -1:
				i--;
				break;
			case 1:
				success = true;
				break;
			}
		}
		if (result != 1) {
			System.out.println("Sorry, but the number was " + generatedNum);
		}
	}
	
	private void generateNumber() {
		Random random = new Random();
		generatedNum = random.nextInt(100) + 1;
	}
	
	public int attemptGuess() {
		System.out.print("Make a guess: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int guess;
		try {
			input = reader.readLine();
			guess = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Input was not a number!");
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		if (guess < 1 || guess > 100) {
			System.out.println("Input was not between 1-100");
			return -1;
		}
		if (guess >= generatedNum - 10 && guess <= generatedNum + 10) {
			if (guess == generatedNum) {
				System.out.println("Correct! The number was " + generatedNum);
			} else {
				System.out.println("Close enough! The number was " + generatedNum);
			}
			return 1;
		} else {
			System.out.println("Incorrect!");
			return 0;
		}
	}
	
	public int getGeneratedNum() {
		return generatedNum;
	}

}
