package telran.multithreading;

import java.util.concurrent.atomic.AtomicLong;

public class CounterUpdater extends Thread {
	private static AtomicLong counter = new AtomicLong(0);
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
			counter.getAndIncrement();
		
	}

	public static long getCounter() {
		
		return counter.get();
	}
	
}
