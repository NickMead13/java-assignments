/**
 * 
 */
package com.ss.jb.one;

/**
 * @author NickM
 *
 */
public class AssignmentOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AssignmentOne assignment = new AssignmentOne();
		assignment.printLeftUp(4);
		assignment.printLeftDown(4);
		assignment.printCenterUp(4);
		assignment.printCenterDown(4);
	}
	
	private int pictureCount = 0;
	
	/**
	 * Prints asterisks along the the left with incrementing line lengths
	 * @param lineCount
	 */
	public void printLeftUp(int lineCount) {
		printCountAndIncrement();
		for (int i = 0; i < lineCount; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		printLineBreak();
	}
	
	/**
	 * Prints asterisks along the left with decrement line lengths
	 * @param lineCount
	 */
	public void printLeftDown(int lineCount) {
		printCountAndIncrement();
		printLineBreak();
		for (int i = 0; i < lineCount; i++) {
			for (int j = 0; j < lineCount - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints asterisks centered based on the line break size, with incrementing line lengths
	 * @param lineCount
	 */
	public void printCenterUp(int lineCount) {
		printCountAndIncrement();
		int offsetSpaces = getOffsetCount(lineCount);
		for (int i = 0; i < lineCount; i++) {
			for (int j = 0; j < lineCount - i - 1 + offsetSpaces; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		printLineBreak();
	}
	
	/**
	 * Prints asterisks centered based on the line break size, with decrementing line lengths
	 * @param lineCount
	 */
	public void printCenterDown(int lineCount) {
		printCountAndIncrement();
		int offsetSpaces = getOffsetCount(lineCount);
		printLineBreak();
		for (int i = 0; i < lineCount; i++) {
			for (int j = 0; j < i + offsetSpaces - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (lineCount - i) * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * Get the number of spaces before each line for centered asterisk pictures
	 * @param lineCount
	 * @return Space Count
	 */
	private int getOffsetCount(int lineCount) {
		return (pictureCount + 8) / 2 - lineCount;
	}
	
	/**
	 * Prints the number of the next picture and increments the count
	 */
	private void printCountAndIncrement() {
		System.out.println(++pictureCount + ")");
	}
	
	/**
	 * Prints a line of periods
	 */
	private void printLineBreak() {
		for (int i = 0; i < 8 + pictureCount; i++) {
			System.out.print(".");
		}
		System.out.println();
	}

}
