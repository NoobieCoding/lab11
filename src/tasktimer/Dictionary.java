package tasktimer;

import java.io.InputStream;

/**
 * Specify the file that is going to be read and return the InputStream with
 * that file as resource.
 * 
 * @author Nuttapong Rojanavanich
 */
public class Dictionary {

	private static String DICTIONARY = "wordlist.txt";

	/**
	 * Return the InputStream with the dictionary file as resource.
	 * @return InputStream object that has dictionary file as the resource.
	 */
	public static InputStream getWordsAsStream() {
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
	}
}
