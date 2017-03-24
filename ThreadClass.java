
class ThreadDemo implements Runnable {
	private Thread t;
	private String threadName;
	
	ThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	@Override
	public void run() {
		System.out.println("RUNNING " + threadName);
	}

	/* A helper function to allocate thread and start() it */
	public void myStart () {
		System.out.println("Allocating " + threadName );
		
		t = new Thread(this, threadName);
		t.start();
	}
}

public class ThreadClass {
	public static void main(String args[]) {
		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.myStart();

		System.out.println("");
		
		ThreadDemo T2 = new ThreadDemo("Thread-2");
		T2.myStart();
	}
}