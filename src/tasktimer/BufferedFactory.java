package tasktimer;

import static java.lang.System.out;
import java.io.*;

/**
 * Get the BufferedReader for various tasks.
 * Reduce duplicate code.
 * 
 * @author Nuttapong Rojanavanich
 */
public class BufferedFactory {

	/**
	 * Get the BufferedReader that read the dictionary file.
	 * Catch the exception if occurred.
	 * @return BufferedReader with InputStream if successfully open the dictionary
	 * (if not return null BufferedReader). 
	 */
	public static BufferedReader getBufferedReader() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(Dictionary.getWordsAsStream()));
		} catch (Exception ex) {
			out.println("Could not open dictionary: " + ex.getMessage());
		}
		return br;
	}
}
