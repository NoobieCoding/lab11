package tasktimer;

public class StopWatch {

	private long startTime;
	private long stopTime;
	private boolean running;
	private static final double NANO_SECOND = 1.0E-9;
	
	public StopWatch() {
		startTime = 0;
		stopTime = 0;
		running = false;
	}

	public void start() {
		startTime = System.nanoTime();
		running = true;
	}

	public void stop() {
		stopTime = System.nanoTime();
		running = false;
	}

	public double getElapsed() {
		return (stopTime - startTime)*NANO_SECOND;
	}
}
