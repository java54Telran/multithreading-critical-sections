package telran.multithreading;

public class CounterUpdater extends Thread {
	private static long counter;
	private static final Object mutex = new Object();
	private int nRuns;
	
	public CounterUpdater(int nRuns) {
		this.nRuns = nRuns;
	}

	@Override 
	public void run() {
		for (int i = 0; i < nRuns; i++) {
			counterIncrement();
		}
	}

	private void counterIncrement() {
		synchronized (mutex) {
			counter++;
		}
		
	}

	public static long getCounter() {
		
		return counter;
	}
	
}
