package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class ThreadsController {
  private static final int N_THREADS = 1000;
private static final int N_RUNS = 10000;
  public static void main(String[] args) {
	  CounterUpdater [] updaters = new CounterUpdater[N_THREADS];
	  Instant start = Instant.now();
	  startUpdaters(updaters);
	  waitigUpdaters(updaters);
	  System.out.printf("counter value: %d; running time: %d\n",
			  CounterUpdater.getCounter(), ChronoUnit.MILLIS.between(start, Instant.now()));
}
private static void waitigUpdaters(CounterUpdater[] updaters) {
	for(CounterUpdater updater: updaters) {
		try {
			updater.join();
		} catch (InterruptedException e) {
			
		}
	}
	
}
private static void startUpdaters(CounterUpdater[] updaters) {
	IntStream.range(0, updaters.length).forEach(i -> {
		updaters[i] = new CounterUpdater(N_RUNS);
		updaters[i].start();
	});
	
}

  
}
