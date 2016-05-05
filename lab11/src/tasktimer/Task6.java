package tasktimer;

import static java.lang.System.out;
import java.io.*;

/**
 * Append all the words from the dictionary to a StringBuilder. Compare how long
 * this takes to appending to String.
 */
public class Task6 implements Runnable {
	
	private final int MAXCOUNT = 50_000;
	private BufferedReader br;

	public Task6() {
		br = BufferedFactory.getBufferedReader();
	}

	public void run() {
	        StringBuilder result = new StringBuilder();
	        String word = null;
	        int count = 0;
	        try {
	            while( (word=br.readLine()) != null  && count < MAXCOUNT) {
	                result.append(word);
	                count++;
	            }
	        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
	        System.out.printf("Done appending %d words to StringBuilder.\n", count);
	}

	public String toString() {
		return "append "+MAXCOUNT+" words to a StringBuilder";
	}
}
