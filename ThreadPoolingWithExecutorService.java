import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Demo implements Runnable {
	public void run() {
		System.out.println("Running thread" + Thread.currentThread().getName());
	}
}

public class ThreadPoolingWithExecutorService {
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);	// creating a pool of 3 threads
		
		for(int i = 0; i < 6; i++) {
			executor.execute(new Demo());	// calling execute method of ExecutorService
		}
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {
			;
		}
		
		System.out.println("Finished all threads");
	}
}