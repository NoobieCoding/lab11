package tasktimer;

import java.io.*;

/**
 * Append all the words from the dictionary to a StringBuilder. Compare how long
 * this takes to appending to String.
 * 
 * @author Nuttapong Rojanavanich (Base of teacher's code).
 */
public class Task6 implements Runnable {

	private final int MAXCOUNT = 50_000;
	private BufferedReader br;

	/**
	 * Constructor with no argument. Initialize BufferedReader.
	 */
	public Task6() {
		br = BufferedFactory.getBufferedReader();
	}

	/**
	 * Run this programming construct.
	 */
	public void run() {
		StringBuilder result = new StringBuilder();
		String word = null;
		int count = 0;
		try {
			while ((word = br.readLine()) != null && count < MAXCOUNT) {
				result.append(word);
				count++;
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.printf("Done appending %d words to StringBuilder.\n", count);
	}
	
	/**
	 * Return the description of this construct.
	 */
	public String toString() {
		return "append " + MAXCOUNT + " words to a StringBuilder";
	}
}
