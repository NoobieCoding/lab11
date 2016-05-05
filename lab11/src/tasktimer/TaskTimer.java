package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*; // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks using different programming
 * constructs.
 * 
 */
public class TaskTimer {

	public static void runTask1() {
		execAndPrint(new Task1());
	}

	public static void runTask2() {
		execAndPrint(new Task2());
	}

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

		public int getCount() {
			return count;
		}
	}

	public static void runTask4() {
		execAndPrint(new Task4());
	}

	public static void runTask5() {
		execAndPrint(new Task5());
	}

	public static void runtask6() {
		execAndPrint(new Task6());
	}

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
