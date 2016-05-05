package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;

/**
 * Process all the words in a file using Scanner to read and parse input.
 * Display summary statistics and elapsed time.
 * 
 * @author Nuttapong Rojanavanich (Base on teacher's code).
 */
public class Task1 implements Runnable {

	private Scanner in;

	/**
	 * Constructor with no argument. 
	 * Initialize Scanner.
	 */
	public Task1() {
		in = new Scanner(Dictionary.getWordsAsStream());
	}

	/**
	 * Run this programming construct.
	 */
	public void run() {
		// perform the task
		int count = 0;
		long totalsize = 0;
		while (in.hasNext()) {
			String word = in.next();
			totalsize += word.length();
			count++;
		}
		double averageLength = ((double) totalsize) / (count > 0 ? count : 1);
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}

	/**
	 * Return the description of this construct.
	 */
	public String toString() {
		return "read words using Scanner and a while loop";
	}
}
