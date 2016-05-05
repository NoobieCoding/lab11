package tasktimer;

/**
 * Used to count the time elapsed.
 * User must start and stop the watch to get the time elapsed.
 * 
 * @author Nuttapong Rojanavanich
 */
public class StopWatch {

	private long startTime;
	private long stopTime;
	private boolean running;
	private static final double NANO_SECOND = 1.0E-9;
	
	/**
	 * Constructor with no argument.
	 */
	public StopWatch() {
		startTime = 0;
		stopTime = 0;
		running = false;
	}

	/**
	 * Start the stop watch.
	 */
	public void start() {
		startTime = System.nanoTime();
		running = true;
	}

	/**
	 * Stop the stop watch.
	 */
	public void stop() {
		stopTime = System.nanoTime();
		running = false;
	}
	
	/**
	 * Get the time elapsed.
	 * @return the difference between start time and stop time (in nanosecond).
	 */
	public double getElapsed() {
		return (stopTime - startTime)*NANO_SECOND;
	}
}
