package tasktimer;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Append all the words from the dictionary to a String. This shows why you
 * should be careful about using "string1"+"string2".
 * 
 * @author Nuttapong Rojanavanich (Base of teacher's code).
 */
public class Task5 implements Runnable {

	private final int MAXCOUNT = 50_000;
	private BufferedReader br;

	/**
	 * Constructor with no argument. Initialize BufferedReader.
	 */
	public Task5() {
		br = BufferedFactory.getBufferedReader();
	}

	/**
	 * Run this programming construct.
	 */
	public void run() {
		String result = "";
		String word = null;
		int count = 0;
		try {
			while ((word = br.readLine()) != null && count < MAXCOUNT) {
				result = result + word;
				count++;
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.printf("Done appending %d words to string.\n", count);
	}
	
	/**
	 * Return the description of this construct.
	 */
	public String toString() {
		return "append " + MAXCOUNT + " words to a String using +";
	}
}
