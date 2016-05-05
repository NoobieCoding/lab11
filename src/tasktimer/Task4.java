package tasktimer;

import static java.lang.System.out;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * Process all the words in a file (one word per line) using BufferedReader and
 * the lines() method which creates a Stream of Strings (one item per line).
 * Then use the stream to compute summary statistics. This is same as task3,
 * except we use a Collector instead of Consumer.
 * 
 * @author Nuttapong Rojanavanich (Base of teacher's code).
 */
public class Task4 implements Runnable {

	private BufferedReader br;

	/**
	 * Constructor with no argument. Initialize BufferedReader.
	 */
	public Task4() {
		br = BufferedFactory.getBufferedReader();
	}

	/**
	 * Run this programming construct.
	 */
	public void run() {
		// We want the Consumer to add to the count and total length,
		// but a Lambda can only access local variables (from surrounding scope)
		// if
		// they are final. That means, we can't use an int, long, or double
		// variable.
		// So, use AtomicInteger and AtomicLong, which are mutable objects.
		final AtomicLong total = new AtomicLong();
		final AtomicInteger counter = new AtomicInteger();
		
		
		Consumer<String> consumer = new Consumer<String>() {
			public void accept(String word) {
				total.getAndAdd(word.length());
				counter.incrementAndGet();
			}
		};

		br.lines().forEach(consumer); // Ha! No loop.
		// close the input
		try {
			br.close();
		} catch (IOException ex) {
			/* ignore it */ }

		int count = counter.intValue();
		double averageLength = (count > 0) ? total.doubleValue() / count : 0.0;
		out.printf("Average length of %,d words is %.2f\n", count, averageLength);
	}
	
	/**
	 * Return the description of this construct.
	 */
	public String toString() {
		return "read words using BufferedReader and Stream with Collector";
	}
}
