package tasktimer;

import static java.lang.System.out;
import java.io.*;

public class BufferedFactory {

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
