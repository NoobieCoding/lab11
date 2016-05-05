package tasktimer;

import static java.lang.System.out;
import java.util.function.IntConsumer;

/**
 * Count the time of reading words into string for each programming construct.
 * 6 programming constructs.
 * 
 * @author Nuttapong Rojanavanich
 */
public class TaskTimer {

	/**
	 * Perform reading words using Scanner and a while loop
	 */
	public static void runTask1() {
		execAndPrint(new Task1());
	}

	/**
	 * Perform reading words using BufferedReader.readLine() with a loop;
	 */
	public static void runTask2() {
		execAndPrint(new Task2());
	}
	
	/**
	 * Perform reading words using BufferedReader and Stream
	 */
	public static void runTask3() {
		execAndPrint(new Task3());
	}

	/**
	 * Define a customer Consumer class that computes <b>both</b> the average
	 * and count of values. An IntConsumer is a special Consumer interface the
	 * has an 'int' parameter in accept().
	 */
	static class IntCounter implements IntConsumer {
		// count the values
		public int count = 0;
		// total of the values
		private long total = 0;

		/**
		 * accept consumes an integer. In this method, count the value and add it to
		 * total.
		 */
		public void accept(int value) {
			count++;
			total += value;
		}

		/** Get the average of all the values consumed. */
		public double average() {
			return (count > 0) ? ((double) total) / count : 0.0;
		}
		
		/** Get the number of the value. */
		public int getCount() {
			return count;
		}
	}

	/**
	 * Perform reading words using BufferedReader and Stream with Collector.
	 */
	public static void runTask4() {
		execAndPrint(new Task4());
	}
	
	/**
	 * Perform appending 50000 words to a String using +.
	 */
	public static void runTask5() {
		execAndPrint(new Task5());
	}

	/**
	 * Perform appending 50000 words to a StringBuilder.
	 */
	public static void runtask6() {
		execAndPrint(new Task6());
	}

	/**
	 * Run the programming construct and count the running time.
	 * @param task is programming construct used to read words into string.
	 */
	public static void execAndPrint(Runnable task) {
		StopWatch stopWatch = new StopWatch();
		out.println("Starting task: " + task.toString());
		stopWatch.start();
		task.run();
		stopWatch.stop();
		out.printf("Elapsed time is %f sec\n", stopWatch.getElapsed());
	}

	/** Run all the tasks. */
	public static void main(String[] args) {
		runTask1();
		runTask2();
		runTask3();
		runTask4();
		runTask5();
		runtask6();
	}

}
